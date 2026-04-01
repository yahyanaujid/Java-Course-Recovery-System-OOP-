/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

public class Retake {
    // Declare variables
    private String retakeID;
    private String courseID;
    private String studentID;
    private String failedComponent;
    private int attemptLefts;
    private String progressStatus;
    private String recoveryResult;

    // Constructor
    public Retake(String retakeID, String courseID, String studentID, String failedComponent, int attemptLefts, String progressStatus, String recoveryResult) {
        this.retakeID = retakeID;
        this.courseID = courseID;
        this.studentID = studentID;
        this.failedComponent = failedComponent;
        this.attemptLefts = attemptLefts;
        this.progressStatus = progressStatus;
        this.recoveryResult = recoveryResult;
    }
    
    // Encapsulation
    public String getRetakeID(){
        return this.retakeID;
    }
    
    public void setRetakeID(String retakeID){
        this.retakeID = retakeID;
    }
    
    public String getCourseID(){
        return this.courseID;
    }
    
    public void setCourseID(String courseID){
        this.courseID = courseID;
    }
    
    public String getStudentID(){
        return this.studentID;
    }
    
    public void setStudentID(String studentID){
        this.studentID = studentID;
    }
    
    public String getFailedComponent(){
        return this.failedComponent;
    }
    
    public void setFailedComponent(String failedComponent){
        this.failedComponent = failedComponent;
    }
    
    public int getAttemptLefts(){
        return this.attemptLefts;
    }
    
    public void setAttemptLefts(int attemptLefts){
        this.attemptLefts = attemptLefts;
    }
    
    public String getProgressStatus(){
        return this.progressStatus;
    }
    
    public void setProgressStatus(String progressStatus){
        this.progressStatus = progressStatus;
    }
    
    public String getRecoveryResult(){
        return this.recoveryResult;
    }
    
    public void setRecoveryResult(String recoveryResult){
        this.recoveryResult = recoveryResult;
    }
}
