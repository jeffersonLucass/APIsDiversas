package io.github.jeffersonLucass.arquiteturaspring;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		//SpringApplication.run(Application.class, args);

		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
		builder.bannerMode(Banner.Mode.OFF);
		builder.profiles("teste");
		builder.run(args);


		// Contexto da aplicação já iniciada:
		ConfigurableApplicationContext Apllicationcontext = builder.context();


		ConfigurableEnvironment environment = Apllicationcontext.getEnvironment();
		String apllicationName = environment.getProperty("spring.application.name");
		System.out.println("Nome da aplicação: " + apllicationName );

	}

}
