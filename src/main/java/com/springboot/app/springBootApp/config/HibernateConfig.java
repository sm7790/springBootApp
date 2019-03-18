package com.springboot.app.springBootApp.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
 
    @Bean
    public LocalSessionFactoryBean getSessionFactory() throws PropertyVetoException {
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
       
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
        hibernateProperties.put("hibernate.show_sql", "true");
        
        bean.setHibernateProperties(hibernateProperties);
        bean.setDataSource(getDataSource());
        bean.setPackagesToScan("com.springboot.app.springBootApp.beans");
        return bean;
    }
    
   /* @Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Environment env) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan("pl.devpragmatic.lifetimer.domain");

		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		//jpaProperties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		//jpaProperties.put("hibernate.ejb.naming_strategy", env.getRequiredProperty("hibernate.ejb.naming_strategy"));
		jpaProperties.put("hibernate.show_sql", "true");
		//jpaProperties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
		entityManagerFactoryBean.setJpaProperties(jpaProperties);
		return entityManagerFactoryBean;
	}*/
    
    /*@Bean
    public ComboPooledDataSource getDataSource() throws PropertyVetoException {
    	ComboPooledDataSource dataSource = new ComboPooledDataSource();
    	// pds.setConnectionFactoryClassName("oracle.jdbc.pool.OracleDataSource");
    	dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
    	//dataSource.setDriverClass("oracle.jdbc.pool.OracleDataSource");
    	//ds.setDriverClassName(oracle.jdbc.driver.OracleDriver.class.getName());
    	dataSource.setJdbcUrl("jdbc:oracle:thin@localhost:1521:xe");
    	dataSource.setUser("dev");
    	dataSource.setPassword("smt123mgh");
    	dataSource.setAcquireIncrement(10);
    	dataSource.setIdleConnectionTestPeriod(0);
    	dataSource.setInitialPoolSize(5);
    	dataSource.setMaxIdleTime(0);
    	dataSource.setMaxPoolSize(50);
    	dataSource.setMaxStatements(100);
    	dataSource.setMinPoolSize(5);
    	
    	return dataSource;
    }*/
    
    @Bean
    public DataSource getDataSource() {
        HikariConfig dataSourceConfig = new HikariConfig();
        
       dataSourceConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSourceConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSourceConfig.setUsername("dev");
        dataSourceConfig.setPassword("smt123mgh");
        
        dataSourceConfig.setMaximumPoolSize(10);
        dataSourceConfig.setMinimumIdle(5);
        dataSourceConfig.setConnectionTimeout(300000);
        dataSourceConfig.setPoolName("springHikariCP");
        dataSourceConfig.addDataSourceProperty("useServerPrepStmts", "true");
        dataSourceConfig.addDataSourceProperty("cachePrepStmts", "true");
        dataSourceConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        dataSourceConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        
        return new HikariDataSource(dataSourceConfig);
    }
    
   /* @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, 
                                                                Environment env) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.springboot.app.springBootApp.beans");
 
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        jpaProperties.put("hibernate.hbm2ddl.auto", 
                env.getRequiredProperty("hibernate.hbm2ddl.auto")
        );
        jpaProperties.put("hibernate.ejb.naming_strategy", 
                env.getRequiredProperty("hibernate.ejb.naming_strategy")
        );
        jpaProperties.put("hibernate.show_sql", 
                env.getRequiredProperty("hibernate.show_sql")
        );
        jpaProperties.put("hibernate.format_sql", 
                env.getRequiredProperty("hibernate.format_sql")
        );
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        return entityManagerFactoryBean;
    }
*/
    
    
    
    /*@Bean
    public DataSource getDataSource() {
        final BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(Preconditions.checkNotNull(env.getProperty("jdbc.driverClassName")));
        dataSource.setUrl(Preconditions.checkNotNull(env.getProperty("jdbc.url")));
        dataSource.setUsername(Preconditions.checkNotNull(env.getProperty("jdbc.user")));
        dataSource.setPassword(Preconditions.checkNotNull(env.getProperty("jdbc.pass")));

        return dataSource;
    }
    */
    @Bean
    public JdbcTemplate getJdbcTemplate() throws PropertyVetoException {
    	JdbcTemplate template = new JdbcTemplate();    	
    	template.setDataSource(getDataSource());    	
    	return template;
    }
 
   @Bean
    public HibernateTransactionManager getTransactionManager() throws PropertyVetoException {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
}