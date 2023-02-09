package me.zexyp.bank.accounts.services;

import me.zexyp.bank.persons.Person;
import me.zexyp.bank.accounts.AccountFactory;
import me.zexyp.bank.accounts.AccountType;
import me.zexyp.bank.accounts.BaseAccount;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class AccountService {
    @Inject
    private AccountCreationService creationService;

    private final Map<String, BaseAccount> accounts = new HashMap<>();

    public void addAccount(BaseAccount account) {
        // TODO: fix laziness - (how about no...)
        accounts.put(account.getAccountNumber(), account);
    }

    public void removeAccount(BaseAccount account) {
        accounts.remove(account.getAccountNumber(), account);
    }

    public BaseAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public BaseAccount[] getAccounts() {
        return accounts.values().toArray(new BaseAccount[0]);
    }

    public BaseAccount createAccount(Person owner, AccountType type) {
        var account = creationService.createBaseAccount(owner);
        addAccount(account);
        return account;
    }
}
