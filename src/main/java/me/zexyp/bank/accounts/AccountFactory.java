package me.zexyp.bank.accounts;

import me.zexyp.bank.persons.Person;

public class AccountFactory {
    public BaseAccount createBaseAccount(String accountNumber, Person owner, double balance) {
        return new BaseAccount(accountNumber, owner, balance);
    }
    public BaseAccount createBaseAccount(String accountNumber, Person owner) { return createBaseAccount(accountNumber, owner, 0); }

    public StudentAccount createStudentAccount(String accountNumber, Person owner, double balance) {
        return new StudentAccount(accountNumber, owner, balance);
    }
    public StudentAccount createStudentAccount(String accountNumber, Person owner) { return createStudentAccount(accountNumber, owner, 0); }

    public SavingsAccount createSavingsAccount(String accountNumber, Person owner, double balance) {
        return new SavingsAccount(accountNumber, owner, balance);
    }
    public SavingsAccount createSavingsAccount(String accountNumber, Person owner) { return createSavingsAccount(accountNumber, owner, 0); }
}
