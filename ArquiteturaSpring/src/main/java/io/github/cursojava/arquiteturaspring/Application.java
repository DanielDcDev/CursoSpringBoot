package io.github.cursojava.arquiteturaspring;

import io.github.cursojava.arquiteturaspring.todos.TodoEntity;
import io.github.cursojava.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);

		SpringApplicationBuilder builder =
				new SpringApplicationBuilder(Application.class);


		builder.bannerMode(Banner.Mode.OFF);
		builder. profiles("producao","homologacao") ;

		builder.run(args);

//		ConfigurableApplicationContext applicationContext = builder.context();
//		var produtoRepository = applicationContext.getBean("produtoRepository");

	}
}
