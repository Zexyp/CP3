package me.zexyp.bank;

import me.zexyp.bank.accounts.BaseAccount;
import me.zexyp.bank.accounts.StudentAccount;

public class FeeCalculator {
    public static final double FEE_BASE = 5;
    public static final double FEE_STUDENT = 0;

    public double calculateSend(BaseAccount account, double amount)
    {
        if (account instanceof StudentAccount)
            return FEE_STUDENT;
        else
            return FEE_BASE;
    }
}