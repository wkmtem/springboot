package com.compass.examination.springboot.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;

/**
 * 
 * <p>Class Name: MapperScannerConfig</p>
 * <p>Description: Mapper接口扫描配置</p>
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年10月16日上午1:25:41
 * @version 2.0
 */
@SpringBootConfiguration
@AutoConfigureAfter(MyBatisConfig.class) // 保证在MyBatisConfig实例化之后再实例化该类
public class MapperScannerConfig {
    
    /**
     * 
     * <p>Method Name: mapperScannerConfigurer</p>
     * <p>Description: Mapper接口扫描器</p>
     * @author wkm
     * @date 2017年10月16日上午1:26:40
     * @version 2.0
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.compass.examination.core.dao");
        return mapperScannerConfigurer;
    }
}
