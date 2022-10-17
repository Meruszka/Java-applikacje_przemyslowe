package pl.smerski.zad5;

import lombok.*;

public class Author {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private Gender gender;

    public Author(String name, String email, Gender gender){
        this.name = name;
        this.email = email;
        this.gender = gender;

    }
    public Author(){
        this("", "", Gender.NotKnown);
    }
    public String toString(){
        return "Author[" + name + "," + email +"," + gender + "]";
    }
}

