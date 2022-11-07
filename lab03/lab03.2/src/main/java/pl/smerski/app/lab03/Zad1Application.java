package pl.smerski.app.lab03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.smerski.app.lab03.domain.Person;
import pl.smerski.app.lab03.serviceBean.PersonManagerInMemory;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@SpringBootApplication
public class Zad1Application {
	public static void main(String[] args) throws IOException, InterruptedException {
		ApplicationContext ctx = SpringApplication.run(Zad1Application.class, args);
		Map<String, Person> persons = ctx.getBeansOfType(Person.class);
		PersonManagerInMemory personManagerInMemory = ctx.getBean(PersonManagerInMemory.class);

		personManagerInMemory.loadPersons();
		persons.forEach((k, v) -> personManagerInMemory.addPerson(v));
	}
}
