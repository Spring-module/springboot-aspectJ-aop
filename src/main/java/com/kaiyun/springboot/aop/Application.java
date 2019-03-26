package com.kaiyun.springboot.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by fanya on 2017/4/10.
 */
@SpringBootApplication
@ImportResource({"classpath:spring-ctx.xml"})
public class Application {
	    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
