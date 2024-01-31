package src.arafat.model;

import java.time.LocalDateTime;
import src.arafat.util.AccNoGenerator;

public abstract class Account {

    //define attributes
    private String accountNumber;
    private String accountName;
    private double balance;
    private double openingBalanceLimit;
    private double minimumBalanceToMaintain;
    private double monthlyTransactionLimit;
    private double dailyTransactionLimit;
    private double transactionFee;
    private double interestRate;
    private String phoneNumber;
    
    
    private LocalDateTime openingDate; 
    private LocalDateTime lastUpdateDate;

    public Account() {
        openingBalanceLimit=0;
        minimumBalanceToMaintain=0;
        monthlyTransactionLimit=100000;
        dailyTransactionLimit=50000;
        transactionFee=0;
        interestRate=7.0;
        balance=0;
        accountNumber = AccNoGenerator.generateAccountNumber();
        openingDate = LocalDateTime.now();

    }

    //define abstract methods
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract double getBalance();


    public Account setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }


    public Account setAccountName(String accountName) {
        this.accountName = accountName;
        this.lastUpdateDate = LocalDateTime.now();
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

    public Account setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public double getOpeningBalanceLimit() {
        return openingBalanceLimit;
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
    public String getAccountName() {
        return accountName;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    // @Override
    // public String toString() {
    //     return "Account{" + "accountNumber=" + accountNumber + ", accountName=" + accountName + ", balance=" + balance +", openingDate=" + openingDate.toString() + ", lastUpdateDate=" + lastUpdateDate.toString() + '}';
    // }

    

} 
