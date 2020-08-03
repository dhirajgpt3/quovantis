package com.quovantis.quovantis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.quovantis.quovantis")
public class QuovantisApplication {
	public static void main(String[] args) {
		SpringApplication.run(QuovantisApplication.class, args);
	}

}
