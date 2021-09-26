package com.example.RulesService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
@EnableEurekaClient
public class RulesServiceApplication extends SpringBootServletInitializer {

	private static final Logger LOGGER = LogManager.getLogger(RulesServiceApplication.class);

	public static void main(String[] args)
	{
		ApplicationContext ctx = SpringApplication.run(RuleserviceApplication.class, args);

		LOGGER.info("Info level log message");
		LOGGER.debug("Debug level log message");
		LOGGER.error("Error level log message");
	}
}