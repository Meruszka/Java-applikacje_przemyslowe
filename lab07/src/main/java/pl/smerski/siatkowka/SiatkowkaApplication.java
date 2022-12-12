package pl.smerski.siatkowka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.smerski.siatkowka.service.PlayerService;

@SpringBootApplication
public class SiatkowkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiatkowkaApplication.class, args);
	}
	@Bean
	public CommandLineRunner appSetup(@Autowired PlayerService playerService){
		return args -> {
			playerService.learning();
		};
	}

}
