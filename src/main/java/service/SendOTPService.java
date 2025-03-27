package service;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class SendOTPService {
    public static void sendOTP(String email, String genOTP) {
        // Recipient's email ID
        String to = email;

        // Sender's email ID
        String from = "platinum9731@gmail.com";

        // SMTP server for Gmail
        String host = "smtp.gmail.com";

        // Set SMTP properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Authenticate with email and app password
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "fobxpcoeaqumziua"); // Use App Password, not Gmail password
            }
        });

        session.setDebug(true); // Enable debug for troubleshooting

        try {
            // Create a MimeMessage object
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("File Enc OTP");

            // Message body
            message.setText("Your One Time Password for File Enc app is: " + genOTP);

            System.out.println("Sending...");
            Transport.send(message);
            System.out.println("Sent message successfully!");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
