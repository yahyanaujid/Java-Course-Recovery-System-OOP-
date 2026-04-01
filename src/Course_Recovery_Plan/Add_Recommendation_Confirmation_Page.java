/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Course_Recovery_Plan;

// Import classes
import Classes.*;
// Import other packages
import Email_Notification.JavaMailUtil;
import User_Management.LogService;

// To get the current date and time
import java.time.LocalDateTime;

public class Add_Recommendation_Confirmation_Page extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Add_Recommendation_Confirmation_Page.class.getName());
    
    // Declare variables
    private Add_Recommendation_Page add_recommendation_page;
    private User user;
    private String[] newRecommendation;
    private String failedComponent;
    private String studentID;
    
    // Call RecommendationService
    RecommendationService rs = new RecommendationService();
    
    // Call StudentService
    StudentService ss = new StudentService();
    // Get the array of all rows from StudentDB
    Student[] student = ss.loadData();
    
    // Call Email Service
    EmailService es = new EmailService();
    
    // Constructor
    public Add_Recommendation_Confirmation_Page(Add_Recommendation_Page add_recommendation_page, User user, String[] newRecommendation, String failedComponent, String studentID) {
        this.user = user;
        this.add_recommendation_page = add_recommendation_page;
        this.newRecommendation = newRecommendation;
        this.failedComponent = failedComponent;
        this.studentID = studentID;
        
        initComponents();
        
        // Call Action Listener for each button
        yesBtn.addActionListener(e -> yesClicked());
        noBtn.addActionListener(e -> setVisible(false));
        
        setAutoLogout();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        noBtn = new javax.swing.JButton();
        yesBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Recommendation?");

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel2.setText("Are you sure?");

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel1.setText("You are about to add this recommendation.");

        noBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        noBtn.setText("No");

        yesBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        yesBtn.setText("Yes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                        .addComponent(yesBtn)
                        .addGap(154, 154, 154)
                        .addComponent(noBtn)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noBtn)
                    .addComponent(yesBtn))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Method 1: Add the new recommendation, notify student and go back to Recommendation Page
    private void yesClicked() {
        // Call joinRecommendation method to set all recommendations into a single string
        rs.joinRecommendation(failedComponent, newRecommendation);
        
        // To store recepient email
        String recipientEmail = "";
        
        // Loop through every row in student array
        for(int i = 0; i < student.length; i++) {
            // Check which row matches the studentID that is passed in
            if(student[i].getStudentID().equals(studentID)) {
                // Get the student email
                recipientEmail = student[i].getEmail();
            }
        }
        
        // Set subject for email header
        String subject = "New Recommendation Added";
        // Set text message for the email body
        String textMessage = "Dear Student,\n\n"
                + "We would like to inform you that a new recommendation text has been added to the school system. Please log in at your earliest convenience to review the updated information.\n\n"
                + "If you have any questions, feel free to reach out.\n\n"
                + "Best regards";
        
        es.joinEmail(recipientEmail, subject);
        // Call sendMail method in JavaMailUtil to send notification to the student
        JavaMailUtil.sendMail(recipientEmail, subject, textMessage);
        
        // Go back to Recommendation Page
        Recommendation_Page recommendation_page = new Recommendation_Page(user, failedComponent, studentID);
        recommendation_page.setVisible(true);
        this.setVisible(false);
        add_recommendation_page.setVisible(false);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton noBtn;
    private javax.swing.JButton yesBtn;
    // End of variables declaration//GEN-END:variables
}
