package me.zexyp.bank.actions;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import me.zexyp.bank.cli.MenuAction;
import me.zexyp.bank.persons.services.PersonService;

import java.util.Scanner;

@Singleton
public class PersonDeleteAction implements MenuAction {
    @Inject
    private PersonReadAction readPerson;
    @Inject
    private PersonService personService;

    @Override
    public void processAction(Scanner scanner) {
        var person = readPerson.getPerson(scanner);
        if (person == null)
            return;

        personService.removePerson(person);
    }
}
