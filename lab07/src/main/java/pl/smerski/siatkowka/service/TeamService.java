package pl.smerski.siatkowka.service;

import org.springframework.stereotype.Service;
import pl.smerski.siatkowka.domain.Team;
import pl.smerski.siatkowka.repository.TeamRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TeamService {
    final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Iterable<Team> findAll(){
        return teamRepository.findAll();
    }

    public Team findById(Long id){
        if(teamRepository.findById(id).isPresent()){
            return teamRepository.findById(id).get();
        }
        // Exception?
        return null;
    }

    public Team addTeam(Team team){
        teamRepository.save(team);
        return team;
    }

    public Team updateTeam(Team team){
        if (teamRepository.findById(team.getId()).isPresent()){
            Team toUpdateTeam = teamRepository.findById(team.getId()).get();
            toUpdateTeam.setName(team.getName());
            toUpdateTeam.setPlayers(team.getPlayers());
            teamRepository.save(toUpdateTeam);
            return toUpdateTeam;
        }
        return null;
    }

    public void deleteTeam(Long id){
        if (teamRepository.findById(id).isPresent()){
            teamRepository.deleteById(id);
        }
    }

    // Custom methods

    public List<Team> findByName(String name){
        return teamRepository.findByName(name);
    }
}
