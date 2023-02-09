package me.zexyp.bank.checks;

import me.zexyp.bank.accounts.BaseAccount;

import javax.inject.Singleton;

@Singleton
public class CheckFactory {
    public Check createCheck(BaseAccount account, String checkId) {
        return new Check(checkId, account);
    }
}
