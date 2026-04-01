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
// To show pop up message
import javax.swing.JOptionPane;

public class Update_Milestone_Page extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Update_Milestone_Page.class.getName());

    // Declare variables
    private User user;
    private String failedComponent;
    private String studentID;
    
    // Call MilestoneService
    MilestoneService ms = new MilestoneService();
    // Get the array of all rows from MilestoneDB
    Milestone[] milestone = ms.loadMilestone();
    
    // Constructor
    public Update_Milestone_Page(User user, String failedComponent, String studentID) {
        this.user = user;
        this.failedComponent = failedComponent;
        this.studentID = studentID;
        
        initComponents();
        initComboBox();
        
        updatedMilestoneTxt.setLineWrap(true);
        updatedMilestoneTxt.setWrapStyleWord(true);
        
        // Call Action Listener for each button
        updateBtn.addActionListener(e -> updateMilestone());
        backBtn.addActionListener(e -> {
            new Recovery_Plan_Page(user, failedComponent, studentID).setVisible(true);
            this.setVisible(false);
        });
        
        setAutoLogout();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        updatedMilestoneTxt = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        weekComboBox = new javax.swing.JComboBox<>();
        backBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Update Milestone");

        updatedMilestoneTxt.setColumns(20);
        updatedMilestoneTxt.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        updatedMilestoneTxt.setRows(5);
        jScrollPane1.setViewportView(updatedMilestoneTxt);

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel1.setText("Week:");

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel2.setText("New Task:");

        weekComboBox.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        weekComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        backBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        backBtn.setText("Back");

        updateBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        updateBtn.setText("Update");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(weekComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(updateBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(weekComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(updateBtn))
                .addGap(10, 10, 10))
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
    
    // Method 2: Update the new milestone
    private void updateMilestone() {
        // Get the index of the selected week
        int selectedIndex = weekComboBox.getSelectedIndex();
        
        // Check if the user type anything in the text box
        if(updatedMilestoneTxt.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Please type in the new milestone.");
            return;
        }
        else{
            // Create an array to store original weeks
            String[] oriWeeks = new String[0];
            // Create an array to store new tasks
            String[] newTasks = new String[0];
            
            // Loop through every row in the milestone
            for(int i = 0; i < milestone.length; i++) {
                // Check if the milestone type matches the selected student failed component
                if(milestone[i].getType().equals(failedComponent)) {
                    // Get each week and save it in oriWeeks array
                    oriWeeks = milestone[i].getWeeks();
                    // Get each task and save it in newTasks array
                    newTasks = milestone[i].getTasks();
                    
                    // Loop through every element in newTasks array
                    for(int j = 0; j < newTasks.length; j++) {
                        // Check which element matches the selected index
                        if(j == selectedIndex) {
                            // Update the new milestone into the array
                            newTasks[j] = updatedMilestoneTxt.getText();
                        }
                    }
                }
            }
            // Go to Confirmation Page
            Update_Milestone_Confirmation_Page update_milestone_confirmation_page = new Update_Milestone_Confirmation_Page(this, user, failedComponent, oriWeeks, newTasks, studentID);
            update_milestone_confirmation_page.setVisible(true);
        }
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTextArea updatedMilestoneTxt;
    private javax.swing.JComboBox<String> weekComboBox;
    // End of variables declaration//GEN-END:variables
}
