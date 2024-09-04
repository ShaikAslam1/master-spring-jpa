package com.aslam.masterspringjpa.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "learningEntityManagerFactory",
        transactionManagerRef = "learningTransactionManager",
        basePackages = {
                "com.aslam.masterspringjpa.repositories"
        }
)
public class LearningDataSourceConfiguration {

    @Primary
    @Bean(name = "learningProperties")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSourceProperties firstDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "learningDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(@Qualifier("learningProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean(name = "learningEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
            (EntityManagerFactoryBuilder builder, @Qualifier("learningDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("com.aslam.masterspringjpa.domain")
                .persistenceUnit("learning").build();
    }

    @Primary
    @Bean(name = "learningTransactionManager")
    @ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager transactionManager
            (@Qualifier("learningEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
