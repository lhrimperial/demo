package com.handy.demo.spring.extend.configurer;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author longhairen
 * @create 2017/8/23 0023 上午 11:21
 */
public class FactoryBeanTest<T> implements InitializingBean, FactoryBean<T> {
    private String innerClassName;
    public void setInnerClassName(String innerClassName) {
        this.innerClassName = innerClassName;
    }
    public T getObject() throws Exception {
        Class innerClass = Class.forName(innerClassName);
        if (innerClass.isInterface()) {
            return (T) InterfaceProxy.newInstance(innerClass);
        } else {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(innerClass);
            enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
            enhancer.setCallback(new MethodInterceptorImpl());
            return (T) enhancer.create();
        }
    }
    public Class<?> getObjectType() {
        try {
            return Class.forName(innerClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean isSingleton() {
        return true;
    }
    public void afterPropertiesSet() throws Exception {
    }
}
