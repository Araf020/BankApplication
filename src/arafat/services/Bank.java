package src.arafat.services;

import java.util.*;

import src.arafat.exceptions.InsufficientBalanceException;
import src.arafat.exceptions.InvalidAmountException;
import src.arafat.filter.BaseFilter;
import src.arafat.model.Account;
import src.arafat.model.User;
import src.arafat.util.AccountType;
import src.arafat.util.ValidityCheck;

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
        if(accounts.isEmpty()){
            System.out.println(">>>>>>> no accounts found! <<<<<<<<");
            return;
        }
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


    public void searchAccounts(BaseFilter filter, String searchKey) {
        List<Account> result = new ArrayList<>();
        for (Account account : accounts) {
            if (filter.filter(account, searchKey)) {
                result.add(account);
            }
        }
        if(result.isEmpty()){
            System.out.println(">>>>>>> no match found! <<<<<<<<");
            return;
        }
        System.out.println("Search Results: ");
        for (Account account : result) {
            System.out.println(account);
        }
        // return result;
    }

    public void updateAccountName(String accountNumber, String newName) throws Exception {

        if(!ValidityCheck.isNameValid(newName))
            throw new Exception(">>>>>>Invalid Name!<<<<<<");
        Account account = getAccount(accountNumber);
        if (account != null) {
            account.getUser().setFirstName(newName);
            System.out.println("Name updated successfully!");
        }
        else {
            throw new Exception("Account not found!");
        }
    }

    public void updateAccountPhoneNumber(String accountNumber, String newPhoneNumber) throws Exception {

        if(!ValidityCheck.isPhoneValid(newPhoneNumber))
            throw new Exception(">>>>>>Invalid Phone Number!<<<<<<");

        Account account = getAccount(accountNumber);
        if (account != null) {
            account.getUser().setPhoneNumber(newPhoneNumber);   
            System.out.println("Phone number updated successfully!");
            
        }
        else {
            throw new Exception("Account not found!");
        }
    }

    public boolean deleteAccount(String accountNumber) throws Exception{
        Account account = getAccount(accountNumber);
        if (account != null) {
           boolean isSuccess =  accounts.remove(account);
            if(isSuccess){
                System.out.println("Account deleted successfully!");
                return true;
            }
            throw new Exception(">>>>>>Something went wrong!<<<<<<");
        }
        throw new Exception(">>>>>>Account to be deleted not found!<<<<<<");
        
    }
    


}

