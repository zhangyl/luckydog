package com.fast.snail.luckydog.dao.config;


import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

@Configuration
@MapperScan(value = "com.fast.snail.luckydog.dao")
public class MyBatisConfig {


    @Value("${spring.datasource.driver-class-name}")
    private String jdbcDriver;
    @Value("${spring.datasource.url}")
    private String jdbcUrl;
    @Value("${spring.datasource.username}")
    private String jdbcUser;
    @Value("${spring.datasource.password}")
    private String jdbcPassword;


    @Autowired(required = false)

    /**
     * 使用单纯application-jdbc.yaml时候，需要打开。
     * 使用使用单纯application.yaml(shardingsphere)时候，不用配置这个数据源
     */

//    @Bean
//    public DataSource createDataSource() throws PropertyVetoException {
//    	DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(jdbcDriver);
//        dataSource.setUrl(jdbcUrl);
//        dataSource.setUsername(jdbcUser);
//        dataSource.setPassword(jdbcPassword);
//        return dataSource;
//    }
    @Bean
    public DataSourceTransactionManager jdbcTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

        sessionFactory.setDataSource(dataSource);


        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath:mybatis/*Mapper.xml"));

        SqlSessionFactory sqlSessionFactory = sessionFactory.getObject();

        return sqlSessionFactory;
    }

    
}
