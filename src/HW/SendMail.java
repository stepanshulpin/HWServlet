package HW;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.*;
import javax.activation.*;

public class SendMail extends HttpServlet {

    private static final String SENDER_HOST = "smtp.gmail.com";
    private static final String SENDER_PORT = "587";
    private static final String MAIL = "hwservlet@gmail.com";
    private static final String PASSWORD = "netcracker";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Recipient's email ID needs to be mentioned.
        String to = req.getParameter("e-mail");
        // Sender's email ID needs to be mentioned
        String from = MAIL;
        // Assuming you are sending email from localhost
        String host = "localhost";
        // Get system properties
        Properties properties = new Properties();
        // Setup mail server
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.host", SENDER_HOST);
        properties.setProperty("mail.smtp.port", SENDER_PORT);
        properties.setProperty("mail.smtp.user", MAIL);
        properties.setProperty("mail.smtp.password", PASSWORD);
        properties.setProperty("mail.smtp.auth", "true");
        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties,
                new Authenticator() {
                    protected PasswordAuthentication  getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                MAIL, PASSWORD);
                    }
                });
        // Set response content type
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        try{
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            // Set Subject: header field
            message.setSubject(req.getParameter("subject"));
            // Send the actual HTML message, as big as you like
            message.setText(req.getParameter("content"));
            // Send message
            Transport.send(message);
            String title = "Send Email";
            String res = "Sent message successfully....";
            String docType =
                    "<!doctype html public \"-//w3c//dtd html 4.0 " +
                            "transitional//en\">\n";
            out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + title + "</h1>\n" +
                    "<p align=\"center\">" + res + "</p>\n" +
                    "</body></html>");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}
