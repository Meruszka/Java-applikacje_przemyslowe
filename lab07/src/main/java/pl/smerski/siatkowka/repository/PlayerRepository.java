package pl.smerski.siatkowka.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.smerski.siatkowka.domain.Player;

import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

    @Query("SELECT p FROM Player p JOIN FETCH p.team")
    List<Player> findAllWithTeam();

    @Query("SELECT p FROM Player p JOIN p.team t WHERE t.name = ?1")
    Player findByTeamName(String teamName);

    @Query("SELECT p FROM Player p WHERE p.team.name = ?1 AND p.surname = ?2")
    Player findByTeamNameAndSurname(String teamName, String surname);

    @Query("SELECT p FROM Player p WHERE p.name = ?1 OR p.surname = ?2")
    List<Player> findByNameOrSurname(String name, String surname);

    @Query("SELECT p FROM Player p WHERE p.height > ?1")
    List<Player> findByHeight(int height);

    @Query("SELECT p FROM Player p WHERE p.age > ?1")
    List<Player> findByAge(int age);

    @Query("SELECT p FROM Player p WHERE p.age <= 21")
    List<Player> findByAgeLessOrEqual21();

    @Query("SELECT p FROM Player p WHERE p.height > 200")
    List<Player> findByHeightGreaterThan200();

}
