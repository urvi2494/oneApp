package com.cognizant.emponboard.dbconfig;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager", basePackages = "com.cognizant.emponboard.repo.emp")
public class EmployeeDBConfig {

	@Primary
	@Bean(name="empDataSource")
	@ConfigurationProperties(prefix = "spring.emp.datasource")
	public DataSource mysqlEmpDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@PersistenceContext(unitName = "spring.emp")
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(EntityManagerFactoryBuilder builder,@Qualifier("empDataSource") DataSource empDataSource) {
		return builder.dataSource(empDataSource).packages(com.cognizant.emponboard.model.Employee.class)
				.persistenceUnit("spring.emp").build();
	}

	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager mysqlTransactionManager(
			@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
