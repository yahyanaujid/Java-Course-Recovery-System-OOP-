/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Academic_Performance_Reporting;

// Import classes
import Classes.*;
// Import other packages
import Course_Recovery_Plan.Login_Page;
import User_Management.LogService;

// To get current date and time
import java.time.LocalDateTime;

public class Select_Component_Page extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Select_Component_Page.class.getName());

    // Declare variables
    private String studentID;
    private String courseID;
    private User user;
    private Add_Grade_Page add_grade_page;
    
    // Call RetakeService
    RetakeService rs = new RetakeService();
    
    // Constructor
    public Select_Component_Page(String studentID, String courseID, User user, Add_Grade_Page add_grade_page) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.user = user;
        this.add_grade_page = add_grade_page;
        
        initComponents();
        initCB();
        
        // Call Action Listener for each button
        backBtn.addActionListener(e -> setVisible(false));
        addBtn.addActionListener(e -> addGrade());
        
        setAutoLogout();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        failedComponentCB = new javax.swing.JComboBox<>();
        backBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Select Failed Component Page");

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel1.setText("Failed Component: ");

        failedComponentCB.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        failedComponentCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        backBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        backBtn.setText("Back");

        addBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        addBtn.setText("Add");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(failedComponentCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(81, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(backBtn)
                        .addGap(17, 17, 17))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(failedComponentCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(addBtn))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Method 1: Initialize combo box
    private void initCB() {
        failedComponentCB.removeAllItems();
        failedComponentCB.addItem("Exam");
        failedComponentCB.addItem("Assignment");
    }
    
    // Method 2: Add Grade into RetakeDB
    private void addGrade() {
        int selectedIndex = failedComponentCB.getSelectedIndex();
        
        String failedComponent = "";
        
        if(selectedIndex == 0) {
           failedComponent = "Exam";
        }
        else {
            failedComponent = "Assignment";
        }
        
        rs.joinRetake(studentID, courseID, failedComponent);
        
        Academic_Performance_Reporting_Page reporting_page = new Academic_Performance_Reporting_Page(user);
        reporting_page.setVisible(true);
        add_grade_page.setVisible(false);
        this.setVisible(false);
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
    private javax.swing.JComboBox<String> failedComponentCB;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
