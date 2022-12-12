package pl.smerski.siatkowka.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="teams")
public class Team {
    @Getter @Setter @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String city;
    @Setter
    private Coach coach;
    @Setter
    private Player captain;

    @OneToOne
    public Coach getCoach() {
        return coach;
    }

    @OneToOne
    public Player getCaptain() {
        return captain;
    }

    public Team(){
    }
    public Team(String name){
        this.name = name;
    }
    public Team(String name, String city, Coach coach, Player captain) {
        this.name = name;
        this.city = city;
        this.coach = coach;
        this.captain = captain;
    }
    public Team(String id, String name, String city, Coach coach, Player captain) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.coach = coach;
        this.captain = captain;
    }


    @Override
    public String toString(){
        return "" + name + city + coach + captain;
    }

}
