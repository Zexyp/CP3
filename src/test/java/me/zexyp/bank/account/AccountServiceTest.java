package me.zexyp.bank.account;

import com.google.inject.Guice;
import com.google.inject.Inject;
import me.zexyp.bank.BankInjectorTest;
import me.zexyp.bank.accounts.AccountType;
import me.zexyp.bank.accounts.services.AccountService;
import me.zexyp.bank.persons.services.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AccountServiceTest {
    @Inject
    private AccountService service;
    @Inject
    private PersonService personService;

    @BeforeEach
    public void setUp() {
        Guice.createInjector(new BankInjectorTest()).injectMembers(this);
    }

    @Test
    void testInjectBaseService() {
        assertNotNull(this.service);
        assertInstanceOf(AccountService.class, this.service);
    }

    @Test
    void complex() {

        var account = service.createAccount(personService.createPerson("empty", "empty"), AccountType.BASE);
        assertTrue(Arrays.stream(service.getAccounts()).anyMatch(e -> e == account));
        service.removeAccount(account);
        assertFalse(Arrays.stream(service.getAccounts()).anyMatch(e -> e == account));
        service.addAccount(account);
        assertTrue(Arrays.stream(service.getAccounts()).anyMatch(e -> e == account));
    }
}
