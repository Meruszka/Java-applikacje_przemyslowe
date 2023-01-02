package pl.smerski.siatkowka.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.smerski.siatkowka.domain.Tournament;

import java.util.List;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {

    @Query("SELECT t FROM Tournament t WHERE t.name = ?1")
    List<Tournament> findByName(String name);


}
