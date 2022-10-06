package me.zexyp.bank.cards;

import me.zexyp.bank.accounts.BaseAccount;

public class CardFactory {
    public BaseCard createCard(BaseAccount account, String number, String exp, String cvc) {
        return new BaseCard(account, number, exp, cvc);
    }
}
