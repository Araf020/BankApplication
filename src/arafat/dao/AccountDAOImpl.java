package src.arafat.dao;

import java.util.List;

import src.arafat.model.Account;

public class AccountDAOImpl extends AbstractDAO<Account> implements IAccountDAO {

    public AccountDAOImpl() {
        super();
    }
    
    @Override
    public Account add(Account t) {
        storage.add(t);
        return t;
    }

    @Override
    public boolean delete(String id) {
        for (Account account : storage) {
            if (account.getAccountNumber().equals(id)) {
                return storage.remove(account);
            }
        }
        return false;
        
    }



    @Override
    public List<Account> getAll() {
        
        return storage;
    }

    @Override
    public Account delete(Long id, Account t) {
        return null;
    }

    @Override
    public Account getById(String id, Account t) {
        return null;
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    

}
