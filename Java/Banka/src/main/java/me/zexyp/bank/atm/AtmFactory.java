package me.zexyp.bank.atm;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import me.zexyp.bank.accounts.services.MoneyTransferService;

@Singleton
public class AtmFactory {
    @Inject
    private MoneyTransferService transferService;

    public BaseAtm createAtm() {
        return new BaseAtm(transferService);
    }
}
