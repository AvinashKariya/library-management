package JFrames;

import java.sql.*;
import javax.swing.JOptionPane;

public class SignUpPage extends javax.swing.JFrame {
    public SignUpPage() {
        initComponents();
    }
    
    //Method to insert values into users tables
    public void insertSignupDetails(){
        String name=username.getText();
        String pass=password.getText();
        String mail=email.getText();
        String contct=contact.getText();
        
        try{
            Connection con = DbConnect.getConnection();
            String quer="insert into users(name,password,email,contact) values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(quer);
            pst.setString(1, name);
            pst.setString(2,pass);
            pst.setString(3, mail);
            pst.setString(4, contct);
            int rowCnt =pst.executeUpdate();
            if(rowCnt >0){
                JOptionPane.showMessageDialog(this, "User Registered Successfully!");
                LoginPage page = new LoginPage();
                page.setVisible(true);
                dispose();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    //Validation Input Fields
    public boolean validateSignUp(){
        String name=username.getText();
        String pass=password.getText();
        String mail=email.getText();
        String contct=contact.getText();
        
        if(name.equals("")){
            JOptionPane.showMessageDialog(this, "Please enter username");
            return false;
        }
        if(name.length()<4){
            JOptionPane.showMessageDialog(this, "Please enter valid username");
            return false;
        }
        if(pass.equals("")){
            JOptionPane.showMessageDialog(this, "Please enter Password");
            return false;
        }
        if(!pass.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")){
            JOptionPane.showMessageDialog(this, "Password must contain atleast 1 numeric,1 lowercase and uppercase,1 special char,length minimum 7");
            return false;
        }
        if(mail.equals("") || !mail.matches("^.+@.+\\..+$")){
            JOptionPane.showMessageDialog(this, "Please enter valid email");
            return false;
        }
        if(contct.equals("") || contct.length()!=10){
            JOptionPane.showMessageDialog(this, "Please enter valid contact number");
            return false;
        }
        return true;
    }
    
    //Check Duplicate Name
    public boolean checkDuplicate(){
        String name=username.getText();
        boolean isExists=false;
        try{
            Connection cn = DbConnect.getConnection();
            PreparedStatement ps= cn.prepareStatement("select * from users where name = ?");
            ps.setString(1, name);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                isExists=true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return isExists;
    }
    
    //Clear All Fields
    public void clearFields(){
        username.setText("");
        password.setText("");
        email.setText("");
        contact.setText("");
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
        jLabel7 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        contact = new javax.swing.JTextField();
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
        jLabel3.setText("Sign Up Page");
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

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel7.setText("E-mail");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel8.setText("Contact:");

        signup.setBackground(new java.awt.Color(255, 51, 51));
        signup.setText("Sign up");
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });

        login.setBackground(new java.awt.Color(255, 153, 153));
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        jLabel5.setText("Already Registered?");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(signup, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
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
                            .addComponent(username)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(contact, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(jLabel8)
                            .addComponent(password)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(login)))
                .addContainerGap(52, Short.MAX_VALUE))
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
                .addGap(44, 44, 44)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(signup, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(login))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        LoginPage pg = new LoginPage();
        pg.setVisible(true);
        dispose();
    }//GEN-LAST:event_loginActionPerformed

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        if(validateSignUp()){
            if(!checkDuplicate()){
                insertSignupDetails();
            }
        }
        clearFields();
    }//GEN-LAST:event_signupActionPerformed

    private void usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusLost
        if(checkDuplicate()){
           JOptionPane.showMessageDialog(this, "User Already Exists.");
        }
    }//GEN-LAST:event_usernameFocusLost

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUpPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField contact;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton login;
    private javax.swing.JPanel panel;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton signup;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
