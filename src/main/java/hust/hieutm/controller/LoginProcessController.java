package hust.hieutm.controller;

import hust.hieutm.dao.AccountDao;
import hust.hieutm.daoImpl.AccountDaoImpl;
import hust.hieutm.model.Account;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginProcessController extends HttpServlet {

    AccountDao accountDao = new AccountDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("pass");

        Account account = accountDao.getAccountByUsername(username);
        if (account != null && password.equals(account.getPassword())){
            Cookie cookie1 = new Cookie("username", username);
            cookie1.setMaxAge(604800);
            Cookie cookie2 = new Cookie("password", password);
            cookie2.setMaxAge(604800);

            resp.addCookie(cookie1);
            resp.addCookie(cookie2);

            resp.sendRedirect(req.getContextPath());
        }
    }
}
