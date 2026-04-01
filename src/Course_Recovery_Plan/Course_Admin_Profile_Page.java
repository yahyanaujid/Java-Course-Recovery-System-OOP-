/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Course_Recovery_Plan;

// Import other packages
import Eligibility_Check_and_Enrolment.*;
import User_Management.*;
// Import classes
import Classes.*;

// For date purposes
import java.time.LocalDate;
// For image purposes
import java.awt.Image;
import javax.swing.ImageIcon;
// To get the current date and time
import java.time.LocalDateTime;

public class Course_Admin_Profile_Page extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Course_Admin_Profile_Page.class.getName());
    
    // Declare variable
    private User user;
    
    // Get the image
    private ImageIcon pfp = new ImageIcon("images/pfp.png");
    
    // Constructor
    public Course_Admin_Profile_Page(User user) {
        this.user = user;
        
        initBG();
        initComponents();
        fillUserDetails();
        
        // Make function panel fully transparent
        jPanel1.setOpaque(false);
        
        // Call Action Listener for each button
        logoutBtn.addActionListener(e -> logout());
        recoveryBtn.addActionListener(e -> {
            new Course_Recovery_Plan_Page(user).setVisible(true);
            this.setVisible(false);
        });
        enrolmentBtn.addActionListener(e -> {
            new EligibilityFrame(user).setVisible(true);
            this.setVisible(false);
        });
        
        setAutoLogout();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        adminProfileBtn = new javax.swing.JButton();
        enrolmentBtn = new javax.swing.JButton();
        recoveryBtn = new javax.swing.JButton();
        dateLbl = new javax.swing.JLabel();
        picLbl = new javax.swing.JLabel();
        useridLbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        titleLbl = new javax.swing.JLabel();
        emailLbl = new javax.swing.JLabel();
        roleLbl = new javax.swing.JLabel();
        statusLbl = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Course Administrator User Profile");
        setPreferredSize(new java.awt.Dimension(590, 435));
        getContentPane().setLayout(null);

        adminProfileBtn.setFont(new java.awt.Font("Modern No. 20", 1, 24)); // NOI18N
        adminProfileBtn.setForeground(new java.awt.Color(53, 53, 53));
        adminProfileBtn.setText("User Profile");
        adminProfileBtn.setPreferredSize(new java.awt.Dimension(180, 90));

        enrolmentBtn.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        enrolmentBtn.setForeground(new java.awt.Color(153, 153, 153));
        enrolmentBtn.setText("<html><center>Eligibility<br/>Check and<br/>Enrolment<center/><html/>");
        enrolmentBtn.setPreferredSize(new java.awt.Dimension(180, 90));

        recoveryBtn.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        recoveryBtn.setForeground(new java.awt.Color(153, 153, 153));
        recoveryBtn.setText("<html><center>Course<br/>Recovery<br/>Plan<center/><html/>");
        recoveryBtn.setPreferredSize(new java.awt.Dimension(180, 90));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adminProfileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recoveryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enrolmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(enrolmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(recoveryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(adminProfileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 566, 102);

        dateLbl.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        dateLbl.setText("(Current Date)");
        getContentPane().add(dateLbl);
        dateLbl.setBounds(17, 114, 110, 20);

        picLbl.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        getContentPane().add(picLbl);
        picLbl.setBounds(38, 156, 150, 150);

        useridLbl.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        useridLbl.setText("(userID)");
        getContentPane().add(useridLbl);
        useridLbl.setBounds(83, 312, 60, 20);

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel4.setText("Email Address:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(206, 232, 109, 20);

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel5.setText("Name:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(269, 152, 46, 20);

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel6.setText("Title:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(280, 192, 35, 20);

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel7.setText("Role:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(278, 272, 37, 20);

        nameLbl.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        nameLbl.setText("(Name)");
        getContentPane().add(nameLbl);
        nameLbl.setBounds(333, 152, 220, 20);

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel8.setText("Status:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(265, 312, 50, 20);

        titleLbl.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        titleLbl.setText("(Title)");
        getContentPane().add(titleLbl);
        titleLbl.setBounds(333, 192, 220, 20);

        emailLbl.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        emailLbl.setText("(Email)");
        getContentPane().add(emailLbl);
        emailLbl.setBounds(333, 232, 220, 20);

        roleLbl.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        roleLbl.setText("(Role)");
        getContentPane().add(roleLbl);
        roleLbl.setBounds(333, 272, 220, 20);

        statusLbl.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        statusLbl.setText("(Status)");
        getContentPane().add(statusLbl);
        statusLbl.setBounds(333, 312, 220, 20);

        logoutBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        logoutBtn.setText("Logout");
        getContentPane().add(logoutBtn);
        logoutBtn.setBounds(438, 350, 90, 31);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Method 1: Change the background
    private void initBG() {
        // Get the path of background image
        Background background = new Background("C:\\Users\\yu en\\OneDrive\\Documents\\Y2S1\\OODJ\\Assignment\\images\\interfaceBG.jpg");

        // allow components on top of the background
        background.setLayout(null);

        // Use this panel as the whole page
        setContentPane(background);
    }
    
    // Method 2: Fill up user details
    private void fillUserDetails() {
        // Display current date
        dateLbl.setText(LocalDate.now().toString());
        // Display user's userID
        useridLbl.setText(user.getUserID());
        // Display user's name
        nameLbl.setText(user.getUsername());
        // Display user's title
        titleLbl.setText(user.getTitle());
        // Display user's email
        emailLbl.setText(user.getEmail());
        // Display user's role
        roleLbl.setText(user.getRole());
        // Display user's account status
        statusLbl.setText(user.getStatus());
        
        // Get a default profile picture
        Image pic = pfp.getImage();
        // Set the scale of the profile picture to 150x150
        Image scaled = pic.getScaledInstance(150,150,Image.SCALE_SMOOTH);
        ImageIcon scaledPic = new ImageIcon(scaled);
        // Display a profile picture
        picLbl.setIcon(scaledPic);
    }
    
    // Method 3: Logout
    private void logout() {
        LocalDateTime logoutTime = LocalDateTime.now();
        LogService.writeLog(Login_Page.currentUserID, Login_Page.loginTime, logoutTime);
        
        // Go back to login page
        Login_Page login_page = new Login_Page(new UserService());
        login_page.setVisible(true);
        this.setVisible(false);
    }
    
    // Method 4: When user terminate system, the log will also be saved
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
    private javax.swing.JButton adminProfileBtn;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JLabel emailLbl;
    private javax.swing.JButton enrolmentBtn;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JLabel picLbl;
    private javax.swing.JButton recoveryBtn;
    private javax.swing.JLabel roleLbl;
    private javax.swing.JLabel statusLbl;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JLabel useridLbl;
    // End of variables declaration//GEN-END:variables
}
