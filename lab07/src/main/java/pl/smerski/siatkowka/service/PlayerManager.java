package pl.smerski.siatkowka.service;


import pl.smerski.siatkowka.domain.Player;

import java.util.List;

public interface PlayerManager {
    List<Player> getPlayers();
    Player getPlayer(String id) throws Exception;
    Player addPlayer(Player player);
    Player updatePlayer(Player player) throws Exception;
    Player deletePlayer(String id) throws Exception;

}
