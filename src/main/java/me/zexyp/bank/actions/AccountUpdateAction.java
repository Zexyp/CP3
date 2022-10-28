package me.zexyp.bank.actions;

import me.zexyp.bank.accounts.BaseAccount;
import me.zexyp.bank.cli.MenuAction;
import me.zexyp.bank.persons.services.PersonService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Scanner;

@Singleton
public class AccountUpdateAction implements MenuAction {
    @Inject
    private AccountReadAction readAction;
    @Inject
    private PersonService personService;
    @Inject
    private PersonReadAction readPersonAction;

    @Override
    public void processAction(Scanner scanner) {
        var account = readAction.getAccount(scanner);
        if (account == null)
            return;

        updateInfo(account, scanner);
    }

    public void updateInfo(BaseAccount account, Scanner scanner) {
        account.setOwner(readPersonAction.getPerson(scanner));
        System.out.print("balance: ");
        account.setBalance(scanner.nextDouble());
    }
}
