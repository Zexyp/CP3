package me.zexyp.bank.persons.serialization;

import me.zexyp.bank.persons.Person;
import me.zexyp.bank.persons.PersonFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PersonJsonSerializationObjectFactory {
    @Inject
    private PersonFactory personFactory;

    public PersonJsonSerializationObject createFromPerson(Person person) {
        PersonJsonSerializationObject personJSO = new PersonJsonSerializationObject();
        personJSO.firstName = person.getFirstName();
        personJSO.lastName = person.getLastName();
        return personJSO;
    }

    public Person createFromPersonJSO(PersonJsonSerializationObject personJSO) {
        return personFactory.createPerson(personJSO.firstName, personJSO.lastName);
    }
}
