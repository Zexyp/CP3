package me.zexyp.bank.actions;

import me.zexyp.bank.cli.MenuAction;
import me.zexyp.bank.cli.MenuChoices;

import java.util.Scanner;

public class HelpAction implements MenuAction {
    @Override
    public void processAction(Scanner scanner) {
        MenuChoices.printOptions();
    }
}
