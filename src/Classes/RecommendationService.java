/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

// To read text file
import java.io.BufferedReader;
import java.io.FileReader;
// To edit text file
import java.io.BufferedWriter;
import java.io.FileWriter;
// For error handling
import java.io.IOException;
// To show pop up message
import javax.swing.JOptionPane;

public class RecommendationService {
    
    // Method 1: Get the data from database
    public Recommendation[] loadRecommendations(){
        // Track the array length
        int count = 0;
        
        // 1st time is to confirm the length of the array
        try (BufferedReader reader = new BufferedReader(new FileReader("data/RecommendationDB.txt"))) {
            String line;
            // Skip the first row (all column names)
            reader.readLine();
            
            // Loop through every row in the text file
            while((line = reader.readLine()) != null){
                if(!line.trim().isEmpty()){
                    // If the row is not empty, increase count by 1
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
        
        // Create an recommendation array
        Recommendation[] recommendation = new Recommendation[count];
        
        //2nd time is to fill in the recommendation array
        try (BufferedReader reader = new BufferedReader(new FileReader("data/RecommendationDB.txt"))) {
            String line;
            // Skip the first row (all column names)
            reader.readLine();
            
            // Keep track of current recommendation
            int index = 0;
            
            // Loop through every row in the text file
            while ((line = reader.readLine()) != null) {
                // Skip the row if it's empty
                if (line.trim().isEmpty()) continue;
                
                // Else split every part and put it in an array (part)
                String[] part = line.split(",");
                
                // Check if array have exactly 3 columns
                if(part.length != 3) continue;
                
                // Set all column into variable for later use
                String recommendationID = part[0].trim();
                String type = part[1].trim();
                String recommendationText = part[2].trim();
                
                // Insert each row into the array
                recommendation[index++] = new Recommendation(recommendationID, type, recommendationText);
            }
        }
        catch (IOException e){
            // Show error message if the file can't be read
            JOptionPane.showMessageDialog(null, "Error reading database.", "System Error", JOptionPane.ERROR_MESSAGE);
            // Print full error details
            e.printStackTrace();
        }
        // Return recommendation array
        return recommendation;
    }
    
    // Method 2: Save updated recommendations to database
    public void writeRecommendationDB(Recommendation[] list){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/RecommendationDB.txt"))){
            // Write header
            writer.write("recommendationID,type,recommendationText");
            writer.newLine();
            
            // Loop through everything in list to write back into database
            for(int i = 0; i < list.length; i++){
                Recommendation r = list[i];
                
                // Write each row
                writer.write(r.getRecommendationID() + "," + r.getType() + "," + r.getRecommendationText());
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
    
    // Method 3: Join the recommendations into a single String
    public void joinRecommendation(String type, String[] newRecommendation) {
        // Load all recommendation
        Recommendation[] recommendation = loadRecommendations();
        
        // Get the length of the new recommendation
        int count = newRecommendation.length;
        
        // Join the new recommendation into a single string
        String joinedRecommendation = "";
        for(int i = 0; i < count; i++) {
            joinedRecommendation += newRecommendation[i];
            // Add "|" at the back of each recommendation except for the last recommendation
            if (i < count - 1) {
                joinedRecommendation += "|";
            }
        }
        
        // Loop though all the row from database
        for(int j = 0; j < recommendation.length; j++) {
            // Check which row metches the type that is passed in
            if(recommendation[j].getType().equals(type)) {
                // Set the updated, joined recommendation into the row that matches the type
                recommendation[j].setRecommendationText(joinedRecommendation);
            }
        }
        // Call writeRecommendationDB method to save into database
        writeRecommendationDB(recommendation);
    }
}
