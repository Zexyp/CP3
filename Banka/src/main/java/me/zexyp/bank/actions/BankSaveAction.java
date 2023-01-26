package me.zexyp.bank.actions;

import me.zexyp.bank.cli.MenuAction;
import me.zexyp.bank.services.BankSerializationService;

import javax.inject.Inject;
import java.util.Scanner;

public class BankSaveAction implements MenuAction {
    @Inject
    private BankSerializationService bankSerializationService;

    @Override
    public void processAction(Scanner scanner) {
        bankSerializationService.serialize();
        System.out.println("Saved");
    }
}
