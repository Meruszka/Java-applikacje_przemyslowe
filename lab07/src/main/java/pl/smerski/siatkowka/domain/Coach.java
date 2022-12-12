package pl.smerski.siatkowka.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="coaches")
public class Coach {
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
    private Team team;

    public Coach(){
    }

    public Coach(String name, String surname, int age, Team team) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.team = team;
    }

    public Coach(String id, String name, String surname, int age, Team team) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.team = team;
    }

    @Override
    public String toString() {
        return "" + name + surname + age + team;
    }
}
