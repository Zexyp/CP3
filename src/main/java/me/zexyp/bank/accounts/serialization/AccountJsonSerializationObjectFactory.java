package me.zexyp.bank.accounts.serialization;

import me.zexyp.bank.accounts.AccountFactory;
import me.zexyp.bank.accounts.AccountType;
import me.zexyp.bank.accounts.BaseAccount;
import me.zexyp.bank.cards.CardFactory;
import me.zexyp.bank.cards.serialization.CardJsonSerializationObject;
import me.zexyp.bank.cards.serialization.CardJsonSerializationObjectFactory;
import me.zexyp.bank.cards.services.CardCreatorService;
import me.zexyp.bank.persons.Person;
import me.zexyp.bank.persons.serialization.PersonJsonSerializationObject;
import me.zexyp.bank.persons.serialization.PersonJsonSerializationObjectFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AccountJsonSerializationObjectFactory {
    @Inject
    private PersonJsonSerializationObjectFactory personJSOFactory;
    @Inject
    private CardJsonSerializationObjectFactory cardJSOFactory;
    @Inject
    private AccountFactory accountFactory;

    public AccountJsonSerializationObject createFromBaseAccount(BaseAccount account) {
        AccountJsonSerializationObject accountJSO = new AccountJsonSerializationObject();
        accountJSO.accountType = AccountType.getFromBaseAccount(account);
        accountJSO.number = account.getAccountNumber();
        accountJSO.balance = account.getBalance();
        accountJSO.owner = personJSOFactory.createFromPerson(account.getOwner());
        var c = account.getCards();
        var c2 = new CardJsonSerializationObject[c.length];
        for (int i = 0; i < c.length; i++) {
            c2[i] = cardJSOFactory.createFromCard(c[i]);
        }
        accountJSO.cards = c2;
        return accountJSO;
    }

    public BaseAccount createFromAccountJSO(AccountJsonSerializationObject accountJSO) {
        BaseAccount account = switch (accountJSO.accountType) {
            case BASE ->
                    accountFactory.createBaseAccount(
                            accountJSO.number,
                            personJSOFactory.createFromPersonJSO(accountJSO.owner),
                            accountJSO.balance);
            case STUDENT ->
                    accountFactory.createStudentAccount(
                            accountJSO.number,
                            personJSOFactory.createFromPersonJSO(accountJSO.owner),
                            accountJSO.balance);
            case SAVINGS ->
                    accountFactory.createSavingsAccount(
                            accountJSO.number,
                            personJSOFactory.createFromPersonJSO(accountJSO.owner),
                            accountJSO.balance);
        };

        for (int i = 0; i < accountJSO.cards.length; i++) {
            account.assignCard(cardJSOFactory.createFromCardJSO(accountJSO.cards[i]));
        }

        return account;
    }
}
