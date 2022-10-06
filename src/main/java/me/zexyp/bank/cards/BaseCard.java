package me.zexyp.bank.cards;

import me.zexyp.bank.accounts.BaseAccount;

public class BaseCard {
    private String number;
    private String exp;
    private String cvc;

    transient private BaseAccount account;

    public BaseCard(BaseAccount account, String number, String exp, String cvc) {
        this.account = account;
        this.number = number;
        this.exp = exp;
        this.cvc = cvc;
    }

    public String getNumber() { return number; }
    public String getCVC() { return cvc; }
    public String getExpiration() { return exp; }
}
