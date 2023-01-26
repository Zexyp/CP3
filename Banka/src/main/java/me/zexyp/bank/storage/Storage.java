package me.zexyp.bank.storage;

public interface Storage {
    String readText(String path);
    void writeText(String path, String content);
}
