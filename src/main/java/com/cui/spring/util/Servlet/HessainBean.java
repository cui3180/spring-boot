package com.cui.spring.util.Servlet;

import com.cui.spring.util.hessain.CustomHessianProxyFactoryBean;
import com.spring.cui.fs.service.TestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by cjs
 * Date： 2018/1/5.
 * Time： 15:44.
 */
@Configuration
public class HessainBean {

    @Bean
    public CustomHessianProxyFactoryBean helloClient() {
        CustomHessianProxyFactoryBean factory = new CustomHessianProxyFactoryBean();
        factory.setServiceUrl("http://localhost/service/collageService");
        factory.setServiceInterface(TestService.class);
        //factory.setToken("1111");
        factory.setOverloadEnabled(true);
        return factory;
    }
}
