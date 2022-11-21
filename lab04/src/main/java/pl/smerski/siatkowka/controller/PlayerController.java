package pl.smerski.siatkowka.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.smerski.siatkowka.domain.Player;
import pl.smerski.siatkowka.service.PlayerManager;


@RestController
public class PlayerController {

    private final PlayerManager playerManager;

    public PlayerController(@Autowired PlayerManager playerManager) {
        this.playerManager = playerManager;
    }

    @GetMapping("/api/players")
    public ResponseEntity<?> getPlayers(){
        return new ResponseEntity<>(playerManager.getPlayers(), HttpStatus.OK);
    }

    @GetMapping("/api/players/{id}")
    public ResponseEntity<?> getPlayer(@PathVariable String id) {
        try {
            return new ResponseEntity<>(playerManager.getPlayer(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/api/players/add")
    public ResponseEntity<?> addPlayer(@RequestBody Player player){
        return new ResponseEntity<>(playerManager.addPlayer(player), HttpStatus.CREATED);
    }

    @PutMapping("/api/players/{id}")
    public ResponseEntity<?> updatePlayer(@RequestBody Player player, @PathVariable String id){
        try {
            return new ResponseEntity<>(playerManager.updatePlayer(player, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/api/players/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable String id){
        try {
            return new ResponseEntity<>(playerManager.deletePlayer(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
