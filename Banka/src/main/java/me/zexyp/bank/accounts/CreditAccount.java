package me.zexyp.bank.accounts;

import me.zexyp.bank.persons.Person;

import javax.inject.Inject;

public class CreditAccount extends BaseAccount {
    private double limit = 0;

    public CreditAccount(String accountNumber, Person owner, double balance) {
        super(accountNumber, owner, balance);
        throw new RuntimeException("too lazy");
    }

    public double getLimit(){return limit;}
}
