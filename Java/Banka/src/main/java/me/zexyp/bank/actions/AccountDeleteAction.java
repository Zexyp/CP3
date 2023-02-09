package me.zexyp.bank.actions;

import me.zexyp.bank.accounts.services.AccountService;
import me.zexyp.bank.cli.MenuAction;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Scanner;

@Singleton
public class AccountDeleteAction implements MenuAction {
    @Inject
    private AccountReadAction readAction;
    @Inject
    private AccountService accountService;

    @Override
    public void processAction(Scanner scanner) {
        var account = readAction.getAccount(scanner);
        if (account == null)
            return;

        accountService.removeAccount(account);
    }
}
