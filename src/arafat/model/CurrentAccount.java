package src.arafat.model;

public class CurrentAccount extends Account {
    
    @Override
    public void deposit(double amount) {
    }

    @Override
    public void withdraw(double amount) {
    }

    @Override
    public double getBalance() {
        return 0;
    }


    @Override
    public String toString() {
        return "Account{" + "accountNumber=" + getAccountNumber() + "accountType= Current"  + ", accountName=" + getUser().getFirstName() + ", balance=" + getBalance() +", openingDate=" + getOpeningDate().toString() + ", lastUpdateDate=" + getLastUpdateDate().toString() + '}';
    }
    




}
