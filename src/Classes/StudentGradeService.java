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

public class StudentGradeService {
    // Method 1: Get the data from database
    public StudentGrade[] loadData(){
        // Track the array length
        int count = 0;
        
        // 1st time is to confirm the length of the array
        try (BufferedReader reader = new BufferedReader(new FileReader("data/StudentGradeDB.txt"))) {
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
        
        // Create an studentGrade array
        StudentGrade[] studentGrade = new StudentGrade[count];
        
        // 2nd time is to fill in the studentGrade array
        try (BufferedReader reader = new BufferedReader(new FileReader("data/StudentGradeDB.txt"))) {
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
                String gradeID = part[0].trim();
                String studentID = part[1].trim();
                String courseID = part[2].trim();
                String year = part[3].trim();
                double gradePoint = Double.parseDouble(part[4].trim());
                String grade = part[5].trim();
                
                // Insert each row into the array
                studentGrade[index++] = new StudentGrade(gradeID, studentID, courseID, year, gradePoint, grade);

            }
        }
        catch (IOException e){
            // Show error message if the file can't be read
            JOptionPane.showMessageDialog(null, "Error reading database.", "System Error", JOptionPane.ERROR_MESSAGE);
            // Print full error details
            e.printStackTrace();
        }
        // Return the array
        return studentGrade;
    }
    
    // Method 2: Save updated student grades to database
    public void writeStudentGradeDB(StudentGrade[] grade){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/StudentGradeDB.txt"))) {
            // Write header
            writer.write("gradeID,studentID,courseID,year,gradePoint,grade");
            writer.newLine();
            
            // Loop through everything in grade to write back into database
            for(StudentGrade g: grade) {
                // Write each row
                writer.write(g.getGradeID() + "," + g.getStudentID() + "," + g.getCourseID() + "," + g.getYear() + "," + g.getGradePoint() + "," + g.getGrade());
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
    
    // Method 3: Get the next student grade id
    public String getNextStudentGradeID() {
        // Load all grades
        StudentGrade[] grades = loadData();

        // Declare an integer variable
        int max = 0;

        // Loop through the student grade array
        for (StudentGrade g : grades) {
            // Get the gradeID
            String id = g.getGradeID();

            // Remove the "G"
            String numPart = id.substring(1); 

            try {
                // Change the value to integer
                int num = Integer.parseInt(numPart);
                // Assign the number to the variable until it finish looping
                if (num > max) {
                    max = num;
                }
            } catch (NumberFormatException e) {
                // Skip invalid IDs
                continue;
            }
        }

        // Set the next number
        int nextID = max + 1;

        // return the next Student Grade ID
        return String.format("G%03d", nextID);
    }
    
    // Method 4: join student grades
    public void joinStudentGrade(String studentID, String courseID, double gradePoint, String grade) {
        // Load all retake
        StudentGrade[] studentGrade = loadData();
        
        // Create a new array with one element larger than the student grade array
        StudentGrade[] newStudentGrade = new StudentGrade[studentGrade.length + 1];
        
        // Call StudentService
        StudentService ss = new StudentService();
        // Load student data
        Student[] student = ss.loadData();
        
        // Declare a String variable
        String year = "";
        
        // Loop thorugh the student array
        for(Student s: student) {
            // Check if the student's studentID in the student array matches the studentID
            if(s.getStudentID().equals(studentID)) {
                // Get that student's year
                year = s.getYear();
                break;
            }
        }
        
        // Create the new Student Grade object
        StudentGrade newStudentGradeObject = new StudentGrade(
            getNextStudentGradeID(),
            studentID,
            courseID,
            year,
            gradePoint,
            grade
        );

        // Loop though all the row from database
        for (int i = 0; i < studentGrade.length; i++) {
            // Copy the old student grade to the new student grade array
            newStudentGrade[i] = studentGrade[i];
        }
        // Assign the new student gade object to the last element of the new array
        newStudentGrade[newStudentGrade.length - 1] = newStudentGradeObject;
        
        // Call writeStudentGradeDB method to save into database
        writeStudentGradeDB(newStudentGrade);
    }
}
