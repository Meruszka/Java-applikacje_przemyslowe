package pl.smerski.siatkowka.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import pl.smerski.siatkowka.domain.Player;
import java.util.List;

@Service
public class PlayerManagerJDBC implements PlayerManager{

    private final JdbcTemplate jdbcTemplate;

    public PlayerManagerJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Player addPlayer(Player player) {
        jdbcTemplate.update("INSERT INTO players (name, surname, age, height, team) VALUES (?, ?, ?, ?, ?)",
                player.getName(), player.getSurname(), player.getAge(), player.getHeight(), player.getTeam());
    }

    @Override
    public List<Player> getPlayers() {
        return jdbcTemplate.query("SELECT * FROM players", (rs, rowNum) -> {
            Player player = new Player();
            player.setId(rs.getString("id"));
            player.setName(rs.getString("name"));
            player.setSurname(rs.getString("surname"));
            player.setAge(rs.getInt("age"));
            player.setHeight(rs.getInt("height"));
            player.setTeam(rs.getString("team"));
            return player;
        });
    }

    @Override
    public Player getPlayer(String id) throws Exception {
        return jdbcTemplate.queryForObject("SELECT * FROM players WHERE id = ?", new Object[]{id}, (rs, rowNum) -> {
            Player player = new Player();
            player.setId(rs.getString("id"));
            player.setName(rs.getString("name"));
            player.setSurname(rs.getString("surname"));
            player.setAge(rs.getInt("age"));
            player.setHeight(rs.getInt("height"));
            player.setTeam(rs.getString("team"));
            return player;
        });
    }

}
