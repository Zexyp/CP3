package me.zexyp.bank.persons.services;

import me.zexyp.bank.persons.Person;
import me.zexyp.bank.persons.PersonFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PersonCreationService {
    @Inject
    PersonFactory factory;

    private int lastId = 0;

    public Person createPerson(String firstName, String lastName) {
        return factory.createPerson(firstName, lastName, String.valueOf(++lastId));
    }
}
