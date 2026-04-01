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

public class Recommendation_Page extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Recommendation_Page.class.getName());

    // Declare variables
    private String failedComponent;
    // Store the original recommendations
    private String[] oriRecommendation;
    
    // Call RecommendationService
    RecommendationService rs = new RecommendationService();
    // Get the array of all rows from RecommendationDB
    Recommendation[] recommendation = rs.loadRecommendations();

    // Constructor
    public Recommendation_Page(User user, String failedComponent, String studentID) {
        this.failedComponent = failedComponent;
        
        initBG();
        initComponents();
        // Load the recommendation table
        loadRecommendation();
        
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
            new Add_Recommendation_Page(user, failedComponent, oriRecommendation, studentID).setVisible(true);
            this.setVisible(false);
        });
        updateBtn.addActionListener(e -> {
            new Update_Recommendation_Page(user, failedComponent, studentID).setVisible(true);
            this.setVisible(false);
        });
        removeBtn.addActionListener(e -> {
            new Remove_Recommendation_Page(user, failedComponent, studentID).setVisible(true);
            this.setVisible(false);
        });
        
        setAutoLogout();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recList = new javax.swing.JList<>();
        functionPanel = new javax.swing.JPanel();
        adminProfileBtn = new javax.swing.JButton();
        enrolmentBtn = new javax.swing.JButton();
        recoveryBtn = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Recommendation");
        setPreferredSize(new java.awt.Dimension(590, 435));

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel1.setText("Recommendation");

        recList.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        recList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(recList);

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
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(functionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(functionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeBtn)
                    .addComponent(updateBtn)
                    .addComponent(addBtn))
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
    
    // Method 2: Load the recommendation table
    private void loadRecommendation() {
        // Create an array to store the original recommendations
        oriRecommendation = new String[0];
        
        // Loop each row of the array taken from rs
        for(int i = 0; i < recommendation.length; i++) {
            // Check if the type matches the selected student failed component
            if(recommendation[i].getType().equals(failedComponent)) {
                // Get each recommendation and save it in oriRecommendation array
                oriRecommendation = recommendation[i].getRecommendations();
                // Stop looping after finding the correct type and assigning all recommendation into the array
                break;
            }
        }
        
        // Create an array for numbers and recommendations
        String[] numberedRec = new String[oriRecommendation.length];
        
        // Loop each item in oriRecommendation to add in numbers in the front of each recommendation
        for(int j = 0; j < oriRecommendation.length; j++) {
            numberedRec[j] = (j + 1) + ". " + oriRecommendation[j];
        }
        // Add the recommendations to recList
        recList.setListData(numberedRec);
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
    private javax.swing.JList<String> recList;
    private javax.swing.JButton recoveryBtn;
    private javax.swing.JButton removeBtn;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
