package pl.smerski.siatkowka.service;

import pl.smerski.siatkowka.domain.Tournament;
import pl.smerski.siatkowka.repository.TournamentRepository;

public class TournamentService {
    final TournamentRepository tournamentRepository;
    public TournamentService(TournamentRepository tournamentRepository){
        this.tournamentRepository = tournamentRepository;
    }

    public Iterable<Tournament> findAll(){
        return tournamentRepository.findAll();
    }

    public Tournament findById(Long id){
        if(tournamentRepository.findById(id).isPresent()){
            return tournamentRepository.findById(id).get();
        }
        // Exception?
        return null;
    }

    public Tournament addTournament(Tournament tournament){
        tournamentRepository.save(tournament);
        return tournament;
    }

    public Tournament updateTournament(Tournament tournament){
        if (tournamentRepository.findById(tournament.getId()).isPresent()){
            Tournament toUpdateTournament = tournamentRepository.findById(tournament.getId()).get();
            toUpdateTournament.setName(tournament.getName());
            toUpdateTournament.setTeams(tournament.getTeams());
            tournamentRepository.save(toUpdateTournament);
            return toUpdateTournament;
        }
        return null;
    }

    public void deleteTournament(Long id){
        if (tournamentRepository.findById(id).isPresent()){
            tournamentRepository.deleteById(id);
        }
    }

    // Custom methods

    public Iterable<Tournament> findAllWithTeams(){
        return tournamentRepository.findAllWithTeams();
    }

    public Iterable<Tournament> findByTeamName(String teamName){
        return tournamentRepository.findByTeamName(teamName);
    }

    public Tournament findByTeamNameAndName(String teamName, String name){
        return tournamentRepository.findByTeamNameAndName(teamName, name);
    }

    public Tournament findByNameOrTeamName(String name, String teamName){
        return tournamentRepository.findByNameOrTeamName(name, teamName);
    }

    public Tournament findByTeamsCount(int count){
        return tournamentRepository.findByTeamsCount(count);
    }

    public Tournament findByTeamsCountGreaterThan(int count){
        return tournamentRepository.findByTeamsCountGreaterThan(count);
    }

    public Tournament findByTeamsCountLessThan(int count){
        return tournamentRepository.findByTeamsCountLessThan(count);
    }
}
