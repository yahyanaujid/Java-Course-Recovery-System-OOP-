/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

// Import other packages
import Course_Recovery_Plan.*;
import javax.swing.JFrame;

public class Admin extends User {
    
    // Constructor
    public Admin(String userID, String username, String password, String title, String email, String status){
        super(userID, username, password, title, email, "Course Administrator", status);
    }
    
    // Override method: Go to Course Administrator Profile Page
    public void openProfilePage(JFrame currentFrame) {
        Course_Admin_Profile_Page admin = new Course_Admin_Profile_Page(this);
        admin.setVisible(true);
        currentFrame.setVisible(false);
    }
}
