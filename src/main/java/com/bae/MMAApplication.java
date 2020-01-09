package com.bae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class MMAApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MMAApplication.class, args);
	}

}
