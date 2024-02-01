package src.arafat.filter;

import src.arafat.model.Account;

public class BaseFilter {
    
    public boolean searchByAccountNumber;
    public boolean searchByAccountName;
    public boolean searchByAccountType;
    public boolean searchByBalance;
    public boolean searchByOpeningDate;
    public boolean searchByPhoneNumber;

    public BaseFilter() {
        searchByAccountNumber = false;
        searchByAccountName = false;
        searchByAccountType = false;
        searchByBalance = false;
        searchByOpeningDate = false;
        searchByPhoneNumber = false;
    }

    public boolean filter(Account acc, String searchKey)
    {
        if(searchByAccountNumber && acc.getAccountNumber().equals(searchKey))
        {
            return true;
        }
        if(searchByAccountName && acc.getUser().getFirstName().toLowerCase().equals(searchKey.toLowerCase()))
        {
            return true;
        }
        if(searchByPhoneNumber && acc.getUser().getPhoneNumber().equals(searchKey))
        {
            return true;
        }
        return false;
    }

}
