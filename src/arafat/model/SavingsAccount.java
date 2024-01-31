package src.arafat.model;

import java.time.LocalDateTime;

import src.arafat.exceptions.InsufficientAmountException;
import src.arafat.exceptions.InsufficientBalanceException;

public class SavingsAccount extends Account{
    
   

    @Override
    public double getBalance() {
        return 0;
    }
    @Override
    public void deposit(double amount) throws InsufficientAmountException {
        try {
            if(amount <= 0){
                throw new InsufficientAmountException(amount);
            }

            setBalance(amount + getBalance());
        } catch (InsufficientAmountException e) {
            System.err.println("Error: Negative or Zero Amount");
            throw e;
        }
    }

    /**
     * Withdraws a given amount from the bank account if the holder's social security number (SSN)
     * matches the one given and the balance is sufficient.
     *
     * @param amount the amount to be withdrawn
     * @throws InsufficientBalanceException if the amount is greater than the current balance
     * @throws InsufficientAmountException if the amount is zero or negative
     */

    @Override
    public void withdraw(double amount)
            throws InsufficientBalanceException, InsufficientAmountException {
        try {
            if(amount <= 0) throw new InsufficientAmountException(amount);
            if(amount > getBalance()) throw new InsufficientBalanceException(getBalance(), amount);
            setBalance(amount - getBalance());

        } catch (InsufficientAmountException | InsufficientBalanceException  e){
            // Would be better to have more catch statements and have exception specific err messages
            System.err.println("Error: Withdrawal");
            throw e;
        }
    }

    @Override
    public String toString() {
        return "Account{" + "accountNumber=" + getAccountNumber() + "accountType= Savings"  + ", accountName=" + getUser().getFirstName() + ", balance=" + getBalance() +", openingDate=" + getOpeningDate().toString() + ", lastUpdateDate=" + getLastUpdateDate().toString() + '}';
    }
}
