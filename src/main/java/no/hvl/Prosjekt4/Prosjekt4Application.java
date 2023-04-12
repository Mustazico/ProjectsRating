package no.hvl.Prosjekt4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Starter Spring Boot applikasjonen
 */
@SpringBootApplication
public class Prosjekt4Application extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Prosjekt4Application.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Prosjekt4Application.class, args);
	}
}