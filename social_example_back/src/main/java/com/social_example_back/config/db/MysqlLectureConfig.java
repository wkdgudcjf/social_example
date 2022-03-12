package com.social_example_back.config.db;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages="com.gwatop_backend.api.temp.mapper", sqlSessionFactoryRef="MySqlTempSessionFactory", annotationClass = MysqlDatasourceSelector.Temp.class)
public class MysqlLectureConfig {
    @Bean(name = "MysqlTempDataSource")
    @ConfigurationProperties(prefix = "spring.mysql.temp.datasource")
    public DataSource dataSource() {
        HikariDataSource hikariDataSource = DataSourceBuilder.create().type(HikariDataSource.class).build();
        hikariDataSource.setMinimumIdle(4);
        hikariDataSource.setMaximumPoolSize(4);
        hikariDataSource.setConnectionTestQuery("SELECT 1");
        return hikariDataSource;
    }

    @Bean(name = "MySqlTempSessionFactory")
    public SqlSessionFactory MySqlSessionFactory(@Qualifier("MysqlTempDataSource") DataSource MyDataSource, ApplicationContext applicationContext) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(MyDataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/temp/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "MySqlTempSessionTemplate")
    public SqlSessionTemplate MySqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception { 
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
