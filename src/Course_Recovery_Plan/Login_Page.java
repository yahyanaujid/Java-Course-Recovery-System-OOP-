/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Course_Recovery_Plan;

// Import classes
import Classes.*;

// To get current date and time
import java.time.LocalDateTime;

public class Login_Page extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login_Page.class.getName());

    // Declare variables
    public static String currentUserID = "";
    public static LocalDateTime loginTime;
    public static User currUser;
    private UserService userService;
    
    // Constructor
    public Login_Page(UserService userService) {
        this.userService = userService;
        
        initBG();
        initComponents();
        
        // Set all text box to empty text box when going into Login Page
        useridTxt.setText(null);
        passwordTxt.setText(null);
        
        // Call Action Listener for each button
        loginBtn.addActionListener(e -> login());
        exitBtn.addActionListener(e -> exit());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        useridTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JPasswordField();
        errorLbl = new javax.swing.JLabel();
        exitBtn = new javax.swing.JButton();
        loginBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        setPreferredSize(new java.awt.Dimension(580, 435));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("UserID:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(106, 196, 66, 25);

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(78, 246, 94, 25);

        jLabel3.setFont(new java.awt.Font("Calisto MT", 1, 40)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Course Recovery System\n");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(62, 46, 440, 48);

        useridTxt.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        useridTxt.setText("(userid)");
        getContentPane().add(useridTxt);
        useridTxt.setBounds(184, 191, 300, 30);

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Welcome to CRS!");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(180, 106, 203, 29);

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Please enter your login details.");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(171, 147, 230, 17);

        passwordTxt.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        passwordTxt.setText("(password)");
        getContentPane().add(passwordTxt);
        passwordTxt.setBounds(184, 239, 300, 30);

        errorLbl.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        errorLbl.setForeground(new java.awt.Color(255, 255, 255));
        errorLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(errorLbl);
        errorLbl.setBounds(140, 340, 280, 20);

        exitBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        exitBtn.setText("Exit");
        getContentPane().add(exitBtn);
        exitBtn.setBounds(470, 350, 76, 31);

        loginBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        loginBtn.setText("Login");
        getContentPane().add(loginBtn);
        loginBtn.setBounds(240, 300, 90, 30);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 
    // Method 1: Change the background
    private void initBG() {
        // Get the path of background image
        Background background = new Background("C:\\Users\\yu en\\OneDrive\\Documents\\Y2S1\\OODJ\\Assignment\\images\\LoginBG.jpg");

        // allow components on top of the background
        background.setLayout(null);

        // Use this panel as the whole page
        setContentPane(background);
    }
    
    // Method 2: Login after verifying
    private void login() {
        String userID = useridTxt.getText();
        String password = new String(passwordTxt.getPassword());
        
        // Call method to check if user is an actual user
        User user = userService.authenticate(userID, password);
        
        // Send an error message
        // If the user doesn't exists
        if(user == null) {
            errorLbl.setText("User not found");
        }
        // Check if user is an invalid user
        else if(user instanceof InvalidUser invalid) {
            // If user entered a wrong password
            if (invalid.getStatus().equals("IncorrectPassword")) {
                errorLbl.setText("Incorrect password");
            }
            // If the user account has been deactivated
            else if (invalid.getStatus().equals("Inactive")) {
                errorLbl.setText("Account has been deactivated");
            }
        }
        // When the userID and password matches what the user enter, and the account is still active
        else {
            currentUserID = user.getUserID();
            loginTime = LocalDateTime.now();
            currUser = user;
            // Call method to open each user profile page
            user.openProfilePage(this);
        }
    }
    
    // Method 3: Exit System
    private void exit() {
        System.exit(0);
    }
    
    // Main Method
    public static void main(String args[]) {
        UserService userService = new UserService();
        
        java.awt.EventQueue.invokeLater( () -> new Login_Page(userService).setVisible(true));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorLbl;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JTextField useridTxt;
    // End of variables declaration//GEN-END:variables
}
