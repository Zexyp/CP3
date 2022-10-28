package me.zexyp.bank.actions;

import me.zexyp.bank.accounts.AccountType;
import me.zexyp.bank.accounts.services.AccountService;
import me.zexyp.bank.cli.MenuAction;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Scanner;

@Singleton
public class AccountCreateAction implements MenuAction {
    @Inject
    private AccountService accountService;
    @Inject
    private AccountUpdateAction accountUpdate;
    @Inject
    private PersonReadAction readPersonAction;

    @Override
    public void processAction(Scanner scanner) {
        System.out.print("account number: ");
        var account = accountService.createAccount(readPersonAction.getPerson(scanner), AccountType.BASE);
        accountUpdate.updateInfo(account, scanner);
    }
}
