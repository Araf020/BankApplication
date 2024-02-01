package src.arafat.model;

import java.time.LocalDateTime;

import src.arafat.exceptions.InvalidAmountException;
import src.arafat.exceptions.InsufficientBalanceException;
import src.arafat.util.AccNoGenerator;
import src.arafat.util.AccountType;

public abstract class Account {

    //define attributes
    private String accountNumber;
    private User user;
    private double balance;
    private double openingBalanceLimit;
    private double minimumBalanceToMaintain;
    private double monthlyTransactionLimit;
    private double dailyTransactionLimit;
    private double transactionFee;
    private double interestRate;
    private AccountType accountType;
    
    
    private LocalDateTime openingDate; 
    private LocalDateTime lastUpdateDate;

    public Account() {
        openingBalanceLimit=0;
        minimumBalanceToMaintain=500;
        monthlyTransactionLimit=100000;
        dailyTransactionLimit=50000;
        transactionFee=0;
        interestRate=7.0;
        balance=0;
        accountNumber = AccNoGenerator.generateAccountNumber();
        openingDate = LocalDateTime.now();

    }

    //define abstract methods
    public abstract void deposit(double amount) throws InvalidAmountException ;
    public abstract void withdraw(double amount) throws InsufficientBalanceException, InvalidAmountException;
    


    public Account setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }


    public Account setUser(User user) {
        this.user = user;
        return this;
    }

    public Account setBalance(double balance) {
        this.balance = balance;
        this.lastUpdateDate = LocalDateTime.now();
        return this;
    }

   

    public Account setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
        return this;
    }


    public Account setOpeningBalanceLimit(double openingBalanceLimit) {
        this.openingBalanceLimit = openingBalanceLimit;
        return this;
    }

    public Account setMinimumBalanceToMaintain(double minimumBalanceToMaintain) {
        this.minimumBalanceToMaintain = minimumBalanceToMaintain;
        return this;
    }

    public Account setMonthlyTransactionLimit(double monthlyTransactionLimit) {
        this.monthlyTransactionLimit = monthlyTransactionLimit;
        return this;
    }

    public Account setDailyTransactionLimit(double dailyTransactionLimit) {
        this.dailyTransactionLimit = dailyTransactionLimit;
        return this;
    }

    public Account setTransactionFee(double transactionFee) {
        this.transactionFee = transactionFee;
        return this;
    }

    public Account setInterestRate(double interestRate) {
        this.interestRate = interestRate;
        return this;
    }

   


    public double getOpeningBalanceLimit() {
        return openingBalanceLimit;
    }
    public  double getBalance() {
        return balance;
    }

    public double getMinimumBalanceToMaintain() {
        return minimumBalanceToMaintain;
    }

    public double getMonthlyTransactionLimit() {
        return monthlyTransactionLimit;
    }

    public double getDailyTransactionLimit() {
        return dailyTransactionLimit;
    }

    public double getTransactionFee() {
        return transactionFee;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public User getUser() {
        return user;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public AccountType getAccountType() {
        return accountType;
    }
    public Account setAccountType(AccountType accountType) {
        this.accountType = accountType;
        return this;
    }

    @Override
    public String toString() {
        return "Account Details: " + "\n\tAccount Number = " + getAccountNumber() + "\n\tAccountType = "+accountType + ",\n\tAccountName = " + user.getFirstName() + " " +user.getLastName() + ",\n\tBalance = " + getBalance() +",\n\tOpeningDate = " + getOpeningDate().toString() + ",\n\tLastUpdateDate = " + getLastUpdateDate().toString()+"\n\tContact Number = "+ user.getPhoneNumber() ;
    }

    

} 
