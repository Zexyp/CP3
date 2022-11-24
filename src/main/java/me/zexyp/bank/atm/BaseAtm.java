package me.zexyp.bank.atm;

import me.zexyp.bank.cards.BaseCard;

public class BaseAtm {
    private BaseCard cardContext;

    public void openAccount(BaseCard card) {
        if (card == null)
            throw new NullPointerException();
        cardContext = card;
    }

    public void closeAccount() {
        cardContext = null;
    }

    public double readBalance() {
        if (cardContext == null)
            throw new RuntimeException();
        return cardContext.getAccount().getBalance();
    }

    public void withdraw(double amount) {
        if (cardContext == null || !cardContext.isActive())
            throw new RuntimeException();
        cardContext.getAccount().subFromBalance(amount);
    }

    public void activateCard() {
        if (cardContext == null)
            throw new RuntimeException();

        cardContext.setActive(true);
    }

    public void deactivateCard() {
        if (cardContext == null)
            throw new RuntimeException();

        cardContext.setActive(false);
    }
}
