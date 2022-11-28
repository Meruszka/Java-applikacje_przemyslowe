package pl.smerski.siatkowka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.smerski.siatkowka.domain.Player;
import pl.smerski.siatkowka.service.PlayerManager;

@SpringBootApplication
public class SiatkowkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiatkowkaApplication.class, args);
	}
	@Bean
	public CommandLineRunner appSetup(@Autowired PlayerManager playerManager){
		return args -> {
			playerManager.addPlayer(new Player("Jan", "Kowalski", 20, 190, "PGE Skra"));
			playerManager.addPlayer(new Player("Adam", "Nowak", 21, 200, "PGE Skra"));
			playerManager.addPlayer(new Player("Piotr", "Kowalski", 22, 180, "PGE Skra"));

		};
	}

}
