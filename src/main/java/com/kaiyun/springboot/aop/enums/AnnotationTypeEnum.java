/**
 * Project Name:springboot-aspectJ-aop
 * File Name:AnnotationTypeEnum.java
 * Package Name:com.kaiyun.springboot.aop.enums
 * Date:2019年3月26日上午11:26:39
 * Copyright (c) 2019, kaiyun@qk365.com All Rights Reserved.
 *
*/

package com.kaiyun.springboot.aop.enums;
/**
 * ClassName:AnnotationTypeEnum <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2019年3月26日 上午11:26:39 <br/>
 * @author   kaiyun
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public enum AnnotationTypeEnum {
	
	CONTROLLER("CONTROLLER", "controller"),
	SERVICE("SERVICE", "service");

    private String name;
    private String desc;
    
    
	private AnnotationTypeEnum() {
	}
	
	private AnnotationTypeEnum(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
    
}

