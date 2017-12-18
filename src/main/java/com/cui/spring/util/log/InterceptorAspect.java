package com.cui.spring.util.log;

import com.cui.spring.service.TestService;
import com.cui.spring.util.BaseResponseVo;
import com.cui.spring.util.exception.ErrorCode;
import com.cui.spring.util.exception.ServiceException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by cjs
 * Date： 2017/12/15.
 * Time： 11:26.
 */
@Component
@Aspect
public class InterceptorAspect {
    @Pointcut("@annotation(com.cui.spring.util.log.InterceptorAdmin)")
    private void cut() {
    }
    @Autowired
    private TestService testService;

    @Before("cut()")
    public void testAspect(JoinPoint joinPoint){
        System.out.print("++++++++++++++++++++++++++++++++++++++"+joinPoint.getSignature());
        BaseResponseVo baseResponseVo = testService.testInterceptor(null);

    }

}
