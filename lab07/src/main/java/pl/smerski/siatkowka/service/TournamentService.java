package pl.smerski.siatkowka.service;

import org.springframework.stereotype.Service;
import pl.smerski.siatkowka.domain.Tournament;
import pl.smerski.siatkowka.repository.TournamentRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
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

    public List<Tournament> findByName(String name){
        return tournamentRepository.findByName(name);
    }
}
