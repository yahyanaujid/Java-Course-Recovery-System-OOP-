/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

public class Email {
    private String emailID;
    private String recipientEmail;
    private String subject;

    // Constructor to create a new Email object
    public Email(String emailID, String recipientEmail, String subject) {
        this.emailID = emailID;
        this.recipientEmail = recipientEmail;
        this.subject = subject;
    }

    // --- Getters ---
    public String getEmailID() {
        return emailID;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public String getSubject() {
        return subject;
    }

    // --- Setters (If needed for future modifications, otherwise optional) ---
    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    // Override toString for easy logging/debugging
    @Override
    public String toString() {
        return String.format("%s,%s,%s", emailID, recipientEmail, subject);
    }
}