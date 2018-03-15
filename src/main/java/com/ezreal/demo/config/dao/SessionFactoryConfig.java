package com.ezreal.demo.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Sql 事务提交配置
 */

@Configuration
public class SessionFactoryConfig {

    @Value("${mybatis_config_file}")
    private String mybatisConfigFilePath;

    @Value("${mapper_path}")
    private String mapperPath;

    @Value("${entity_package}")
    private String entityPackage;

    @Autowired
    @Qualifier("dataSource")  // 以别名的方式加载
    private DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        // 设置扫描路径,配置文件路径
        factoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
        // 指定 mapper 的路径
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
        factoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
        // 指定dataSource
        factoryBean.setDataSource(dataSource);
        // 指定映射实体类路径
        factoryBean.setTypeAliasesPackage(entityPackage);
        return factoryBean;
    }
}
