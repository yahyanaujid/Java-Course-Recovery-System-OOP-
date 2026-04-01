/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

public class Course {
    //Declare variable
    private String courseID;
    private String courseName;
    private String credits;
    private String semester;
    private String instructor;

    // Constructor
    public Course(String courseID, String courseName, String credits, String semester, String instructor) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credits = credits;
        this.semester = semester;
        this.instructor = instructor;
    }

    // Encapsulation
    public String getCourseID() { 
        return this.courseID; 
    }
    public String getCourseName() { 
        return this.courseName; 
    }
    public String getCredits() { 
        return this.credits; 
    }
    public String getSemester() { 
        return this.semester; 
    }
    public String getInstructor() { 
        return this.instructor; 
    }
    public void setCourseID(String courseID) { 
        this.courseID = courseID; 
    }
    public void setCourseName(String courseName) { 
        this.courseName = courseName; 
    }
    public void setCredits(String credits) { 
        this.credits = credits; 
    }
    public void setSemester(String semester) { 
        this.semester = semester; 
    }
    public void setInstructor(String instructor) { 
        this.instructor = instructor; 
    }
}
