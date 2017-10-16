package com.compass.examination.springboot.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * 
 * <p>Class Name: MyBatisConfig</p>
 * <p>Description: MyBatis 配置</p>
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年10月16日上午12:55:46
 * @version 2.0
 */
@SpringBootConfiguration
public class MyBatisConfig {

    @Bean
    @ConditionalOnMissingBean({SqlSessionFactoryBean.class}) // 仅在当前上下文中不存在实例对象时，实例化Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) { // spring IOC
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        // MyBatis主配置文件
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource mybatisConfigXml = resolver.getResource("classpath:config/mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(mybatisConfigXml);
        // 设置别名包
        sqlSessionFactoryBean.setTypeAliasesPackage("com.compass.examination.pojo");

        return sqlSessionFactoryBean;
    }
}
