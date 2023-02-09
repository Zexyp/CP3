package me.zexyp.bank.services;

public interface StringSerializationService {
    String serialize(Object obj);
    <T> T deserialize(String text, Class<T> type);
}
