package src.arafat.UI;

import java.util.Scanner;

import src.arafat.filter.BaseFilter;
import src.arafat.model.Account;
import src.arafat.services.Bank;
import src.arafat.util.AccountType;
import src.arafat.util.ValidityCheck;

public class UI {
 
    private Scanner scanner;
    private Bank bank;
    public UI(Scanner scanner, Bank bank) {
        this.scanner = scanner;
        this.bank = bank;

    }

    public void showCreateAccountOption()
    {
        //taking input from user
        // name , balance , type
        System.out.println("Enter account name: ");
        String accountName = scanner.nextLine();
        if(!ValidityCheck.isNameValid(accountName))
        {
            System.out.println("Invalid name!");
            return;
        }
        System.out.println("Enter opening account balance: ");
        double openingBalance = scanner.nextDouble();
        if(openingBalance <500)
        {
            System.out.println("Opening balance must be greater than 500!");
            return;
        }
        System.out.println("opening balance: " + openingBalance);
        System.out.println("Enter account type:");
        System.out.println("1. Current");
        System.out.println("2. Savings");
        System.out.println("3. Salary");
        int accountTypeChoice = scanner.nextInt();
        AccountType type ;
        if(accountTypeChoice == 1)
        {
            type = AccountType.CURRENT;
        }
        else if(accountTypeChoice == 2)
        {
            type = AccountType.SAVINGS;
        }
        else if(accountTypeChoice == 3)
        {
            type = AccountType.SALARY;
        }
        else
        {
            System.out.println("Invalid choice!");
            return;
        }

        
        
        createAccount(type, accountName, openingBalance);
    }

    public void updateAccount() throws Exception
    {
        System.out.println("Enter account number: ");
        String inputAccountNumber = scanner.next();
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
                String accountName = scanner.next();
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
    }

    public void deleteAccount() throws Exception
    {
        // Delete an account
        System.out.println("Enter account number: ");
        String inputAccountNumber = scanner.next();
        bank.deleteAccount(inputAccountNumber);
    }

    public void deposit() throws Exception
    {
         // Deposit an amount into an account
         System.out.println("Enter account number: ");
         String inputAccountNumber = scanner.next();
         System.out.println("Enter amount to deposit: ");
         double inputAmount = scanner.nextDouble();
         bank.deposit(inputAccountNumber, inputAmount);
    }


    private Account createAccount(AccountType type, String accountName, double openingBalance)
    {
        return bank.createAccount(type, accountName, openingBalance);
    }

    public void displayAllAccounts()
    {
        bank.displayAllAccounts();
    }
    

    public void withdraw() throws Exception
    {
        // Withdraw an amount from an account
        System.out.println("Enter account number: ");
        String inputAccountNumber = scanner.next();
        System.out.println("Enter amount to withdraw: ");
        double inputAmount = scanner.nextDouble();
        bank.withdraw(inputAccountNumber, inputAmount);
    }

    public void search() throws Exception
    {
        // Search for an account
        System.out.println("Select Search Options:");
        System.out.println("1. Search by account number");
        System.out.println("2. Search by account name");
        System.out.println("3. Search by phone number");
        int searchChoice = scanner.nextInt();
        if(searchChoice == 1){
            System.out.println("Enter account number: ");
            String inputAccountNumber = scanner.next();
            BaseFilter filterOptions = new BaseFilter();
            filterOptions.searchByAccountNumber = true;
            bank.searchAccounts(filterOptions,inputAccountNumber);
        }
        else if(searchChoice == 2){
            System.out.println("Enter account name: ");
            String accountName = scanner.next();
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
        
    }


    public void displayMenu() {
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
