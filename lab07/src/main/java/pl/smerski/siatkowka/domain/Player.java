package pl.smerski.siatkowka.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Player {
    @Getter @Setter @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String surname;
    @Getter @Setter
    private int age;
    @Getter @Setter
    private int height;
    @Getter @Setter
    @ManyToOne
    private Team team;

    public Player(){
    }
    public Player(String name, String surname, int age, int height, Team team) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.height = height;
        this.team = team;
    }

    @Override
    public String toString(){
        return "" + name + surname + age + height + team;
    }

}
