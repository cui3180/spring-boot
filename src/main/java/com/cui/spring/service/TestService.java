package com.cui.spring.service;

import com.cui.spring.model.Test;
import com.cui.spring.model.User;
import com.cui.spring.util.BaseResponseVo;

/**
 * Created by cjs
 * Date： 2017/12/14.
 * Time： 15:59.
 */
public interface TestService {
    /**
     * log test
     * @param ad
     * @param type
     * @param user
     * @return
     */
    BaseResponseVo testMothed(String ad , Integer type , User user);


    /**
     * Interceptor
     * @param str
     * @return
     */
    BaseResponseVo testInterceptor (String str);

    /**
     * addTest
     * @param test
     * @return
     */
    BaseResponseVo addTest(Test test);

}
