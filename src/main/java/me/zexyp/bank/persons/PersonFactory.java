package me.zexyp.bank.persons;

import javax.inject.Singleton;

@Singleton
public class PersonFactory {
    public Person createPerson(String firstName, String lastName, String id) {
        return new Person(firstName, lastName, id);
    }
}
