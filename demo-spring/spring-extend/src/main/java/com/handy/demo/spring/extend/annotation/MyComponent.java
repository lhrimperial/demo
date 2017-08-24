package com.handy.demo.spring.extend.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author longhairen
 * @create 2017/8/23 0023 上午 10:42
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MyComponent {
    String value() default "";
}
