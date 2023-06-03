package com.lingyi.mall.common.base.aspect;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.StopWatch;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.common.base.util.RequestUtil;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author mwy
 * @datetime 2022/10/23 15:54
 * @description
 */
@Slf4j
@Aspect
@Component
public class LogAspect {


    /**
     * 设置一个切点
     */
    @Pointcut("execution(public com.lingyi.mall.common.base.util.ServerResponse com.lingyi.mall..*(..))")
    private void pointcut() {


    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object returnValue = null;
        Throwable t = null;
        String methodName = null;
        StopWatch sw = new StopWatch();
        try {
            sw.start();
            MethodSignature ms = (MethodSignature) joinPoint.getSignature();
            methodName = ms.getName();
            HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
            this.printUrlAndMethod(request);
            List<ParamDescription> paramDescriptionList = this.analysisInParameter(ms.getMethod().getParameterAnnotations(), ms.getParameterTypes(), ms.getMethod().getParameters(), joinPoint.getArgs());
            this.printRequest(paramDescriptionList);
            returnValue = joinPoint.proceed(joinPoint.getArgs());
            return returnValue;
        } catch (Throwable throwable) {
            t = throwable;
            throw throwable;
        } finally {
            sw.stop();
            this.printResponse(returnValue);
            this.printResult(joinPoint.getTarget().getClass().getName(), methodName, t, sw);
        }
    }

    private void printUrlAndMethod(HttpServletRequest request) {
        log.info("RequestBefore:IP地址 = {},URL = {},METHOD = {}", RequestUtil.getRemoteHost(request), request.getContextPath() + request.getServletPath(), request.getMethod());
    }

    private List<ParamDescription> analysisInParameter(Annotation[][] paramAnnos, Class<?>[] paramTypes, Parameter[] parameters, Object[] paramValues) {
        List<ParamDescription> paramDescList = CollUtil.newArrayList();
        for (int i = 0; i < paramAnnos.length; i++) {
            if (this.isReqOrResp(paramValues[i])) {
                continue;
            }
            Class<? extends Annotation> paramAnnoClass = RequestParam.class;
            String paramAnnoAliasName = null;
            Class<?> paramType = paramTypes[i];
            boolean isBaseType = this.isBaseType(paramType);
            String paramName = parameters[i].getName();
            Object paramValue = paramValues[i];
            for (int j = 0; j < paramAnnos[i].length; j++) {
                if (paramAnnos[i][j].annotationType() == PathVariable.class) {
                    paramAnnoClass = PathVariable.class;
                    PathVariable pathVariable = (PathVariable) paramAnnos[i][j];
                    paramAnnoAliasName = StrUtil.isNotBlank(pathVariable.name()) ? pathVariable.name() : StrUtil.isBlank(pathVariable.value()) ? null : pathVariable.value();
                    isBaseType = true;
                    break;
                }
                if (paramAnnos[i][j].annotationType() == RequestHeader.class) {
                    paramAnnoClass = RequestHeader.class;
                    RequestHeader requestHeader = (RequestHeader) paramAnnos[i][j];
                    paramAnnoAliasName = StrUtil.isNotBlank(requestHeader.name()) ? requestHeader.name() : StrUtil.isBlank(requestHeader.value()) ? null : requestHeader.value();
                    break;
                }
                if (paramAnnos[i][j].annotationType() == RequestParam.class) {
                    RequestParam requestParam = (RequestParam) paramAnnos[i][j];
                    paramAnnoAliasName = StrUtil.isNotBlank(requestParam.name()) ? requestParam.name() : StrUtil.isBlank(requestParam.value()) ? null : requestParam.value();
                    isBaseType = this.isBaseType(paramTypes[i]);
                    break;
                }
                if (paramAnnos[i][j].annotationType() == RequestBody.class) {
                    paramAnnoClass = RequestBody.class;
                    break;
                }
            }
            ParamDescription paramDesc = new ParamDescription();
            paramDesc.setParamAnnoClass(paramAnnoClass);
            paramDesc.setParamAnnoAliasName(paramAnnoAliasName);
            paramDesc.setParamType(paramType);
            paramDesc.setIsBaseType(isBaseType);
            paramDesc.setParamName(paramName);
            paramDesc.setParamValue(paramValue);
            paramDescList.add(paramDesc);
        }
        return paramDescList;
    }

