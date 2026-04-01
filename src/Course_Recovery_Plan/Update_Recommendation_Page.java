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

public class Update_Recommendation_Page extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Update_Recommendation_Page.class.getName());

    // Declare variables
    private User user;
    private String failedComponent;
    private String studentID;
    
    // Call RecommendationService
    RecommendationService rs = new RecommendationService();
    // Get the array of all rows from RecommendationDB
    Recommendation[] recommendation = rs.loadRecommendations();
    
    // Constructor
    public Update_Recommendation_Page(User user, String failedComponent, String studentID) {
        this.user = user;
        this.failedComponent = failedComponent;
        this.studentID = studentID;
        
        initComponents();
        initComboBox();
        
        updatedRecTxt.setLineWrap(true);
        updatedRecTxt.setWrapStyleWord(true);
        
        // Call Action Listener for each button
        updateBtn.addActionListener(e -> updateRec());
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
        jLabel2 = new javax.swing.JLabel();
        recComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        updatedRecTxt = new javax.swing.JTextArea();
        backBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Update Recommendation");

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        jLabel1.setText("Recommendation:");

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        jLabel2.setText("New Recommendation:");

        recComboBox.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N

        updatedRecTxt.setColumns(20);
        updatedRecTxt.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        updatedRecTxt.setRows(5);
        jScrollPane1.setViewportView(updatedRecTxt);

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .addComponent(recComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(11, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(updateBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backBtn)
                        .addGap(9, 9, 9))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(recComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(updateBtn))
                .addGap(10, 10, 10))
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
    
    // Method 2: Update the new recommendation text
    private void updateRec() {
        // Get the index of the selected recommendation
        int selectedIndex = recComboBox.getSelectedIndex();
        
        // Check if the user type anything in the text box
        if(updatedRecTxt.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Please type in the new recommendation.");
            return;
        }
        else {
            // Create an array to store updated recommendation
            String[] newRecommendation = new String[0];
            
            // Loop though the array gotten from RecommendationDB
            for(int i = 0; i < recommendation.length; i++) {
                // Check if the recommendation type matches the failed component
                if(recommendation[i].getType().equals(failedComponent)) {
                    // Get the recommendations and store in the new array when matched
                    newRecommendation = recommendation[i].getRecommendations();
                    
                    // Loop though eveything in the newRecommendation array
                    for(int j = 0; j < newRecommendation.length; j++) {
                        // Check if recommendation index matches the selected index
                        if(j == selectedIndex) {
                            // Set the updated recommendation to the correct index in the array
                            newRecommendation[j] = updatedRecTxt.getText();
                        }
                    }
                }
            }
            // Go to Confirmation Page
            Update_Recommendation_Confirmation_Page update_recommendation_confirmation_page = new Update_Recommendation_Confirmation_Page(this, user, newRecommendation, failedComponent, studentID);
            update_recommendation_confirmation_page.setVisible(true);
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
    private javax.swing.JComboBox<String> recComboBox;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTextArea updatedRecTxt;
    // End of variables declaration//GEN-END:variables
}
