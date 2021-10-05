package com.example.RulesService;

import com.example.entities.ExistingIssue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableEurekaClient
public class RulesServiceApplication {

	private static final Logger LOGGER = LogManager.getLogger(RulesServiceApplication.class);

	//private static WelcomeService welcome;


	//@Autowired
	//static SaveDataClient savedataclient;


	public static void main(String[] args)
	{

		ApplicationContext context = new ClassPathXmlApplicationContext("SpringInjection.xml");
		AddExistingIssue a = (AddExistingIssue)context.getBean("AddExistingIssue");

		System.out.println("a is "+a);

		System.out.println("k is "+a.getK());


		a.getK().Test();

		//this is one way of creating object in case Autowired is not working
		/*ApplicationContext ctx = SpringApplication.run(RulesServiceApplication.class, args);

		System.out.println("Contains AddExistingissue  "+ctx.containsBeanDefinition("Test"));
		System.out.println("Contains SaveDataClient "+ctx.containsBeanDefinition("Test1"));

        System.out.println("object is "+ctx.getBean("Test").toString());

         SaveDataClient s=(SaveDataClient)ctx.getBean("Test");

         AddExistingIssue a=(AddExistingIssue)ctx.getBean("Test1");*/

   // SaveDataClient s=ctx.getBean("Test1");

		ExistingIssue i=new ExistingIssue();
		i.setIssueName("CPU1");
		i.setTeamName("Wintel");
		i.setCount(6);



		a.addIssue(i);
	}
}