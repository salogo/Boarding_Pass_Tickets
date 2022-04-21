// we can use this class to send the Receipt to the customer by email
// your chrome broser must be Less secure app access in order to test it:
// 1- on the google search type: google Security -> click: Security - Google Account ->
// scroll down to -> Less secure app access turn it on
// You must do the same on the receiver chrome too for testing purpose
//NOTE: do not forget to turn it back off to get more secure

// for some reason it not working yet, probably it get blocked by my mac device or Java version unmatched with JavaMail Api
// or activation.jar version
package main.java.com.boardingpass.utils;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class UserFriendlyReceipt {

    public static void main(String[] args) {
        // this is for testing purpose but in the real world it must be in .env file for security concern
        String to = "zakariasalgo@gmail.com";
        // this is for testing purpose but in the real world it must be in .env file for security concern
        String from = "jhonk9703@gmail.com";
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);

        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("jhonk9703@gmail.com", "mongodb09");
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("This is test Subject Line!");
            message.setText("This is test mail");// we will inject the body of the Receipt here instead of String text
            Transport.send(message);
            System.out.println("Sent message successfully...");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }


    }
}











