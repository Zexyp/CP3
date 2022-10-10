package me.zexyp.bank.cards.serialization;

import me.zexyp.bank.cards.BaseCard;
import me.zexyp.bank.cards.CardFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CardJsonSerializationObjectFactory {
    @Inject
    private CardFactory cardFactory;
    public CardJsonSerializationObject createFromCard(BaseCard card) {
        CardJsonSerializationObject cardJSO = new CardJsonSerializationObject();
        cardJSO.number = card.getNumber();
        cardJSO.cvc = card.getCVC();
        cardJSO.exp = card.getExpiration();
        return cardJSO;
    }

    public BaseCard createFromCardJSO(CardJsonSerializationObject cardJSO) {
        return cardFactory.createCard(cardJSO.number, cardJSO.exp, cardJSO.cvc);
    }
}
