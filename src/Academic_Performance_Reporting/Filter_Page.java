/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Academic_Performance_Reporting;

// Import other packages
import Course_Recovery_Plan.Login_Page;
import User_Management.LogService;

// To get the current date and time
import java.time.LocalDateTime;
// For array list purposes
import java.util.ArrayList;

public class Filter_Page extends javax.swing.JFrame {
    
    private Academic_Performance_Reporting_Page reporting_page;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Filter_Page.class.getName());

    // Constructor
    public Filter_Page(Academic_Performance_Reporting_Page reporting_page) {
        this.reporting_page = reporting_page;
        
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
        freshmanCB = new javax.swing.JCheckBox();
        juniorCB = new javax.swing.JCheckBox();
        seniorCB = new javax.swing.JCheckBox();
        sophomoreCB = new javax.swing.JCheckBox();
        applyBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel1.setText("Filters");

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel2.setText("Year");

        freshmanCB.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        freshmanCB.setText("Freshman");

        juniorCB.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        juniorCB.setText("Junior");

        seniorCB.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        seniorCB.setText("Senior");

        sophomoreCB.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        sophomoreCB.setText("Sophomore");

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
                            .addComponent(freshmanCB, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(juniorCB, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(seniorCB, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sophomoreCB, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(freshmanCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sophomoreCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(juniorCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seniorCB)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(applyBtn)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(applyBtn)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Method 1: Collects selected year and filter them in the reporting page
    private void applyFil() {
        ArrayList<String> yearFilter = new ArrayList<> ();
        if(freshmanCB.isSelected()) {
            yearFilter.add("Freshman");
        }
        if(sophomoreCB.isSelected()) {
            yearFilter.add("Sophomore");
        }
        if(juniorCB.isSelected()) {
            yearFilter.add("Junior");
        }
        if(seniorCB.isSelected()) {
            yearFilter.add("Senior");
        }
        
        String[] yearFil = yearFilter.toArray(new String[0]);
        
        reporting_page.applyFilter(yearFil);
        
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
    private javax.swing.JButton applyBtn;
    private javax.swing.JCheckBox freshmanCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox juniorCB;
    private javax.swing.JCheckBox seniorCB;
    private javax.swing.JCheckBox sophomoreCB;
    // End of variables declaration//GEN-END:variables
}
