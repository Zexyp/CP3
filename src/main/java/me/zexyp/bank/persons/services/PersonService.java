package me.zexyp.bank.persons.services;

import me.zexyp.bank.persons.Person;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class PersonService {
    @Inject
    private PersonCreationService creationService;

    private final Map<String, Person> persons = new HashMap<>();

    public void addPerson(Person person) {
        persons.put(person.getId(), person);
    }

    public void removePerson(Person person) {
        persons.remove(person.getId());
    }

    public Person getPerson(String id) {
        return persons.get(id);
    }

    public Person[] getPersons() {
        return persons.values().toArray(new Person[0]);
    }

    public Person createPerson(String firstName, String lastName) {
        var person = creationService.createPerson(firstName, lastName);
        addPerson(person);
        return person;
    }
}
