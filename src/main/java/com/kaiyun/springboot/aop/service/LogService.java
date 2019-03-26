/**
 * Project Name:springboot-aspectJ-aop
 * File Name:LogTest.java
 * Package Name:com.kaiyun.springboot.aop.service
 * Date:2019年3月26日下午3:44:57
 * Copyright (c) 2019, kaiyun@qk365.com All Rights Reserved.
 *
*/

package com.kaiyun.springboot.aop.service;

import org.springframework.stereotype.Component;

import com.kaiyun.springboot.aop.annotation.SystemServiceLog;

import lombok.extern.slf4j.Slf4j;

/**
 * ClassName:LogTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2019年3月26日 下午3:44:57 <br/>
 * @author   kaiyun
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Slf4j
@Component
public class LogService {
	
	@SystemServiceLog
    public int testLog01(int a, int b) {
        log.info("进入+运算");
        return a + b;
    }

	@SystemServiceLog
    public int testLog02(int a, int b) {
		log.info("进入-运算");
        return a - b;
    }
}

