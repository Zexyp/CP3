package me.zexyp.bank.storage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

public class FileSystemStorage implements Storage {
    @Override
    public String readText(String path) {
        try {
            var pathobj = Paths.get(path);
            return Files.readString(pathobj, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void writeText(String path, String content) {
        try {
            var pathobj = Paths.get(path);
            Files.writeString(pathobj, content, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
