package me.zexyp.bank;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import me.zexyp.bank.account.AccountNumberGeneratorServiceMock;
import me.zexyp.bank.accounts.services.AccountNumberGeneratorService;
import me.zexyp.bank.card.CardDataGenerationServiceMock;
import me.zexyp.bank.cards.services.CardDataGeneratorService;
import me.zexyp.bank.services.GsonSerializationService;
import me.zexyp.bank.services.StringSerializationService;
import me.zexyp.bank.storage.Storage;

public class BankInjectorTest extends AbstractModule {
    @Override
    public void configure() {
        super.configure();

        this.bind(CardDataGeneratorService.class).to(CardDataGenerationServiceMock.class);
        this.bind(AccountNumberGeneratorService.class).to(AccountNumberGeneratorServiceMock.class);
        this.bind(Storage.class).to(FakeStorage.class);
        this.bind(StringSerializationService.class).to(GsonSerializationService.class);
    }
}
