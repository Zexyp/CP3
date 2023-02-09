package me.zexyp.bank.accounts.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import me.zexyp.bank.accounts.AccountFactory;
import me.zexyp.bank.accounts.BaseAccount;
import me.zexyp.bank.accounts.SavingsAccount;
import me.zexyp.bank.accounts.StudentAccount;
import me.zexyp.bank.persons.Person;

@Singleton
public class AccountCreationService {
    @Inject
    AccountFactory factory;
    @Inject
    AccountNumberGeneratorService generator;

    public BaseAccount createBaseAccount(Person person) {
        return factory.createBaseAccount(generator.generate(), person, 0);
    }

    public SavingsAccount createSavingsAccount(Person person) {
        return factory.createSavingsAccount(generator.generate(), person, 0);
    }

    public StudentAccount createStudentAccount(Person person) {
        return factory.createStudentAccount(generator.generate(), person, 0);
    }
}