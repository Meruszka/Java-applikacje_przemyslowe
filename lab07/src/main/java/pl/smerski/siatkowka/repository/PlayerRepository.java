package pl.smerski.siatkowka.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.smerski.siatkowka.domain.Player;

import java.lang.Iterable;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

    @Query("SELECT p FROM Player p JOIN FETCH p.team")
    Iterable<Player> findAllWithTeam();

    @Query("SELECT p FROM Player p JOIN p.team t WHERE t.name = ?1")
    Iterable<Player> findByTeamName(String teamName);

    @Query("SELECT p FROM Player p WHERE p.team.name = ?1 AND p.surname = ?2")
    Iterable<Player> findByTeamNameAndSurname(String teamName, String surname);

    @Query("SELECT p FROM Player p WHERE p.name = ?1 OR p.surname = ?2")
    Iterable<Player> findByNameOrSurname(String name, String surname);

    @Query("SELECT p FROM Player p WHERE p.height > ?1")
    Iterable<Player> findByHeight(int height);

    @Query("SELECT p FROM Player p WHERE p.age > ?1")
    Iterable<Player> findByAge(int age);

    @Query("SELECT p FROM Player p WHERE p.age <= 21")
    Iterable<Player> findByAgeLessOrEqual21();

    @Query("SELECT p FROM Player p WHERE p.height > 200")
    Iterable<Player> findByHeightGreaterThan200();

    @Query("SELECT p FROM Player p WHERE p.height < 180 OR p.height > 200")
    Iterable<Player> findByHeightLessThan180OrGreaterThan200();
}
