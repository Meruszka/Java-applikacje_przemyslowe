package pl.smerski.siatkowka.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.smerski.siatkowka.domain.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
    @Query("SELECT t FROM Team t JOIN FETCH t.players")
    Iterable<Team> findAllWithPlayers();

    @Query("SELECT t FROM Team t JOIN t.players p WHERE p.name = ?1")
    Team findByPlayerName(String playerName);

    @Query("SELECT t FROM Team t JOIN t.players p WHERE p.surname = ?1")
    Team findByPlayerSurname(String playerSurname);

    @Query("SELECT t FROM Team t JOIN t.players p WHERE p.name = ?1 OR p.surname = ?2")
    Team findByPlayerNameOrSurname(String playerName, String playerSurname);

    @Query("SELECT t FROM Team t JOIN t.players p GROUP BY t.name HAVING COUNT(p) > ?1")
    Iterable<Team> findByPlayersCountGreaterThan(int count);

}
