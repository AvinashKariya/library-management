package JFrames;

import java.sql.*;
import javax.swing.JOptionPane;

public class LoginPage extends javax.swing.JFrame {
    public LoginPage() {
        initComponents();
    }
    
    //Validate Login Details
    public boolean validateLogin(){
        String name=username.getText();
        String pass=password.getText();
        
        if(name.equals("")){
            JOptionPane.showMessageDialog(this, "Please Enter Username");
            return false;
        }
        if(pass.equals("")){
            JOptionPane.showMessageDialog(this, "Please Enter Password");
            return false;
        }
        return true;
    }
    
    //Verifying Credentials
    public void login(){
        String name=username.getText();
        String pass=password.getText();
        
        try{
            Connection con = DbConnect.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from users where name = ? and password = ?");
            pst.setString(1, name);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(this, "login successfully");
                HomePage pg = new HomePage();
                pg.setVisible(true);
                dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Please enter valid credentials");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        signup = new javax.swing.JButton();
        login = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign Up ");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("The Maharaja Saiyaji Rao University");

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Library Management System");

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel3.setText("Login Page");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel4.setText("Username:");

        username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameFocusLost(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel6.setText("Password:");

        signup.setBackground(new java.awt.Color(255, 51, 51));
        signup.setText("Login");
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });

        login.setBackground(new java.awt.Color(255, 153, 153));
        login.setText("Sign Up");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        jLabel5.setText("New User ?");

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel3))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(password)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(login))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(signup, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(78, 78, 78)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(signup, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login)
                    .addComponent(jLabel5))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        SignUpPage pg = new SignUpPage();
        pg.setVisible(true);
        dispose();
    }//GEN-LAST:event_loginActionPerformed

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        if(validateLogin()){
            login();
        }
    }//GEN-LAST:event_signupActionPerformed

    private void usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusLost
     
    }//GEN-LAST:event_usernameFocusLost

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton login;
    private javax.swing.JPanel panel;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton signup;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
