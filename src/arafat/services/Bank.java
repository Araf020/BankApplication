package src.arafat.services;

import java.util.*;

import src.arafat.model.Account;

public class Bank {
    private static volatile Bank instance;
    private List<Account> accounts;

    private Bank() {
        accounts = new ArrayList<>();
    }

    public static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }

    // Implement methods like createAccount, displayAllAccounts, updateAccount, etc.
    public void createAccount(Account account) {
        accounts.add(account);
    }
    public void displayAllAccounts() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }


}

