package pl.smerski.siatkowka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.smerski.siatkowka.domain.Team;
import pl.smerski.siatkowka.service.TeamService;

@RestController
public class TeamController {
    final TeamService teamService;

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


}
