package me.zexyp.bank;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BankInjector());

        Bank bank = injector.getInstance(Bank.class);
        bank.example();
        bank.startTerminal();

        System.out.println();
    }
}
