/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

// Import other packages
import Course_Recovery_Plan.*;
import javax.swing.JFrame;

public class Officer extends User {
    
    // Constructor
    public Officer(String userID, String username, String password, String title, String email, String status){
        super(userID, username, password, title, email, "Academic Officer", status);
    }
    
    // Override method: Go to Academic Officer Profile Page
    public void openProfilePage(JFrame currentFrame) {
        Officer_Profile_Page officer = new Officer_Profile_Page(this);
        officer.setVisible(true);
        currentFrame.setVisible(false);
    }
}
