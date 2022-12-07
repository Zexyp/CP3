package me.zexyp.bank.accounts.services;

import me.zexyp.bank.accounts.BaseAccount;
import me.zexyp.bank.FeeCalculator;
import me.zexyp.bank.atm.BaseAtm;

import javax.inject.Singleton;

@Singleton
public class MoneyTransferService {
    private FeeCalculator feeCalculator;

    public void setFeeCalculator(FeeCalculator feeCalc) {
        feeCalculator = feeCalc;
    }

    public boolean transferMoney(BaseAccount from, BaseAccount to, double amount) {
        double amountWithTax = amount + feeCalculator.calculateSend(from, amount);
        if (from.getBalance() < amountWithTax)
            return false;

        from.subFromBalance(amountWithTax);
        to.addToBalance(amount);

        return true;
    }

    public boolean withdrawMoney(BaseAccount account, double amount) {
        double amountWithTax = amount + feeCalculator.calculateWithdraw(account, amount);
        if (account.getBalance() < amount)
            return false;

        account.subFromBalance(amount);

        return true;
    }
}
