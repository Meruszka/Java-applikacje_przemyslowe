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


        Player player1 = new Player("Jan", "Kowalski", 19, 190, team1);
        Player player2 = new Player("Olek", "Malinowski", 20, 200, team1);
        Player player3 = new Player("Golf", "Fiesta", 25, 150, team2);

        List<Player> t1 = new ArrayList<>();
        t1.add(player1);
        t1.add(player2);
        List<Player> t2 = new ArrayList<>();
        t2.add(player3);

        team1.setPlayers(t1);
        team2.setPlayers(t2);

//        playerRepository.save(player1);
//        playerRepository.save(player2);
//        playerRepository.save(player3);

        teamRepository.save(team1);
        teamRepository.save(team2);

        Iterable<Player> players = playerRepository.findAll();
        System.out.println(players);
    }
}
