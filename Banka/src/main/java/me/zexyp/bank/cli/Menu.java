package me.zexyp.bank.cli;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    public MenuChoices read(Scanner scanner) {
        try {
            System.out.print("> ");
            //int menuInput = scanner.nextInt();
            return MenuChoices.convertFromString(scanner.next().toLowerCase());
        } catch (Exception exception) {
            System.out.println("Error");
            return MenuChoices.INVALID_VALUE;
        }
    }
}
