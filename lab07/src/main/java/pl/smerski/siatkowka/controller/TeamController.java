package pl.smerski.siatkowka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.smerski.siatkowka.domain.Team;
import pl.smerski.siatkowka.service.TeamService;

public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/teams")
    public ResponseEntity<Iterable<Team>> getAllTeams(){
        return ResponseEntity.ok(teamService.findAll());
    }

    @GetMapping("/teams/{id}")
    public ResponseEntity<Team> getTeamById(Long id){
        return ResponseEntity.ok(teamService.findById(id));
    }

    @PostMapping("/teams")
    public ResponseEntity<Team> addTeam(Team team){
        return ResponseEntity.ok(teamService.addTeam(team));
    }

    @PostMapping("/teams/{id}")
    public ResponseEntity<Team> updateTeam(Team team){
        return ResponseEntity.ok(teamService.updateTeam(team));
    }

    @PostMapping("/teams/delete/{id}")
    public ResponseEntity<Team> deleteTeam(Long id){
        teamService.deleteTeam(id);
        return ResponseEntity.ok().build();
    }

    // Custom methods

    @GetMapping("/teams/withPlayers")
    public ResponseEntity<Iterable<Team>> getAllTeamsWithPlayers(){
        return ResponseEntity.ok(teamService.findAllWithPlayers());
    }

    @GetMapping("/teams/byName/{playerName}")
    public ResponseEntity<Iterable<Team>> getAllTeamsByPlayerName(String playerName){
        return ResponseEntity.ok(teamService.findByPlayerName(playerName));
    }

    @GetMapping("/teams/bySurname/{surname}")
    public ResponseEntity<Iterable<Team>> getAllTeamsBySurname(String surname){
        return ResponseEntity.ok(teamService.findByPlayerSurname(surname));
    }

    @GetMapping("/teams/byBoth/{playerName}/{surname}")
    public ResponseEntity<Iterable<Team>> getAllTeamsByPlayerNameAndSurname(String playerName, String surname){
        return ResponseEntity.ok(teamService.findByPlayerNameOrSurname(playerName, surname));
    }

    @GetMapping("/teams/count/{num}")
    public ResponseEntity<Iterable<Team>> getAllTeamsByPlayerCountGreaterThan(Integer num){
        return ResponseEntity.ok(teamService.findByPlayersCountGreaterThan(num));
    }

}
