package com.hus.common.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by zhh on 2017/3/3.
 */
@Configuration
@MapperScan("com.hus.web.mapper")
public class MybaitsConfig {

    @Autowired
    private DataSource dataSource;
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory() {
        SqlSessionFactoryBean session = new SqlSessionFactoryBean();
        try {
            session.setDataSource(dataSource);
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            session.setMapperLocations(resolver.getResources("classpath:sqlMap/*.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return session;
    }
}
