package com.example.TradeRec.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@Configuration
public class ApplicationConfig {
	
	@Value("${traderec.datasource.url}")
	private String dbUrl;
	
	@Value("${traderec.datasource.username}")
	private String dbUsername;
	
	@Value("${traderec.hikari.driver-class-name}")
	private String dbDriver;
	
	@Value("${traderec.datasource.password}")
	private String dbPassword;
	
	@Value("${hikari.minimum-idle}")
	private int minimumIdle;
	
	@Value("${hikari.max-pool-size}")
	private int maxPoolSize;
	
	@Bean(name = "dataSource")
	public HikariDataSource instantiateDataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(dbUrl);
		config.setDriverClassName(dbDriver);
		config.setUsername(dbUsername);
		config.setPassword(dbPassword);
		config.setMinimumIdle(minimumIdle);
		config.setMaximumPoolSize(maxPoolSize);
		
		return new HikariDataSource(config);
	}
}
