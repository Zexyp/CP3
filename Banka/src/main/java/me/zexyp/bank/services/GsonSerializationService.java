package me.zexyp.bank.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

@Singleton
public class GsonSerializationService implements StringSerializationService {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public String serialize(Object obj) {
        return gson.toJson(obj);
    }

    @Override
    public <T> T deserialize(String text, Class<T> type) {
        return gson.fromJson(text, type);
    }
}
