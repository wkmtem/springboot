package com.compass.examination.springboot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import com.jolbox.bonecp.BoneCPDataSource;

/**
 * 
 * <p>Class Name: DataBaseConfig</p>
 * <p>Description: 数据库配置</p>
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年10月15日下午11:36:37
 * @version 2.0
 */
@SpringBootConfiguration
@PropertySource(value = { "classpath:properties/boneCP.properties" }, ignoreResourceNotFound = true)
public class DataBaseConfig {

	@Value("${boneCP.driverClass}")
    private String driverClass;
    @Value("${boneCP.username}")
    private String username;
    @Value("${boneCP.password}")
    private String password;
    @Value("${boneCP.url}")
    private String url;
    
    @Value("${boneCP.idleConnectionTestPeriodInMinutes}")
    private String idleConnectionTestPeriodInMinutes;
    @Value("${boneCP.idleMaxAgeInMinutes}")
    private String idleMaxAgeInMinutes;
    @Value("${boneCP.maxConnectionsPerPartition}")
    private String maxConnectionsPerPartition;
    @Value("${boneCP.minConnectionsPerPartition}")
    private String minConnectionsPerPartition;

    // bean名称(id): 未指定,则是带注释的方法的名称; 指定, 方法名将被忽略。bean的名称和别名也可以通过value指定。
    @Bean(name = "dataSource", destroyMethod = "close") // 销毁方法参数:"close"
    public DataSource dataSource() {
        BoneCPDataSource boneCPDataSource = new BoneCPDataSource();
        boneCPDataSource.setDriverClass(driverClass);
        boneCPDataSource.setUsername(username);
        boneCPDataSource.setPassword(password);
        boneCPDataSource.setJdbcUrl(url);
        
        // 检查数据库连接池中空闲连接的间隔时间, 单位:分钟, 默认:240, 取消:0
        boneCPDataSource.setIdleConnectionTestPeriodInMinutes(Integer.parseInt(idleConnectionTestPeriodInMinutes));
        // 连接池中未使用的连接最大存活时间, 单位:分钟, 默认:60, 永远存活:0
        boneCPDataSource.setIdleMaxAgeInMinutes(Integer.parseInt(idleMaxAgeInMinutes));
        // 每个分区最大的连接数, 判断依据: 请求并发数
        boneCPDataSource.setMaxConnectionsPerPartition(Integer.parseInt(maxConnectionsPerPartition));
        // 每个分区最小的连接数, 判断依据: 请求并发数
        boneCPDataSource.setMinConnectionsPerPartition(Integer.parseInt(minConnectionsPerPartition));
        return boneCPDataSource;
    }
}
