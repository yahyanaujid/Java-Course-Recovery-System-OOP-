/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Academic_Performance_Reporting;

// Import classes
import Classes.*;
import Course_Recovery_Plan.Login_Page;
// Import other packages
import Course_Recovery_Plan.Officer_Profile_Page;
import User_Management.LogService;
import User_Management.UserManagementPage;

// To get the current date and time
import java.time.LocalDateTime;

public class Selection_Page extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Selection_Page.class.getName());
    
    //Declare variable
    private String studentID;
    private String studentName;
    private User user;
    
    // Constructor
    public Selection_Page(String studentID, String studentName, User user) {
        this.user = user;
        //Assigning value to variables
        this.studentID = studentID;
        this.studentName = studentName;
        
        initBG();
        initComponents();
        //Run loadYears method
        loadYears();
        
        //Set Label text to variable value
        idLbl.setText(studentID);
        nameLbl.setText(studentName);
        
        // Make function panel fully transparent
        functionPanel.setOpaque(false);
        
        // Call Action Listener for each button
        officerProfileBtn.addActionListener(e -> {
            new Officer_Profile_Page(user).setVisible(true);
            this.setVisible(false);
        });
        managementBtn.addActionListener(e -> {
            new UserManagementPage(user).setVisible(true);
            this.setVisible(false);
        });
        reportBtn.addActionListener(e -> {
            new Academic_Performance_Reporting_Page(user).setVisible(true);
            this.setVisible(false);
        });
        viewBtn.addActionListener(e -> viewReport());
        returnBtn.addActionListener(e -> {
            new Academic_Performance_Reporting_Page(user).setVisible(true);
            this.setVisible(false);
        });
        
        setAutoLogout();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        functionPanel = new javax.swing.JPanel();
        officerProfileBtn = new javax.swing.JButton();
        managementBtn = new javax.swing.JButton();
        reportBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        idLbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        semCB = new javax.swing.JComboBox<>();
        returnBtn = new javax.swing.JButton();
        viewBtn = new javax.swing.JButton();
        yearCB = new javax.swing.JComboBox<>();

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
        setTitle("Selection Page");

        officerProfileBtn.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        officerProfileBtn.setForeground(new java.awt.Color(153, 153, 153));
        officerProfileBtn.setText("User \nProfile");
        officerProfileBtn.setPreferredSize(new java.awt.Dimension(180, 90));

        managementBtn.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        managementBtn.setForeground(new java.awt.Color(153, 153, 153));
        managementBtn.setText("<html><center>User<br/>Management<center/><html/>");
        managementBtn.setPreferredSize(new java.awt.Dimension(180, 90));

        reportBtn.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        reportBtn.setForeground(new java.awt.Color(153, 153, 153));
        reportBtn.setText("<html><center>Academic<br/>Performance<br/>Reporting<center/><html/>");
        reportBtn.setPreferredSize(new java.awt.Dimension(180, 90));

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
                    .addComponent(reportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(managementBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel1.setText("StudentID:");

        idLbl.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        idLbl.setText("(StudentID)");

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel3.setText("Student Name:");

        nameLbl.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        nameLbl.setText("(Student Name)");

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel5.setText("Semester:");

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel6.setText("Year:");

        semCB.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        semCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        returnBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        returnBtn.setText("Return");

        viewBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        viewBtn.setText("View Report");

        yearCB.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        yearCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(functionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(viewBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(returnBtn)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLbl)
                    .addComponent(idLbl)
                    .addComponent(semCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(functionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLbl)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nameLbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(yearCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(semCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnBtn)
                    .addComponent(viewBtn))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Method 1: Change the background
    private void initBG() {
        // Get the path of background image
        Background background = new Background("C:\\Users\\yu en\\OneDrive\\Documents\\Y2S1\\OODJ\\Assignment\\images\\interfaceBG.jpg");

        // allow components on top of the background
        background.setLayout(null);

        // Use this panel as the whole page
        setContentPane(background);
    }
    
    //Method 2: Loads all academic years the student has studied and populates the year dropdown
    private void loadYears() {
        ReportService rs = new ReportService();
        //Get the years the student has studied in based on studentID from ReportService
        //Assign the years to a variable(years) that will hold the array 
        String[] years = rs.getYearsForStudent(studentID);

        yearCB.removeAllItems();    //Clearing dropdown list
        
        //For every year the student has studied in, add into dropdown list
        for (String y : years) {
            yearCB.addItem(y);
        }
        
        //Run loadSemesters method
        loadSemesters(); 
    }

    //Method 3: Loads available semesters for the selected year and updates the semester dropdown.
    private void loadSemesters() {
        //Get what is selected in the year ComboBox and store as String
        String selectedYear = (String) yearCB.getSelectedItem();
        //Return if year is not chosen
        if (selectedYear == null) 
            return;

        //Get available semester based on studentID and the selected year
        ReportService rs = new ReportService();
        String[] sems = rs.getSemestersForStudent(studentID, selectedYear);
        
        semCB.removeAllItems();     //Clearing dropdown list
        //Add an option to choose all semesters to print annual report
        semCB.addItem("All");      
        
        //For every available semester, add it into dropdown list
        for (String s : sems) {
            semCB.addItem(s);
        }
    }

    //Method 4: view report page
    private void viewReport() {
        //Get selected year and semester
        String year = (String) yearCB.getSelectedItem();
        String semester = (String) semCB.getSelectedItem();

        //Send selected year and semester to the next page
        Report_Page nextPage = new Report_Page(studentID, studentName, year, semester, user);
        nextPage.setVisible(true);      //Show next page

        this.setVisible(false);         //Hide this page
    }
        
    // Method 5: When user terminate system, the log will also be saved
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
    private javax.swing.JPanel functionPanel;
    private javax.swing.JLabel idLbl;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton managementBtn;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JButton officerProfileBtn;
    private javax.swing.JButton reportBtn;
    private javax.swing.JButton returnBtn;
    private javax.swing.JComboBox<String> semCB;
    private javax.swing.JButton viewBtn;
    private javax.swing.JComboBox<String> yearCB;
    // End of variables declaration//GEN-END:variables
}
