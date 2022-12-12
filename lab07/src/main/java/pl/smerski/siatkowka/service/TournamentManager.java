package pl.smerski.siatkowka.service;

import pl.smerski.siatkowka.domain.Tournament;

import java.util.List;

public interface TournamentManager {
    List<Tournament> getTournaments();
    Tournament getTournament(String id) throws Exception;
    Tournament addTournament(Tournament tournament);
    Tournament updateTournament(Tournament tournament) throws Exception;
    Tournament deleteTournament(String id) throws Exception;
}
