package me.zexyp.bank.actions;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import jdk.jshell.spi.ExecutionControl;
import me.zexyp.bank.accounts.BaseAccount;
import me.zexyp.bank.accounts.services.AccountService;
import me.zexyp.bank.cli.MenuAction;

import java.util.Scanner;

@Singleton
public class AccountReadAction implements MenuAction {
    @Inject
    private AccountService accountService;


    @Override
    public void processAction(Scanner scanner) {
        var account = getAccount(scanner);
        if (account == null)
            return;

        try {
            throw new ExecutionControl.NotImplementedException("");
        } catch (ExecutionControl.NotImplementedException e) {
            throw new RuntimeException(e);
        }
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
