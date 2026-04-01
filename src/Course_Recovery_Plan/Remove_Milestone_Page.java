/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Course_Recovery_Plan;

// Import classes
import Classes.*;
// Import other packages
import User_Management.LogService;

// To get the current date and time
import java.time.LocalDateTime;

public class Remove_Milestone_Page extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Remove_Milestone_Page.class.getName());

    // Declare variables
    private User user;
    private String failedComponent;
    private String studentID;
    
    // Call MilestoneService
    MilestoneService ms = new MilestoneService();
    // Get the array of all rows from MilestoneDB
    Milestone[] milestone = ms.loadMilestone();
    
    // Constructor
    public Remove_Milestone_Page(User user, String failedComponent, String studentID) {
        this.user = user;
        this.failedComponent = failedComponent;
        this.studentID = studentID;
        
        initComponents();
        initComboBox();
        
        // Call Action Listener for each button
        removeBtn.addActionListener(e -> removeMilestone());
        backBtn.addActionListener(e -> {
            new Recovery_Plan_Page(user, failedComponent, studentID).setVisible(true);
            this.setVisible(false);
        });
        
        setAutoLogout();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        weekComboBox = new javax.swing.JComboBox<>();
        backBtn = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Remove Milestone");

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel1.setText("Week:");

        weekComboBox.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        weekComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Week 1", "Week 2", "Week 3", "Week 4" }));

        backBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        backBtn.setText("Back");

        removeBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        removeBtn.setText("Remove");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(weekComboBox, 0, 359, Short.MAX_VALUE)
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(removeBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backBtn)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(weekComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(removeBtn))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Method 1: Initialize combo box
    private void initComboBox(){
        // Create an array to store original weeks
        String[] oriWeeks = new String[0];
        
        // Remove everything inside the combo box
        weekComboBox.removeAllItems();
        
        // Loop through every row in the milestone
        for(int i = 0; i < milestone.length; i++) {
            // Check if the milestone type matches the selected student failed component
            if(milestone[i].getType().equals(failedComponent)) {
                // Get each week and save it in week array
                oriWeeks = milestone[i].getWeeks();
                // Stop looping after finding the correct type and assigning all weeks into the array
                break;
            }
        }
        
        // Loop through the original week array to get the amount of week inside database
        for(int j = 1; j <= oriWeeks.length; j++) {
            // Add into combo box
            weekComboBox.addItem("Week " + j);
        }
    }
    
    // Method 2: Remove the selected milestone
    private void removeMilestone() {
        // Get the index of the selected milestone
        int selectedIndex = weekComboBox.getSelectedIndex();
        
        // Create an array to store original weeks
        String[] oriWeeks = new String[0];
        // Create an array to store original tasks
        String[] oriTasks = new String[0];
        
        // Loop through every row in the milestone
        for(int i = 0; i < milestone.length; i++) {
            // Check if the milestone type matches the selected student failed component
            if(milestone[i].getType().equals(failedComponent)) {
                // Get each week and save it in oriWeeks array
                oriWeeks = milestone[i].getWeeks();
                // Get each task and save it in oriTasks array
                oriTasks = milestone[i].getTasks();
            }
        }
        
        // Create an array to store new weeks
        String[] newWeeks = new String[oriWeeks.length - 1];
        // Create an array to store new tasks
        String[] newTasks = new String[oriTasks.length - 1];
        
        // Keep track of the current index
        int index = 0;
        
        // Loop through every element and move the original weeks and tasks into the new arrays
        for(int j = 0; j < oriWeeks.length; j++) {
            // Skip the selected week
            if(j == selectedIndex) continue;
            newWeeks[index] = oriWeeks[j];
            newTasks[index] = oriTasks[j];
            index++;
        }
        
        // Loop through every element in newWeeks and change the number to be in order
        for(int k = 0; k < newWeeks.length; k++) {
            newWeeks[k] = String.valueOf(k + 1);
        }
        
        // Go to Confirmation Page
        Remove_Milestone_Confirmation_Page remove_milestone_confirmation_page = new Remove_Milestone_Confirmation_Page(this, user, failedComponent, newWeeks, newTasks, studentID);
        remove_milestone_confirmation_page.setVisible(true);
    }
    
    // Method 3: When user terminate system, the log will also be saved
    private void setAutoLogout() {
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                // Get the current date and time
                LocalDateTime logoutTime = LocalDateTime.now();
                // Call writeLog method to save the log into database
                LogService.writeLog(Login_Page.currentUserID, Login_Page.loginTime, logoutTime);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton removeBtn;
    private javax.swing.JComboBox<String> weekComboBox;
    // End of variables declaration//GEN-END:variables
}
