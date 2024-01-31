package src.arafat;
import java.util.*;
import java.io.*;
import src.arafat.services.Bank;;;
public class BankApplication {
    public static void main(String[] args) {

        Bank bank = Bank.getInstance();
        int choice;

        do {
            displayMenu();
            try (Scanner scanner = new Scanner(System.in)) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
            }
            switch (choice) {
                case 1:
                    // Create a new account
                    break;
                case 2:
                    // Display all accounts
                    break;
                case 3:
                    // Update an account
                    break;
                case 4:
                    // Delete an account
                    break;
                case 5:
                    // Deposit an amount into an account
                    break;
                case 6:
                    // Withdraw an amount from an account
                    break;
                case 7:
                    // Search for an account
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 8);
    }

    private static void displayMenu() {
        System.out.println("Banking Application Menu:");
        System.out.println("1. Create a new account");
        System.out.println("2. Display all accounts");
        System.out.println("3. Update an account");
        System.out.println("4. Delete an account");
        System.out.println("5. Deposit an amount into your account");
        System.out.println("6. Withdraw an amount from your account");
        System.out.println("7. Search for account");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    
    }

}
