package com.social_example_back.config.db;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages="com.gwatop_backend.api.user.mapper", sqlSessionFactoryRef="MySqlUserSessionFactory", annotationClass = MysqlDatasourceSelector.User.class)
public class MysqlUserConfig {
    @Bean(name = "MysqlUserDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.mysql.user.datasource")
    public DataSource dataSource() {
        HikariDataSource hikariDataSource = DataSourceBuilder.create().type(HikariDataSource.class).build();
        hikariDataSource.setMinimumIdle(4);
        hikariDataSource.setMaximumPoolSize(4);
        hikariDataSource.setConnectionTestQuery("SELECT 1");
        return hikariDataSource;
    }

    @Bean(name = "MySqlUserSessionFactory")
    @Primary
    public SqlSessionFactory MySqlSessionFactory(@Qualifier("MysqlUserDataSource") DataSource MyDataSource, ApplicationContext applicationContext) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(MyDataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/user/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "MySqlUseressionTemplate")
    @Primary
    public SqlSessionTemplate MySqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception { 
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
