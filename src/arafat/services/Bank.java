package src.arafat.services;

import java.util.*;

import src.arafat.exceptions.InsufficientBalanceException;
import src.arafat.exceptions.InvalidAmountException;
import src.arafat.model.Account;
import src.arafat.model.User;
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
                        .setUser(
                                    new User().setFirstName(accountName)
                                )
                        .setBalance(balance);

        accounts.add(account);
        return account;
    }
    
    public void displayAllAccounts() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    public void deposit(String accountNumber, double amount) throws InvalidAmountException, Exception {
        Account account = getAccount(accountNumber);
        
        if (account != null) {
            account.deposit(amount);
        }
        else {
            throw new Exception("Account not found!");
        }
    }

   

    public void withdraw(String accountNumber, double amount) throws InvalidAmountException, InsufficientBalanceException, Exception{
        Account account = getAccount(accountNumber);
        
        if (account != null) {
            account.withdraw(amount);
        }
        else {
            throw new Exception("Account not found!");
        }
    }

    private Account getAccount(String accountNumber) {
        for (Account account : accounts) {
            
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }


}

