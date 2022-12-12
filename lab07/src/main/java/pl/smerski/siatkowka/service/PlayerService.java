package pl.smerski.siatkowka.service;

import org.springframework.stereotype.Service;
import pl.smerski.siatkowka.domain.Player;
import pl.smerski.siatkowka.domain.Team;
import pl.smerski.siatkowka.repository.PlayerRepository;
import pl.smerski.siatkowka.repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
    final PlayerRepository playerRepository;

    final TeamRepository teamRepository;

    public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository){
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    public void learning(){
        Team team1 = new Team("PGE Skra", "Bełchatów", "Joel Banks", "Grzegorz Łomacz");
        Team team2 = new Team("Trefl", "Gdańsk", "Michał Winiarski", "Mariusz Wlazły");

        teamRepository.save(team1);
        teamRepository.save(team2);

        Player player1 = new Player("Jan", "Kowalski", 19, 190, team1);
        Player player2 = new Player("Olek", "Malinowski", 20, 200, team1);
        Player player3 = new Player("Golf", "Fiesta", 25, 150, team2);
        
        playerRepository.save(player1);
        playerRepository.save(player2);
        playerRepository.save(player3);

        Iterable<Player> players = playerRepository.findAll();
        System.out.println(players);
    }
}