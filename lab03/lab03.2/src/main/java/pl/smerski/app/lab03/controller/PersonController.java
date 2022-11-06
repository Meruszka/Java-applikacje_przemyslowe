package pl.smerski.app.lab03.controller;


import org.springframework.beans.factory.annotation.Autowired;
import pl.smerski.app.lab03.domain.Person;
import pl.smerski.app.lab03.serviceBean.PersonManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    public PersonController(@Autowired PersonManager personManager) {
        this.personManager = personManager;

    }

    private PersonManager personManager;

    @PostMapping("/person")
    public void addPerson(@RequestBody Person person) {
        personManager.addPerson(person);
    }

    @GetMapping("/person")
    public Person getPerson(@RequestParam String id) {
        return personManager.getPerson(Integer.parseInt(id));
    }

    @GetMapping("/person/all")
    public List<Person> getAllPerson() {
        return personManager.getAllPersons();
    }

    @DeleteMapping("/person")
    public void deletePerson(@RequestParam String id) {
        personManager.deletePerson(Integer.parseInt(id));
    }

    @PutMapping("/person")
    public void updatePerson(@RequestBody Person person) {
        personManager.updatePerson(person);
    }
}
