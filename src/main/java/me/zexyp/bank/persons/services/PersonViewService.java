package me.zexyp.bank.persons.services;

import me.zexyp.bank.persons.Person;

import javax.inject.Singleton;

@Singleton
public class PersonViewService {
    public void printPerson(Person person)
    {
        System.out.println(String.format("id: %s; fn: %s; ln: %s",
                person.getFirstName(),
                person.getLastName(),
                person.getId()));
    }
}
