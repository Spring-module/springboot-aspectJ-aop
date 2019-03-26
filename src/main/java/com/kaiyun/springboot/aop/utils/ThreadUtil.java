/**
 * Project Name:springboot-aspectJ-aop
 * File Name:ThreadUtil.java
 * Package Name:com.kaiyun.springboot.aop.utils
 * Date:2019年3月26日上午11:20:05
 * Copyright (c) 2019, kaiyun@qk365.com All Rights Reserved.
 *
*/

package com.kaiyun.springboot.aop.utils;

import java.util.UUID;

/**
 * ClassName:ThreadUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2019年3月26日 上午11:20:05 <br/>
 * @author   kaiyun
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class ThreadUtil {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static String getThreadId() {
        String threadId = threadLocal.get();
        if (null == threadId) {
            threadId = UUID.randomUUID().toString();
            threadLocal.set(threadId);
        }
        return threadId;
    }

}

