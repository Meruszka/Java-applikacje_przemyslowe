package pl.smerski.siatkowka.service;

import pl.smerski.siatkowka.domain.Coach;

import java.util.List;

public interface CoachManager {
    List<Coach> getCoaches();
    Coach getCoach(String id) throws Exception;
    Coach addCoach(Coach coach);
    Coach updateCoach(Coach coach) throws Exception;
    Coach deleteCoach(String id) throws Exception;
}
