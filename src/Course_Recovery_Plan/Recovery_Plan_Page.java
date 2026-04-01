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

// To get the current date and time
import java.time.LocalDateTime;
// For table purposes
import javax.swing.table.DefaultTableModel;

public class Recovery_Plan_Page extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Recovery_Plan_Page.class.getName());

    // Declare variables
    private String failedComponent;
    
    // Call MilestoneService
    MilestoneService ms = new MilestoneService();
    // Get the array of all rows from MilestoneDB
    Milestone[] milestone = ms.loadMilestone();
    
    // Constructor
    public Recovery_Plan_Page(User user, String failedComponent, String studentID) {
        this.failedComponent = failedComponent;
        
        initBG();
        initComponents();
        // Load the milestone table
        loadMilestone();
        
        recoveryPlanTable.setRowSelectionAllowed(false);
        recoveryPlanTable.setColumnSelectionAllowed(false);
        
        // Make function panel fully transparent
        functionPanel.setOpaque(false);
        
        // Call Action Listener for each button
        adminProfileBtn.addActionListener(e -> {
            new Course_Admin_Profile_Page(user).setVisible(true);
            this.setVisible(false);
        });
        recoveryBtn.addActionListener(e -> {
            new Course_Recovery_Plan_Page(user).setVisible(true);
            this.setVisible(false);
        });
        enrolmentBtn.addActionListener(e -> {
            new EligibilityFrame(user).setVisible(true);
            this.setVisible(false);
        });
        addBtn.addActionListener(e -> {
            new Add_Milestone_Page(user, failedComponent, studentID).setVisible(true);
            this.setVisible(false);
        });
        updateBtn.addActionListener(e -> {
            new Update_Milestone_Page(user, failedComponent, studentID).setVisible(true);
            this.setVisible(false);
        });
        removeBtn.addActionListener(e -> {
            new Remove_Milestone_Page(user, failedComponent, studentID).setVisible(true);
            this.setVisible(false);
        });
        
        setAutoLogout();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recoveryPlanTable = new javax.swing.JTable();
        functionPanel = new javax.swing.JPanel();
        adminProfileBtn = new javax.swing.JButton();
        enrolmentBtn = new javax.swing.JButton();
        recoveryBtn = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Recovery Plan");

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel1.setText("Recovery Plan");

        recoveryPlanTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Week", "Task"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(recoveryPlanTable);
        if (recoveryPlanTable.getColumnModel().getColumnCount() > 0) {
            recoveryPlanTable.getColumnModel().getColumn(0).setResizable(false);
            recoveryPlanTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            recoveryPlanTable.getColumnModel().getColumn(1).setResizable(false);
            recoveryPlanTable.getColumnModel().getColumn(1).setPreferredWidth(400);
        }

        adminProfileBtn.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        adminProfileBtn.setForeground(new java.awt.Color(153, 153, 153));
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

        javax.swing.GroupLayout functionPanelLayout = new javax.swing.GroupLayout(functionPanel);
        functionPanel.setLayout(functionPanelLayout);
        functionPanelLayout.setHorizontalGroup(
            functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(functionPanelLayout.createSequentialGroup()
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

        removeBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        removeBtn.setText("Remove");

        updateBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        updateBtn.setText("Update");

        addBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        addBtn.setText("Add");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeBtn)))
                .addContainerGap())
            .addComponent(functionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(functionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeBtn)
                    .addComponent(updateBtn)
                    .addComponent(addBtn))
                .addGap(10, 10, 10))
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
    
    // Method 2: Load the milestone table
    private void loadMilestone() {
        // Uses TableModel to store table row and column
        DefaultTableModel table = (DefaultTableModel) recoveryPlanTable.getModel();
        // Clear table
        table.setRowCount(0);
        
        // Create an array to store the original weeks
        String[] week = new String[0];
        // Create an array to store thr original tasks
        String[] task = new String[0];
        
        // Loop through every row in the milestone
        for(int i = 0; i < milestone.length; i++) {
            // Check if the milestone type matches the selected student failed component
            if(milestone[i].getType().equals(failedComponent)) {
                // Get each week and save it in week array
                week = milestone[i].getWeeks();
                // Get each task and save it in task array
                task = milestone[i].getTasks();
                
                // Keep track of the current week or task
                int count = 0;
                
                // While the count doesn't exceed the length, continue looping
                while(count < week.length && count < task.length) {
                    // Assign data to each row 
                    table.addRow(new Object[] {
                        week[count],
                        task[count]
                    });
                    // Increase the count by 1 after each loop
                    count++;
                }
            }
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
    private javax.swing.JButton addBtn;
    private javax.swing.JButton adminProfileBtn;
    private javax.swing.JButton enrolmentBtn;
    private javax.swing.JPanel functionPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton recoveryBtn;
    private javax.swing.JTable recoveryPlanTable;
    private javax.swing.JButton removeBtn;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
