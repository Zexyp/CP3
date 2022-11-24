package me.zexyp.bank.cards;

import me.zexyp.bank.accounts.BaseAccount;

public class BaseCard {
    private String number;
    private String exp;
    private String cvc;
    private boolean active;

    transient private BaseAccount account;

    public BaseCard(String number, String exp, String cvc) {
        this.number = number;
        this.exp = exp;
        this.cvc = cvc;
    }

    public String getNumber() { return number; }
    public String getCVC() { return cvc; }
    public String getExpiration() { return exp; }

    public void setAccount(BaseAccount account) { this.account = account; }
    public BaseAccount getAccount() { return account; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
