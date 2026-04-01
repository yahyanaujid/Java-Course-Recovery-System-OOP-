/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import javax.swing.JFrame;

public abstract class User {
    // Declare variables
    private String userID;
    private String username;
    private String password;
    private String title;
    private String email;
    private String role;
    private String status;

    // Constructor
    public User(String userID, String username, String password, String title, String email, String role, String status) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.title = title;
        this.email = email;
        this.role = role;
        this.status = status;
    }
    
    // Abstraction: each different role of user know how to open their own profile page
    public abstract void openProfilePage(JFrame currentFrame);
    
    // Encapsulation
    public String getUserID(){
        return this.userID;
    }
    
    public void setUserID(String userID){
        this.userID = userID;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getRole(){
        return this.role;
    }
    
    public void setRole(String role){
        this.role = role;
    }
    
    public String getStatus(){
        return this.status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
}
