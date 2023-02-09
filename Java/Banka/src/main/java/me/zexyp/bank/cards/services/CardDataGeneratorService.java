package me.zexyp.bank.cards.services;

import javax.inject.Singleton;
import java.util.Calendar;
import java.util.Random;

@Singleton
public class CardDataGeneratorService {
    private Random random = new Random();

    private int expirationOffset = 5;

    public String generateNumber() {
        String[] num = new String[] { generateGroup(), generateGroup(), generateGroup(), generateGroup() };
        return String.join(" ", num);
    }
    
    public String generateExpiration() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, expirationOffset);

        return String.format("%02d", calendar.get(Calendar.MONTH)) + "/" + String.format("%02d", calendar.get(Calendar.YEAR));
    }
    
    public String generateCVC() {
        return generateGroup().substring(0, 2);
    }

    private String generateGroup() {
        String num = "";
        for (int i = 0; i < 4; i++) {
            num += (char)random.nextInt('0', '9' + 1);
        }
        return num;
    }
}
