package me.zexyp.bank.atm;

import me.zexyp.bank.cards.BaseCard;

public class BaseAtm {
    private BaseCard cardContext;

    public void openAccount(BaseCard card) {
        cardContext = card;
    }

    public void closeAccount() {
        cardContext = null;
    }

    public double readBalance() {
        return cardContext.getAccount().getBalance();
    }

    public void withdraw(double amount) {
        cardContext.getAccount().subFromBalance(amount);
    }
}
