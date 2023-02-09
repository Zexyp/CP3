package me.zexyp.bank;

import me.zexyp.bank.accounts.BaseAccount;
import me.zexyp.bank.accounts.AccountWithInterest;

public class InterestCalculator {
    public double calculate(BaseAccount account) {
        if (!(account instanceof AccountWithInterest))
            return 0;

        return (account.getBalance() / 100) * (((AccountWithInterest) account).getInterest());
    }
}
