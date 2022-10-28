package me.zexyp.bank.actions;

import me.zexyp.bank.accounts.services.AccountSerializationService;
import me.zexyp.bank.cli.MenuAction;

import javax.inject.Inject;
import java.util.Scanner;

public class BankSaveAction implements MenuAction {
    @Inject
    private AccountSerializationService accountSerializationService;

    @Override
    public void processAction(Scanner scanner) {
        accountSerializationService.save();
        System.out.println("Saved");
    }
}
