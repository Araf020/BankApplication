package src.arafat.exceptions;

public class InvalidAmountException extends Exception {
    

    public InvalidAmountException(double amount){
        super("Amount " + amount + " is invalid");
    }
    
}