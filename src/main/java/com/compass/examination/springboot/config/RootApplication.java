package com.compass.examination.springboot.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * <p>Class Name: ProjectApplication</p>
 * <p>Description: Spring Boot 入口类</p>
 * 				   springboot项目一般都会有*Application入口类，入口main函数，提取至项目基路径
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年10月15日下午11:36:55
 * @version 2.0
 */
@SpringBootConfiguration // 配置类, 推荐替代@Configuration
@ComponentScan(basePackages = "com.compass.examination") // spring扫包, 如未指定包, 则默认扫描注解所在类的包及子包, 约定优于配置, 尽可能不要去配置而使用默认
	//, excludeFilters = {@Filter(type = FilterType.ANNOTATION, value = Controller.class)})
@SpringBootApplication // 核心注解，开启自动配置, (exclude = { XxxxAutoConfiguration.class })则是关闭某项自动配置
public class RootApplication extends SpringBootServletInitializer{ 	

	/**
	 * （非 Javadoc）
	 * Method Name: configure
	 * Description: 设置启动类，用于独立tomcat运行的入口
	 * @author wkm
	 * @date 2017年10月16日上午4:35:21
	 * @version 2.0
	 * @param builder
	 * @return
	 * @see org.springframework.boot.web.support.SpringBootServletInitializer#configure(org.springframework.boot.builder.SpringApplicationBuilder)
	 */
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(RootApplication.class);
    }
}
