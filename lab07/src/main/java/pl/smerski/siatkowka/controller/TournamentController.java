package pl.smerski.siatkowka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.smerski.siatkowka.domain.Tournament;
import pl.smerski.siatkowka.service.TournamentService;

import java.util.List;

@RestController
public class TournamentController {
    final TournamentService tournamentService;

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

    @GetMapping("/tournaments/{name")
    public ResponseEntity<List<Tournament>> getTournamentByName(String name){
        return ResponseEntity.ok(tournamentService.findByName(name));
    }
}
