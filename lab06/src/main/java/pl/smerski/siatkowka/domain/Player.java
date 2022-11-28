package pl.smerski.siatkowka.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="players")
public class Player {
    @Getter @Setter @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String surname;
    @Getter @Setter
    private int age;
    @Getter @Setter
    private int height;
    @Getter @Setter
    private String team;

    public Player(){
    }
    public Player(String name, String surname, int age, int height, String team) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.height = height;
        this.team = team;
    }
    public Player(String id, String name, String surname, int age, int height, String team) {
        this.id = id;
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
