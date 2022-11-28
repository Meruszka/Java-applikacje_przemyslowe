package pl.smerski.siatkowka.service;

import org.springframework.stereotype.Service;
import pl.smerski.siatkowka.domain.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PlayerManagerInMemory implements PlayerManager {

    List<Player> players = new ArrayList<>();
    @Override
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public Player getPlayer(String id) throws Exception {
        Player foundPlayer = null;
        for (Player player : players) {
            if (player.getId().equals(id)) {
                foundPlayer = player;
            }
        }
        if (foundPlayer == null) {
            // Custom Exception TODO
            throw new Exception("Player not found");
        }
        return foundPlayer;
    }

    @Override
    public Player addPlayer(Player player) {
        player.setId(UUID.randomUUID().toString());
        players.add(player);
        return player;
    }

    @Override
    public Player updatePlayer(Player player) throws Exception {
        Player playerToUpdate = players.stream()
                .filter(p -> p.getId().equals(player.getId()))
                .findFirst()
                .orElseThrow(() -> new Exception("Player not found"));
        playerToUpdate.setName(player.getName());
        playerToUpdate.setSurname(player.getSurname());
        playerToUpdate.setAge(player.getAge());
        playerToUpdate.setHeight(player.getHeight());
        playerToUpdate.setTeam(player.getTeam());
        return playerToUpdate;
    }

    @Override
    public Player deletePlayer(String id) throws Exception {
        Player foundPlayer = players.stream()
                .filter(player -> player.getId().equals(id))
                .findFirst()
                .orElse(null);
        boolean removed = players.removeIf(player -> player.getId().equals(id));
        if (removed) {
            return foundPlayer;
        }
        throw new Exception("Player not found");
    }
}

