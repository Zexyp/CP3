package me.zexyp.bank.accounts.services;

import me.zexyp.bank.accounts.BaseAccount;
import me.zexyp.bank.FeeCalculator;
import me.zexyp.bank.atm.BaseAtm;
import me.zexyp.bank.observing.Observer;
import me.zexyp.bank.observing.Subject;
import org.checkerframework.checker.units.qual.A;

import javax.inject.Singleton;
import java.util.LinkedList;
import java.util.List;

@Singleton
public class MoneyTransferService implements Subject {
    public interface MoneyTransferArgs {
        BaseAccount getFrom();
        BaseAccount getTo();
        double getAmount();
    }

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

        notifyObserversMoneyTransfer(from, to, amount);

        return true;
    }

    public boolean withdrawMoney(BaseAccount account, double amount) {
        double amountWithTax = amount + feeCalculator.calculateWithdraw(account, amount);
        if (account.getBalance() < amount)
            return false;

        account.subFromBalance(amount);

        return true;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObserversMoneyTransfer(BaseAccount from, BaseAccount to, double amount) {
        class Args implements MoneyTransferArgs {
            BaseAccount from;
            BaseAccount to;
            double amount;

            public Args(BaseAccount from, BaseAccount to, double amount) {
                this.from = from;
                this.to = to;
                this.amount = amount;
            }

            @Override
            public BaseAccount getFrom() {
                return from;
            }

            @Override
            public BaseAccount getTo() {
                return to;
            }

            @Override
            public double getAmount() {
                return amount;
            }
        }

        observers.forEach(o -> o.update(this, new Args(from, to, amount)));
    }
}
