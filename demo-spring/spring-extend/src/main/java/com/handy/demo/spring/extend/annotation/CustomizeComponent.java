package com.handy.demo.spring.extend.annotation;

import java.lang.annotation.*;

/**
 * @author longhairen
 * @create 2017/8/23 0023 上午 11:09
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomizeComponent {
    String value() default "";
}
