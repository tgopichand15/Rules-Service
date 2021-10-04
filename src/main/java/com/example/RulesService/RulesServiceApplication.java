package com.example.RulesService;

import com.example.client.SaveDataClient;
import com.example.entities.ExistingIssue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableEurekaServer
public class RulesServiceApplication extends SpringBootServletInitializer {

	private static final Logger LOGGER = LogManager.getLogger(RulesServiceApplication.class);

	@Autowired
	static AddExistingIssue addexistingIssue;

	@Autowired
	static SaveDataClient savedataclient;


	public static void main(String[] args)
	{
		ApplicationContext ctx = SpringApplication.run(RulesServiceApplication.class, args);

		LOGGER.info("Info level log message");
		LOGGER.debug("Debug level log message");
		LOGGER.error("Error level log message");



		ExistingIssue i=new ExistingIssue();
		i.setIssueName("CPU");
		i.setTeamName("Wintel");
		i.setCount(5);


		addexistingIssue.addIssue(i,savedataclient);
	}
}