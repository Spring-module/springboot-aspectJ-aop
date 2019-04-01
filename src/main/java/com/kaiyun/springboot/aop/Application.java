package com.kaiyun.springboot.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.context.request.RequestContextListener;

/**
 * Created by kaiyun on 2017/4/10.
 */
@SpringBootApplication
@ImportResource({ "classpath:spring-ctx.xml" })
public class Application {

	@Bean
	public RequestContextListener requestContextListener() {
		return new RequestContextListener();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
