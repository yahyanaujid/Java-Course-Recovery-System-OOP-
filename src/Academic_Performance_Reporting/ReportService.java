/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Academic_Performance_Reporting;

// Import classes
import Classes.*;

import java.util.*;

public class ReportService {
    //Method 1
    public String[] getYearsForStudent(String studentID) {
        
        
        StudentGradeService sgs = new StudentGradeService();
        StudentGrade[] grades = sgs.loadData();

        ArrayList<String> yearList = new ArrayList<>();
        
        //Add the year a student has into an array called yearList
        for (StudentGrade sg : grades) {
            if (sg.getStudentID().equals(studentID)) {
                String year = sg.getYear();
                if (!yearList.contains(year)) {
                    yearList.add(year);
                }
            }
        }
        
        //Order of years
        String[] order = {"Freshman", "Sophomore", "Junior", "Senior"};
        ArrayList<String> sorted = new ArrayList<>();
        
        //Add the years sorted based on the order to the array
        for (String y : order) {
            if (yearList.contains(y)) {
                sorted.add(y);
            }
        }
        //Convert to array
        return sorted.toArray(new String[0]);
    }
    
    //Method 2
    public String[] getSemestersForStudent(String studentID, String year) {

        StudentGradeService sgs = new StudentGradeService();
        StudentGrade[] grades = sgs.loadData();

        CourseService cs = new CourseService();
        Course[] courses = cs.loadData();

        ArrayList<String> semList = new ArrayList<>();
        
        //For every grade, find those matching both the student and year
        for (StudentGrade sg : grades) {

            if (!sg.getStudentID().equals(studentID)) continue;
            if (!sg.getYear().equals(year)) continue;

            String courseID = sg.getCourseID();
            
            //For every course, find those matching the courseID
            for (Course c : courses) {
                if (c.getCourseID().equals(courseID)) {

                    String sem = c.getSemester();
                    
                    //Add the ones that are not in the list already
                    if (!semList.contains(sem)) {
                        semList.add(sem);
                    }
                }
            }
        }
        
        //Order of semesters
        String[] order = {"Spring", "Summer", "Fall"};
        ArrayList<String> sorted = new ArrayList<>();
        
        //For every string according to the order add it into the array
        for (String s : order) {
            if (semList.contains(s)) {
                sorted.add(s);
            }
        }
        
        return sorted.toArray(new String[0]);
    }
}