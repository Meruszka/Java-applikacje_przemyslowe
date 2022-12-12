package pl.smerski.siatkowka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.smerski.siatkowka.domain.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
}
