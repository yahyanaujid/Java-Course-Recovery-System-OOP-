/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Course_Recovery_Plan;

// Import other packages
import Academic_Performance_Reporting.Academic_Performance_Reporting_Page;
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

public class Officer_Profile_Page extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Officer_Profile_Page.class.getName());
    
    // Declare variable
    private User user;
    
    // Get the image
    private ImageIcon pfp = new ImageIcon("images/pfp.png");
    
    // Constructor
    public Officer_Profile_Page(User user) {
        this.user = user;
        
        initBG();
        initComponents();
        fillUserDetails();
        
        // Make function panel fully transparent
        functionPanel.setOpaque(false);
        
        // Call Action Listener for each button
        logoutBtn.addActionListener(e -> logout());
        managementBtn.addActionListener(e -> {
            new UserManagementPage(user).setVisible(true);
            this.setVisible(false);
        });
        reportBtn.addActionListener(e -> {
            new Academic_Performance_Reporting_Page(user).setVisible(true);
            this.setVisible(false);
        });
        
        setAutoLogout();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        functionPanel = new javax.swing.JPanel();
        reportBtn = new javax.swing.JButton();
        officerProfileBtn = new javax.swing.JButton();
        managementBtn = new javax.swing.JButton();
        dateLbl = new javax.swing.JLabel();
        picLbl = new javax.swing.JLabel();
        useridLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        titleLbl = new javax.swing.JLabel();
        emailLbl = new javax.swing.JLabel();
        roleLbl = new javax.swing.JLabel();
        statusLbl = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Academic Officer User Profile");

        reportBtn.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        reportBtn.setForeground(new java.awt.Color(153, 153, 153));
        reportBtn.setText("<html><center>Academic<br/>Performance<br/>Report<center/><html/>");
        reportBtn.setPreferredSize(new java.awt.Dimension(180, 90));

        officerProfileBtn.setFont(new java.awt.Font("Modern No. 20", 1, 24)); // NOI18N
        officerProfileBtn.setForeground(new java.awt.Color(53, 53, 53));
        officerProfileBtn.setText("User Profile");
        officerProfileBtn.setPreferredSize(new java.awt.Dimension(180, 90));

        managementBtn.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        managementBtn.setForeground(new java.awt.Color(153, 153, 153));
        managementBtn.setText("<html><center>User<br/>Management<center/><html/>");
        managementBtn.setPreferredSize(new java.awt.Dimension(180, 90));

        javax.swing.GroupLayout functionPanelLayout = new javax.swing.GroupLayout(functionPanel);
        functionPanel.setLayout(functionPanelLayout);
        functionPanelLayout.setHorizontalGroup(
            functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(functionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(officerProfileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(managementBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        functionPanelLayout.setVerticalGroup(
            functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(functionPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(officerProfileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(managementBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        dateLbl.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        dateLbl.setText("(Current Date)");

        useridLbl.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        useridLbl.setText("(userID)");

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel1.setText("Name:");

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel2.setText("Title:");

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel3.setText("Email Address:");

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel4.setText("Role:");

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel5.setText("Status:");

        nameLbl.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        nameLbl.setText("(Name)");

        titleLbl.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        titleLbl.setText("(Title)");

        emailLbl.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        emailLbl.setText("(Email)");

        roleLbl.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        roleLbl.setText("(Role)");

        statusLbl.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        statusLbl.setText("(Status)");

        logoutBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        logoutBtn.setText("Logout");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(functionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(dateLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(useridLbl)
                            .addComponent(picLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(titleLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(95, 95, 95))
                            .addComponent(emailLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(roleLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(statusLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(logoutBtn)
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(functionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(dateLbl)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLbl))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(titleLbl))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(emailLbl))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(roleLbl))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(statusLbl)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(picLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(useridLbl)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

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
    private javax.swing.JLabel dateLbl;
    private javax.swing.JLabel emailLbl;
    private javax.swing.JPanel functionPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton managementBtn;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JButton officerProfileBtn;
    private javax.swing.JLabel picLbl;
    private javax.swing.JButton reportBtn;
    private javax.swing.JLabel roleLbl;
    private javax.swing.JLabel statusLbl;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JLabel useridLbl;
    // End of variables declaration//GEN-END:variables
}
