package hust.hieutm.daoImpl;

import hust.hieutm.DBUtils.MySQLUtils;
import hust.hieutm.dao.AccountDao;
import hust.hieutm.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao {
    @Override
    public Account getAcountById(int id) {
        Account account = null;
        Connection connection = MySQLUtils.getConnection();
        try {
            String sql = "select * from account where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                int accountId = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                account = new Account(accountId, username, password);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        MySQLUtils.closeConnection(connection);
        return account;
    }

    @Override
    public Account getAccountByUsername(String transUsername) {
        Account account = null;
        Connection connection = MySQLUtils.getConnection();
        try {
            String sql = "select * from account where username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, transUsername);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int accountId = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println(accountId + " " + username + " " + password);
                account = new Account(accountId, username, password);
            }
            System.out.println(account);
        } catch (SQLException e){
            e.printStackTrace();
        }
        MySQLUtils.closeConnection(connection);
        return account;
    }

    @Override
    public void createAccount(Account account) {
        Connection connection = MySQLUtils.getConnection();
        try{
            String sql = "insert into account(id, username, password) values(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, account.getId());
            ps.setString(2, account.getUsername());
            ps.setString(3, account.getPassword());
            ps.execute();
        } catch (SQLException e){
            MySQLUtils.rollback(connection);
        }
        MySQLUtils.closeConnection(connection);
    }

    @Override
    public int updateAccount(Account account) {
        int result = 0;
        Connection connection = MySQLUtils.getConnection();
        try{
            String sql = "update account set username = ?. password = ? where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.setInt(3, account.getId());
            result = ps.executeUpdate();
        } catch (SQLException e){
            MySQLUtils.rollback(connection);
        }
        MySQLUtils.closeConnection(connection);

        return result;
    }
}
