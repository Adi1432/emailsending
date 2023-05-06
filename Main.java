package org.example;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        try {
            sendMailWithoutAttachment("adilapi123@gmail.com","318129212054@gvpcdpgc.edu.in","Congratulation Srikanth you have won 1lakh rs");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }



    public static void sendMailWithoutAttachment(String from , String to, String body) throws MessagingException {

        // we need host, port, ssl , auth params;
        Properties properties = System.getProperties();

        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        //creating session to connect with email server

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("adilapi123@gmail.com","hhkitcbrkwebipvn");
            }
        });

        //composing the mail

        MimeMessage message = new MimeMessage(session);

        message.setFrom(from);
        message.addRecipients(Message.RecipientType.TO,to);
        message.setSubject("Email sending using java");
        message.setText(body);

        // sending the mail

        Transport.send(message);

        System.out.println("email sent successfully");





    }
}