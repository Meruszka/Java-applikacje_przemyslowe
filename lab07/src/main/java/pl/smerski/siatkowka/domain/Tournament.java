package pl.smerski.siatkowka.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "tournament")
public class Tournament {
    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Team> teams;


    public Tournament(){
    }

    public Tournament(String name){
        this.name = name;
    }

    public Tournament(String name, List<Team> teams){
        this.name = name;
        this.teams = teams;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Team team: teams) {
            sb.append(team.getName()).append(" ");
        }
        return "" + name + " " + sb;
    }

}
