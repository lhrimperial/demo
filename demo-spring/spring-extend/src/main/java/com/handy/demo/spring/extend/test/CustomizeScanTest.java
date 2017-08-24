package com.handy.demo.spring.extend.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author longhairen
 * @create 2017/8/23 0023 上午 11:39
 */
public class CustomizeScanTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(CustomizeScanTest.class);
        annotationConfigApplicationContext.refresh();
        ScanClass1 injectClass = annotationConfigApplicationContext.getBean(ScanClass1.class);
        injectClass.print();
    }
}
