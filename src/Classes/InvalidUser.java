/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import javax.swing.JFrame;

public class InvalidUser extends User {
    // Constructor
    public InvalidUser(String status) {
        super("INVALID", "", "", "", "", "InvalidUser", status);
    }

    // Override method: For invalid user
    public void openProfilePage(JFrame currentFrame) {
        // Do nothing, invalid users cannot open profile page
    }
}
