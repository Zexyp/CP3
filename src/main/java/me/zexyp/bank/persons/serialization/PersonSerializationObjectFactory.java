package me.zexyp.bank.persons.serialization;

import me.zexyp.bank.persons.Person;
import me.zexyp.bank.persons.PersonFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PersonSerializationObjectFactory {
    @Inject
    private PersonFactory personFactory;

    public PersonSerializationObject createFromPerson(Person person) {
        PersonSerializationObject personSO = new PersonSerializationObject();
        personSO.firstName = person.getFirstName();
        personSO.lastName = person.getLastName();
        return personSO;
    }

    public Person createFromPersonSerializationObject(PersonSerializationObject personSO) {
        return personFactory.createPerson(personSO.firstName, personSO.lastName);
    }
}
