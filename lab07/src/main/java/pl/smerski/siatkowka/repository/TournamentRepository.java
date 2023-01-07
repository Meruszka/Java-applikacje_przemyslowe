package pl.smerski.siatkowka.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.smerski.siatkowka.domain.Tournament;

import java.util.List;

public interface TournamentRepository extends CrudRepository<Tournament, Long> {

    @Query("SELECT t FROM Tournament t JOIN FETCH t.teams")
    List<Tournament> findAllWithTeams();

    @Query("SELECT t FROM Tournament t JOIN t.teams te WHERE te.name = ?1")
    List<Tournament> findByTeamName(String teamName);

    @Query("SELECT t FROM Tournament t JOIN t.teams te WHERE COUNT(te) = ?1")
    List<Tournament> findByTeamsCount(int count);

    @Query("SELECT t FROM Tournament t JOIN t.teams te WHERE COUNT(te) > ?1")
    List<Tournament> findByTeamsCountGreaterThan(int count);

    @Query("SELECT t FROM Tournament t JOIN t.teams te WHERE COUNT(te) < ?1")
    List<Tournament> findByTeamsCountLessThan(int count);

}
