/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Academic_Performance_Reporting;

// Import other packages
import Classes.*;
// Import other packages
import Course_Recovery_Plan.Login_Page;
import Email_Notification.JavaMailUtil;
import User_Management.LogService;

// To get the current date and time
import java.time.LocalDateTime;

public class ExportPDF_Confirmation_Page extends javax.swing.JFrame {
    
    //Declare variable
    private String studentID;
    private String studentName;
    private String yearSem;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ExportPDF_Confirmation_Page.class.getName());

    // constructor
    public ExportPDF_Confirmation_Page(String studentID, String studentName, String yearSem) {
        //Assign value to variables
        this.studentID = studentID;
        this.studentName = studentName;
        this.yearSem = yearSem;
        
        initComponents();
        
        // Call Action Listener for each button
        yesBtn.addActionListener(e -> yesClicked());
        noBtn.addActionListener(e -> setVisible(false));
        
        setAutoLogout();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        noBtn = new javax.swing.JButton();
        yesBtn = new javax.swing.JButton();

        jButton4.setFont(new java.awt.Font("Modern No. 20", 1, 24)); // NOI18N
        jButton4.setText("User \nProfile");
        jButton4.setPreferredSize(new java.awt.Dimension(180, 90));

        jButton5.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        jButton5.setText("<html><center>User<br/>Management<center/><html/>");
        jButton5.setPreferredSize(new java.awt.Dimension(180, 90));

        jButton6.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        jButton6.setText("<html><center>Academic<br/>Performance<br/>Reporting<center/><html/>");
        jButton6.setPreferredSize(new java.awt.Dimension(180, 90));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Export PDF?");

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel1.setText("You are about to export this to PDF.");

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel2.setText("Are you sure?");

        noBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        noBtn.setText("No");

        yesBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        yesBtn.setText("Yes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(yesBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(noBtn)))
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noBtn)
                    .addComponent(yesBtn))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Method 1
    private void yesClicked() {
        PDFReport exportPDF = new PDFReport();
        exportPDF.export(studentID, studentName, yearSem);
        
        StudentService ss = new StudentService();
        // Get the array of all rows from StudentDB
        Student[] student = ss.loadData();
        
        // Call Email Service
        EmailService es = new EmailService();
        
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
        String subject = "Academic Report (PDF Attached)";
        // Set text message for the email body
        String textMessage = "Dear Student,\n\n"
                + "Your academic report has been released. Please review the attached PDF at your earliest convenience.\n\n"
                + "If you have any questions, feel free to reach out.\n\n"
                + "Best regards";
        String fileName = "C:\\Users\\yu en\\OneDrive\\Documents\\Y2S1\\OODJ\\Assignment\\" + exportPDF.fileName;
        
        es.joinEmail(recipientEmail, subject);
        // Call sendMail method in JavaMailUtil to send notification to the student
        JavaMailUtil.sendMailWithAttachment(recipientEmail, subject, textMessage, fileName);
        
        //Display successfully exported message
        javax.swing.JOptionPane.showMessageDialog(this, "PDF Exported Successfully.");
        this.setVisible(false);     //Hide this page
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
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton noBtn;
    private javax.swing.JButton yesBtn;
    // End of variables declaration//GEN-END:variables
}
