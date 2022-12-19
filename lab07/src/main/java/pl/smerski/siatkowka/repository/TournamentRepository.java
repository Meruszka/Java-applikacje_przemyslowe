package pl.smerski.siatkowka.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.smerski.siatkowka.domain.Tournament;

public interface TournamentRepository extends CrudRepository<Tournament, Long> {

    @Query("SELECT t FROM Tournament t JOIN FETCH t.teams")
    Iterable<Tournament> findAllWithTeams();

    @Query("SELECT t FROM Tournament t JOIN t.teams te WHERE te.name = ?1")
    Iterable<Tournament> findByTeamName(String teamName);

    @Query("SELECT t FROM Tournament t WHERE t.teams.name = ?1 AND t.name = ?2")
    Tournament findByTeamNameAndName(String teamName, String name);

    @Query("SELECT t FROM Tournament t WHERE t.name = ?1 OR t.teams.name = ?2")
    Tournament findByNameOrTeamName(String name, String teamName);

    @Query("SELECT t FROM Tournament t JOIN t.teams te WHERE COUNT(te) = ?1")
    Tournament findByTeamsCount(int count);

    @Query("SELECT t FROM Tournament t JOIN t.teams te WHERE COUNT(te) > ?1")
    Tournament findByTeamsCountGreaterThan(int count);

    @Query("SELECT t FROM Tournament t JOIN t.teams te WHERE COUNT(te) < ?1")
    Tournament findByTeamsCountLessThan(int count);

}
