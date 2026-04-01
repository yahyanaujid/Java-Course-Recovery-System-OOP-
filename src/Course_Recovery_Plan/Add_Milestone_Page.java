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

public class Add_Milestone_Page extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Add_Milestone_Page.class.getName());

    // Declare variables
    private User user;
    private String failedComponent;
    private String studentID;
    
    // Call MilestoneService
    MilestoneService ms = new MilestoneService();
    // Get the array of all rows from MilestoneDB
    Milestone[] milestone = ms.loadMilestone();
    
    // Constructor
    public Add_Milestone_Page(User user, String failedComponent, String studentID) {
        this.user = user;
        this.failedComponent = failedComponent;
        this.studentID = studentID;
        
        initComponents();
        initWeekNum();
        
        newMilestoneTxt.setLineWrap(true);
        newMilestoneTxt.setWrapStyleWord(true);
        
        // Call Action Listener for each button
        addBtn.addActionListener(e -> addMilestone());
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
        jLabel2 = new javax.swing.JLabel();
        weekLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        newMilestoneTxt = new javax.swing.JTextArea();
        backBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Milestone");

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel1.setText("Week:");

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel2.setText("New Task:");

        weekLbl.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        weekLbl.setText("(Week)");

        newMilestoneTxt.setColumns(20);
        newMilestoneTxt.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        newMilestoneTxt.setRows(5);
        jScrollPane1.setViewportView(newMilestoneTxt);

        backBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        backBtn.setText("Back");

        addBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        addBtn.setText("Add");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(weekLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 280, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backBtn)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(weekLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(addBtn))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Method 1: Initialize week label
    private void initWeekNum(){
        // Call getWeekNumber method from MilestoneService
        int nextWeek = ms.getNextWeekNumber(failedComponent);
        
        // Set the value to String
        String week = String.valueOf(nextWeek);
        
        //Set the value into label
        weekLbl.setText(week);
    }
    
    // Method 2: Add in new milestone
    private void addMilestone() {
        // Check if the text box is empty
        if(newMilestoneTxt.getText().trim().isEmpty()){
            // Notify user to write something
            JOptionPane.showMessageDialog(this,"Please type in the new milestone.");
            return;
        }
        else{
            // Create an array to store original weeks
            String[] oriWeek = new String[0];
            // Create an array to store original tasks
            String[] oriTask = new String[0];
            // Create an array to store new weeks
            String[] newWeeks = new String[0];
            // Create an array to store new tasks
            String[] newTasks = new String[0];
            
            // Loop through every row in the milestone
            for(int i = 0; i < milestone.length; i++) {
                // Check if the milestone type matches the selected student failed component
                if(milestone[i].getType().equals(failedComponent)) {
                    // Get each week and save it in oriWeek array
                    oriWeek = milestone[i].getWeeks();
                    // Get each week and save it in oriTask array
                    oriTask = milestone[i].getTasks();
                    // Stop looping after finding the correct type and assigning all weeks and tasks into the array
                    break;
                }
            }
            
            // Set the new week array element
            int weekCount = oriWeek.length + 1;
            // Assign the element into newWeeks array
            newWeeks = new String[weekCount];
            
            // Set the new task array element
            int taskCount = oriTask.length + 1;
            // Assign the element into newTasks array
            newTasks = new String[taskCount];
            
            // Loop through every row and move the original weeks and tasks into the new arrays
            for(int j = 0; j < oriWeek.length; j++) {
                newWeeks[j] = oriWeek[j];
                newTasks[j] = oriTask[j];
            }
            // Add the new week and task into the last element of the array
            newWeeks[weekCount - 1] = weekLbl.getText().trim();
            newTasks[taskCount - 1] = newMilestoneTxt.getText();
            
            // Go to Confirmation Page
            Add_Milestone_Confirmation_Page add_milestone_confirmation_page = new Add_Milestone_Confirmation_Page(this, user, failedComponent, newWeeks, newTasks, studentID);
            add_milestone_confirmation_page.setVisible(true);
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
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea newMilestoneTxt;
    private javax.swing.JLabel weekLbl;
    // End of variables declaration//GEN-END:variables
}
