package com.ttiedu.code;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootLazyInitializationApplication {

	// private static Logger logger =
	// Logger.getLogger(SpringBootLazyInitializationApplication.class);

	public static void main(String[] args) {
		/*
		 * logger.debug("Log4jExample: A Sample Debug Message");
		 * logger.info("Log4jExample: A Sample Info  Message");
		 * logger.warn("Log4jExample: A Sample Warn  Message");
		 * logger.error("Log4jExample: A Sample Error Message");
		 * logger.fatal("Log4jExample: A Sample Fatal Message");
		 */
		// SpringApplication.run(SpringBootLazyInitializationApplication.class, args);

		SpringApplication application = new SpringApplication(SpringBootLazyInitializationApplication.class);
		// application.setBanner(Banner.class);
		application.run(args);
	}

	private String name;

	public String getName() {
		return name;
	}

	@SuppressWarnings("deprecation")
	@Required
	public void setName(String name) {
		System.out.println(" i am populated at Application Context Loading time");
		this.name = name;
	}

	@Bean
	public void customBean() {
		System.out.println("I am custom bean "); // initialized bean at application loading time
	}

	@Bean
	@Lazy(false) // set true if start with lazy loading
	@GetMapping(value = "/")
	public void customBean1() {
		System.out.println("I am custom bean 2");
	}
}
