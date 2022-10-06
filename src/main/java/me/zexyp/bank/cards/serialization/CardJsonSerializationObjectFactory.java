package me.zexyp.bank.cards.serialization;

import me.zexyp.bank.cards.BaseCard;

import javax.inject.Singleton;

@Singleton
public class CardJsonSerializationObjectFactory {
    public CardJsonSerializationObject createFromCard(BaseCard card) {
        CardJsonSerializationObject cardJSO = new CardJsonSerializationObject();
        cardJSO.number = card.getNumber();
        cardJSO.cvc = card.getCVC();
        cardJSO.exp = card.getExpiration();
        return cardJSO;
    }
}
