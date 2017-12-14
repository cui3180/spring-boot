package com.cui.spring.util.log;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Created by cjs
 * Date： 2017/12/14.
 * Time： 15:29.
 */
@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface Log {
    String value() default "我是日志注解";
}
