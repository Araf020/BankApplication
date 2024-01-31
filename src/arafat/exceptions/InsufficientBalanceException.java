package src.arafat.exceptions;

public class InsufficientBalanceException extends Exception {
    

    public InsufficientBalanceException(double balance, double amount) {
        super("Insufficient Balance " + balance + " for amount " + amount);
    }
    
}