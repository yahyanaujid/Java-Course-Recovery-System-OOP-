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
// To show pop up message
import javax.swing.JOptionPane;

public class Add_Recommendation_Page extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Add_Recommendation_Page.class.getName());

    // Declare variables
    private User user;
    private String failedComponent;
    // Store the original recommendations of the failed component
    private String[] oriRecommendation;
    private String studentID;

    // Constructors
    public Add_Recommendation_Page(User user, String failedComponent, String[] oriRecommendation, String studentID) {
        this.user = user;
        this.failedComponent = failedComponent;
        this.oriRecommendation = oriRecommendation;
        this.studentID = studentID;
        
        initComponents();
        
        newRecTxt.setLineWrap(true);
        newRecTxt.setWrapStyleWord(true);
        
        // Call Action Listener for each button
        addBtn.addActionListener(e -> addRec());
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
        jScrollPane2 = new javax.swing.JScrollPane();
        newRecTxt = new javax.swing.JTextArea();
        backBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Recommendation");

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel1.setText("New Recommendation:");

        newRecTxt.setColumns(20);
        newRecTxt.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        newRecTxt.setRows(5);
        jScrollPane2.setViewportView(newRecTxt);

        backBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        backBtn.setText("Back");

        addBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        addBtn.setText("Add");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(addBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(backBtn)
                            .addGap(24, 24, 24))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(259, 259, 259)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(addBtn))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Method 1: Add in new recommendation
    private void addRec() {
        // Check if the text box is empty
        if(newRecTxt.getText().trim().isEmpty()){
            // Notify user to write something
            JOptionPane.showMessageDialog(this,"Please type in the new recommendation.");
            return;
        }
        else{
            // Add 1 element for the new recommendation
            int count = oriRecommendation.length + 1;
            
            // Create an array with the new length to store new recommendation
            String[] newRecommendation = new String[count];
            
            // Loop through everything in the original recommendation and move the original text to the new array
            for(int i = 0; i < oriRecommendation.length; i++){
                newRecommendation[i] = oriRecommendation[i];
            }
            
            // Add the new recommendation to the last index of the array
            newRecommendation[count - 1] = newRecTxt.getText().trim();
            
            // Go to Confirmation Page
            Add_Recommendation_Confirmation_Page add_recommendation_confirmation_page = new Add_Recommendation_Confirmation_Page(this, user, newRecommendation, failedComponent, studentID);
            add_recommendation_confirmation_page.setVisible(true);
        }
    }
    
    // Method 2: When user terminate system, the log will also be saved
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea newRecTxt;
    // End of variables declaration//GEN-END:variables
}