    private void printRequest(List<ParamDescription> paramDescList) {
        Map<Class<? extends Annotation>, List<ParamDescription>> map = paramDescList.stream().collect(Collectors.groupingBy(ParamDescription::getParamAnnoClass));
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        for (Class<? extends Annotation> clazz : map.keySet()) {
            if (clazz == PathVariable.class) {
                List<ParamDescription> list1 = map.get(PathVariable.class);
                for (ParamDescription desc : list1) {
                    sb1.append(StrUtil.isNotBlank(desc.getParamAnnoAliasName()) ? desc.getParamAnnoAliasName() : desc.getParamName()).append("=").append(desc.getParamValue());
                }
            }
            if (clazz == RequestHeader.class) {
                List<ParamDescription> list2 = map.get(RequestHeader.class);
                for (ParamDescription desc : list2) {
                    sb2.append(!desc.getIsBaseType() ? this.getBeanStr(desc.getParamValue()) : (StrUtil.isNotBlank(desc.getParamAnnoAliasName()) ? desc.getParamAnnoAliasName() : desc.getParamName()) + "=" + desc.getParamValue());
                }
            }
            if (clazz == RequestParam.class) {
                List<ParamDescription> list3 = map.get(RequestParam.class);
                for (ParamDescription desc : list3) {
                    sb3.append(!desc.getIsBaseType() ? this.getBeanStr(desc.getParamValue()) : (StrUtil.isNotBlank(desc.getParamAnnoAliasName()) ? desc.getParamAnnoAliasName() : desc.getParamName()) + "=" + desc.getParamValue());
                }
            }
            if (clazz == RequestBody.class) {
                List<ParamDescription> list4 = map.get(RequestBody.class);
                for (ParamDescription desc : list4) {
                    sb4.append(JSON.toJSONString(desc.getParamValue()));
                }
            }
        }
        log.info("Request:【PATH】:{}; 【HEADER】:{}; 【QUERY】:{}; 【BODY】:{}", sb1, sb2, sb3, sb4);

    }

    private boolean isReqOrResp(Object paramValue) {
        return paramValue instanceof ServletRequest || paramValue instanceof ServletResponse;
    }

    private boolean isBaseType(Class<?> clazz) {
        return clazz == byte.class || clazz == Byte.class ||
                clazz == char.class || clazz == Character.class ||
                clazz == short.class || clazz == Short.class ||
                clazz == int.class || clazz == Integer.class ||
                clazz == long.class || clazz == Long.class ||
                clazz == float.class || clazz == Float.class ||
                clazz == boolean.class || clazz == Boolean.class || clazz == String.class;
    }

    private String getBeanStr(Object paramValue) {
        StringBuilder sb = new StringBuilder();
        Map<String, Object> map = BeanUtil.beanToMap(paramValue);
        for (String key : map.keySet()) {
            sb.append(key).append("=").append(map.get(key)).append(" ");
        }
        return sb.toString();
    }


    private void printResponse(Object obj) {
        log.info("Response:{}", JSON.toJSONString(obj));
    }

    private void printResult(String className, String methodName, Throwable throwable, StopWatch sw) {
        log.info("ResponseAfter:METHOD = {};  EX = {}; 耗时 = {}ms;", className + "." + methodName, throwable == null ? "-" : throwable.getClass().getSimpleName(), sw.getLastTaskTimeMillis());
    }


    @Data
    private static class ParamDescription {

        private Class<? extends Annotation> paramAnnoClass;

        private String paramAnnoAliasName;

        private Class<?> paramType;

        private Boolean isBaseType;

        private String paramName;

        private Object paramValue;
    }
}