package me.zexyp.bank.actions;

import me.zexyp.bank.cli.MenuAction;
import me.zexyp.bank.persons.Person;
import me.zexyp.bank.persons.services.PersonService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Scanner;

@Singleton
public class PersonUpdateAction implements MenuAction {
    @Inject
    private PersonReadAction readPerson;
    @Inject
    private PersonService personService;

    @Override
    public void processAction(Scanner scanner) {
        var person = readPerson.getPerson(scanner);
        if (person == null)
            return;
        updateInfo(person, scanner);
    }

    public void updateInfo(Person person, Scanner scanner) {
        System.out.print("first name:");
        var firstName = scanner.next();
        System.out.print("last name: ");
        var lastName = scanner.next();
        person.setFirstName(firstName);
        person.setLastName(lastName);
    }
}
