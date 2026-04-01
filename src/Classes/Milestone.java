/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

public class Milestone {
    // Declare variables
    private String milestoneID;
    private String type;
    private String week;
    private String task;
    private String[] weeks;
    private String[] tasks;
    
    // Constructor
    public Milestone(String milestoneID, String type, String week, String task) {
        this.milestoneID = milestoneID;
        this.type = type;
        this.week = week;
        this.task = task;
        //Split the week and place them in an array
        this.weeks = week.split("\\|");
        //Split the task and place them in an array
        this.tasks = task.split("\\|");
    }
    
    // Encapsulation
    public String getMilestoneID(){
        return this.milestoneID;
    }
    
    public void setMilestoneID(String milestoneID){
        this.milestoneID = milestoneID;
    }
    
    public String getType(){
        return this.type;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    public String getWeek(){
        return this.week;
    }
    
    public void setWeek(String week){
        this.week = week;
        
        // Splits the week
        this.weeks = week.split("\\|");
    }
    
    public String getTask(){
        return this.task;
    }
    
    public void setTask(String task){
        this.task = task;
        
        // Splits the task
        this.tasks = task.split("\\|");
    }
    
    public String[] getWeeks(){
        return this.weeks;
    }
    
    public String[] getTasks(){
        return this.tasks;
    }
    
    // Get the number of week
    public int getWeekCount(){
        return weeks.length;
    }
    
    // Get the number of task
    public int getTaskCount(){
        return tasks.length;
    }
}
