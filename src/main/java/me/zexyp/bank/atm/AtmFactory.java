package me.zexyp.bank.atm;

import com.google.inject.Singleton;

@Singleton
public class AtmFactory {
    public BaseAtm createAtm() {
        return new BaseAtm();
    }
}
