package pl.smerski.siatkowka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.smerski.siatkowka.domain.Player;
import pl.smerski.siatkowka.service.PlayerService;

@RestController
public class PlayerController {
    final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public ResponseEntity<Iterable<Player>> getAllPlayers(){
        return ResponseEntity.ok(playerService.findAll());
    }

    @GetMapping("/players/{id}")
    public ResponseEntity<Player> getPlayerById(Long id){
        return ResponseEntity.ok(playerService.findById(id));
    }

    @PostMapping("/players")
    public ResponseEntity<Player> addPlayer(Player player){
        return ResponseEntity.ok(playerService.addPlayer(player));
    }

    @PostMapping("/players/{id}")
    public ResponseEntity<Player> updatePlayer(Player player){
        return ResponseEntity.ok(playerService.updatePlayer(player));
    }

    @PostMapping("/players/delete/{id}")
    public ResponseEntity<Player> deletePlayer(Long id){
        playerService.deletePlayer(id);
        return ResponseEntity.ok().build();
    }

    // Custom methods

    @GetMapping("/players/withTeam")
    public ResponseEntity<Iterable<Player>> getAllPlayersWithTeam(){
        return ResponseEntity.ok(playerService.findAllWithTeam());
    }

    @GetMapping("/players/byTeam/{teamName}")
    public ResponseEntity<Iterable<Player>> getAllPlayersByTeamName(String teamName){
        return ResponseEntity.ok(playerService.findByTeamName(teamName));
    }

    @GetMapping("/players/byBoth/{teamName}/{surname}")
    public ResponseEntity<Iterable<Player>> getAllPlayersByTeamNameAndSurname(String teamName, String surname){
        return ResponseEntity.ok(playerService.findByTeamNameAndSurname(teamName, surname));
    }

    @GetMapping("/players/h/{height}")
    public ResponseEntity<Iterable<Player>> getAllPlayersByHeight(int height){
        return ResponseEntity.ok(playerService.findByHeight(height));
    }

    @GetMapping("/players/a/{age}")
    public ResponseEntity<Iterable<Player>> getAllPlayersByAge(int age){
        return ResponseEntity.ok(playerService.findByAge(age));
    }

    @GetMapping("/players/heigher200")
    public ResponseEntity<Iterable<Player>> getHeighestPlayers(){
        return ResponseEntity.ok(playerService.findByHeightGreaterThan200());
    }

    @GetMapping("/players/heightBetween")
    public ResponseEntity<Iterable<Player>> getPlayersBetweenHeights(){
        return ResponseEntity.ok(playerService.findByHeightLessThan180OrGreaterThan200());
    }
}
