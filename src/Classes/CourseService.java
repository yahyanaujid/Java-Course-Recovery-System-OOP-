/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class CourseService {
    
    //Method 1
    public Course[] loadData() {
        int count = 0;

        //Count rows
        try (BufferedReader reader = new BufferedReader(new FileReader("data/CourseDB.txt"))) {
            String line;
            reader.readLine(); //Skip header
            
            while ((line = reader.readLine()) != null) {
                //skip empty line
                if (line.trim().isEmpty()) continue;
                String[] part = line.split(",");        //Split to obtain value for each field
                //Only count rows with 5 columns
                if (part.length == 5) {
                    count++;
                }
            }
        }
        //display error message if fail
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading CourseDB.", "System Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        Course[] courses = new Course[count];

        //Load data into array
        try (BufferedReader reader = new BufferedReader(new FileReader("data/CourseDB.txt"))) {
            String line;
            reader.readLine(); //Skip header

            int index = 0;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] part = line.split(",");
                
                //If no 5 fields in that row skip it
                if (part.length != 5) continue;
                
                //Trim each field
                String courseID = part[0].trim();
                String courseName = part[1].trim();
                String credits = part[2].trim();
                String semester = part[3].trim();
                String instructor = part[4].trim();
                
                //Declare Course object and store it
                courses[index++] = new Course(courseID, courseName, credits, semester, instructor);
            }

        }
        //Show error message if fail to read db
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading CourseDB.", "System Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        return courses;
    }
}

