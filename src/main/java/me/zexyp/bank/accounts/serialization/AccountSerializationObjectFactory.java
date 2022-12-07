package me.zexyp.bank.accounts.serialization;

import me.zexyp.bank.accounts.AccountFactory;
import me.zexyp.bank.accounts.AccountType;
import me.zexyp.bank.accounts.BaseAccount;
import me.zexyp.bank.cards.serialization.CardSerializationObject;
import me.zexyp.bank.cards.serialization.CardSerializationObjectFactory;
import me.zexyp.bank.cards.services.CardService;
import me.zexyp.bank.persons.serialization.PersonSerializationObjectFactory;
import me.zexyp.bank.persons.services.PersonService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AccountSerializationObjectFactory {
    @Inject
    private AccountFactory accountFactory;

    @Inject
    private CardService cardService;
    @Inject
    private PersonService personService;

    public AccountSerializationObject createFromAccount(BaseAccount account) {
        AccountSerializationObject accountData = new AccountSerializationObject();
        accountData.accountType = AccountType.getFromBaseAccount(account);
        accountData.number = account.getAccountNumber();
        accountData.balance = account.getBalance();
        accountData.ownerId = account.getOwner().getId();
        var c = account.getCards();
        accountData.cardIds = new String[c.length];
        for (int i = 0; i < c.length; i++) {
            accountData.cardIds[i] = c[i].getNumber();
        }
        return accountData;
    }

    public BaseAccount createFromAccountSerializationObject(AccountSerializationObject accountData) {
        var person = personService.getPerson(accountData.ownerId);
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

        for (int i = 0; i < accountData.cardIds.length; i++) {
            account.assignCard(cardService.getCard(accountData.cardIds[i]));
        }

        return account;
    }
}
