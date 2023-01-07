package pl.smerski.siatkowka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.smerski.siatkowka.domain.Tournament;
import pl.smerski.siatkowka.service.TournamentService;

public class TournamentController {
    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @GetMapping("/tournaments")
    public ResponseEntity<Iterable<Tournament>> getAllTournaments(){
        return ResponseEntity.ok(tournamentService.findAll());
    }

    @GetMapping("/tournaments/{id}")
    public ResponseEntity<Tournament> getTournamentById(Long id){
        return ResponseEntity.ok(tournamentService.findById(id));
    }

    @PostMapping("/tournaments")
    public ResponseEntity<Tournament> addTournament(Tournament tournament){
        return ResponseEntity.ok(tournamentService.addTournament(tournament));
    }

    @PostMapping("/tournaments/{id}")
    public ResponseEntity<Tournament> updateTournament(Tournament tournament){
        return ResponseEntity.ok(tournamentService.updateTournament(tournament));
    }

    @PostMapping("/tournaments/delete/{id}")
    public ResponseEntity<Tournament> deleteTournament(Long id){
        tournamentService.deleteTournament(id);
        return ResponseEntity.ok().build();
    }

    // Custom methods

    @GetMapping("/tournaments/withTeams")
    public ResponseEntity<Iterable<Tournament>> getAllTournamentsWithTeams(){
        return ResponseEntity.ok(tournamentService.findAllWithTeams());
    }

    @GetMapping("/tournaments/byName/{teamName}")
    public ResponseEntity<Iterable<Tournament>> getAllTournamentsByTeamName(String teamName){
        return ResponseEntity.ok(tournamentService.findByTeamName(teamName));
    }

    @GetMapping("/tournaments/teamCount/{teamCount}")
    public ResponseEntity<Iterable<Tournament>> getAllTournamentsByTeamCount(Integer teamCount){
        return ResponseEntity.ok(tournamentService.findByTeamsCount(teamCount));
    }

    @GetMapping("/tournaments/byBoth/teamCount/greaterThan/{teamCount}")
    public ResponseEntity<Iterable<Tournament>> getAllTournamentsByTeamCountGreaterThan(Integer teamCount){
        return ResponseEntity.ok(tournamentService.findByTeamsCountGreaterThan(teamCount));
    }

    @GetMapping("/tournaments/byBoth/teamCount/lessThan/{teamCount}")
    public ResponseEntity<Iterable<Tournament>> getAllTournamentsByTeamCountLessThan(Integer teamCount){
        return ResponseEntity.ok(tournamentService.findByTeamsCountLessThan(teamCount));
    }
}
