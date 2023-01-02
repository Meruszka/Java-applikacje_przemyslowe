package pl.smerski.siatkowka.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.smerski.siatkowka.domain.Team;

import java.util.List;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    @Query("Select t from Team t where t.name=?1")
    List<Team> findByName(@Param("name") String name);
}
