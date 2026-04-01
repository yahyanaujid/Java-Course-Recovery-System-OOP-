/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

// To read text file
import java.io.BufferedReader;
import java.io.FileReader;
// To write text file
import java.io.BufferedWriter;
import java.io.FileWriter;
// For error handling
import java.io.IOException;
// To show pop up message
import javax.swing.JOptionPane;

public class RetakeService {
    
    // Method 1: Get the data from database
    public Retake[] loadData(){
        // Track the array length
        int count = 0;
        
        // 1st time is to confirm the length of the array
        try (BufferedReader reader = new BufferedReader(new FileReader("data/RetakeDB.txt"))) {
            String line;
            // Skip the first row (all column names)
            reader.readLine();
            
            // Loop through every row in the text file
            while((line = reader.readLine()) != null){
                // Skip the row, if it's empty
                if(line.trim().isEmpty()) continue;
                
                // Else split every part and put it in an array (part)
                String[] part = line.split(",");
                
                // Check if array have exactly 7 columns
                if(part.length == 7){
                    count++;
                }
            }
        }
        catch (IOException e){
            // Show error message if the file can't be read
            JOptionPane.showMessageDialog(null, "Error reading database.", "System Error", JOptionPane.ERROR_MESSAGE);
            // Print full error details
            e.printStackTrace();
        }
        
        // Create an retake array
        Retake[] retake = new Retake[count];
        
        // 2nd time is to fill in the retake array
        try (BufferedReader reader = new BufferedReader(new FileReader("data/RetakeDB.txt"))) {
            String line;
            // Skip the first row (all column names)
            reader.readLine();
            
            // Track the current row
            int index = 0;
            
            // Loop through every row in the text file
            while((line = reader.readLine()) != null){
                // Skip the row, if it's empty
                if (line.trim().isEmpty()) continue;
                
                // Else split every part and put it in an array (part)
                String[] part = line.split(",");
                
                // Check if array have exactly 7 columns
                if (part.length != 7) continue;
                 
                // Set all column into variable for later use
                String retakeID = part[0].trim();
                String courseID = part[1].trim();
                String studentID = part[2].trim();
                String failedComponent = part[3].trim();
                int attemptLefts = Integer.parseInt(part[4].trim());
                String progressStatus = part[5].trim();
                String recoveryResult = part[6].trim();
                
                // Insert each row into the array
                retake[index++] = new Retake(retakeID, courseID, studentID, failedComponent, attemptLefts, progressStatus, recoveryResult);

            }
        }
        catch (IOException e){
            // Show error message if the file can't be read
            JOptionPane.showMessageDialog(null, "Error reading database.", "System Error", JOptionPane.ERROR_MESSAGE);
            // Print full error details
            e.printStackTrace();
        }
        // Return the array
        return retake;
    }
    
    // Method 2: Save updated retakes to database
    public void writeRetakeDB(Retake[] retake){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/RetakeDB.txt"))) {
            // Write header
            writer.write("retakeID,courseID,studentID,failedComponent,attemptLefts,progressStatus,recoveryResult");
            writer.newLine();
            
            // Loop through everything in retakes to write back into database
            for(Retake r: retake) {
                // Write each row
                writer.write(r.getRetakeID() + "," + r.getCourseID() + "," + r.getStudentID() + "," + r.getFailedComponent() + "," + r.getAttemptLefts() + "," + r.getProgressStatus() + "," + r.getRecoveryResult());
                writer.newLine();
            }
            
        }
        catch (IOException e){
            // Show error message if the file can't be read
            JOptionPane.showMessageDialog(null, "Error writing database.", "System Error", JOptionPane.ERROR_MESSAGE);
            // Print full error details
            e.printStackTrace();
        }
    }
    
    // Method 3: Get next retake ID
    public String getNextRetakeID() {
        // Load all data from database
        Retake[] retake = loadData();
        // declare and integer value
        int maxNumber = 0;

        // Loop through the retake array
        for (Retake r : retake) {
            // Get the retakeID
            String id = r.getRetakeID().trim();

            if (id.startsWith("RT")) {
                try {
                    // Remove "RT" and get the number
                    int num = Integer.parseInt(id.substring(2));

                    // Assign the number to the variable until it finish looping
                    if (num > maxNumber) {
                        maxNumber = num;
                    }
                } catch (NumberFormatException e) {
                    // Skip invalid IDs
                    continue;
                }
            }
        }

        // Set the next number
        int nextNum = maxNumber + 1;

        // return next retakeID
        return String.format("RT%03d", nextNum);
    }
    
    // Method 4: Join the take into a single String
    public void joinRetake(String studentID, String courseID, String failedComponent) {
        // Load all retake
        Retake[] retake = loadData();
        
        // Create a new array wth one element larger than the retake array
        Retake[] newRetake = new Retake[retake.length + 1];
        
        // Create the new Retake object
        Retake newRetakeObject = new Retake(
            getNextRetakeID(),
            courseID,
            studentID,
            failedComponent,
            3,
            "Haven't Started",
            "Pending"
        );

        // Loop though all the row from database
        for (int i = 0; i < retake.length; i++) {
            // Copy the old retake elements into the new array
            newRetake[i] = retake[i];
        }
        // Assign the new retake object to the last element
        newRetake[newRetake.length - 1] = newRetakeObject;
        
        // Call writeRetakeDB method to save into database
        writeRetakeDB(newRetake);
    }
}
