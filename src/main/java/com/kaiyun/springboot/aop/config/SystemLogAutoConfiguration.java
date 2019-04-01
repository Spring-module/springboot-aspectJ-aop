/**
 * Project Name:springboot-aspectJ-aop
 * File Name:SystemLogAutoConfiguration.java
 * Package Name:com.kaiyun.springboot.aop.config
 * Date:2019年3月26日上午11:21:42
 * Copyright (c) 2019, kaiyun@qk365.com All Rights Reserved.
 *
*/

package com.kaiyun.springboot.aop.config;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.kaiyun.springboot.aop.aspect.SystemLogAspect;

/**
 * ClassName:SystemLogAutoConfiguration <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2019年3月26日 上午11:21:42 <br/>
 * @author   kaiyun
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Configuration
@AutoConfigureOrder(5)
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ConditionalOnClass(SystemLogAspect.class)
@ConditionalOnMissingBean(SystemLogAspect.class)
public class SystemLogAutoConfiguration {

    @Bean
    public SystemLogAspect systemLogAspect() {
        return new SystemLogAspect();
    }
    
}

