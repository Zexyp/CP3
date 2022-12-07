package me.zexyp.bank.atm.services;

import me.zexyp.bank.atm.AtmFactory;
import me.zexyp.bank.atm.BaseAtm;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AtmCreationService {
    @Inject
    AtmFactory factory;

    public BaseAtm createAtm() {
        return factory.createAtm();
    }
}
