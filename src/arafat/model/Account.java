package src.arafat.model;

public abstract class Account {

    //define attributes
    public String accountNumber;
    public String accountName;
    public double balance;

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
        return this;
    }
    public Account setBalance(double balance) {
        this.balance = balance;
        return this;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public String getAccountName() {
        return accountName;
    }
    

} 
