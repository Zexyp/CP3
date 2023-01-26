package me.zexyp.bank.checks.services;

import me.zexyp.bank.accounts.BaseAccount;
import me.zexyp.bank.checks.Check;
import me.zexyp.bank.checks.CheckFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CheckCreationService {
    @Inject
    private CheckFactory factory;

    public Check createCheck(BaseAccount $for) {
        String randomId = "74a3984d-ffc3-4f03-8840-4bb977a9600d";
        return factory.createCheck($for, randomId);
    }
}
