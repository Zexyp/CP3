package me.zexyp.bank.actions;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import me.zexyp.bank.accounts.BaseAccount;
import me.zexyp.bank.accounts.services.AccountService;
import me.zexyp.bank.accounts.services.AccountViewService;
import me.zexyp.bank.cli.MenuAction;

import java.util.Scanner;

@Singleton
public class AccountReadAction implements MenuAction {
    @Inject
    private AccountService accountService;
    @Inject
    private AccountViewService viewService;

    @Override
    public void processAction(Scanner scanner) {
        var account = getAccount(scanner);
        if (account == null)
            return;

        viewService.printAccount(account);
    }

    public BaseAccount getAccount(Scanner scanner)
    {
        System.out.println("select a account by account number:");
        var account = accountService.getAccount(scanner.next());
        if (account == null) {
            System.out.println("nothing found");
            return null;
        }
        return account;
    }
}
