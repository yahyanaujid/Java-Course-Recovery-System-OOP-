/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

public class StudentGrade {
    // Declare variables
    private String gradeID;
    private String studentID;
    private String courseID;
    private String year;
    private double gradePoint;
    private String grade;
    
    // Constructor
    public StudentGrade(String gradeID, String studentID, String courseID, String year, double gradePoint, String grade) {
        this.gradeID = gradeID;
        this.studentID = studentID;
        this.courseID = courseID;
        this.year = year;
        this.gradePoint = gradePoint;
        this.grade = grade;
    }
    
    // Encapsulation
    public String getGradeID() {
        return this.gradeID;
    }
    
    public void setGradeID(String gradeID) {
        this.gradeID = gradeID;
    }
    
    public String getStudentID() {
        return this.studentID;
    }
    
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    
    public String getCourseID() {
        return this.courseID;
    }
    
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
    
    public String getYear() {
        return this.year;
    }
    
    public void setYear(String year) {
        this.year = year;
    }
    
    public double getGradePoint() {
        return this.gradePoint;
    }
    
    public void setGradePoint(double gradePoint) {
        this.gradePoint = gradePoint;
    }
    
    public String getGrade() {
        return this.grade;
    }
    
    public void setGrade(String grade) {
        this.grade = grade;
    }
}
