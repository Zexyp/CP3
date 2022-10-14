package me.zexyp.bank.persons.services;

import me.zexyp.bank.persons.Person;
import me.zexyp.bank.persons.PersonFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class PersonService {
    @Inject
    private PersonFactory factory;

    private final Map<String, Person> persons = new HashMap<>();

    public Person createPerson(String id, String firstName, String lastName) {
        var person = factory.createPerson(firstName, lastName);
        persons.put(id, person);
        return  person;
    }


    public Person getPerson(String id) {
        return persons.get(id);
    }
}
