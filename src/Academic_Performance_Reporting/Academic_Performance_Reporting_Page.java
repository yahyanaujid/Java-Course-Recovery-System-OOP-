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
import javax.swing.JOptionPane;
//For table purposes
import javax.swing.table.DefaultTableModel;


public class Academic_Performance_Reporting_Page extends javax.swing.JFrame {
    
    private User user;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Academic_Performance_Reporting_Page.class.getName());
    
    // Cosntructor
    public Academic_Performance_Reporting_Page(User user) {
        this.user = user;
        
        initBG();
        initComponents();
        loadTable();
        
        // Make function panel fully transparent
        functionPanel.setOpaque(false);
        
        studentTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION); //Ensure only single selection is allowed in the table.
        
        // Call Action Listener for each button
        addGradeBtn.addActionListener(e -> addGrade());
        viewReportBtn.addActionListener(e -> selectStudent());
        officerProfileBtn.addActionListener(e -> {
            new Officer_Profile_Page(user).setVisible(true);
            this.setVisible(false);
        });
        managementBtn.addActionListener(e -> {
            new UserManagementPage(user).setVisible(true);
            this.setVisible(false);
        });
        filterBtn.addActionListener(e -> new Filter_Page(this).setVisible(true));
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        viewReportBtn = new javax.swing.JButton();
        filterBtn = new javax.swing.JButton();
        addGradeBtn = new javax.swing.JButton();

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
        setTitle("Academic Performance Reporting Page");

        officerProfileBtn.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        officerProfileBtn.setForeground(new java.awt.Color(153, 153, 153));
        officerProfileBtn.setText("User \nProfile");
        officerProfileBtn.setPreferredSize(new java.awt.Dimension(180, 90));

        managementBtn.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        managementBtn.setForeground(new java.awt.Color(153, 153, 153));
        managementBtn.setText("<html><center>User<br/>Management<center/><html/>");
        managementBtn.setPreferredSize(new java.awt.Dimension(180, 90));

        reportBtn.setFont(new java.awt.Font("Modern No. 20", 1, 24)); // NOI18N
        reportBtn.setForeground(new java.awt.Color(51, 51, 51));
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

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "StudentID", "First Name", "Last Name", "Year"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(studentTable);
        if (studentTable.getColumnModel().getColumnCount() > 0) {
            studentTable.getColumnModel().getColumn(0).setResizable(false);
            studentTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            studentTable.getColumnModel().getColumn(1).setResizable(false);
            studentTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            studentTable.getColumnModel().getColumn(2).setResizable(false);
            studentTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            studentTable.getColumnModel().getColumn(3).setResizable(false);
            studentTable.getColumnModel().getColumn(3).setPreferredWidth(120);
        }

        viewReportBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        viewReportBtn.setText("View Report");

        filterBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        filterBtn.setText("Filter");

        addGradeBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        addGradeBtn.setText("Add Grade");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(functionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filterBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(addGradeBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(viewReportBtn)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(functionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewReportBtn)
                    .addComponent(addGradeBtn))
                .addContainerGap())
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

    //Method 2: Check if the student has result or not
    private boolean hasResults(String studentID) {
        //Getting all grades from StudentGrade
        StudentGradeService sgs = new StudentGradeService();
        StudentGrade[] allGrades = sgs.loadData();

        //For every grade obtained, check if the studentID exists
        for (StudentGrade sg : allGrades) {
            if (sg.getStudentID().equals(studentID)) {
                return true;
            }
        }
            return false;
    }   

    //Method 3
    private void loadTable() {
        DefaultTableModel model = (DefaultTableModel) studentTable.getModel(); 
        model.setRowCount(0);        // Clear table
        
        //Creating studentTable
        StudentService ss = new StudentService();
        Student[] students = ss.loadData();
        
        
        for(int i = 0; i < students.length; i++) {
            //Creating a new row with their studentID, first name, last name, and year, then add that row to the table.
            model.addRow(new Object[]{
                students[i].getStudentID(),
                students[i].getFirstName(),
                students[i].getLastName(),
                students[i].getYear()
            });
        }
    }
    
    //Method 4: select student to generate report
    private void selectStudent() {
        int row = studentTable.getSelectedRow();        //Get the index of the selected row
        
        //Check if there is a selected row, first row has an index of 0, so if index = -1, means no row selected.
        if(row==-1){
            //Show error message if no row selected.
            JOptionPane.showMessageDialog(this, "Please select a student from the table.");
            return;
        }
        
        //Get value at the first,second and third column of selected row and convert to string
        String studentID = studentTable.getValueAt(row, 0).toString();
        String firstName = studentTable.getValueAt(row, 1).toString();
        String lastName = studentTable.getValueAt(row, 2).toString();
        String fullName = firstName + " " + lastName;   //Combine first name and last name to become full name
        
        //Send studentID and full name to the next Page (Selection_Page)
        //Check if student has grade or not
        if (!hasResults(studentID)) {
            //Display a warning message if the student doesn't have grade in database
            javax.swing.JOptionPane.showMessageDialog(this,"This student has no grade in the database.");
            return;
        }

        Selection_Page nextPage = new Selection_Page(studentID, fullName, user);
        nextPage.setVisible(true);      //Show next page
        this.setVisible(false);         //Hide this page
    }
     
    //Method 5: Enable user to filter out the year they want only
    public void applyFilter(String[] yearFil){
        StudentService ss = new StudentService();
        Student[] student = ss.loadData();
        
        DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
        model.setRowCount(0);
        
        for(int i = 0; i < student.length; i++) {
            Student s = student[i];
            
            boolean matchYear = (yearFil.length == 0);
            
            if(yearFil.length > 0) {
                for(int j = 0; j < yearFil.length; j++) {
                    if(s.getYear().equals(yearFil[j])) {
                        matchYear = true;
                        break;
                    }
                }
            }
            
            if(matchYear) {
                model.addRow(new Object[] {
                    s.getStudentID(),
                    s.getFirstName(),
                    s.getLastName(),
                    s.getYear()
                });
            }
        }
    }
    
    // Method 6: Select a student to add grade for and go to add grade page
    private void addGrade() {
        int row = studentTable.getSelectedRow();        //Get the index of the selected row
        
        //Check if there is a selected row, first row has an index of 0, so if index = -1, means no row selected.
        if(row == -1) {
            //Show error message if no row selected.
            JOptionPane.showMessageDialog(this, "Please select a student from the table.");
            return;
        }
        
        // Get the year of the student
        String year = studentTable.getValueAt(row, 3).toString();
        
        if(year.equals("Graduated")) {
            JOptionPane.showMessageDialog(this, "This student have graduated.");
            return;
        }
        
        //Get value at the first,second and third column of selected row and convert to string
        String studentID = studentTable.getValueAt(row, 0).toString();
        
        // Check if that student have graduated
        Add_Grade_Page add_grade_page = new Add_Grade_Page(user, studentID);
        add_grade_page.setVisible(true);
        this.setVisible(false);
    }
    
    // Method 7: When user terminate system, the log will also be saved
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
    private javax.swing.JButton addGradeBtn;
    private javax.swing.JButton filterBtn;
    private javax.swing.JPanel functionPanel;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton managementBtn;
    private javax.swing.JButton officerProfileBtn;
    private javax.swing.JButton reportBtn;
    private javax.swing.JTable studentTable;
    private javax.swing.JButton viewReportBtn;
    // End of variables declaration//GEN-END:variables
}
