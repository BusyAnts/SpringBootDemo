package com.cimc.config;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author chenz
 * @create 2019-09-22 18:47
 */
@Configuration
@MapperScan(basePackages = "com.cimc.one", sqlSessionFactoryRef = "sqlSessionFactoryOne")
public class DataSourceOneConfig {

    @Bean(name = "dataSourceOne")
    public DataSource dataSourceOne(DBConfigOne dbConfigOne) throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(dbConfigOne.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(dbConfigOne.getPassword());
        mysqlXaDataSource.setUser(dbConfigOne.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("dataSourceOne");
        xaDataSource.setMinPoolSize(dbConfigOne.getMinPoolSize());
        xaDataSource.setMaxPoolSize(dbConfigOne.getMaxPoolSize());
        xaDataSource.setMaxLifetime(dbConfigOne.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(dbConfigOne.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(dbConfigOne.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(dbConfigOne.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(dbConfigOne.getMaxIdleTime());
        xaDataSource.setTestQuery(dbConfigOne.getTestQuery());
        return xaDataSource;

    }

    @Bean(name = "sqlSessionFactoryOne")
    public SqlSessionFactory sqlSessionFactoryOne(@Qualifier("dataSourceOne") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com.cimc.entity");
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/one/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "sqlSessionTemplateOne")
    public SqlSessionTemplate sqlSessionTemplateOne(
            @Qualifier("sqlSessionFactoryOne") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
