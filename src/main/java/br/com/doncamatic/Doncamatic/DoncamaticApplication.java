package br.com.doncamatic.Doncamatic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DoncamaticApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoncamaticApplication.class, args);
	}

}
