package src.arafat.model;

import java.time.LocalDateTime;

public class SavingsAccount extends Account{
    
    @Override
    public void deposit(double amount) {

        setLastUpdateDate(LocalDateTime.now());
    }

    @Override
    public void withdraw(double amount) {
        setLastUpdateDate(LocalDateTime.now());
    }

    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public String toString() {
        return "Account{" + "accountNumber=" + getAccountNumber() + "accountType= Savings"  + ", accountName=" + getUser().getFirstName() + ", balance=" + getBalance() +", openingDate=" + getOpeningDate().toString() + ", lastUpdateDate=" + getLastUpdateDate().toString() + '}';
    }
}
