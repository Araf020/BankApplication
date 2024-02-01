package src.arafat;
import java.util.*;
import java.io.*;

import src.arafat.filter.BaseFilter;
import src.arafat.services.Bank;
import src.arafat.util.AccountType;;;
public class BankApplication {
    public static void main(String[] args)  {

        Bank bank = Bank.getInstance();
        int choice;
        String inputAccountNumber;
        double inputAmount;
        Scanner scanner;
        do {
            displayMenu();
            scanner = new Scanner(System.in);
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            try{
            switch (choice) {
                case 1:
                     //taking input from user
                     // name , balance , type
                    System.out.println("Enter account name: ");
                    String accountName = scanner.nextLine();
                    System.out.println("Enter opening account balance: ");
                    double openingBalance = scanner.nextDouble();
                    System.out.println("opening balance: " + openingBalance);
                    System.out.println("Enter account type (Savings, Current, Salary): ");
                    //scan the account type
                    String accountType = scanner.next();
                    System.out.println("account type: " + accountType);
                    AccountType type = AccountType.getAccountType(accountType.toUpperCase());

                    
                    // Create an account
                    bank.createAccount(type, accountName, openingBalance);
                    
                    break;
                case 2:
                    // Display all accounts
                    bank.displayAllAccounts();
                    break;
                case 3:
                    // Update an account
                    System.out.println("Enter account number: ");
                    inputAccountNumber = scanner.next();
                    while (true) {
                        System.out.println(("Select Update Options:"));
                        System.out.println("1. Update account name");
                        System.out.println("2. Update phone number");
                        System.out.println("3. Update account type");
                        System.out.println( "4. Exit");
                        int updateChoice = scanner.nextInt();
                        if(updateChoice == 4)
                        {
                            break;
                        }
                        if(updateChoice == 1)
                        {
                            System.out.println("Enter new account name: ");
                            accountName = scanner.next();
                            bank.updateAccountName(inputAccountNumber, accountName);
                            System.out.println("Want to update more? (y/n)");
                            String more = scanner.next();
                            if(more.equals("n"))
                            {
                                break;
                            }
                        }
                        else if(updateChoice == 2)
                        {
                            System.out.println("Enter new phone number: ");
                            String phoneNumber  = scanner.next();
                            bank.updateAccountPhoneNumber(inputAccountNumber, phoneNumber);
                            System.out.println("Want to update more? (y/n)");
                            String more = scanner.next();
                            if(more.equals("n"))
                            {
                                break;
                            }
                        }

                
                    }
                    

                    break;
                case 4:
                    // Delete an account
                    System.out.println("Enter account number: ");
                    inputAccountNumber = scanner.next();
                    bank.deleteAccount(inputAccountNumber);
                    break;
                case 5:
                    // Deposit an amount into an account
                    System.out.println("Enter account number: ");
                    inputAccountNumber = scanner.next();
                    System.out.println("Enter amount to deposit: ");
                    inputAmount = scanner.nextDouble();
                    bank.deposit(inputAccountNumber, inputAmount);
                    break;
                case 6:
                    // Withdraw an amount from an account
                    System.out.println("Enter account number: ");
                    inputAccountNumber = scanner.next();
                    System.out.println("Enter amount to withdraw: ");
                    inputAmount = scanner.nextDouble();

                    bank.withdraw(inputAccountNumber, inputAmount);

                    break;
                case 7:
                    // Search for an account
                    System.out.println("Select Search Options:");
                    System.out.println("1. Search by account number");
                    System.out.println("2. Search by account name");
                    System.out.println("3. Search by phone number");
                    int searchChoice = scanner.nextInt();
                    if(searchChoice == 1){
                        System.out.println("Enter account number: ");
                        inputAccountNumber = scanner.next();
                        BaseFilter filterOptions = new BaseFilter();
                        filterOptions.searchByAccountNumber = true;
                        bank.searchAccounts(filterOptions,inputAccountNumber);
                    }
                    else if(searchChoice == 2){
                        System.out.println("Enter account name: ");
                        accountName = scanner.next();
                        BaseFilter filterOptions = new BaseFilter();
                        filterOptions.searchByAccountName = true;
                        bank.searchAccounts(filterOptions,accountName);
                    }
                    else if(searchChoice == 3){
                        System.out.println("Enter phone number: ");
                        String phoneNumber = scanner.next();
                        BaseFilter filterOptions = new BaseFilter();
                        filterOptions.searchByPhoneNumber = true;
                        bank.searchAccounts(filterOptions,phoneNumber);
                    }
                    else{
                        System.out.println("Invalid choice!");
                    }
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
