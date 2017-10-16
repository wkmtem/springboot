package com.compass.examination;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;

import com.compass.examination.springboot.config.RootApplication;

/**
 * 
 * <p>Class Name: Main</p>
 * <p>Description: Spring Boot 标准入口函数</p>
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年10月16日上午4:45:48
 * @version 2.0
 */
public class Main {
    
	public static void main(String[] args) {
		// 运行的应用必须包含@SpringBootApplication注解
	    //SpringApplication.run(ProjectApplication.class, args); 
	    SpringApplication application = new SpringApplication(RootApplication.class);
	    // Banner 开:CONSOLE, 关:OFF
	    application.setBannerMode(Mode.CONSOLE); 
	    application.run(args);
	}
}
