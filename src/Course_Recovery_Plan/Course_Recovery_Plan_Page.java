/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Course_Recovery_Plan;

// Import classes
import Classes.*;
// Import other packages
import Eligibility_Check_and_Enrolment.*;
import User_Management.LogService;

// For array list purposes
import java.util.ArrayList;
// For table purposes
import javax.swing.table.DefaultTableModel;
// Get the current date and time
import java.time.LocalDateTime;
// To show pop up message
import javax.swing.JOptionPane;

public class Course_Recovery_Plan_Page extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Course_Recovery_Plan_Page.class.getName());
    
    /// Declare variable
    private User user;
    
    // Call RetakeService
    RetakeService rs = new RetakeService();
    // Get the array of all rows from RetakeDB
    Retake[] retake = rs.loadData();
    
    // Constructor
    public Course_Recovery_Plan_Page(User user) {
        this.user = user;
        
        initBG();
        initComponents();
        
        // Load the table of all retake student
        loadTable();
        // Only allow single row selection
        failedRecordTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        
        // Make function panel fully transparent
        functionPanel.setOpaque(false);
        
        // Call Action Listener for each button
        adminProfileBtn.addActionListener(e -> {
            new Course_Admin_Profile_Page(user).setVisible(true);
            this.setVisible(false);
        });
        enrolmentBtn.addActionListener(e -> {
            new EligibilityFrame(user).setVisible(true);
            this.setVisible(false);
        });
        filterBtn.addActionListener(e -> new Filter_Page(this).setVisible(true));
        viewRecBtn.addActionListener(e -> viewRec());
        viewPlanBtn.addActionListener(e -> viewPlan());
        
        setAutoLogout();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        failedRecordTable = new javax.swing.JTable();
        functionPanel = new javax.swing.JPanel();
        adminProfileBtn = new javax.swing.JButton();
        enrolmentBtn = new javax.swing.JButton();
        recoveryBtn = new javax.swing.JButton();
        filterBtn = new javax.swing.JButton();
        viewPlanBtn = new javax.swing.JButton();
        viewRecBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Course Recovery Plan");

        failedRecordTable.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        failedRecordTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "RetakeID", "CourseID", "StudentID", "Failed Component", "Attempt Lefts", "Status", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(failedRecordTable);
        if (failedRecordTable.getColumnModel().getColumnCount() > 0) {
            failedRecordTable.getColumnModel().getColumn(0).setResizable(false);
            failedRecordTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            failedRecordTable.getColumnModel().getColumn(1).setResizable(false);
            failedRecordTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            failedRecordTable.getColumnModel().getColumn(2).setResizable(false);
            failedRecordTable.getColumnModel().getColumn(2).setPreferredWidth(53);
            failedRecordTable.getColumnModel().getColumn(3).setResizable(false);
            failedRecordTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            failedRecordTable.getColumnModel().getColumn(4).setResizable(false);
            failedRecordTable.getColumnModel().getColumn(4).setPreferredWidth(70);
            failedRecordTable.getColumnModel().getColumn(5).setResizable(false);
            failedRecordTable.getColumnModel().getColumn(5).setPreferredWidth(70);
            failedRecordTable.getColumnModel().getColumn(6).setResizable(false);
            failedRecordTable.getColumnModel().getColumn(6).setPreferredWidth(55);
        }

        adminProfileBtn.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        adminProfileBtn.setForeground(new java.awt.Color(153, 153, 153));
        adminProfileBtn.setText("User Profile");
        adminProfileBtn.setPreferredSize(new java.awt.Dimension(180, 90));

        enrolmentBtn.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        enrolmentBtn.setForeground(new java.awt.Color(153, 153, 153));
        enrolmentBtn.setText("<html><center>Eligibility<br/>Check and<br/>Enrolment<center/><html/>");
        enrolmentBtn.setPreferredSize(new java.awt.Dimension(180, 90));

        recoveryBtn.setFont(new java.awt.Font("Modern No. 20", 1, 24)); // NOI18N
        recoveryBtn.setForeground(new java.awt.Color(53, 53, 53));
        recoveryBtn.setText("<html><center>Course<br/>Recovery<br/>Plan<center/><html/>");
        recoveryBtn.setPreferredSize(new java.awt.Dimension(180, 90));

        javax.swing.GroupLayout functionPanelLayout = new javax.swing.GroupLayout(functionPanel);
        functionPanel.setLayout(functionPanelLayout);
        functionPanelLayout.setHorizontalGroup(
            functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, functionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adminProfileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recoveryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enrolmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        functionPanelLayout.setVerticalGroup(
            functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, functionPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(enrolmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(recoveryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(adminProfileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        filterBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        filterBtn.setText("Filter");

        viewPlanBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        viewPlanBtn.setText("View Recovery Plan");

        viewRecBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        viewRecBtn.setText("View Recommendation");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filterBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(viewPlanBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(viewRecBtn)))))
                .addContainerGap())
            .addComponent(functionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(functionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewPlanBtn)
                    .addComponent(viewRecBtn))
                .addGap(9, 9, 9))
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
    
    // Method 2: Load the table with data from RetakeDB
    public void loadTable() {
        // Uses TableModel to store table row and column
        DefaultTableModel model = (DefaultTableModel) failedRecordTable.getModel();
        // Clear table
        model.setRowCount(0);
        
        // Assign each row into the table
        for(int i = 0; i < retake.length; i++) {
            Retake r = retake[i];
            model.addRow(new Object[] {
                r.getRetakeID(),
                r.getCourseID(),
                r.getStudentID(),
                r.getFailedComponent(),
                r.getAttemptLefts(),
                r.getProgressStatus(),
                r.getRecoveryResult()
            });
        }
    }
    
    // Method 3: Go to View Recommendation Page
    private void viewRec() {
        // Get the selected row
        int selectedRow = failedRecordTable.getSelectedRow();
        
        // Check if there is any row selected by the user
        if (selectedRow == -1) {
            // No row selected
            JOptionPane.showMessageDialog(this,"Please select a row.");
            return;
        }
        else {
            // Get the model of the table
            DefaultTableModel model = (DefaultTableModel) failedRecordTable.getModel();
            
            // Get the progress status from selected row and at column 5
            String status = model.getValueAt(selectedRow, 5).toString();
            
            // Check if the progress status is not "Done"
            if(!status.equals("Done")){
                // Get the failedComponent from selectedRow and at column 3
                String failedComponent = model.getValueAt(selectedRow, 3).toString();
                
                // Get the studentID for email
                String studentID = model.getValueAt(selectedRow, 2).toString();
                
                // Go to Recommendation Page
                Recommendation_Page recommendation_page = new Recommendation_Page(user, failedComponent, studentID);
                recommendation_page.setVisible(true);
                this.setVisible(false);
            }
            // Show message notifying that the student have done the retake
            else{
                JOptionPane.showMessageDialog(this,"This student have done their retake.");
                return;
            }
        }
    }
    
    // Method 4: Go to View Recovery Plan Page
    private void viewPlan() {
        // Get the selected row
        int selectedRow = failedRecordTable.getSelectedRow();
        
        // Check if there is any row selected by the user
        if (selectedRow == -1){
            // No row selected
            JOptionPane.showMessageDialog(this,"Please select a row.");
            return;
        }
        else{
            // Get the model of the table
            DefaultTableModel model = (DefaultTableModel) failedRecordTable.getModel();
            
            // Get the progress status from selected row and at column 5
            String status = model.getValueAt(selectedRow, 5).toString();
            
            // Check if the progress status is not "Done"
            if(!status.equals("Done")){
                // Get the failedComponent from selected row and at column 3
                String failedComponent = model.getValueAt(selectedRow, 3).toString();
                
                // Get the studentID for email
                String studentID = model.getValueAt(selectedRow, 2).toString();
                
                // Go to Recovery Plan Page
                Recovery_Plan_Page recovery_plan_page = new Recovery_Plan_Page(user, failedComponent, studentID);
                recovery_plan_page.setVisible(true);
                this.setVisible(false);
            }
            // Show message notifying that the student have done the retake
            else{
                JOptionPane.showMessageDialog(this,"This student have done their retake.");
                return;
            }
        }
    }
    
    // Method 5: Apply filter to the table
    public void applyFilter(String[] failedFil, String[] attemptFil, String[] statusFil, String[] resultFil) {
        // Uses TableModel to store table row and column
        DefaultTableModel model = (DefaultTableModel) failedRecordTable.getModel();
        // Clear table
        model.setRowCount(0);
        
        // Loop through every row in table
        for(int i = 0; i < retake.length; i++) {
            Retake r = retake[i];
            
            // Set all to false when there are no filter
            boolean matchFailed = (failedFil.length == 0);
            boolean matchAttempt = (attemptFil.length == 0);
            boolean matchStatus = (statusFil.length == 0);
            boolean matchResult = (resultFil.length == 0);
            
            // Failed Component Filter
            if(failedFil.length > 0) {
                // Loop through the failedFil array
                for(int j = 0; j < failedFil.length; j++) {
                    // Check if the table row failed component matches the the element inside failedFil array
                    if(r.getFailedComponent().equals(failedFil[j])) {
                        // Set to true if match
                        matchFailed = true;
                        break;
                    }
                }
            }
            
            // Attempt Lefts Filter
            if(attemptFil.length > 0) {
                // Set the attempt to String
                String attempt = String.valueOf(r.getAttemptLefts());
                // Loop through the attemptFil array
                for(int k = 0; k < attemptFil.length; k++) {
                    // Check if the table row attempt left matches the the element inside attemptFil array
                    if(attempt.equals(attemptFil[k])) {
                        // Set to true if match
                        matchAttempt = true;
                        break;
                    }
                }
            }
            
            // Progress Status Filter
            if(statusFil.length > 0) {
                // Loop through the statusFil array
                for(int l = 0; l < statusFil.length; l++) {
                    // Check if the table row progress status matches the the element inside statusFil array
                    if(r.getProgressStatus().equals(statusFil[l])) {
                        // Set to true if match
                        matchStatus = true;
                        break;
                    }
                }
            }
            
            // Recovery Result Filter
            if(resultFil.length > 0) {
                // Loop through the resultFil array
                for(int m = 0; m < resultFil.length; m++) {
                    // Check if the table row recovery result matches the the element inside resultFil array
                    if(r.getRecoveryResult().equals(resultFil[m])) {
                        // Set to true if match
                        matchResult = true;
                        break;
                    }
                }
            }
            
            // Only add row if it matches all selected filters
            if(matchFailed && matchAttempt && matchStatus && matchResult) {
                model.addRow(new Object[] {
                    r.getRetakeID(),
                    r.getCourseID(),
                    r.getStudentID(),
                    r.getFailedComponent(),
                    r.getAttemptLefts(),
                    r.getProgressStatus(),
                    r.getRecoveryResult()
                });
            }
        }
    }
    
    // Method 6: When user terminate system, the log will also be saved
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
    private javax.swing.JButton enrolmentBtn;
    private javax.swing.JTable failedRecordTable;
    private javax.swing.JButton filterBtn;
    private javax.swing.JPanel functionPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton recoveryBtn;
    private javax.swing.JButton viewPlanBtn;
    private javax.swing.JButton viewRecBtn;
    // End of variables declaration//GEN-END:variables
}
