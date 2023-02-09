package me.zexyp.bank.services;

import me.zexyp.bank.accounts.BaseAccount;
import me.zexyp.bank.accounts.serialization.AccountSerializationObject;
import me.zexyp.bank.accounts.serialization.AccountSerializationObjectFactory;
import me.zexyp.bank.accounts.services.AccountService;
import me.zexyp.bank.cards.BaseCard;
import me.zexyp.bank.cards.serialization.CardSerializationObject;
import me.zexyp.bank.cards.serialization.CardSerializationObjectFactory;
import me.zexyp.bank.cards.services.CardService;
import me.zexyp.bank.persons.Person;
import me.zexyp.bank.persons.serialization.PersonSerializationObject;
import me.zexyp.bank.persons.serialization.PersonSerializationObjectFactory;
import me.zexyp.bank.persons.services.PersonService;
import me.zexyp.bank.storage.Storage;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Arrays;

@Singleton
public class BankSerializationService {
    class SerializationStructure {
        public AccountSerializationObject[] accounts;
        public CardSerializationObject[] cards;
        public PersonSerializationObject[] persons;
    }

    @Inject
    private StringSerializationService serializationService;

    @Inject
    private Storage storage;

    @Inject
    private AccountService accountService;
    @Inject
    private CardService cardService;
    @Inject
    private PersonService personService;
    @Inject
    private AccountSerializationObjectFactory accountFactory;
    @Inject
    private CardSerializationObjectFactory cardFactory;
    @Inject
    private PersonSerializationObjectFactory personFactory;

    public void serialize() {
        var structure = new SerializationStructure();
        structure.accounts = Arrays.stream(accountService.getAccounts()).
                map(e -> accountFactory.createFromAccount(e)).toArray(AccountSerializationObject[]::new);
        structure.cards = Arrays.stream(cardService.getCards()).
                map(e -> cardFactory.createFromCard(e)).toArray(CardSerializationObject[]::new);
        structure.persons = Arrays.stream(personService.getPersons()).
                map(e -> personFactory.createFromPerson(e)).toArray(PersonSerializationObject[]::new);

        var cnt = serializationService.serialize(structure);
        storage.writeText("bank.json", cnt);
    }

    public void deserialize()
    {
        var cnt = storage.readText("bank.json");
        var structure = serializationService.deserialize(cnt, SerializationStructure.class);
        Person[] persons = Arrays.stream(structure.persons).
                map(e -> personFactory.createFromPersonSerializationObject(e)).toArray(Person[]::new);
        for (var person: persons) {
            personService.addPerson(person);
        }

        BaseCard[] cards = Arrays.stream(structure.cards).
                map(e -> cardFactory.createFromCardSerializationObject(e)).toArray(BaseCard[]::new);
        for (var card: cards) {
            cardService.addCard(card);
        }

        BaseAccount[] accounts = Arrays.stream(structure.accounts).
                map(e -> accountFactory.createFromAccountSerializationObject(e)).toArray(BaseAccount[]::new);
        for (var account: accounts) {
            accountService.addAccount(account);
        }
    }
}
