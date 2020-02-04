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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "vcEntityManager", transactionManagerRef = "vcTransactionManager", basePackages = "com.cognizant.emponboard.repo.vc")
public class VeriCredDBConfig {

	//@Bean

	@Bean(name = "vcDataSource")
	@ConfigurationProperties(prefix = "spring.vc.datasource")
	public DataSource mysqlVCDataSource() {
		return DataSourceBuilder.create().build();
	}

	@PersistenceContext(unitName = "spring.vc")
	@Bean(name = "vcEntityManager")
	public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(EntityManagerFactoryBuilder builder,@Qualifier("vcDataSource") DataSource vcDataSource) {
		return builder.dataSource(vcDataSource).packages(com.cognizant.emponboard.model.VerifiableCredential.class)
				.persistenceUnit("spring.vc").build();
	}

	// @Transactional(value = "vcTransactionManager")
	@Bean(name = "vcTransactionManager")
	public PlatformTransactionManager mysqlTransactionManager(
			@Qualifier("vcEntityManager") EntityManagerFactory vcEntityManager) {
		return new JpaTransactionManager(vcEntityManager);
	}

}
