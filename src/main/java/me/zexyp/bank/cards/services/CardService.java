package me.zexyp.bank.cards.services;

import me.zexyp.bank.accounts.BaseAccount;
import me.zexyp.bank.cards.BaseCard;
import me.zexyp.bank.cards.CardFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class CardService {
    @Inject
    private CardFactory cardFactory;
    @Inject
    private CardDataGeneratorService generator;

    private Map<String, BaseCard> cards = new HashMap<>();

    public BaseCard generateCard() {
        String num = generator.generateNumber();
        String exp = generator.generateExpiration();
        String cvc = generator.generateCVC();

        var card = cardFactory.createCard(num, exp, cvc);

        cards.put(num, card);

        return card;
    }

    public BaseCard generateCardFor(BaseAccount account) {
        var card = generateCard();

        account.assignCard(card);

        return card;
    }

    public BaseCard getCard(String number) {
        return cards.get(number);
    }
}
