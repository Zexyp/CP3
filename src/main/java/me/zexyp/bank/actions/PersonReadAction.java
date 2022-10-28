package me.zexyp.bank.actions;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import me.zexyp.bank.cli.MenuAction;
import me.zexyp.bank.persons.Person;
import me.zexyp.bank.persons.services.PersonService;
import me.zexyp.bank.persons.services.PersonViewService;

import java.util.Scanner;

@Singleton
public class PersonReadAction implements MenuAction {
    @Inject
    private PersonService personService;
    @Inject
    private PersonViewService viewService;

    @Override
    public void processAction(Scanner scanner) {
        var person = getPerson(scanner);
        if (person == null)
            return;

        viewService.printPerson(person);
    }

    public Person getPerson(Scanner scanner)
    {
        System.out.println("select a person by id:");
        var person = personService.getPerson(scanner.next());
        if (person == null) {
            System.out.println("nothing found");
            return null;
        }
        return person;
    }
}
