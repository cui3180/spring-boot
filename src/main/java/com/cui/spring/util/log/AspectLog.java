/*
package com.cui.spring.util.log;

import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

*/
/**
 * Created by cjs
 * Date： 2017/12/14.
 * Time： 15:08.
 *//*

//申明是个切面
@Aspect
//申明是个spring管理的bean
@Component
@Order(1)
public class AspectLog {
    private Logger log = Logger.getLogger(getClass());
    private Gson gson = new Gson();

    //申明一个切点 里面是 execution表达式
    @Pointcut("execution(public * com.cui.spring.web.CollageController.*(..))")
    private void controllerAspect() {
    }

    //请求method前打印内容
    @Before(value = "controllerAspect()")
    public void methodBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //打印请求内容
        log.info("===============请求内容===============");
        log.info("请求地址:" + request.getRequestURL().toString());
        log.info("请求方式:" + request.getMethod());
        log.info("请求类方法:" + joinPoint.getSignature() + "请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
        log.info("===============请求内容===============");
    }

    //在方法执行完结后打印返回内容
    @AfterReturning(returning = "o", pointcut = "controllerAspect()")
    public void methodAfterReturing(Object o) {
        log.info("--------------返回内容----------------");
        log.info("Response内容:" + gson.toJson(o));
        log.info("--------------返回内容----------------");
    }
}*/
