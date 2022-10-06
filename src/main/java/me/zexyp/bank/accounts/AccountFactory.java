package me.zexyp.bank.accounts;

import me.zexyp.bank.persons.Person;

public class AccountFactory {
    public BaseAccount createBaseAccount(String accountNumber, Person owner) {
        return new BaseAccount(accountNumber, owner, 0);
    }
    public StudentAccount createStudentAccount(String accountNumber, Person owner) {
        return new StudentAccount(accountNumber, owner, 0);
    }
    public SavingsAccount createSavingsAccount(String accountNumber, Person owner) {
        return new SavingsAccount(accountNumber, owner, 0);
    }
}
