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

import javax.swing.table.DefaultTableModel; 

public class Report_Page extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Report_Page.class.getName());
    
    // Declare variable
    private User user;
    
    // Constructor
    public Report_Page(String studentID, String studentName, String year, String semester, User user) {
        this.user = user;
        
        initBG();
        initComponents();
        //Run loadReportData method
        loadReportData(studentID, year, semester);
        
        // Make function panel fully transparent
        functionPanel.setOpaque(false);
        
        //Set label texts
        idLbl.setText(studentID);
        nameLbl.setText(studentName);
        ysLbl.setText("(" + year + ": " + semester + ")");
           
        // Call Action Listener for each button
        exportBtn.addActionListener(e -> exportToPDF());
        returnBtn.addActionListener(e -> {
            new Selection_Page(idLbl.getText(), nameLbl.getText(), user).setVisible(true);
            this.setVisible(false);
        });
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
        gpa1Lbl = new javax.swing.JLabel();
        ysLbl = new javax.swing.JLabel();
        gpa2Lbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        gpa3Lbl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cgpaLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        idLbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reportTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        exportBtn = new javax.swing.JButton();
        returnBtn = new javax.swing.JButton();

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
        setTitle("Report Page");

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

        gpa1Lbl.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        gpa1Lbl.setText("(gpa1)");

        ysLbl.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        ysLbl.setText("(YEAR, SEMESTER)");

        gpa2Lbl.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        gpa2Lbl.setText("(gpa2)");

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel2.setText("CGPA:");

        gpa3Lbl.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        gpa3Lbl.setText("(gpa3)");

        cgpaLbl.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        cgpaLbl.setText("(cgpa)");

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel1.setText("StudentID:");

        idLbl.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        idLbl.setText("(StudentID)");

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel3.setText("Student Name:");

        nameLbl.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        nameLbl.setText("(Student Name)");

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel4.setText("GPA:");

        reportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CourseID", "Course Name", "Credits", "Grade Point", "Grade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(reportTable);
        if (reportTable.getColumnModel().getColumnCount() > 0) {
            reportTable.getColumnModel().getColumn(0).setResizable(false);
            reportTable.getColumnModel().getColumn(0).setPreferredWidth(30);
            reportTable.getColumnModel().getColumn(1).setResizable(false);
            reportTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            reportTable.getColumnModel().getColumn(2).setResizable(false);
            reportTable.getColumnModel().getColumn(2).setPreferredWidth(20);
            reportTable.getColumnModel().getColumn(3).setResizable(false);
            reportTable.getColumnModel().getColumn(3).setPreferredWidth(30);
            reportTable.getColumnModel().getColumn(4).setResizable(false);
            reportTable.getColumnModel().getColumn(4).setPreferredWidth(15);
        }

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel5.setText("*For more detailed report, click Export to view in PDF. ");

        exportBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        exportBtn.setText("Export");

        returnBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        returnBtn.setText("Return");

        javax.swing.GroupLayout functionPanelLayout = new javax.swing.GroupLayout(functionPanel);
        functionPanel.setLayout(functionPanelLayout);
        functionPanelLayout.setHorizontalGroup(
            functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(functionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, functionPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameLbl))
                    .addComponent(gpa2Lbl, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gpa3Lbl, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, functionPanelLayout.createSequentialGroup()
                        .addGroup(functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(functionPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2))
                            .addGroup(functionPanelLayout.createSequentialGroup()
                                .addComponent(ysLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)))
                        .addGap(25, 25, 25)
                        .addGroup(functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gpa1Lbl, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cgpaLbl, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(functionPanelLayout.createSequentialGroup()
                        .addComponent(officerProfileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(managementBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(functionPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exportBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(returnBtn)))
                .addContainerGap())
        );
        functionPanelLayout.setVerticalGroup(
            functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(functionPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(officerProfileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(managementBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLbl)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(nameLbl))
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ysLbl)
                        .addComponent(gpa1Lbl)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gpa2Lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gpa3Lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cgpaLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exportBtn)
                    .addComponent(returnBtn)
                    .addComponent(jLabel5))
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(functionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(functionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    //Method 2: Loads and displays the student's grade records into the report table, and calculates GPA/CGPA.
    private void loadReportData(String studentID, String selectedYear, String selectedSemester) {
        
        //Create table
        DefaultTableModel model = (DefaultTableModel) reportTable.getModel();
        model.setRowCount(0);       //Clear table
        
        //Load data from CourseService into an array 
        CourseService cs = new CourseService();
        Course[] courses = cs.loadData();   
        
        //Load data from StudentGradeService into an array        
        StudentGradeService sgs = new StudentGradeService();
        StudentGrade[] grades = sgs.loadData();

        //If selected semester is not all
        if (!selectedSemester.equals("All")) {
            //Declaring and initializing variable
            double totalCredits = 0;
            double totalGpa = 0;

            //For every grade obtained from StudentGrade
            for (StudentGrade sg : grades) {

                //If the record’s studentID and year is not equal to the selected studentID and year then skip
                if (!sg.getStudentID().equals(studentID)) continue;
                if (!sg.getYear().equalsIgnoreCase(selectedYear)) continue;

                //Get courseID,grade and gradePoint from StudentGrade
                String courseID = sg.getCourseID();
                String grade = sg.getGrade();
                //Double.parseDouble is used to convert String into double
                double gradePoint = sg.getGradePoint();     

                //For every course obtained from Course
                for (Course c : courses) {

                    //If the record’s courseID and semeste and is not equal to the selected courseID and semester then skip
                    if (!c.getCourseID().equals(courseID)) continue;
                    if (!c.getSemester().equals(selectedSemester)) continue;

                    //Declare and assign get value which is converted to integer to variable
                    int credits = Integer.parseInt(c.getCredits());

                    //Add value into table
                    model.addRow(new Object[]{
                        courseID,
                        c.getCourseName(),
                        credits,
                        gradePoint,
                        grade
                    });

                    //Calculating total credits and gpa
                    totalCredits += credits;
                    totalGpa += credits * gradePoint;
                }
            }
            //Declare variable
            double semGPA ;
            
            //If there isn't any credit then there won't be any gpa
            if (totalCredits == 0) {
                semGPA = 0;
            } else {
                semGPA = totalGpa / totalCredits;   //Calculation for gpa
            }
                    
            //Set text for gpa label
            gpa1Lbl.setText(String.format("%.2f", semGPA)); 
            gpa1Lbl.setVisible(true);
            //Hide all other gpa and cgpa labels that are not used in annual report
            gpa2Lbl.setVisible(false);
            gpa3Lbl.setVisible(false);
            cgpaLbl.setVisible(false);
            jLabel2.setVisible(false);
            return;
        }
        else{
            //Declaring and initializing variables
            double sem1Cred = 0;
            double sem1Gpa = 0;
            
            double sem2Cred = 0; 
            double sem2Gpa = 0;
            
            double sem3Cred = 0;
            double sem3Gpa = 0;
            
            double totalCredits = 0;
            double totalGpa = 0;


            //For every grade obtained from StudentGrade
            for (StudentGrade sg : grades) {

                //If the record’s studentID and year is not equal to the selected studentID and year then skip
                if (!sg.getStudentID().equals(studentID)) continue;
                if (!sg.getYear().equalsIgnoreCase(selectedYear)) continue;

                //Get courseID,grade and gradePoint from StudentGrade
                String courseID = sg.getCourseID();
                String grade = sg.getGrade();
                //Double.parseDouble is used to convert String into double
                double gradePoint = sg.getGradePoint();     

                //For every course obtained from Course
                for (Course c : courses) {

                    //If the record’s courseID and is not equal to the selected courseID then skip
                    if (!c.getCourseID().equals(courseID)) continue;

                    //Declare and assign get value which is converted to integer to variable
                    int credits = Integer.parseInt(c.getCredits());     
                    

                    //Add value into table
                    model.addRow(new Object[]{
                        courseID,
                        c.getCourseName(),
                        credits,
                        gradePoint,
                        grade
                    });
                    
                    //Check which semester it is then set the labels accordingly
                    if (c.getSemester().equals("Spring")) { 
                        //Calculate total credits and gpa for this semester
                        sem1Cred += credits;                 
                        sem1Gpa += credits * gradePoint; 
                    }
                    else if (c.getSemester().equals("Summer")) { 
                        //Calculate total credits and gpa for this semester
                        sem2Cred += credits;
                        sem2Gpa += credits * gradePoint;
                    }
                    else if (c.getSemester().equals("Fall")) { 
                        //Calculate total credits and gpa for this semester
                        sem3Cred += credits;
                        sem3Gpa += credits * gradePoint;
      
                    //Calculating total credits and gpa
                    totalCredits += credits;
                    totalGpa += credits * gradePoint;
                }
            }
        }
        //Semester 1 GPA
        if (sem1Cred == 0) {
            //If no credit set gpa to "-"
            gpa1Lbl.setText("-");
        } else {
            //Calculate gpa then set it to label
            gpa1Lbl.setText("Spring: " +String.format("%.2f", sem1Gpa / sem1Cred));
        }

        // Semester 2 GPA
        if (sem2Cred == 0) {
            //If no credit set gpa to "-"
            gpa2Lbl.setText("-");
        } else {
            //Calculate gpa then set it to label
            gpa2Lbl.setText("Summer: " +String.format("%.2f", sem2Gpa / sem2Cred));
        }

        // Semester 3 GPA
        if (sem3Cred == 0) {
            //If no credit set gpa to "-"
            gpa3Lbl.setText("-");
        } else {
            //Calculate gpa then set it to label
            gpa3Lbl.setText("Fall: " +String.format("%.2f", sem3Gpa / sem3Cred));
        }
        
        //Set labels to visible
        gpa1Lbl.setVisible(true);
        gpa2Lbl.setVisible(true);
        gpa3Lbl.setVisible(true);
        
        //Declare variable
        double cgpa;
        
        //If no credits then cgpa equals to 0
        if (totalCredits == 0) {
            cgpa = 0;
        } else {
            //Calculate cgpa
            cgpa = totalGpa / totalCredits;
        }
        
        //Set label to visible and display cgpa
        cgpaLbl.setText(String.format("%.2f", cgpa));
        cgpaLbl.setVisible(true);
        jLabel2.setVisible(true);
        }
    }
    
    //Method 3: Opens the PDF export confirmation window with the student's details.
    private void exportToPDF() {
        //Declare variable then get text from label and assign to it
        String studentID = idLbl.getText();
        String studentName = nameLbl.getText();
        String ys = ysLbl.getText();
        
        //Display pop up message
        ExportPDF_Confirmation_Page nextPage = new ExportPDF_Confirmation_Page(studentID, studentName, ys);
        nextPage.setVisible(true);
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
    private javax.swing.JLabel cgpaLbl;
    private javax.swing.JButton exportBtn;
    private javax.swing.JPanel functionPanel;
    private javax.swing.JLabel gpa1Lbl;
    private javax.swing.JLabel gpa2Lbl;
    private javax.swing.JLabel gpa3Lbl;
    private javax.swing.JLabel idLbl;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton managementBtn;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JButton officerProfileBtn;
    private javax.swing.JButton reportBtn;
    private javax.swing.JTable reportTable;
    private javax.swing.JButton returnBtn;
    private javax.swing.JLabel ysLbl;
    // End of variables declaration//GEN-END:variables
}
