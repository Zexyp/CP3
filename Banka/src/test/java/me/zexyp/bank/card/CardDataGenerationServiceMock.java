package me.zexyp.bank.card;

import com.google.inject.Singleton;
import me.zexyp.bank.cards.services.CardDataGeneratorService;

@Singleton
public class CardDataGenerationServiceMock extends CardDataGeneratorService {
    @Override
    public String generateNumber() {
        return "only fake data here";
    }
}
