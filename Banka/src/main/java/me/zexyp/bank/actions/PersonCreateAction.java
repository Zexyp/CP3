package me.zexyp.bank.actions;

import me.zexyp.bank.cli.MenuAction;
import me.zexyp.bank.persons.services.PersonService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Scanner;

@Singleton
public class PersonCreateAction implements MenuAction {
    @Inject
    private PersonService personService;
    @Inject
    private PersonUpdateAction personUpdate;

    @Override
    public void processAction(Scanner scanner) {
        System.out.print("id: ");
        var person = personService.createPerson(scanner.nextLine(), scanner.nextLine());
        personUpdate.updateInfo(person, scanner);
    }
}
