package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"com.general.model.dao.login.repository" , "com.general.model.dao.table.repository"})
@ComponentScan(basePackages = {"com.general"}, excludeFilters = {@ComponentScan.Filter(SpringBootApplication.class)})
@EntityScan(basePackages = "com.general.model", basePackageClasses = {Jsr310JpaConverters.class})
public class ApplicationTests {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationTests.class, args);
    }
}
