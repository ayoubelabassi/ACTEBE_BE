package com.elab.actebe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.inject.Inject;
import java.net.InetAddress;
import java.util.Arrays;

@SpringBootApplication
public class ActebeApplication{

	private static final Logger log = LoggerFactory.getLogger(ActebeApplication.class);

	@Inject
	private Environment env;
	public static void main(String[] args) {
		SpringApplication.run(ActebeApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			/*
			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
			*/
			log.info(
					"\n----------------------------------------------------------\n\t"
							+ "Application '{}' is running! Access URLs:\n\t" + "Local: \t\thttp://localhost:{}\n\t"
							+ "External: \thttp://{}:{}\n----------------------------------------------------------",
					env.getProperty("spring.application.name"), env.getProperty("server.port"),
					InetAddress.getLocalHost().getHostAddress(), env.getProperty("server.port"));
		};
	}
}
