package me.zexyp.bank.cards.services;

import me.zexyp.bank.accounts.BaseAccount;
import me.zexyp.bank.cards.BaseCard;
import me.zexyp.bank.cards.CardFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CardCreatorService {
    @Inject
    private CardFactory cardFactory;
    @Inject
    private CardDataGeneratorService generator;

    public BaseCard generateCard()
    {
        String num = generator.generateNumber();
        String exp = generator.generateExpiration();
        String cvc = generator.generateCVC();

        var card = cardFactory.createCard(num, exp, cvc);

        return card;
    }

    public BaseCard generateCardFor(BaseAccount account)
    {
        String num = generator.generateNumber();
        String exp = generator.generateExpiration();
        String cvc = generator.generateCVC();

        var card = cardFactory.createCard(num, exp, cvc);

        account.assignCard(card);

        return card;
    }
}
