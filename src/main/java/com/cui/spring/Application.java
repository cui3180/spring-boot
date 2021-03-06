package com.cui.spring;

import com.cui.fs.api.CollageService;
import com.cui.spring.util.hessain.CustomHessianProxyFactory;
import com.cui.spring.util.hessain.CustomHessianProxyFactoryBean;
import com.spring.cui.fs.service.TestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.CountDownLatch;

/**
 * Created by cjs
 * Date： 2017/7/12.
 * Time： 11:30.
 */
@ServletComponentScan
@SpringBootApplication
@ImportResource(locations = {"classpath*:/spring/spring-config.xml"})
@EnableScheduling
@EnableAsync
public class Application extends SpringBootServletInitializer {



    @Bean
    public  CountDownLatch latch(){
        return new CountDownLatch(1);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}