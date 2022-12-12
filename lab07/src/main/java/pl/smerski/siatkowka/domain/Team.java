package pl.smerski.siatkowka.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {
    @Getter @Setter @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String city;
    @Setter @Getter
//    @OneToOne
    private String coach;
    @Setter @Getter
//    @OneToOne
    private String captain;

    @Setter @Getter
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Player> players;


    public Team(){
    }
    public Team(String name){
        this.name = name;
    }
    public Team(String name, String city, String coach, String captain) {
        this.name = name;
        this.city = city;
        this.coach = coach;
        this.captain = captain;
    }
    public Team(String name, String city, String coach, String captain,  List<Player> players) {
        this.name = name;
        this.city = city;
        this.coach = coach;
        this.captain = captain;
        this.players = players;
    }


    @Override
    public String toString(){
        return "" + name;
    }

}
