package com.lee.dianping.common;

import java.lang.annotation.*;

/**
 * @Description 管理员权限注解
 * @Author 61671
 * @Date 2022/8/26 14:53
 * @Version 1.0.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AdminPermission {

    String produceType() default "text/html";
}
