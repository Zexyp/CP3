package me.zexyp.bank;

import me.zexyp.bank.accounts.AccountType;
import me.zexyp.bank.accounts.BaseAccount;
import me.zexyp.bank.accounts.serialization.AccountSerializationObjectFactory;
import me.zexyp.bank.accounts.services.AccountService;
import me.zexyp.bank.atm.services.AtmService;
import me.zexyp.bank.cards.services.CardService;
import me.zexyp.bank.cli.Menu;
import me.zexyp.bank.cli.MenuActionProcessService;
import me.zexyp.bank.cli.MenuChoices;
import me.zexyp.bank.persons.Person;
import me.zexyp.bank.persons.services.PersonService;
import me.zexyp.bank.services.BobuxGenerator;
import me.zexyp.bank.accounts.services.InterestRunnerService;
import me.zexyp.bank.accounts.services.MoneyTransferService;
import me.zexyp.bank.services.StringSerializationService;

import javax.inject.Inject;
import java.util.Scanner;

public class Bank {
    @Inject
    private PersonService personService;
    @Inject
    private AccountSerializationObjectFactory accountSerializationObjectFactory;

    @Inject
    private InterestRunnerService interestService;
    @Inject
    private MoneyTransferService moneyTransferService;
    @Inject
    private CardService cardService;
    @Inject
    private BobuxGenerator bobuxGenerator;
    @Inject
    private AccountService accountService;
    @Inject
    private StringSerializationService serializationService;
    @Inject
    private MenuActionProcessService actionProcessService;
    @Inject
    private AtmService atmService;



    public Bank()
    {

    }

    public void example()
    {
        moneyTransferService.setFeeCalculator(new FeeCalculator());

        Person owner = personService.createPerson("Very", "egzampel");

        BaseAccount account1 = accountService.createAccount(owner, AccountType.BASE);
        BaseAccount account2 = accountService.createAccount(owner, AccountType.BASE);
        account1.addToBalance(2000);

        //accountViewService.printAccount(account1);
        //accountViewService.printAccount(account2);

        moneyTransferService.transferMoney(account1, account2, 990);
        System.out.println("transferred");

        //accountViewService.printAccount(account1);
        //accountViewService.printAccount(account2);

        BaseAccount stuAccount = accountService.createAccount(owner, AccountType.STUDENT);

        interestService.run(new BaseAccount[] {account1, account2, stuAccount});
        //accountViewService.printAccount(stuAccount);

        var card = cardService.createCard();
        account1.assignCard(card);
        //accountViewService.printAccount(account1);

        bobuxGenerator.generate(account1,4);

        var atm = atmService.createAtm();
        atm.openAccount(card);
        atm.activateCard();
        System.out.println(atm.readBalance());
        atm.withdraw(5);
        System.out.println(atm.readBalance());
        atm.closeAccount();

        moneyTransferService.addObserver((sender, args) -> {
            if (args instanceof MoneyTransferService.MoneyTransferArgs mtargs) {
                System.out.println(
                        "money transfer from " + mtargs.getFrom().getAccountNumber() +
                        " to " + mtargs.getTo().getAccountNumber() +
                        " of " + mtargs.getAmount());
            }
        });
    }

    public void startTerminal() {
        System.out.println("<put MOTD here>");

        Menu menu = new Menu();
        MenuChoices.printOptions();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            var choice = menu.read(scanner);
            actionProcessService.processAction(choice, scanner);
            if (choice == MenuChoices.EXIT)
                break;
        }
    }
}
