/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Course_Recovery_Plan;

// Import other packages
import User_Management.LogService;

// For array list purposes
import java.util.ArrayList;
// To get current date and time
import java.time.LocalDateTime;

public class Filter_Page extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Filter_Page.class.getName());

    // Declare variable
    private Course_Recovery_Plan_Page recovery_plan_page;
    
    // Constructor
    public Filter_Page(Course_Recovery_Plan_Page recovery_plan_page) {
        this.recovery_plan_page = recovery_plan_page;
        
        initComponents();
        
        // Call Action Listener for each button
        applyBtn.addActionListener(e -> applyFil());
        
        setAutoLogout();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        examComboBox = new javax.swing.JCheckBox();
        assignmentComboBox = new javax.swing.JCheckBox();
        bothComboBox = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        ComboBox3 = new javax.swing.JCheckBox();
        ComboBox2 = new javax.swing.JCheckBox();
        ComboBox1 = new javax.swing.JCheckBox();
        ComboBox0 = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        notStartedComboBox = new javax.swing.JCheckBox();
        startedComboBox = new javax.swing.JCheckBox();
        doneComboBox = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        pendingComboBox = new javax.swing.JCheckBox();
        failComboBox = new javax.swing.JCheckBox();
        passComboBox = new javax.swing.JCheckBox();
        applyBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel1.setText("Filters");

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel2.setText("Failed Component");

        examComboBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        examComboBox.setText("Exam");

        assignmentComboBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        assignmentComboBox.setText("Assignment");

        bothComboBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        bothComboBox.setText("Both");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(examComboBox, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(assignmentComboBox, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bothComboBox, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(examComboBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(assignmentComboBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bothComboBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel5.setText("Attempt Lefts");

        ComboBox3.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        ComboBox3.setText("3");

        ComboBox2.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        ComboBox2.setText("2");

        ComboBox1.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        ComboBox1.setText("1");

        ComboBox0.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        ComboBox0.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(ComboBox3)
                            .addComponent(ComboBox2)
                            .addComponent(ComboBox1)
                            .addComponent(ComboBox0)))
                    .addComponent(jLabel5))
                .addGap(27, 27, 27))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComboBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboBox0)
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel6.setText("Status");

        notStartedComboBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        notStartedComboBox.setText("Haven't Started");

        startedComboBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        startedComboBox.setText("In Progress");

        doneComboBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        doneComboBox.setText("Done");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(notStartedComboBox)
                    .addComponent(doneComboBox)
                    .addComponent(startedComboBox)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(notStartedComboBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startedComboBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doneComboBox)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel7.setText("Result");

        pendingComboBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        pendingComboBox.setText("Pending");

        failComboBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        failComboBox.setText("Failed");

        passComboBox.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        passComboBox.setText("Passed");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passComboBox)
                    .addComponent(pendingComboBox)
                    .addComponent(jLabel7)
                    .addComponent(failComboBox))
                .addGap(32, 32, 32))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pendingComboBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passComboBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(failComboBox)
                .addContainerGap())
        );

        applyBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        applyBtn.setText("Apply");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(applyBtn))))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(applyBtn)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Method 1: Apply the filter and go back to Course Recovery Plan Page
    private void applyFil() {
        // Create an array list to store the selected failed component
        ArrayList<String> failedFilter = new ArrayList<> ();
        if(examComboBox.isSelected()) {
            failedFilter.add("Exam");
        }
        if(assignmentComboBox.isSelected()) {
            failedFilter.add("Assignment");
        }
        if(bothComboBox.isSelected()) {
            failedFilter.add("Both");
        }
        
        // Create an array list to store the selected attempt
        ArrayList<String> attemptFilter = new ArrayList<> ();
        if(ComboBox3.isSelected()) {
            attemptFilter.add("3");
        }
        if(ComboBox2.isSelected()) {
            attemptFilter.add("2");
        }
        if(ComboBox1.isSelected()) {
            attemptFilter.add("1");
        }
        if(ComboBox0.isSelected()) {
            attemptFilter.add("0");
        }
        
        // Create an array list to store the selected status
        ArrayList<String> statusFilter = new ArrayList<> ();
        if(notStartedComboBox.isSelected()) {
            statusFilter.add("Haven't Started");
        }
        if(startedComboBox.isSelected()) {
            statusFilter.add("In Progress");
        }
        if(doneComboBox.isSelected()) {
            statusFilter.add("Done");
        }
        
        // Create an array list to store the selected status
        ArrayList<String> resultFilter = new ArrayList<> ();
        if(pendingComboBox.isSelected()) {
            resultFilter.add("Pending");
        }
        if(passComboBox.isSelected()) {
            resultFilter.add("Passed");
        }
        if(failComboBox.isSelected()) {
            resultFilter.add("Failed");
        }
        
        // Convert array lists to arrays
        String[] failedFil = failedFilter.toArray(new String[0]);
        String[] attemptFil = attemptFilter.toArray(new String[0]);
        String[] statusFil = statusFilter.toArray(new String[0]);
        String[] resultFil = resultFilter.toArray(new String[0]);
        
        // Call recovery_plan_page method from Course Recovery Plan Page to apply the filter
        recovery_plan_page.applyFilter(failedFil, attemptFil, statusFil, resultFil);
        
        // Close this page
        this.setVisible(false);
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
    private javax.swing.JCheckBox ComboBox0;
    private javax.swing.JCheckBox ComboBox1;
    private javax.swing.JCheckBox ComboBox2;
    private javax.swing.JCheckBox ComboBox3;
    private javax.swing.JButton applyBtn;
    private javax.swing.JCheckBox assignmentComboBox;
    private javax.swing.JCheckBox bothComboBox;
    private javax.swing.JCheckBox doneComboBox;
    private javax.swing.JCheckBox examComboBox;
    private javax.swing.JCheckBox failComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JCheckBox notStartedComboBox;
    private javax.swing.JCheckBox passComboBox;
    private javax.swing.JCheckBox pendingComboBox;
    private javax.swing.JCheckBox startedComboBox;
    // End of variables declaration//GEN-END:variables
}
