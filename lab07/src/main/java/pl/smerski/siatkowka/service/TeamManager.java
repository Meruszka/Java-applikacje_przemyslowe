package pl.smerski.siatkowka.service;

import pl.smerski.siatkowka.domain.Team;

import java.util.List;

public interface TeamManager {
    List<Team> getTeams();
    Team getTeam(String id) throws Exception;
    Team addTeam(Team team);
    Team updateTeam(Team team) throws Exception;
    Team deleteTeam(String id) throws Exception;

}
