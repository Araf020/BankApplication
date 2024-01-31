package src.arafat.util;

public class AccNoGenerator {
    
    private static String lastGeneratedAccountNumber = "0100000000"; // Initial account number

    public static synchronized String generateAccountNumber() {
        // Increment the last generated account number
        int lastNumber = Integer.parseInt(lastGeneratedAccountNumber.substring(6)); 
        lastNumber++;
        String newAccountNumber = String.format("010000%04d", lastNumber); // Format the new account number
        
        // Update the last generated account number
        lastGeneratedAccountNumber = newAccountNumber;
        
        return newAccountNumber;
    }
}
