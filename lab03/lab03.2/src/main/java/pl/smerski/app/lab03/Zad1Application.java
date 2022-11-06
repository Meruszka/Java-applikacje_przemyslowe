package pl.smerski.app.lab03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.smerski.app.lab03.serviceBean.PersonManagerInMemory;

import java.io.IOException;
import java.util.Arrays;

@SpringBootApplication
public class Zad1Application {
	public static void main(String[] args) throws IOException, InterruptedException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Zad1Application.class);
		PersonManagerInMemory personManager = ctx.getBean(PersonManagerInMemory.class);
		personManager.loadPersons();
		SpringApplication.run(Zad1Application.class, args);
	}
}
