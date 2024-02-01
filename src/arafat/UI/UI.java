package src.arafat.UI;

import java.util.Scanner;

import src.arafat.model.Account;
import src.arafat.services.Bank;
import src.arafat.util.AccountType;

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
        System.out.println("Enter opening account balance: ");
        double openingBalance = scanner.nextDouble();
        System.out.println("opening balance: " + openingBalance);
        System.out.println("Enter account type (Savings, Current, Salary): ");
        //scan the account type
        String accountType = scanner.next();
        System.out.println("account type: " + accountType);
        AccountType type = AccountType.getAccountType(accountType.toUpperCase());
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


    private Account createAccount(AccountType type, String accountName, double openingBalance)
    {
        return bank.createAccount(type, accountName, openingBalance);
    }

    public void displayAllAccounts()
    {
        bank.displayAllAccounts();
    }

}
