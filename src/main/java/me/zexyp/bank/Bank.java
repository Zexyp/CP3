package me.zexyp.bank;

import com.google.gson.Gson;
import me.zexyp.bank.accounts.AccountType;
import me.zexyp.bank.accounts.BaseAccount;
import me.zexyp.bank.accounts.serialization.AccountJsonSerializationObject;
import me.zexyp.bank.accounts.serialization.AccountJsonSerializationObjectFactory;
import me.zexyp.bank.accounts.services.AccountService;
import me.zexyp.bank.cards.services.CardCreatorService;
import me.zexyp.bank.accounts.services.AccountViewService;
import me.zexyp.bank.persons.Person;
import me.zexyp.bank.persons.PersonFactory;
import me.zexyp.bank.services.BobuxGenerator;
import me.zexyp.bank.accounts.services.InterestRunnerService;
import me.zexyp.bank.accounts.services.MoneyTransferService;

import javax.inject.Inject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

public class Bank {
    @Inject
    private AccountViewService accountViewService;
    @Inject
    private InterestRunnerService interestService;
    @Inject
    private MoneyTransferService moneyTransferService;
    @Inject
    private CardCreatorService cardCreatorService;
    @Inject
    private PersonFactory personFactory;
    @Inject
    private BobuxGenerator bobuxGenerator;
    @Inject
    private AccountService accountCreatorService;
    @Inject
    private AccountJsonSerializationObjectFactory accountFSOF;

    public Bank()
    {

    }

    public void example()
    {
        moneyTransferService.setFeeCalculator(new FeeCalculator());

        Person owner = new Person("Aiwen", "");

        BaseAccount account1 = accountCreatorService.createAccount(owner, AccountType.BASE);
        BaseAccount account2 = accountCreatorService.createAccount(owner, AccountType.BASE);

        accountViewService.printAccount(account1);
        accountViewService.printAccount(account2);

        moneyTransferService.transferMoney(account1, account2, 990);
        System.out.println("transferred");

        accountViewService.printAccount(account1);
        accountViewService.printAccount(account2);

        BaseAccount stuAccount = accountCreatorService.createAccount(owner, AccountType.STUDENT);

        interestService.run(new BaseAccount[] {account1, account2, stuAccount});
        accountViewService.printAccount(stuAccount);

        cardCreatorService.generateCardFor(account1);
        accountViewService.printAccount(account1);

        bobuxGenerator.generate(account1,4);

        Gson gson = new Gson();
        var ouchie = gson.toJson(accountFSOF.createFromBaseAccount(account1));
        System.out.println(ouchie);
        accountViewService.printAccount(accountFSOF.createFromAccountJSO(gson.fromJson(ouchie, AccountJsonSerializationObject.class)));

        /*
        var path = Paths.get("ouchie.txt");
        var content = Collections.singleton(ouchie);
        try {
            Files.write(path, content, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            for (;;);
        }
        */
    }
}
