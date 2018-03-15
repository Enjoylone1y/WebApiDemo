package com.ezreal.demo.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
 * DataSource 的配置类，取代以往xml配置文件
 * DataSource 用于连接数据库
 */
// 通知 spring 检索该类，注入类中的 dataSource
@Configuration
// 声明 dao 位置，配置 mybatis mapper 的扫描路径
@MapperScan("com.ezreal.demo.dao")

public class DataSourceConfig {

    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUserName;
    @Value("${jdbc.password}")
    private String jdbcPassWord;

    /**
     * 声明 dataSource bean，spring ioc 将会动态注入
     * @return 数据库连接池 ComboPooledDataSource
     */
    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        // 设置驱动
        dataSource.setDriverClass(jdbcDriver);
        // 设置 Url
        dataSource.setJdbcUrl(jdbcUrl);
        // 设置用户名
        dataSource.setUser(jdbcUserName);
        // 设置密码
        dataSource.setPassword(jdbcPassWord);
        // 连接关闭后，是否自动提交
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }

}
