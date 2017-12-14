package com.cui.spring.util.log;

/**
 * Created by cjs
 * Date： 2017/12/14.
 * Time： 15:31.
 */
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Component
@Aspect
public class LogAspect {
    private Logger log = Logger.getLogger(getClass());
    @Pointcut("@annotation(com.cui.spring.util.log.Log)")
    private void cut() {
    }
    @Before("cut()")
    public void methodBefore(JoinPoint joinPoint) {
        //ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //HttpServletRequest request = requestAttributes.getRequest();
        //打印请求内容
       /* log.info("请求地址:" + request.getRequestURL().toString());
        log.info("请求方式:" + request.getMethod());*/
        log.info("请求类方法:" + joinPoint.getSignature() + "请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
    }
    //在方法执行完结后打印返回内容
    @AfterReturning(returning = "o", pointcut = "cut()")
    public void methodAfterReturing(JoinPoint joinPoint,Object o) {
        log.info("Response内容:"+ joinPoint.getSignature() +"返回参数："+ JSONObject.toJSONString(o));
    }

    @AfterThrowing( throwing="ex" , pointcut = "cut()")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        log.info("调用异常:"+ joinPoint.getSignature() +"异常信息："+ ex);
    }

}
