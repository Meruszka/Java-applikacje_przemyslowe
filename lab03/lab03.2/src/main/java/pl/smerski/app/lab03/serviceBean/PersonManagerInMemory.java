package pl.smerski.app.lab03.serviceBean;


import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import pl.smerski.app.lab03.domain.Person;
import pl.smerski.app.lab03.service.ParseCSV;

import java.io.IOException;
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
    @Override
    public void loadPersons() throws IOException, InterruptedException {
        ParseCSV parseCSV = new ParseCSV();
        String csv = parseCSV.getCSV();
        for (CSVRecord record : parseCSV.parseCSV(csv)) {
            Person person = new Person(record.get("id"), record.get("name"), record.get("surname"), record.get("email"), record.get("company_name"));
            persons.add(person);
        }
    }
    }
