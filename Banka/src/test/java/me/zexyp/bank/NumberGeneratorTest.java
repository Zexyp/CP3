package me.zexyp.bank;

import me.zexyp.bank.accounts.BaseAccount;
import me.zexyp.bank.accounts.services.AccountNumberGeneratorService;
import me.zexyp.bank.accounts.services.MoneyTransferService;
import me.zexyp.bank.atm.BaseAtm;
import me.zexyp.bank.cards.BaseCard;
import me.zexyp.bank.persons.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberGeneratorTest {
    @Test
    void numberGeneration() {
        AccountNumberGeneratorService service = new AccountNumberGeneratorService();

        assertNotNull(service.generate());
        assertNotEquals(service.generate(), service.generate());
    }

    @Test
    void carding() {
        BaseCard card = new BaseCard("4564 4564 4564 4564", "08/05", "753");
        assertNull(card.getAccount());

        BaseAtm atm = new BaseAtm(new MoneyTransferService());
        atm.openAccount(card);
        assertThrows(Exception.class, () -> atm.withdraw(1));
        card.setAccount(new BaseAccount("0", new Person("fn", "ln", "ider"), 0));
    }
}
