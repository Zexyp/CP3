package me.zexyp.bank.account;

import com.google.inject.Singleton;
import me.zexyp.bank.accounts.services.AccountNumberGeneratorService;

@Singleton
public class AccountNumberGeneratorServiceMock extends AccountNumberGeneratorService {
    @Override
    public String generate() {
        return "garbario";
    }
}
