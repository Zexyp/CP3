package me.zexyp.bank;

import com.google.inject.Guice;
import com.google.inject.Inject;
import me.zexyp.bank.services.BankSerializationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SerializationTest {
    @Inject
    private BankSerializationService service;

    @BeforeEach
    public void setUp() {
        Guice.createInjector(new BankInjectorTest()).injectMembers(this);
    }

    @Test
    void serialization() {
        service.serialize();
    }

    @Test
    void deserialization() {
        service.deserialize();
    }
}
