/**
 * Project Name:springboot-aspectJ-aop
 * File Name:SystemControllerLog.java
 * Package Name:com.kaiyun.springboot.aop.annotation
 * Date:2019年3月26日上午11:08:23
 * Copyright (c) 2019, kaiyun@qk365.com All Rights Reserved.
 *
*/

package com.kaiyun.springboot.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName:SystemControllerLog <br/>
 * Function: 注解定义. <br/>
 * Date:     2019年3月26日 上午11:08:23 <br/>
 * @author   kaiyun
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface SystemControllerLog {
	
	String description() default "";

    boolean async() default false;

}

