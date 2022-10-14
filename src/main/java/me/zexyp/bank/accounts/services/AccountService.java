package me.zexyp.bank.accounts.services;

import me.zexyp.bank.persons.Person;
import me.zexyp.bank.accounts.AccountFactory;
import me.zexyp.bank.accounts.AccountType;
import me.zexyp.bank.accounts.BaseAccount;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Singleton
public class AccountService {
    @Inject
    private AccountFactory factory;
    @Inject
    private AccountNumberGeneratorService numberService;

    private final Map<String, BaseAccount> accounts = new HashMap<>();

    public BaseAccount createAccount(Person owner, AccountType type) {
        var num = numberService.generate();
        var acc = switch (type) {
            case BASE -> factory.createBaseAccount(num, owner);
            case STUDENT -> factory.createStudentAccount(num, owner);
            case SAVINGS -> factory.createSavingsAccount(num, owner);
        };

        addAccount(acc);
        return acc;
    }

    public void addAccount(BaseAccount account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public BaseAccount getAccount(String accountNumber) {
        /*
        for (BaseAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber))
                return account;
        }
        return null;
        */

        /*
        return accounts.
                stream().
                filter(a -> a.getAccountNumber().equals(accountNumber)).
                findAny().
                orElse(null);
        */

        return accounts.get(accountNumber);
    }

    public BaseAccount[] getAccounts() {
        return accounts.values().toArray(new BaseAccount[0]);
    }
}
