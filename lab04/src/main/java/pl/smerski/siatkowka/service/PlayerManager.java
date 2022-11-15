package pl.smerski.siatkowka.service;

import org.springframework.http.ResponseEntity;
import pl.smerski.siatkowka.domain.Player;

import java.util.List;

public interface PlayerManager {
    ResponseEntity getPlayers();
    ResponseEntity getPlayer(String id) throws Exception;
    ResponseEntity addPlayer(Player player) throws Exception;
    ResponseEntity updatePlayer(Player player, String id) throws Exception;
    ResponseEntity deletePlayer(String id) throws Exception;

}
