package me.zexyp.bank.accounts.serialization;

import me.zexyp.bank.cards.serialization.CardJsonSerializationObject;
import me.zexyp.bank.accounts.AccountType;
import me.zexyp.bank.persons.serialization.PersonJsonSerializationObject;

public class AccountJsonSerializationObject {
    public AccountType accountType;
    public double balance;
    public String number;
    public PersonJsonSerializationObject owner;
    public CardJsonSerializationObject[] cards;
}
