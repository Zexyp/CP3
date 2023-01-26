package me.zexyp.bank.card;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import me.zexyp.bank.BankInjectorTest;
import me.zexyp.bank.cards.services.CardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CardServiceTest {
    @Inject
    private CardService service;

    @BeforeEach
    public void setUp() {
        Guice.createInjector(new BankInjectorTest()).injectMembers(this);
    }

    @Test
    void testInjectBaseService() {
        assertNotNull(this.service);
        assertInstanceOf(CardService.class, this.service);
    }

    @Test
    void complex() {
        var card = service.createCard();
        assertTrue(Arrays.stream(service.getCards()).anyMatch(e -> e == card));
        service.removeCard(card);
        assertFalse(Arrays.stream(service.getCards()).anyMatch(e -> e == card));
        service.addCard(card);
        assertTrue(Arrays.stream(service.getCards()).anyMatch(e -> e == card));
    }
}
