package me.zexyp.bank.cards.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import me.zexyp.bank.cards.BaseCard;
import me.zexyp.bank.cards.CardFactory;

@Singleton
public class CardCreationService {
    @Inject
    CardFactory factory;
    @Inject
    CardDataGeneratorService generator;

    public BaseCard createBaseCard() {
        String num = generator.generateNumber();
        String exp = generator.generateExpiration();
        String cvc = generator.generateCVC();

        return factory.createBaseCard(num, exp, cvc);
    }
}
