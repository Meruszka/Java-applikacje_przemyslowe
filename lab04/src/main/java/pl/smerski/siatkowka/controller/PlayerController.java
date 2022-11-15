package pl.smerski.siatkowka.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.smerski.siatkowka.domain.Player;
import pl.smerski.siatkowka.service.PlayerManager;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlayerController implements PlayerManager {
    List<Player> players = new ArrayList<>();
    @GetMapping("/players")
    public ResponseEntity<?> getPlayers(){
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/players/{id}")
    public ResponseEntity<?> getPlayer(@PathVariable String id) {
        Player foundPlayer = players.stream()
                .filter(player -> player.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (foundPlayer == null) {
            return new ResponseEntity<>("Player not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundPlayer, HttpStatus.valueOf(200));
    }

    @PostMapping("/players/add")
    public ResponseEntity<?> addPlayer(@RequestBody Player player){
        players.add(player);
        return new ResponseEntity<>(player, HttpStatus.CREATED);
    }

    @PutMapping("/players/{id}")
    public ResponseEntity<?> updatePlayer(@RequestBody Player player, @PathVariable String id){
        players.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .ifPresent(p -> {
                    p.setName(player.getName());
                    p.setSurname(player.getSurname());
                    p.setAge(player.getAge());
                    p.setHeight(player.getHeight());
                    p.setTeam(player.getTeam());
                });
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable String id){
        boolean removed = players.removeIf(player -> player.getId().equals(id));
        if (removed) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
