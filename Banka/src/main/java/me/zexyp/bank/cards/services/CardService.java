package me.zexyp.bank.cards.services;

import me.zexyp.bank.cards.BaseCard;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class CardService {
    @Inject
    private CardCreationService creationService;

    private Map<String, BaseCard> cards = new HashMap<>();

    public void addCard(BaseCard card) {
        cards.put(card.getNumber(), card);
    }

    public void removeCard(BaseCard card) {
        cards.remove(card.getNumber());
    }

    public BaseCard getCard(String number) {
        return cards.get(number);
    }

    public BaseCard[] getCards() {
        return cards.values().toArray(new BaseCard[0]);
    }

    public BaseCard createCard() {
        var card = creationService.createBaseCard();
        addCard(card);
        return card;
    }
}
