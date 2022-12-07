package me.zexyp.bank.accounts;

import me.zexyp.bank.persons.Person;

public class AccountFactory {
    public BaseAccount createBaseAccount(String accountNumber, Person owner, double balance) {
        return new BaseAccount(accountNumber, owner, balance);
    }

    public StudentAccount createStudentAccount(String accountNumber, Person owner, double balance) {
        return new StudentAccount(accountNumber, owner, balance);
    }

    public SavingsAccount createSavingsAccount(String accountNumber, Person owner, double balance) {
        return new SavingsAccount(accountNumber, owner, balance);
    }
}
