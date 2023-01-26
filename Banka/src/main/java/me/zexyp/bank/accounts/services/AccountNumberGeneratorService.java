package me.zexyp.bank.accounts.services;

import javax.inject.Singleton;
import java.util.Random;

@Singleton
public class AccountNumberGeneratorService {
    private Random random = new Random();

    public String generate() {
        String num = "";
        for (int i = 0; i < 16; i++) {
            num += (char)random.nextInt('0', '9' + 1);
        }
        return num;
    }
}
