package src.arafat.services;

import src.arafat.model.Account;
import src.arafat.model.CurrentAccount;
import src.arafat.model.SalaryAccount;
import src.arafat.model.SavingsAccount;
import src.arafat.util.AccountType;

public class AccountFactory {
    public static Account createAccount(AccountType type) {
        switch (type) {
            case CURRENT:
                return new CurrentAccount().setAccountType(type);
            case SAVINGS:
                return new SavingsAccount().setAccountType(type);
            case SALARY:
                return new SalaryAccount().setAccountType(type);
            default:
                throw new IllegalArgumentException("Unsupported account type");
        }
    }

}
