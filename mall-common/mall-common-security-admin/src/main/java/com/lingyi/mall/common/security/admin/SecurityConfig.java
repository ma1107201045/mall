package com.lingyi.mall.common.security.admin;

import com.lingyi.mall.common.security.admin.constant.SecurityAdminConstant;
import com.lingyi.mall.common.base.filter.TrackIdFilter;
import com.lingyi.mall.common.security.admin.filter.CaptchaFilter;
import com.lingyi.mall.common.security.admin.handler.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;


/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/2 13:14
 * @description
 */
@Configuration(proxyBeanMethods = false)
public class SecurityConfig {


    @Bean
    public TrackIdFilter trackIdFilter() {
        return new TrackIdFilter();
    }

    @Bean
    public CaptchaFilter captchaFilter() {
        return new CaptchaFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new JsonAuthenticationSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new JsonAuthenticationFailureHandler();
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new JsonLogoutSuccessHandler();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new JsonAuthenticationEntryPoint();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new JsonAccessDeniedHandler();
    }

    @Bean
    public CorsConfiguration corsConfiguration() {
        //1.添加CORS配置信息
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //放行哪些原始域
        corsConfiguration.addAllowedOriginPattern("*");
        //是否发送Cookie信息
        corsConfiguration.setAllowCredentials(true);
        //放行哪些原始域(请求方式)
        corsConfiguration.addAllowedMethod("*");
        //放行哪些原始域(头部信息)
        corsConfiguration.addAllowedHeader("*");
        //暴露哪些头部信息(因为跨域访问默认不能获取全部头部信息)
        corsConfiguration.addExposedHeader("*");
        return corsConfiguration;
    }
    @Bean
    public UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource(CorsConfiguration corsConfiguration) {
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", corsConfiguration);
        return configSource;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   TrackIdFilter trackIdFilter,
                                                   CaptchaFilter captchaFilter,
                                                   AuthenticationSuccessHandler authenticationSuccessHandler,
                                                   AuthenticationFailureHandler authenticationFailureHandler,
                                                   LogoutSuccessHandler logoutSuccessHandler,
                                                   AuthenticationEntryPoint authenticationEntryPoint,
                                                   AccessDeniedHandler accessDeniedHandler,
                                                   UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource) throws Exception {
        return http.addFilterBefore(trackIdFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(captchaFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(authorizeHttpRequestsConfigurer -> authorizeHttpRequestsConfigurer
                        .requestMatchers(HttpMethod.GET, "/swagger-ui/**", "/doc.html", "/webjars/**", "/v3/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/auth/admin/get-captcha").permitAll()
                        .requestMatchers(HttpMethod.POST, "/admin/system/logs").permitAll()
                        .requestMatchers(HttpMethod.GET, "/admin/system/users/permissions").permitAll()
                        .anyRequest().authenticated())
                .formLogin(formLoginConfigurer -> formLoginConfigurer.loginProcessingUrl(SecurityAdminConstant.LOGIN_PROCESSING_URL)
                        .usernameParameter(SecurityAdminConstant.USER_NAME_PARAMETER)
                        .passwordParameter(SecurityAdminConstant.PASSWORD_PARAMETER)
                        .successHandler(authenticationSuccessHandler)
                        .failureHandler(authenticationFailureHandler))
                .logout(logoutConfigurer -> logoutConfigurer.logoutUrl(SecurityAdminConstant.LOGOUT_URL)
                        .logoutSuccessHandler(logoutSuccessHandler))
                .rememberMe(rememberMeConfigurer -> rememberMeConfigurer.key(SecurityAdminConstant.REMEMBER_ME_KEY)
                        .rememberMeParameter(SecurityAdminConstant.REMEMBER_ME_PARAMETER)
                        .rememberMeCookieName(SecurityAdminConstant.REMEMBER_ME_COOKIE_NAME))
                .exceptionHandling(exceptionHandlingConfigurer -> exceptionHandlingConfigurer
                        .authenticationEntryPoint((authenticationEntryPoint))
                        .accessDeniedHandler(accessDeniedHandler))
                .cors(corsConfigurer -> corsConfigurer.configurationSource(urlBasedCorsConfigurationSource))
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return web -> web.ignoring().requestMatchers("doc.html",
//                "/v3/**",
//                "/favicon.ico",
//                "/images/**",
//                "/js/**",
//                "/webjars/**");
//    }


}
