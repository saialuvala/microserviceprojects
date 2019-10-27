package com.easycrmapp.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;


@Configuration
public class DatabaseConfiguration {

	@Bean(name="mySqlDb")
	@ConfigurationProperties(prefix = "spring.datasource")
	@Primary
	public DataSource createDatasourceForCRM() {
		System.out.println("1.......createDatasourceForCRM---------------------");
		return  (DataSource) DataSourceBuilder.create().build();
	}
	
	@Bean(name="crmJdbcTemplate")
	@Autowired
	public JdbcTemplate createJdbcTemplateForCrmApp(@Qualifier("mySqlDb") DataSource ds) {
		System.out.println("2.......createJdbcTemplateForCrmApp");
		return new JdbcTemplate(ds);
	}
}
