/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Email_Notification;

import java.util.Properties;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class JavaMailUtil {
   // Method 1: Send email
   public static void sendMail(String recipient, String subject, String textMessage) {
       // Create a Properties object to store mail server settings
       Properties properties = new Properties();
       
       // Turn on authentication (username + password)
       properties.put("mail.smtp.auth", "true");
       // Enable STARTTLS (encryption)
       properties.put("mail.smtp.starttls.enable", "true");
       // Set the SMTP server host (Gmail)
       properties.put("mail.smtp.host", "smtp.gmail.com");
       // Set the SMTP server port (TLS uses 587)
       properties.put("mail.smtp.port", "587");
       
       // Set sender email
       String senderEmail = "java.apu@gmail.com";
       // App password for the email account
       String password = "sfws ybjj ltmk fedm";
       
       // Create a mail session with authentication
       Session session = Session.getInstance(properties, new Authenticator(){
           protected PasswordAuthentication getPasswordAuthentication() {
               // Return the email and password to log in to the SMTP server
               return new PasswordAuthentication(senderEmail, password);
           }
       });
       
       // Prepare the email message
       Message message = prepareMessage(session, senderEmail, recipient, subject, textMessage);
       
       try {
           // Send the email
            Transport.send(message);
        } 
       catch (Exception e) {
           // Print full error details
            e.printStackTrace();
        }
   }
   
   // Method 2: Prepare email
   private static Message prepareMessage(Session session, String senderEmail, String recipient, String subject, String textMessage) {
       try {
           // Create a new email message
           Message message = new MimeMessage(session);
           
           // Set who will send the email
           message.setFrom(new InternetAddress(senderEmail));
           // Set who will be the one receiving
           message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
           // Set the header of the email
           message.setSubject(subject);
           // Set the body of the email
           message.setText(textMessage);
           
           // Return the message
           return message;
       } 
       catch (Exception ex) {
           // Log any error that happens while creating the message
           System.getLogger(JavaMailUtil.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
       }
       // Return null if something went wrong
       return null;
   }
   
   // Method 3: Send email with attachment
   public static void sendMailWithAttachment(String recipient, String subject, String textMessage, String filePath) {
       // Create a Properties object to store mail server settings
       Properties properties = new Properties();
       
       // Turn on authentication (username + password)
       properties.put("mail.smtp.auth", "true");
       // Enable STARTTLS (encryption)
       properties.put("mail.smtp.starttls.enable", "true");
       // Set the SMTP server host (Gmail)
       properties.put("mail.smtp.host", "smtp.gmail.com");
       // Set the SMTP server port (TLS uses 587)
       properties.put("mail.smtp.port", "587");
       
       // Set sender email
       String senderEmail = "java.apu@gmail.com";
       // App password for the email account
       String password = "sfws ybjj ltmk fedm";
       
       // Create a mail session with authentication
       Session session = Session.getInstance(properties, new Authenticator(){
           protected PasswordAuthentication getPasswordAuthentication() {
               // Return the email and password to log in to the SMTP server
               return new PasswordAuthentication(senderEmail, password);
           }
       });
       
       // Prepare the email message
       Message message = prepareMessageWithAttachment(session, senderEmail, recipient, subject, textMessage, filePath);
       
       try {
           // Send the email
            Transport.send(message);
        } 
       catch (Exception e) {
           // Print full error details
            e.printStackTrace();
        }
   }
   
   // Method 4: Prepare email with attachement
   private static Message prepareMessageWithAttachment(Session session, String senderEmail, String recipient, String subject, String textMessage, String filePath) {
       try {
           // Create a new email message
           Message message = new MimeMessage(session);
           
           // Set who will send the email
           message.setFrom(new InternetAddress(senderEmail));
           // Set who will be the one receiving
           message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
           // Set the header of the email
           message.setSubject(subject);
           
           // Create multiple parts message
           Multipart multipart = new MimeMultipart();
           
           // Part 1: Email's text message
           MimeBodyPart textPart = new MimeBodyPart();
           // Set the body of the email
           textPart.setText(textMessage);
           multipart.addBodyPart(textPart);
           
           // Part 2: PDF Attachment
           MimeBodyPart attachmentPart = new MimeBodyPart();
           attachmentPart.attachFile(filePath);
           multipart.addBodyPart(attachmentPart);
           
           // Include all parts to the message
            message.setContent(multipart);
           
           // Return the message
           return message;
       } 
       catch (Exception ex) {
           // Log any error that happens while creating the message
           System.getLogger(JavaMailUtil.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
       }
       // Return null if something went wrong
       return null;
   }
}
