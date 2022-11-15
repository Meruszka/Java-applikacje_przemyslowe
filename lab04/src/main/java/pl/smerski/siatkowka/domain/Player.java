package pl.smerski.siatkowka.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class Player {
    @Getter
    private final String id = UUID.randomUUID().toString();
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String surname;
    @Getter @Setter
    private int age;
    @Getter @Setter
    private int height;
    @Getter @Setter
    private String team; // może być enumem albo klasą Team

    public Player(){}
    public Player(String name, String surname, int age, int height, String team) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.height = height;
        this.team = team;
    }

}
