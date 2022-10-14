package me.zexyp.bank.cards.serialization;

import me.zexyp.bank.cards.BaseCard;
import me.zexyp.bank.cards.CardFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CardSerializationObjectFactory {
    @Inject
    private CardFactory cardFactory;
    public CardSerializationObject createFromCard(BaseCard card) {
        CardSerializationObject cardSO = new CardSerializationObject();
        cardSO.number = card.getNumber();
        cardSO.cvc = card.getCVC();
        cardSO.exp = card.getExpiration();
        return cardSO;
    }

    public BaseCard createFromCardSerializationObject(CardSerializationObject cardSO) {
        return cardFactory.createCard(cardSO.number, cardSO.exp, cardSO.cvc);
    }
}
