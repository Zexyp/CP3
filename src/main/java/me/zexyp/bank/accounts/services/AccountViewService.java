package me.zexyp.bank.accounts.services;

import me.zexyp.bank.accounts.BaseAccount;

import javax.inject.Singleton;

@Singleton
public class AccountViewService {
    public void printAccount(BaseAccount account)
    {
        System.out.println(String.format("%s %s (%s) has %f",
                account.getOwner().getFirstName(),
                account.getOwner().getLastName(),
                account.getAccountNumber(),
                account.getBalance()));

        for (var card : account.getCards()) {
            System.out.println(String.format("    with card %s; cvc %s; exp %s",
                    card.getNumber(),
                    card.getCVC(),
                    card.getExpiration()));
        };
    }
}
