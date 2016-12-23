package com.wyh.annotation;


import privilege.PrivilegeBean;

import java.lang.annotation.*;

/**
 * Created by zhangwj on 16/3/5.
 */
@Documented
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PrivilegeRequired {
    PrivilegeBean[] privileges() default {};
}
