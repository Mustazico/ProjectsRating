package no.hvl.Prosjekt4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//Den excluden må nok taes vekk når man legger inn en databasetilkobling
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Prosjekt4Application {
	public static void main(String[] args) {
		SpringApplication.run(Prosjekt4Application.class, args);
	}
}