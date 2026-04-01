/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

public class Student {
    // Declare variables
    private String studentID;
    private String firstName;
    private String lastName;
    private String major;
    private String year;
    private String email;
    
    // Constructor
    public Student(String studentID, String firstName, String lastName, String major, String year, String email) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.year = year;
        this.email = email;
    }
    
    // Encapsulation
    public String getStudentID(){
        return this.studentID;
    }
    
    public void setStudentID(String studentID){
        this.studentID = studentID;
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getMajor(){
        return this.major;
    }
    
    public void setMajor(String major){
        this.major = major;
    }
    
    public String getYear(){
        return this.year;
    }
    
    public void setYear(String year){
        this.year = year;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
}
