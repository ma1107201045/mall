package com.lingyi.mall.common.redis.util;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.context.expression.MethodBasedEvaluationContext;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.lang.reflect.Method;


/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/7/16 19:02
 * @Description:
 */
public class SpelUtil {

    /**
     * 支持 #p0 参数索引的表达式解析
     *
     * @param rootObject 根对象,method 所在的对象
     * @param spel       表达式
     * @param method     目标方法
     * @param args       方法参数值集
     * @return 解析后的字符串
     */
    public static String parse(Object rootObject, String spel, Method method, Object[] args) {
        if (StrUtil.isBlank(spel)) {
            return StrUtil.EMPTY;
        }
        //获取被拦截方法参数名列表(使用Spring支持类库)
        var parameterNameDiscoverer = new DefaultParameterNameDiscoverer();
        var paraNames = parameterNameDiscoverer.getParameterNames(method);
        if (ArrayUtil.isEmpty(paraNames)) {
            return spel;
        }
        //使用SPEL进行key的解析
        var parser = new SpelExpressionParser();
        //SPEL上下文
        var context = new MethodBasedEvaluationContext(rootObject, method, args, parameterNameDiscoverer);
        //把方法参数放入SPEL上下文中
        for (var i = 0; i < paraNames.length; i++) {
            context.setVariable(paraNames[i], args[i]);
        }
        return parser.parseExpression(spel).getValue(context, String.class);
    }
}
