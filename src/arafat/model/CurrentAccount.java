package src.arafat.model;

import src.arafat.exceptions.InsufficientBalanceException;
import src.arafat.exceptions.InvalidAmountException;

public class CurrentAccount extends Account {
    
    @Override
    public void deposit(double amount) throws InvalidAmountException {
        try {
            if(amount <= 0){
                throw new InvalidAmountException(amount);
            }

            setBalance(amount + getBalance());
        } catch (InvalidAmountException e) {
            System.err.println("Error: Negative or Zero Amount");
            throw e;
        }
    }

    

    @Override
    public void withdraw(double amount)
            throws InsufficientBalanceException, InvalidAmountException {
        try {
            if(amount <= 0) throw new InvalidAmountException(amount);
            // check if withdrawal amount is greater than balance - minimum balance
            if(amount > getBalance()-getMinimumBalanceToMaintain()) throw new InsufficientBalanceException(getBalance(), amount);
            setBalance(getBalance()-amount);

        } catch (InvalidAmountException | InsufficientBalanceException  e){
            // Would be better to have more catch statements and have exception specific err messages
            System.err.println(">>>>Error: Withdrawal<<<<");
            throw e;
        }
    }

   


    @Override
    public String toString() {
        return "Account Details:" + "\n\tAccount Number = " + getAccountNumber() + "\n\tAccountType = Current"  + ",\n\tAccountName=" + getUser().getFirstName() + ",\n\tBalance = " + getBalance() +",\n\tOpeningDate=" + getOpeningDate().toString() + ",\n\tLastUpdateDate=" + getLastUpdateDate().toString() ;
    }
    




}
