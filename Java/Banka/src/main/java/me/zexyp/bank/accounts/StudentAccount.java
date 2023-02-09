package me.zexyp.bank.accounts;


import me.zexyp.bank.persons.Person;

public class StudentAccount extends BaseAccount implements AccountWithInterest {
    public StudentAccount(String accountNumber, Person owner, double balance) {
        super(accountNumber, owner, balance);
    }

    @Override
    public double getInterest() {
        return 5;
    }
}
