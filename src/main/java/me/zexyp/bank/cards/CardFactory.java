package me.zexyp.bank.cards;

import me.zexyp.bank.accounts.BaseAccount;

public class CardFactory {
    public BaseCard createBaseCard(String number, String exp, String cvc) {
        return new BaseCard(number, exp, cvc);
    }
}
