package me.zexyp.bank;

import com.google.inject.AbstractModule;
import me.zexyp.bank.services.GsonSerializationService;
import me.zexyp.bank.services.StringSerializationService;
import me.zexyp.bank.storage.FileSystemStorage;
import me.zexyp.bank.storage.Storage;

import java.io.File;

public class BankInjector extends AbstractModule {
    @Override
    protected void configure() {
        this.bind(Storage.class).to(FileSystemStorage.class);
        this.bind(StringSerializationService.class).to(GsonSerializationService.class);
    }
}
