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
// For table purposes
import javax.swing.table.DefaultTableModel;

public class Course_Selection_Page extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Course_Selection_Page.class.getName());

    // Declare variable
    private String studentID;
    private User user;
    private String courseID;
    private Add_Grade_Page add_grade_page;
    
    // Call CourseService
    CourseService cs = new CourseService();
    
    // Call StudentGradeService
    StudentGradeService sgs = new StudentGradeService();
    
    // Constructor
    public Course_Selection_Page(User user, String studentID, Add_Grade_Page add_grade_page) {
        this.user = user;
        this.studentID = studentID;
        this.add_grade_page = add_grade_page;
        
        initComponents();
        loadTable();
        
        // Call Action Listener for each button
        selectBtn.addActionListener(e -> selectCourse());
        
        setAutoLogout();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        courseTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        selectBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Course Selection Page");

        courseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CourseID", "Course Name", "Credits", "Semester", "Instructor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(courseTable);
        if (courseTable.getColumnModel().getColumnCount() > 0) {
            courseTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            courseTable.getColumnModel().getColumn(1).setPreferredWidth(130);
            courseTable.getColumnModel().getColumn(2).setPreferredWidth(30);
            courseTable.getColumnModel().getColumn(3).setPreferredWidth(70);
            courseTable.getColumnModel().getColumn(4).setPreferredWidth(70);
        }

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel1.setText("Please select a course");

        selectBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        selectBtn.setText("Select");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(selectBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(selectBtn)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Method 1: Load course table
    private void loadTable() {
        DefaultTableModel model = (DefaultTableModel) courseTable.getModel(); 
        model.setRowCount(0);        // Clear table
        
        Course[] course = cs.loadData();
        
        
        for(int i = 0; i < course.length; i++) {
            //Creating a new row with their studentID, first name, last name, and year, then add that row to the table.
            model.addRow(new Object[]{
                course[i].getCourseID(),
                course[i].getCourseName(),
                course[i].getCredits(),
                course[i].getSemester(),
                course[i].getInstructor()
            });
        }
    }
    
    // Method 2: Select course
    private void selectCourse() {
        //Get the index of the selected row
        int row = courseTable.getSelectedRow();
        
        //Check if there is a selected row, first row has an index of 0, so if index = -1, means no row selected.
        if(row == -1) {
            //Show error message if no row selected.
            JOptionPane.showMessageDialog(this, "Please select a course from the table.");
            return;
        }
        //Get courseID of the selected row
        courseID = courseTable.getValueAt(row, 0).toString();
        String selectedCourseName = courseTable.getValueAt(row, 1).toString();
            
        StudentGrade[] grade = sgs.loadData();
        Course[] course = cs.loadData();
            
        for(StudentGrade sGrade: grade) {
            if(sGrade.getStudentID().equals(studentID) && sGrade.getCourseID().equals(courseID)) {
               JOptionPane.showMessageDialog(this, "This student have already taken this course. The result is " + sGrade.getGradePoint() + "\n Please choose another course.");
                return;
            }
        }
            
        for(StudentGrade sGrade: grade){
            if (!sGrade.getStudentID().equals(studentID)) {
                continue;
            }
            for(Course c: course) {
                if(c.getCourseID().equals(sGrade.getCourseID()) && c.getCourseName().equals(selectedCourseName)) {
                    JOptionPane.showMessageDialog(this, "This student have already taken the course " + selectedCourseName + ".\nPlease choose another course.");
                    return;
                }
            }
        }
        add_grade_page.setCourseIDLbl(courseID);
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
    private javax.swing.JTable courseTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton selectBtn;
    // End of variables declaration//GEN-END:variables
}
