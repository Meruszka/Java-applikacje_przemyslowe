package pl.smerski.app.lab03.domain;

import lombok.Getter;
import lombok.Setter;

public class Person {
    @Getter @Setter
    String id;
    @Getter @Setter
    String name;
    @Getter @Setter
    String surname;
    @Getter @Setter
    String email;
    @Getter @Setter
    String company_name;
    public Person(){}
    public Person(String id, String name, String surname, String email, String company_name) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.company_name = company_name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", company_name='" + company_name + '\'' +
                '}';
    }
}
