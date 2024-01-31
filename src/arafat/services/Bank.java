package src.arafat.services;

import java.util.*;

import src.arafat.model.Account;
import src.arafat.util.AccountType;

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
    public Account createAccount(AccountType type, String accountName, double balance) {
        Account account = AccountFactory
                        .createAccount(type)
                        .setAccountName(accountName)
                        .setBalance(balance);
                        
        accounts.add(account);
        return account;
    }
    
    public void displayAllAccounts() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }


}

