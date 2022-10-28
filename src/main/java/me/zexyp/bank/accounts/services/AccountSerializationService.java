package me.zexyp.bank.accounts.services;

import me.zexyp.bank.accounts.BaseAccount;
import me.zexyp.bank.accounts.serialization.AccountSerializationObject;
import me.zexyp.bank.accounts.serialization.AccountSerializationObjectFactory;
import me.zexyp.bank.services.StringSerializationService;
import me.zexyp.bank.storage.Storage;

import javax.inject.Inject;
import java.util.Arrays;

public class AccountSerializationService {
    @Inject
    private AccountService accountService;
    @Inject
    private AccountSerializationObjectFactory accountSerializationObjectFactory;
    @Inject
    private StringSerializationService serializationService;

    @Inject
    private Storage storage;

    public void save() {
        AccountSerializationObject[] accountSOs = Arrays.stream(accountService.getAccounts()).
                map(e -> accountSerializationObjectFactory.createFromBaseAccount(e)).toArray(AccountSerializationObject[]::new);
        var cnt = serializationService.serialize(accountSOs);
        storage.writeText("bank.json", cnt);
    }

    public void load() {
        /*
        if (accountService.getAccounts().length > 0)
            throw new RuntimeException();
        */

        var text = storage.readText("bank.json");
        BaseAccount[] accounts = Arrays.stream(serializationService.deserialize(text, AccountSerializationObject[].class)).
                map(e -> accountSerializationObjectFactory.createFromAccountSerializationObject(e)).toArray(BaseAccount[]::new);

        for (var account: accounts) {
            accountService.addAccount(account);
        }
    }
}
