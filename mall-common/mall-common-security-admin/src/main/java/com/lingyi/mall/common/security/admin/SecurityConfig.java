package com.lingyi.mall.common.security.admin;

import com.lingyi.mall.common.security.admin.constant.SecurityAdminConstant;
import com.lingyi.mall.common.base.filter.TrackIdFilter;
import com.lingyi.mall.common.security.admin.filter.ImageCaptchaFilter;
import com.lingyi.mall.common.security.admin.handler.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
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
    public ImageCaptchaFilter imageCaptchaFilter() {
        return new ImageCaptchaFilter();
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
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   TrackIdFilter trackIdFilter,
                                                   ImageCaptchaFilter imageCaptchaFilter,
                                                   AuthenticationSuccessHandler authenticationSuccessHandler,
                                                   AuthenticationFailureHandler authenticationFailureHandler,
                                                   LogoutSuccessHandler logoutSuccessHandler,
                                                   AuthenticationEntryPoint authenticationEntryPoint,
                                                   AccessDeniedHandler accessDeniedHandler) throws Exception {
        return http.addFilterBefore(trackIdFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(imageCaptchaFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(authorizeHttpRequestsConfigurer -> authorizeHttpRequestsConfigurer
                        .requestMatchers(HttpMethod.GET, "/swagger-ui/**", "/doc.html", "/webjars/**", "/v3/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/auth/admin/get-base64-image-captcha", "/auth/admin/get-bin-image-captcha").permitAll()
                        .requestMatchers(HttpMethod.POST, "/admin/file/files/**").permitAll()
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
                        .rememberMeParameter(SecurityAdminConstant.IS_REMEMBER_ME_PARAMETER)
                        .rememberMeCookieName(SecurityAdminConstant.REMEMBER_ME_COOKIE_NAME))
                .exceptionHandling(exceptionHandlingConfigurer -> exceptionHandlingConfigurer
                        .authenticationEntryPoint((authenticationEntryPoint))
                        .accessDeniedHandler(accessDeniedHandler))
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
