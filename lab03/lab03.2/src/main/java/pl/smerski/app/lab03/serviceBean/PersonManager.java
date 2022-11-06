package pl.smerski.app.lab03.serviceBean;

import pl.smerski.app.lab03.domain.Person;

import java.io.IOException;
import java.util.List;

public interface PersonManager {
    List<Person> getAllPersons();
    Person getPerson(int id);
    void addPerson(Person person);
    void deletePerson(int id);
    void updatePerson(Person person);
    void loadPersons() throws IOException, InterruptedException;
}
