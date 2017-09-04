package com.handy.demo.sboot.starter;

import com.handy.demo.sboot.starter.servlet.MyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author longhairen
 * @create 2017/8/15 0015 下午 6:42
 * "com.lvmama.boot",
 */
@SpringBootApplication
//@ComponentScan({"com.handy.demo"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * 在spring boot中添加自己的Servlet有两种方法，代码注册Servlet和注解自动注册（Filter和Listener也是如此）。
     * 一、代码注册通过ServletRegistrationBean、 FilterRegistrationBean 和 ServletListenerRegistrationBean 获得控制。
     * 也可以通过实现 ServletContextInitializer 接口直接注册。
     *
     * 二、在 SpringBootApplication 上使用@ServletComponentScan 注解后，Servlet、Filter、Listener
     * 可以直接通过 @WebServlet、@WebFilter、@WebListener 注解自动注册，无需其他代码。
     *
     * @return
     */
 /*   @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new MyServlet(), "/xs*//*");// ServletName默认值为首字母小写，即myServlet
    }*/

    /**
     * 修改DispatcherServlet默认配置
     * @param dispatcherServlet
     * @return
     */
/*    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
        registration.getUrlMappings().clear();
        registration.addUrlMappings("*.do");
        registration.addUrlMappings("*.json");
        return registration;
    }*/

}
