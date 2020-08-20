package hust.hieutm.controller;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SendEmailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String toEmail = req.getParameter("email");
        String subject = req.getParameter("subject");
        String message = req.getParameter("message");

        String myEmail = "minhhieu.tran0407@gmail.com";
        String myPassword ="020304";

        try{
            Email email = new SimpleEmail();

            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(456);
            email.setAuthentication(myEmail, myPassword);

            email.setSSLOnConnect(true);
            // Người gửi
            email.setFrom(myEmail);

            // Tiêu đề
            email.setSubject(subject);

            // Nội dung email
            email.setMsg(message);

            // Người nhận
            email.addTo(toEmail);
            email.send();
            System.out.println("Sent!!");
        } catch (EmailException exception){
            exception.printStackTrace();
        }
    }
}
