package me.zexyp.bank.persons.serialization;

import me.zexyp.bank.persons.Person;

import javax.inject.Singleton;

@Singleton
public class PersonJsonSerializationObjectFactory {
    public PersonJsonSerializationObject createFromPerson(Person person) {
        PersonJsonSerializationObject personJSO = new PersonJsonSerializationObject();
        personJSO.firstName = person.getFirstName();
        personJSO.lastName = person.getLastName();
        return personJSO;
    }
}
