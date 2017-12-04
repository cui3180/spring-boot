package com.cui.spring;

import com.cui.fs.api.CollageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import java.util.concurrent.CountDownLatch;

/**
 * Created by cjs
 * Date： 2017/7/12.
 * Time： 11:30.
 */
@ServletComponentScan
@SpringBootApplication
@ImportResource(locations = {"classpath*:/spring/spring-config.xml"})
public class Application extends SpringBootServletInitializer {

    //hessian 调用接口
    @Bean
    public HessianProxyFactoryBean helloClient() {
        HessianProxyFactoryBean factory = new HessianProxyFactoryBean();
        factory.setServiceUrl("http://localhost/service/collageService");
        factory.setServiceInterface(CollageService.class);
        return factory;
    }
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