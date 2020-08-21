package hust.hieutm.dao;

import hust.hieutm.model.Account;

public interface AccountDao {
    public Account getAcountById(int id);

    public Account getAccountByUsername(String username);

    public void createAccount(Account account);

    public int updateAccount(Account account);
}
