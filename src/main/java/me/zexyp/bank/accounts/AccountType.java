package me.zexyp.bank.accounts;

import com.google.gson.annotations.SerializedName;

public enum AccountType {
    BASE,
    STUDENT,
    SAVINGS;

    public static AccountType getFromBaseAccount(BaseAccount account) {
        if (account instanceof StudentAccount)
            return AccountType.STUDENT;
        if (account instanceof SavingsAccount)
            return AccountType.SAVINGS;

        return AccountType.BASE;
    }
}
