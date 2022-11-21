package pl.smerski.siatkowka.service;

import org.springframework.stereotype.Service;
import pl.smerski.siatkowka.domain.Player;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerManagerInMemory implements PlayerManager {

    List<Player> players = new ArrayList<>();
    @Override
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public Player getPlayer(String id) throws Exception {
        Player foundPlayer = players.stream()
                .filter(player -> player.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (foundPlayer == null) {
            // Custom Exception TODO
            throw new Exception("Player not found");
        }
        return foundPlayer;
    }

    @Override
    public Player addPlayer(Player player) {
        players.add(player);
        return player;
    }

    @Override
    public Player updatePlayer(Player player, String id) throws Exception {
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
        return player;
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

