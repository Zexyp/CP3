package me.zexyp.bank.checks;

import me.zexyp.bank.accounts.BaseAccount;
import me.zexyp.bank.cards.BaseCard;

public class Check {
    private String id;
    private BaseAccount account;

    public Check(String id, BaseAccount account) {
        this.id = id;
        this.account = account;
    }

    public String getId() { return id; }
    public BaseAccount getAccount() { return account; }
}
