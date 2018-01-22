package com.cui.spring.util.hessain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.stereotype.Component;

/**
 * Created by huangjun on 2017/9/14.
 */
public class CustomHessianProxyFactoryBean extends HessianProxyFactoryBean {
    private String token;
    @Autowired
    private CustomHessianProxyFactory customHessianProxyFactory;

    @Override
    public void afterPropertiesSet() {
        customHessianProxyFactory.setToken(token);
        setProxyFactory(customHessianProxyFactory);
        super.afterPropertiesSet();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
