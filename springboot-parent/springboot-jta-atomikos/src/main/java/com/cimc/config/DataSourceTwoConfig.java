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
@MapperScan(basePackages = "com.cimc.two", sqlSessionFactoryRef = "sqlSessionFactoryTwo")
public class DataSourceTwoConfig {

    @Bean(name = "dataSourceTwo")
    public DataSource dataSourceTwo(DBConfigTwo dbConfigTwo) throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(dbConfigTwo.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(dbConfigTwo.getPassword());
        mysqlXaDataSource.setUser(dbConfigTwo.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("dataSourceTwo");
        xaDataSource.setMinPoolSize(dbConfigTwo.getMinPoolSize());
        xaDataSource.setMaxPoolSize(dbConfigTwo.getMaxPoolSize());
        xaDataSource.setMaxLifetime(dbConfigTwo.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(dbConfigTwo.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(dbConfigTwo.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(dbConfigTwo.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(dbConfigTwo.getMaxIdleTime());
        xaDataSource.setTestQuery(dbConfigTwo.getTestQuery());
        return xaDataSource;

    }

    @Bean(name = "sqlSessionFactoryTwo")
    public SqlSessionFactory sqlSessionFactoryTwo(@Qualifier("dataSourceTwo") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com.cimc.entity");
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/two/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "sqlSessionTemplateTwo")
    public SqlSessionTemplate sqlSessionTemplateTwo(
            @Qualifier("sqlSessionFactoryTwo") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
