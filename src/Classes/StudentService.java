/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

// To read text file
import java.io.BufferedReader;
import java.io.FileReader;
// For error handling
import java.io.IOException;
// To show pop up message
import javax.swing.JOptionPane;

public class StudentService {
    // Method 1: Get the data from database
    public Student[] loadData(){
        // Track the array length
        int count = 0;
        
        // 1st time is to confirm the length of the array
        try (BufferedReader reader = new BufferedReader(new FileReader("data/StudentDB.txt"))) {
            String line;
            // Skip the first row (all column names)
            reader.readLine();
            
            // Loop through every row in the text file
            while((line = reader.readLine()) != null){
                // Skip the row, if it's empty
                if(line.trim().isEmpty()) continue;
                
                // Else split every part and put it in an array (part)
                String[] part = line.split(",");
                
                // Check if array have exactly 6 columns
                if(part.length == 6){
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
        
        // Create an student array
        Student[] student = new Student[count];
        
        // 2nd time is to fill in the student array
        try (BufferedReader reader = new BufferedReader(new FileReader("data/StudentDB.txt"))) {
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
                
                // Check if array have exactly 6 columns
                if (part.length != 6) continue;
                 
                // Set all column into variable for later use
                String studentID = part[0].trim();
                String firstName = part[1].trim();
                String lastName = part[2].trim();
                String major = part[3].trim();
                String year = part[4].trim();
                String email = part[5].trim();
                
                // Insert each row into the array
                student[index++] = new Student(studentID, firstName, lastName, major, year, email);

            }
        }
        catch (IOException e){
            // Show error message if the file can't be read
            JOptionPane.showMessageDialog(null, "Error reading database.", "System Error", JOptionPane.ERROR_MESSAGE);
            // Print full error details
            e.printStackTrace();
        }
        // Return the array
        return student;
    }
    
    //Method 2
    public Student getStudentByID(String studentID) {
    //Obtain student list
    Student[] students = loadData();
    //For each student in the array, find which studentID matches
    for (Student s : students) {
        if (s.getStudentID().equals(studentID)) {
            return s;
        }
    }
    return null;
    }
}
