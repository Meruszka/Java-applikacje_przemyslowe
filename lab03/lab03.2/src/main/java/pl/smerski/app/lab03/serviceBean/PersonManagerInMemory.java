package pl.smerski.app.lab03.serviceBean;


import org.springframework.stereotype.Component;
import pl.smerski.app.lab03.domain.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonManagerInMemory implements PersonManager{
    private List<Person> persons = new ArrayList<>();

    @Override
    public List<Person> getAllPersons() {
        return persons;
    }

    @Override
    public Person getPerson(int id) {
        return persons.get(id);
    }

    @Override
    public void addPerson(Person person) {
        Person newPerson = new Person(person.getId(), person.getName(), person.getSurname(), person.getEmail(), person.getCompany_name());
        persons.add(newPerson);
    }

    @Override
    public void deletePerson(int id) {
        persons.remove(id);
    }

    @Override
    public void updatePerson(Person person) {
        persons.remove(person);
        persons.add(person);
    }



}
