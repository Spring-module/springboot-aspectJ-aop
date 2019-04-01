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

/**
 * ClassName:LogTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2019年3月26日 下午3:44:57 <br/>
 * @author   kaiyun
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Component
public class LogService {
	/**
	 * testLog01:testLog01. <br/>
	 *
	 * @param a
	 * @param b
	 * @return
	 * @since JDK 1.8
	 * @author kaiyun
	 */
	@SystemServiceLog(description="＋运算")
    public int testLog01(int a, int b) {
        return a + b;
    }

	@SystemServiceLog(description="－运算")
    public int testLog02(int a, int b) {
        return a - b;
    }
}

