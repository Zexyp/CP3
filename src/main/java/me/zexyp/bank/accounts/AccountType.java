package me.zexyp.bank.accounts;

public enum AccountType {
    BASE,
    STUDENT,
    SAVINGS,
    CREDIT;

    public static AccountType getFromAccount(BaseAccount account) {
        if (account instanceof StudentAccount)
            return AccountType.STUDENT;
        if (account instanceof SavingsAccount)
            return AccountType.SAVINGS;
        if (account instanceof CreditAccount)
            return CREDIT;

        return AccountType.BASE;
    }
}
