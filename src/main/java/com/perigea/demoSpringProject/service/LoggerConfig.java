package com.perigea.demoSpringProject.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerConfig {
	
	
	@Bean
	public Logger config() {
		Logger log = LoggerFactory.getLogger(MainService.class);
		return log;
	}

}
