package me.zexyp.bank;

import me.zexyp.bank.storage.Storage;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.SimpleTimeZone;

@Singleton
public class FakeStorage implements Storage {
    static Map<String, String> fs = new HashMap<>();
    @Override
    public String readText(String path) {
        return fs.get(path);
    }

    @Override
    public void writeText(String path, String content) {
        fs.put(path, content);
    }
}
