package me.zexyp.bank.accounts.services;

import me.zexyp.bank.persons.Person;
import me.zexyp.bank.accounts.AccountFactory;
import me.zexyp.bank.accounts.AccountType;
import me.zexyp.bank.accounts.BaseAccount;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.LinkedList;
import java.util.List;

@Singleton
public class AccountService {
    @Inject
    private AccountFactory factory;
    @Inject
    private AccountNumberGeneratorService numberService;

    private final List<BaseAccount> accounts = new LinkedList<>();

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
        accounts.add(account);
    }

    public BaseAccount[] getAccounts() {
        return accounts.toArray(new BaseAccount[0]);
    }
}
