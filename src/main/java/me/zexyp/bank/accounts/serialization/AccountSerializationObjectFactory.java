package me.zexyp.bank.accounts.serialization;

import me.zexyp.bank.accounts.AccountFactory;
import me.zexyp.bank.accounts.AccountType;
import me.zexyp.bank.accounts.BaseAccount;
import me.zexyp.bank.cards.serialization.CardSerializationObject;
import me.zexyp.bank.cards.serialization.CardSerializationObjectFactory;
import me.zexyp.bank.persons.serialization.PersonSerializationObjectFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AccountSerializationObjectFactory {
    @Inject
    private PersonSerializationObjectFactory personSerializationObjectFactory;
    @Inject
    private CardSerializationObjectFactory cardSerializationObjectFactory;
    @Inject
    private AccountFactory accountFactory;

    public AccountSerializationObject createFromBaseAccount(BaseAccount account) {
        AccountSerializationObject accountData = new AccountSerializationObject();
        accountData.accountType = AccountType.getFromBaseAccount(account);
        accountData.number = account.getAccountNumber();
        accountData.balance = account.getBalance();
        accountData.owner = personSerializationObjectFactory.createFromPerson(account.getOwner());
        var c = account.getCards();
        var c2 = new CardSerializationObject[c.length];
        for (int i = 0; i < c.length; i++) {
            c2[i] = cardSerializationObjectFactory.createFromCard(c[i]);
        }
        accountData.cards = c2;
        return accountData;
    }

    public BaseAccount createFromAccountSerializationObject(AccountSerializationObject accountData) {
        var person = personSerializationObjectFactory.createFromPersonSerializationObject(accountData.owner);
        BaseAccount account = switch (accountData.accountType) {
            case BASE ->
                    accountFactory.createBaseAccount(
                            accountData.number,
                            person,
                            accountData.balance);
            case STUDENT ->
                    accountFactory.createStudentAccount(
                            accountData.number,
                            person,
                            accountData.balance);
            case SAVINGS ->
                    accountFactory.createSavingsAccount(
                            accountData.number,
                            person,
                            accountData.balance);
        };

        for (int i = 0; i < accountData.cards.length; i++) {
            account.assignCard(cardSerializationObjectFactory.createFromCardSerializationObject(accountData.cards[i]));
        }

        return account;
    }
}
