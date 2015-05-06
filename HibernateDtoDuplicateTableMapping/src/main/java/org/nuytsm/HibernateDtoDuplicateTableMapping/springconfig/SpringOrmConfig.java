package org.nuytsm.HibernateDtoDuplicateTableMapping.springconfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class SpringOrmConfig {
		
	@Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }
		
	@Bean
	public DataSource dsLocal() {
        BasicDataSource bean = new BasicDataSource();
        bean.setDriverClassName("org.hsqldb.jdbcDriver");
        bean.setUrl("jdbc:hsqldb:mem:pu");
        bean.setUsername("SA");
        bean.setPassword("");
        bean.setInitialSize(10);
        bean.setMaxActive(5);
        bean.setMaxWait(5000);
        return bean;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setPersistenceUnitName("PU");
        bean.setDataSource(dsLocal());
        bean.setJpaVendorAdapter(jpaVendorAdapter());
        bean.setPackagesToScan(new String[]{"org.nuytsm.HibernateDtoDuplicateTableMapping"});
        bean.setJpaProperties(additionalProperties());
        return bean;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter bean = new HibernateJpaVendorAdapter();
        bean.setDatabasePlatform("org.hibernate.dialect.HSQLDialect");
        bean.setGenerateDdl(true);
        bean.setShowSql(true);
        return bean;
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.hbm2ddl.auto", "create-drop");
        properties.put("hibernate.generate_statistics", false);
        return properties;
    }

}
