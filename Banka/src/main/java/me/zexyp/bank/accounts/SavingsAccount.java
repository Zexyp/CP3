package me.zexyp.bank.accounts;

import me.zexyp.bank.persons.Person;

public class SavingsAccount extends BaseAccount implements AccountWithInterest {

    public SavingsAccount(String accountNumber, Person owner, double balance) {
        super(accountNumber, owner, balance);
    }

    public void save()
    {
        System.out.println("you not going to save world using this method");
    }

    @Override
    public double getInterest() {
        return 5;
    }
}
