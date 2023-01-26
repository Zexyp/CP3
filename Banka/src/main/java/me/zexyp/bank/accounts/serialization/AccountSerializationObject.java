package me.zexyp.bank.accounts.serialization;

import me.zexyp.bank.cards.serialization.CardSerializationObject;
import me.zexyp.bank.accounts.AccountType;
import me.zexyp.bank.persons.serialization.PersonSerializationObject;

public class AccountSerializationObject {
    public AccountType accountType;
    public double balance;
    public String number;
    public String ownerId;
    public String[] cardIds;
}
