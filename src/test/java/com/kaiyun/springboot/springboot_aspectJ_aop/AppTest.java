package com.kaiyun.springboot.springboot_aspectJ_aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.kaiyun.springboot.aop.service.LogService;

@RunWith(SpringRunner.class) // 整合 
@ContextConfiguration(locations={"classpath:spring-ctx.xml"}) // 加载配置
public class AppTest{
	@Autowired
	private LogService logService;
	
	@Test
	public void testOne () {
		try {
			logService.testLog01(1, 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
