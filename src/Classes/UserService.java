/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserService {
    public User authenticate(String enteredUserID, String enteredPassword) {

        // Read the database file
        try (BufferedReader reader = new BufferedReader(new FileReader("data/UserDB.txt"))) {
            String line;
            // Skip the first row (all column names)
            reader.readLine();
            
            // Loop through every row in the text file
            while ((line = reader.readLine()) != null) {
                // Skip the row, if it's empty
                if (line.trim().isEmpty()) continue;
                
                // Else split every part and put it in an array (part)
                String[] part = line.split(",");
                
                // Check if array have exactly 7 columns
                if (part.length != 7) continue;
                
                // Set all column into variable for later use
                String userID = part[0].trim();
                String username = part[1].trim();
                String password = part[2].trim();
                String title = part[3].trim();
                String email = part[4].trim();
                String role = part[5].trim();
                String status = part[6].trim();
                
                // Check if the entered userID matches any ID in the text file
                if (userID.equals(enteredUserID)) {
                    // Send an error message
                    // If user entered a wrong password
                    if (!password.equals(enteredPassword)) {
                        return new InvalidUser("IncorrectPassword");
                    }

                    // If the user account has been deactivated
                    if (!status.equals("Active")) {
                        return new InvalidUser("Inactive");
                    }
                    
                    // Use a switch case to check what user to return based on the user's role
                    switch (role) {
                        // If it's academic officer return Officer user
                        case "Academic Officer":
                            return new Officer(userID, username, password, title, email, status);
                        // If it's course administrator return Admin user
                        case "Course Administrator":
                            return new Admin(userID, username, password, title, email, status);
                        // If the role is an unknown role, return null
                        default:
                            return null;
                    }
                }
            }

        } catch (IOException e) {
            // Print full error details
            e.printStackTrace();
        }
        // Return null if no userID in the file matches the entered userID
        return null;
    }
}
