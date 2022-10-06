package me.zexyp.bank.accounts.services;

import me.zexyp.bank.accounts.BaseAccount;
import me.zexyp.bank.InterestCalculator;

import javax.inject.Singleton;

@Singleton
public class InterestRunnerService {
    private InterestCalculator interestCalc = new InterestCalculator();

    public void run(BaseAccount[] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            double interest = interestCalc.calculate(accounts[i]);
            accounts[i].addToBalance(interest);
        }
    }
}
