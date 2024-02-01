package src.arafat;
import java.util.*;
import java.io.*;

import src.arafat.UI.UI;
import src.arafat.filter.BaseFilter;
import src.arafat.services.Bank;
import src.arafat.util.AccountType;;;
public class BankApplication {
    public static void main(String[] args)  {

        Bank bank = Bank.getInstance();
        int choice;
        String inputAccountNumber;
        String accountName;
        double inputAmount;
        Scanner scanner;

        UI userInterface = new UI(new Scanner(System.in), bank);
        do {
            userInterface.displayMenu();
            scanner = new Scanner(System.in);
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            try{
            switch (choice) {
                case 1:
                     userInterface.showCreateAccountOption();

                    
                    break;
                case 2:
                    // Display all accounts
                    userInterface.displayAllAccounts();
                    break;
                case 3:
                    // Update an account
                    userInterface.updateAccount();                    
                    break;
                case 4:
                     userInterface.deleteAccount();
                    break;
                case 5:
                      userInterface.deposit();
                    break;
                case 6:
                    userInterface.withdraw();

                    break;
                case 7:
                    userInterface.search();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        catch(Exception e){
            System.out.println(">>>>>>"+e.getMessage()+"<<<<<<");
        }
        } while (choice != 8);

        scanner.close();
    }

    

    

}
