package me.zexyp.bank;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import me.zexyp.bank.actions.*;
import me.zexyp.bank.cli.MenuAction;
import me.zexyp.bank.cli.MenuChoices;
import me.zexyp.bank.services.GsonSerializationService;
import me.zexyp.bank.services.StringSerializationService;
import me.zexyp.bank.storage.FileSystemStorage;
import me.zexyp.bank.storage.Storage;

public class BankInjector extends AbstractModule {
    @Override
    protected void configure() {
        this.bind(Storage.class).to(FileSystemStorage.class);
        this.bind(StringSerializationService.class).to(GsonSerializationService.class);

        MapBinder<MenuChoices, MenuAction> mapBinder = MapBinder.newMapBinder(binder(), MenuChoices.class, MenuAction.class);
        //mapBinder.addBinding(MenuChoices.EXIT, );
        //mapBinder.addBinding(MenuChoices.HELP, );
        mapBinder.addBinding(MenuChoices.INVALID_VALUE).to(InvalidAction.class);
        mapBinder.addBinding(MenuChoices.HELP).to(HelpAction.class);
        mapBinder.addBinding(MenuChoices.LOAD).to(BankLoadAction.class);
        mapBinder.addBinding(MenuChoices.SAVE).to(BankSaveAction.class);
        mapBinder.addBinding(MenuChoices.CREATE_ACCOUNT).to(AccountCreateAction.class);
        mapBinder.addBinding(MenuChoices.READ_ACCOUNT).to(AccountReadAction.class);
        mapBinder.addBinding(MenuChoices.UPDATE_ACCOUNT).to(AccountUpdateAction.class);
        mapBinder.addBinding(MenuChoices.DELETE_ACCOUNT).to(AccountDeleteAction.class);
        mapBinder.addBinding(MenuChoices.CREATE_PERSON).to(PersonCreateAction.class);
        mapBinder.addBinding(MenuChoices.READ_PERSON).to(PersonReadAction.class);
        mapBinder.addBinding(MenuChoices.UPDATE_PERSON).to(PersonUpdateAction.class);
        mapBinder.addBinding(MenuChoices.DELETE_PERSON).to(PersonDeleteAction.class);
    }
}
