package me.zexyp.bank.actions;

import me.zexyp.bank.cli.MenuAction;

import javax.inject.Singleton;
import java.util.Scanner;

@Singleton
public class InvalidAction implements MenuAction {
    @Override
    public void processAction(Scanner scanner) {
        System.out.println("Use help to see the options");
    }
}
