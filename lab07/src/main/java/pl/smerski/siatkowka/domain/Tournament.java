package pl.smerski.siatkowka.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tournaments")
public class Tournament {
    @Getter @Setter @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private List<Team> teams;

    @ManyToMany
    public List<Team> getTeams() {
        return teams;
    }
    public Tournament(){
    }
    public Tournament(String name, List<Team> teams) {
        this.name = name;
        this.teams = teams;
    }
    public Tournament(String id, String name, List<Team> teams) {
        this.id = id;
        this.name = name;
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "" + name + teams;
    }
}
