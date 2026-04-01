/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Course_Recovery_Plan;

// Import classes
import Classes.*;
// Import other packages
import User_Management.LogService;

// To get current date and time
import java.time.LocalDateTime;

public class Remove_Recommendation_Page extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Remove_Recommendation_Page.class.getName());

    // Declare variables
    private User user;
    private String failedComponent;
    private String studentID;
    
    // Call RecommendationService
    RecommendationService rs = new RecommendationService();
    // Get the array of all rows from RecommendationDB
    Recommendation[] recommendation = rs.loadRecommendations();
    
    // Constructor
    public Remove_Recommendation_Page(User user, String failedComponent, String studentID) {
        this.user = user;
        this.failedComponent = failedComponent;
        this.studentID = studentID;
        
        initComponents();
        initComboBox();
        
        // Call Action Listener for each button
        removeBtn.addActionListener(e -> removeRec());
        backBtn.addActionListener(e -> {
            new Recommendation_Page(user, failedComponent, studentID).setVisible(true);
            this.setVisible(false);
        });
        
        setAutoLogout();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        recComboBox = new javax.swing.JComboBox<>();
        backBtn = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Remove Recommendation");

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel1.setText("Recommendation:");

        recComboBox.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N

        backBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        backBtn.setText("Back");

        removeBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        removeBtn.setText("Remove");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(removeBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(recComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(recComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(removeBtn))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Method 1: Initialize the combo box
    private void initComboBox() {
        // Create an array to store the original recommendations
        String[] oriRecommendation = new String[0];
        
        // Remove everything inside the combo box
        recComboBox.removeAllItems();
        
        // Loop through every row in the recommendation to get the row with the same failed component
        for(int i = 0; i < recommendation.length; i++) {
            // Check if the type matches the selected student failed component
            if (recommendation[i].getType().equals(failedComponent)) {
                // Get each recommendation and save it in oriRecommendation array
                oriRecommendation = recommendation[i].getRecommendations();
                // Stop looping after finding the correct type and assigning all recommendation into the array
                break;
            }
        }
        
        // Loop through the original recommendation array to get the amount of recommendation inside database
        for(int j = 1; j <= oriRecommendation.length; j++) {
            // Add into combo box
            recComboBox.addItem("Recommendation " + j);
        }
    }
    
    // Method 2: Remove the selected recommendation text
    private void removeRec() {
        // Get the index of the selected recommendation
        int selectedIndex = recComboBox.getSelectedIndex();
        
        // Create an array to store the original recommendations
        String[] oriRecommendations = new String[0];
        // Create an array to store the new recommendations
        String[] newRecommendation = new String[0];
        
        // Loop though the array gotten from RecommendationDB
        for(int i = 0; i < recommendation.length; i++) {
            // Check if the recommendation type matches the failed component
            if(recommendation[i].getType().equals(failedComponent)) {
                // Copy the original recommendations to the new recommendation array
                oriRecommendations = recommendation[i].getRecommendations();
                
                // Assign element to the newRecommendation array
                newRecommendation = new String[oriRecommendations.length - 1];
                
                // Keep track of the current index
                int index = 0;
                
                // Loop through every element in the recommendation array and remove the selected recommendation
                for(int j = 0; j < oriRecommendations.length; j++) {
                    // Skip the selected recommendation
                    if(j == selectedIndex) continue;
                    newRecommendation[index] = oriRecommendations[j];
                    index++;
                }
                /// Stop looping after finding the correct type and assigning all recommendation into the array
                break;
            }
        }
        // Go to Confirmation Page
        Remove_Recommendation_Confirmation_Page remove_recommendation_confirmation_page = new Remove_Recommendation_Confirmation_Page(this, user, failedComponent, newRecommendation, studentID);
        remove_recommendation_confirmation_page.setVisible(true);
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
    private javax.swing.JComboBox<String> recComboBox;
    private javax.swing.JButton removeBtn;
    // End of variables declaration//GEN-END:variables
}
