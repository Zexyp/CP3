package me.zexyp.bank.cli;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Map;
import java.util.Scanner;

@Singleton
public class MenuActionProcessService {
    @Inject
    private Map<MenuChoices, MenuAction> registeredActions;

    public void processAction(MenuChoices menuChoices, Scanner scanner) {
        MenuAction action = this.registeredActions.get(menuChoices);
        if (action != null)
            action.processAction(scanner);
    }
}
