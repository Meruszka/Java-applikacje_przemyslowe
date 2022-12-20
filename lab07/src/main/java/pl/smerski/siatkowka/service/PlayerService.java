package pl.smerski.siatkowka.service;

import org.springframework.stereotype.Service;
import pl.smerski.siatkowka.domain.Player;
import pl.smerski.siatkowka.domain.Team;
import pl.smerski.siatkowka.repository.PlayerRepository;
import pl.smerski.siatkowka.repository.TeamRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PlayerService {
    final PlayerRepository playerRepository;
    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public Iterable<Player> findAll(){
        return playerRepository.findAll();
    }

    public Player findById(Long id){
        if(playerRepository.findById(id).isPresent()){
            return playerRepository.findById(id).get();
        }
        // Exception?
        return null;
    }

    public Player addPlayer(Player player){
        playerRepository.save(player);
        return player;
    }

    public Player updatePlayer(Player player){
        if (playerRepository.findById(player.getId()).isPresent()){
            Player toUpdatePlayer = playerRepository.findById(player.getId()).get();
            toUpdatePlayer.setName(player.getName());
            toUpdatePlayer.setSurname(player.getSurname());
            toUpdatePlayer.setAge(player.getAge());
            toUpdatePlayer.setHeight(player.getHeight());
            toUpdatePlayer.setTeam(player.getTeam());
            playerRepository.save(toUpdatePlayer);
            return toUpdatePlayer;
        }
        return null;
    }

    public void deletePlayer(Long id){
        if (playerRepository.findById(id).isPresent()){
            playerRepository.deleteById(id);
        }
    }

    // Custom methods

    public Iterable<Player> findAllWithTeam(){
        return playerRepository.findAllWithTeam();
    }

    public Iterable<Player> findByTeamName(String teamName){
        return playerRepository.findByTeamName(teamName);
    }

    public Iterable<Player> findByTeamNameAndSurname(String teamName, String surname){
        return playerRepository.findByTeamNameAndSurname(teamName, surname);
    }

    public Iterable<Player> findByHeight(int height){
        return playerRepository.findByHeight(height);
    }

    public Iterable<Player> findByAge(int age){
        return playerRepository.findByAge(age);
    }

    public Iterable<Player> findByAgeLessOrEqual21(){
        return playerRepository.findByAgeLessOrEqual21();
    }

    public Iterable<Player> findByHeightGreaterThan200(){
        return playerRepository.findByHeightGreaterThan200();
    }

    public Iterable<Player> findByHeightLessThan180OrGreaterThan200(){
        return playerRepository.findByHeightLessThan180OrGreaterThan200();
    }

//    public void learning(){
//        Team team1 = new Team("PGE Skra", "Bełchatów", "Joel Banks", "Grzegorz Łomacz");
//        Team team2 = new Team("Trefl", "Gdańsk", "Michał Winiarski", "Mariusz Wlazły");
//
//
//        Player player1 = new Player("Jan", "Kowalski", 19, 190, team1);
//        Player player2 = new Player("Olek", "Malinowski", 20, 200, team1);
//        Player player3 = new Player("Golf", "Fiesta", 25, 150, team2);
//
//        List<Player> t1 = new ArrayList<>();
//        t1.add(player1);
//        t1.add(player2);
//        List<Player> t2 = new ArrayList<>();
//        t2.add(player3);
//
//        team1.setPlayers(t1);
//        team2.setPlayers(t2);
//
////        playerRepository.save(player1);
////        playerRepository.save(player2);
////        playerRepository.save(player3);
//
//        teamRepository.save(team1);
//        teamRepository.save(team2);
//
//        Iterable<Player> players = playerRepository.findAll();
//        System.out.println(players);
//    }
}
