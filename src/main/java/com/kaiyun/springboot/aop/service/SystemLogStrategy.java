/**
 * Project Name:springboot-aspectJ-aop
 * File Name:SystemLogStrategy.java
 * Package Name:com.kaiyun.springboot.aop.pojo
 * Date:2019年3月26日上午11:11:45
 * Copyright (c) 2019, kaiyun@qk365.com All Rights Reserved.
 *
*/

package com.kaiyun.springboot.aop.service;

import java.io.Serializable;

import lombok.Data;

/**
 * ClassName:SystemLogStrategy <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2019年3月26日 上午11:11:45 <br/>
 * @author   kaiyun
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Data
public class SystemLogStrategy implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private boolean async;		// 是否是同步方法

    private String threadId;	// 线程ID

    private String location;	// 注解位置

    private String description;	// 方法描述

    private String className;	// 目标类名

    private String methodName;	// 目标方法

    private String arguments;	// 调用参数

    private String result;		// 返回结果

    private Long elapsedTime;	// 花费时间


    public String format() {
        return "\n线程ID: {}, \n注解位置: {}, \n方法描述: {}, \n目标类名: {}, \n目标方法: {}, \n调用参数: {}, \n返回结果: {}, \n花费时间: {}ms";
    }

	public Object[] args() {
		return new Object[] { this.threadId, this.location, this.description, this.className, this.methodName,
				this.arguments, this.result, this.elapsedTime };
	}

}

