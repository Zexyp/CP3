package me.zexyp.bank.accounts;

import me.zexyp.bank.cards.BaseCard;
import me.zexyp.bank.persons.Person;

import java.util.LinkedList;
import java.util.List;

public class BaseAccount {
    private double balance;
    private Person owner;
    private String accountNumber;

    private List<BaseCard> cards = new LinkedList<BaseCard>();

    public BaseAccount(String accountNumber, Person owner, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
    }

    public String getAccountNumber() { return accountNumber; }

    public double getBalance() {
        return balance;
    }

    public Person getOwner() {
        return owner;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void addToBalance(double amount) {
        balance += amount;
    }

    public void subFromBalance(double amount) {
        balance -= amount;
    }

    public void assignCard(BaseCard card) {
        cards.add(card);
        card.setAccount(this);
    }

    public BaseCard[] getCards() {
        return cards.toArray(new BaseCard[0]);
    }
}
