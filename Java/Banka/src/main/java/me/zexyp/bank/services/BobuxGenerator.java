package me.zexyp.bank.services;

import me.zexyp.bank.accounts.BaseAccount;

import javax.inject.Singleton;

@Singleton
public class BobuxGenerator {
    public void generate(BaseAccount account, double amount) {
        account.addToBalance(amount);
    }
}
