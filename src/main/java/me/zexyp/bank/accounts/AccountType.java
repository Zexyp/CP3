package me.zexyp.bank.accounts;

import jdk.jshell.spi.ExecutionControl;

public enum AccountType {
    BASE,
    STUDENT,
    SAVINGS;

    public static AccountType getFromBaseAccount(BaseAccount account) {
        if (account instanceof BaseAccount)
            return AccountType.BASE;
        if (account instanceof StudentAccount)
            return AccountType.STUDENT;
        if (account instanceof SavingsAccount)
            return AccountType.SAVINGS;

        for (;;);
    }
}
