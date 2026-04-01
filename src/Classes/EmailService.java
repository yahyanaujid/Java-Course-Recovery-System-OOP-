/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmailService {
    private static final String FILE_NAME = "C:\\Users\\yu en\\OneDrive\\Documents\\Y2S1\\OODJ\\Assignment\\data\\EmailDB.txt";
    private List<Email> emailLogList;

    public EmailService() {
        // Initialize the list and load existing data when the service is created
        this.emailLogList = loadData();
    }

    // 1. loadData() - Loads all records from EmailDB.txt
    public List<Email> loadData() {
        List<Email> logs = new ArrayList<>();
        // Note: The first line is the header, which should be skipped.
        boolean isHeader = true; 
        
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue; // Skip the header line
                }
                
                String[] parts = line.split(",");
                // Ensure the line has exactly 3 parts before processing
                if (parts.length == 3) {
                    String emailID = parts[0].trim();
                    String recipientEmail = parts[1].trim();
                    String subject = parts[2].trim();
                    logs.add(new Email(emailID, recipientEmail, subject));
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading email data: " + e.getMessage());
        }
        return logs;
    }

    // 2. writeEmailDB() - Writes all current records back to the file
    // This is typically called after adding a new email log.
    public void writeEmailDB() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            // Write the header line first
            writer.write("emailID,receipientEmail,subject\n");
            
            // Write all email objects
            for (Email email : emailLogList) {
                // Using the overridden toString() method for CSV format
                writer.write(email.toString() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing email data: " + e.getMessage());
        }
    }

    // 3. getNextEmailID() - Generates the next sequential ID (E011, E012, etc.)
    public String getNextEmailID() {
        int maxId = 0;
        
        // Find the highest numerical part of the existing IDs
        for (Email email : emailLogList) {
            try {
                // Extracts the numerical part (e.g., '010' from 'E010')
                String idNumStr = email.getEmailID().substring(1); 
                int idNum = Integer.parseInt(idNumStr);
                if (idNum > maxId) {
                    maxId = idNum;
                }
            } catch (NumberFormatException e) {
                // Handle cases where the ID is not in the expected format
                System.err.println("Skipping non-standard ID: " + email.getEmailID());
            }
        }
        
        // Increment and format the new ID (e.g., E011)
        int nextIdNum = maxId + 1;
        // Formats the number to always have 3 digits, padding with leading zeros
        return String.format("E%03d", nextIdNum); 
    }

    // 4. joinEmail() - The key method to create and persist a new log entry
    // This method encapsulates the logging logic.
    public boolean joinEmail(String recipientEmail, String subject) {
        try {
            // Get the next unique ID
            String nextId = getNextEmailID();
            
            // Create the new Email object
            Email newLog = new Email(nextId, recipientEmail, subject);
            
            // Add the new object to the in-memory list
            this.emailLogList.add(newLog);
            
            // Persist the entire list to the file (Database)
            writeEmailDB();
            
            System.out.println("LOGGED EMAIL: " + newLog.toString());
            return true;
        } catch (Exception e) {
            System.err.println("Failed to log email: " + e.getMessage());
            return false;
        }
    }
}
