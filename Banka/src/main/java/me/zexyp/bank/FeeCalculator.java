package me.zexyp.bank;

import me.zexyp.bank.accounts.BaseAccount;
import me.zexyp.bank.accounts.StudentAccount;

public class FeeCalculator {
    public static final double FEE_SEND_BASE = 5;
    public static final double FEE_SEND_STUDENT = 0;
    public static final double FEE_WITHDRAW_BASE = 5;
    public static final double FEE_WITHDRAW_STUDENT = 0;

    public double calculateSend(BaseAccount account, double amount)
    {
        if (account instanceof StudentAccount)
            return FEE_SEND_STUDENT;
        else
            return FEE_SEND_BASE;
    }

    public double calculateWithdraw(BaseAccount account, double amount)
    {
        if (account instanceof StudentAccount)
            return FEE_SEND_STUDENT;
        else
            return FEE_SEND_BASE;
    }
}