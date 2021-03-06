package com.cui.spring.util.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by cjs
 * Date： 2017/12/15.
 * Time： 10:45.
 */
@Component
public class TestConfig extends WebMvcConfigurerAdapter {

    /**
     * 防止注入service 失败
     * @return
     */
    @Bean
    public HandlerInterceptor getMyInterceptor(){
        return new InterceptorTest();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(getMyInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
