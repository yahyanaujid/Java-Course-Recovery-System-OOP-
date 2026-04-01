/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Academic_Performance_Reporting;

// Import Classes
import Classes.*;
// Import other packages
import Course_Recovery_Plan.Login_Page;
import User_Management.LogService;

// To get the current date and time
import java.time.LocalDateTime;
// To show pop up message
import javax.swing.JOptionPane;

public class Add_Grade_Page extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Add_Grade_Page.class.getName());

    // Declare variable
    private User user;
    private String studentID;
    
    // Call RetakeService
    RetakeService rs = new RetakeService();
    
    // Call StudentGradeService
    StudentGradeService sgs = new StudentGradeService();
    
    // Constructor
    public Add_Grade_Page(User user, String studentID) {
        this.user = user;
        this.studentID = studentID;
        
        initComponents();
        fillUserDetails();
        
        addBtn.setVisible(false);
        
        // Call Action Listener for each button
        chooseBtn.addActionListener(e -> {
            Course_Selection_Page course_selection = new Course_Selection_Page(user, studentID, this);
            course_selection.setVisible(true);
        });
        returnBtn.addActionListener(e -> {
            new Academic_Performance_Reporting_Page(user).setVisible(true);
            this.setVisible(false);
        });
        addBtn.addActionListener(e -> addGrade());
        gradePointCB.addActionListener(e -> {
            if (gradePointCB.getSelectedItem() != null) {
                double gradePoint = Double.parseDouble(gradePointCB.getSelectedItem().toString());
                String grade = getGradeFromPoint(gradePoint);
                gradeLbl.setText(grade);
            }
        });
        
        setAutoLogout();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        studentIDLbl = new javax.swing.JLabel();
        courseIDLbl = new javax.swing.JLabel();
        gradePointCB = new javax.swing.JComboBox<>();
        returnBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        chooseBtn = new javax.swing.JButton();
        gradeLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Grade Page");

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel1.setText("StudentID: ");

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel2.setText("CourseID: ");

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel3.setText("Grade Point: ");

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel4.setText("Grade: ");

        studentIDLbl.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N

        courseIDLbl.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N

        gradePointCB.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        gradePointCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        returnBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        returnBtn.setText("Return");

        addBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        addBtn.setText("Add");

        chooseBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        chooseBtn.setText("Choose Course");

        gradeLbl.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(studentIDLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(courseIDLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                                .addComponent(chooseBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(gradePointCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gradeLbl))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addBtn)
                        .addGap(18, 18, 18)
                        .addComponent(returnBtn)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(studentIDLbl))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(courseIDLbl)
                    .addComponent(chooseBtn))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(gradePointCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(gradeLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnBtn)
                    .addComponent(addBtn))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Method 1: Set prefixed values in the dropdown list
    private void fillUserDetails() {
        studentIDLbl.setText(studentID);
        
        gradePointCB.removeAllItems();
        gradePointCB.addItem("4.0");
        gradePointCB.addItem("3.7");
        gradePointCB.addItem("3.3");
        gradePointCB.addItem("3.0");
        gradePointCB.addItem("2.7");
        gradePointCB.addItem("2.3");
        gradePointCB.addItem("2.0");
        gradePointCB.addItem("1.7");
        gradePointCB.addItem("1.3");
        gradePointCB.addItem("1.0");
        gradePointCB.addItem("0.0");
        
        gradeLbl.setText("A+");
    }
    
    // Method 2: Add grade for student
    private void addGrade() {
        String courseID = courseIDLbl.getText();
        double gradePoint = Double.parseDouble(gradePointCB.getSelectedItem().toString());
        String grade = gradeLbl.getText();

        Retake[] retakes = rs.loadData();
        boolean updated = false;     // Track if retake was modified

        for (Retake r : retakes) {

            // Student is retaking this course
            if (r.getStudentID().equals(studentID) && r.getCourseID().equals(courseID)) {

                // Already completed retake
                if (r.getProgressStatus().equals("Done")) continue;

                int attempts = r.getAttemptLefts();

                // 1st Attempt (attempts = 3)
                if (attempts == 3) {

                    if (gradePoint >= 2.0) {   // PASS
                        r.setAttemptLefts(2);
                        r.setFailedComponent("None");
                        r.setProgressStatus("Done");
                        r.setRecoveryResult("Passed");
                        sgs.joinStudentGrade(studentID, courseID, gradePoint, grade);
                    } else {                   // FAIL
                        r.setAttemptLefts(2);
                        r.setProgressStatus("In Progress");
                    }
                }

                // 2nd Attempt (attempts = 2)
                else if (attempts == 2) {

                    if (gradePoint >= 2.0) {   // PASS
                        r.setAttemptLefts(1);
                        r.setFailedComponent("None");
                        r.setProgressStatus("Done");
                        r.setRecoveryResult("Passed");
                        sgs.joinStudentGrade(studentID, courseID, gradePoint, grade);
                    } else {                    // FAIL
                        r.setAttemptLefts(1);
                        r.setFailedComponent("Both");
                    }
                }

                // 3rd Attempt (attempts = 1)
                else {

                    if (gradePoint >= 2.0) {   // PASS
                        r.setAttemptLefts(0);
                        r.setFailedComponent("None");
                        r.setProgressStatus("Done");
                        r.setRecoveryResult("Passed");
                        sgs.joinStudentGrade(studentID, courseID, gradePoint, grade);
                    } else {                   // FAIL → retake ends
                        r.setAttemptLefts(0);
                        r.setProgressStatus("Done");
                        r.setRecoveryResult("Failed");
                        sgs.joinStudentGrade(studentID, courseID, gradePoint, grade);
                    }
                }

                updated = true;
                break;  // No need to continue loop
            }
        }

        // Write updated retake array into DB
        if (updated) {
            rs.writeRetakeDB(retakes);
            Academic_Performance_Reporting_Page reporting_page = new Academic_Performance_Reporting_Page(user);
            reporting_page.setVisible(true);
            this.setVisible(false);
        }

        // If not a retake (normal course)
        if (!updated) {
            if (gradePoint >= 2.0) {
                sgs.joinStudentGrade(studentID, courseID, gradePoint, grade);
                new Academic_Performance_Reporting_Page(user).setVisible(true);
                this.setVisible(false);
            } 
            else {
                new Select_Component_Page(studentID, courseID, user, this).setVisible(true);
            }
        }
    }
    
    // Method 3: Set label to course chosen and allow add grade action
    public void setCourseIDLbl(String courseID) {
        courseIDLbl.setText(courseID);
        addBtn.setVisible(true);
    }
    
    // Method 4: When grade point is selected, automatically display grade
    private String getGradeFromPoint(double gp) {
        if (gp == 4.0) return "A+";
        if (gp == 3.7) return "A";
        if (gp == 3.3) return "B+";
        if (gp == 3.0) return "B";
        if (gp == 2.7) return "C+";
        if (gp == 2.3) return "C";
        if (gp == 2.0) return "C-";
        if (gp == 1.7) return "D";
        if (gp == 1.3) return "F+";
        if (gp == 1.0) return "F";
        if (gp == 0.0) return "F-"; 
        return "";
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
    private javax.swing.JButton addBtn;
    private javax.swing.JButton chooseBtn;
    private javax.swing.JLabel courseIDLbl;
    private javax.swing.JLabel gradeLbl;
    private javax.swing.JComboBox<String> gradePointCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton returnBtn;
    private javax.swing.JLabel studentIDLbl;
    // End of variables declaration//GEN-END:variables
}
