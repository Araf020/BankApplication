package src.arafat.exceptions;

public class InsufficientAmountException extends Exception {
    

    public InsufficientAmountException(double amount){
        super("Amount" + amount + "is negative");
    }
    
}