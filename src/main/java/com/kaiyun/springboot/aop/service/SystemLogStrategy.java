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

	private boolean async;

    private String threadId;

    private String location;

    private String description;

    private String className;

    private String methodName;

    private String arguments;

    private String result;

    private Long elapsedTime;


    public String format() {
        return "线程ID: {}, 注解位置: {}, 方法描述: {}, 目标类名: {}, 目标方法: {}, 调用参数: {}, 返回结果: {}, 花费时间: {}";
    }

	public Object[] args() {
		return new Object[] { this.threadId, this.location, this.description, this.className, this.methodName,
				this.arguments, this.result, this.elapsedTime };
	}

}
