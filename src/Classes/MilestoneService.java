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

public class MilestoneService {
    
    // Method 1: Get the data from database
    public Milestone[] loadMilestone(){
        // Track the array length
        int count = 0;
        
        // 1st time is to confirm the length of the array
        try (BufferedReader reader = new BufferedReader(new FileReader("data/MilestoneDB.txt"))) {
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
        
        // Create an milestone array
        Milestone[] milestone = new Milestone[count];
        
        //2nd time is to fill in the milestone array
        try (BufferedReader reader = new BufferedReader(new FileReader("data/MilestoneDB.txt"))) {
            String line;
            // Skip the first row (all column names)
            reader.readLine();
            
            // Keep track of the current milestone
            int index = 0;
            
            // Loop through every row in the text file
            while ((line = reader.readLine()) != null) {
                // Skip row if it's empty
                if (line.trim().isEmpty()) continue;
                
                // Else split every part and put it in an array (part)
                String[] part = line.split(",");
                
                // Check if array have exactly 4 columns
                if(part.length != 4) continue;
                
                // Set all column into variable for later use
                String milestoneID = part[0].trim();
                String type = part[1].trim();
                String week = part[2].trim();
                String task = part[3].trim();
                
                // Insert each row into the array
                milestone[index++] = new Milestone(milestoneID, type, week, task);
            }
        }
        catch (IOException e){
            // Show error message if the file can't be read
            JOptionPane.showMessageDialog(null, "Error reading database.", "System Error", JOptionPane.ERROR_MESSAGE);
            // Print full error details
            e.printStackTrace();
        }
        // Return milestone array
        return milestone;
    }
    
    // Method 2: Get the next week number
    public int getNextWeekNumber(String type) {
        // Load all milestone
        Milestone[] milestone = loadMilestone();
        // Create an array to store the weeks
        String[] weeks = new String[0];
        
        // Loop though all the row from database
        for(int i = 0; i < milestone.length; i++) {
            // Check which row matches the type that is passed in
            if(milestone[i].getType().equals(type)) {
                // Get each week and save it in weeks array
                weeks = milestone[i].getWeeks();
                
                // Return the length of the weeks array + 1
                return weeks.length + 1;
            }
        }
        // Return 0, if can't load the milestone from database
        return 0;
    }
    
    // Method 3: Save updated milestone to database
    public void writeMilestoneDB(Milestone[] milestone){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/MilestoneDB.txt"))) {
            // Write header
            writer.write("milestoneID,week,task,type");
            writer.newLine();
            
            // Loop through everything in milestone to write back into database
            for(Milestone m: milestone) {
                // Write each row
                writer.write(m.getMilestoneID() + "," + m.getType() + "," + m.getWeek() + "," + m.getTask());
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
    
    // Method 4: Join the milestones into a single String
    public void joinMilestone(String type, String[] newWeeks, String[] newTasks){
        // Load all milestone
        Milestone[] milestone = loadMilestone();
        
        // Join the new weeks into a single string
        String joinedWeeks = "";
        for(int i = 0; i < newWeeks.length; i++) {
            joinedWeeks += newWeeks[i];
            if(i < newWeeks.length - 1) {
                // Add "|" at the back of each week except for the last week
                joinedWeeks += "|";
            }
        }
        
        // Join the new tasks into a single string
        String joinedTasks = "";
        for(int j = 0; j < newTasks.length; j++) {
            joinedTasks += newTasks[j];
            if(j < newTasks.length - 1) {
                // Add "|" at the back of each task except for the last task
                joinedTasks += "|";
            }
        }
        
        // Loop though all the row from database
        for(int k = 0; k < milestone.length; k++) {
            // Check which row metches the type that is passed in
            if(milestone[k].getType().equals(type)) {
                // Set the updated, joined week into the row that matches the type
                milestone[k].setWeek(joinedWeeks);
                // Set the updated, joined task into the row that matches the type
                milestone[k].setTask(joinedTasks);
            }
        }
        // Call writeMilestoneDB method to save into database
        writeMilestoneDB(milestone);
    }
}
