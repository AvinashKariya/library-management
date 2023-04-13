package JFrames;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public class ReturnBook extends javax.swing.JFrame {
    public ReturnBook() {
        initComponents();
    }
    
    //Fetching issued book details from given inputs
    public void getIssueDetail(){
        String b_id = bid_field.getText();
        String s_id = sid_field.getText();
        
        try{
            Connection con = DbConnect.getConnection();
            String qur = "select * from issue_book where bid = ? and sid = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(qur);
            pst.setString(1, b_id);
            pst.setString(2, s_id);
            pst.setString(3, "pending");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                id.setText(Integer.toString(rs.getInt("id")));
                bid.setText(rs.getString("bid"));
                sid.setText(rs.getString("sid"));
                issuDt.setText(rs.getDate("issue_dt").toString());
                rtnDt.setText(rs.getDate("return_dt").toString());
            }
            else{
                JOptionPane.showMessageDialog(this, "No Such Record found!!");
                clearFields();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    //Returning Book in otherwords just set status of book issue will be set as returned so it'll be removed from pending list.
    public boolean returnBook(){
        boolean flag=false;
        String b_id = bid_field.getText();
        String s_id = sid_field.getText();
        
        try{
            Connection con = DbConnect.getConnection();
            String qur="update issue_book set status = ? where bid = ? and sid = ?";
            PreparedStatement pst = con.prepareStatement(qur);
            pst.setString(1, "returned");
            pst.setString(2, b_id);
            pst.setString(3, s_id);
            int cn = pst.executeUpdate();
            
            if(cn>0){
                flag=true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return flag;
    }
    
    
    //Updating Book Count
    public void bookCount(){
        String b_id = bid_field.getText();
        
        try{
            Connection con = DbConnect.getConnection();
            String qur = "update book set quantity = quantity + 1 where bid = ?";
            PreparedStatement pst = con.prepareStatement(qur);
            pst.setString(1, b_id);
            pst.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    //Clearing all fields after issuing
    public void clearFields(){
        id.setText("");
        bid.setText("");
        sid.setText("");
        issuDt.setText("");
        rtnDt.setText("");
        bid_field.setText("");
        sid_field.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        bid = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        issuDt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        sid = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        rtnDt = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        sid_field = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        bid_field = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("Issued Book Details");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 440, 70));

        id.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        id.setEnabled(false);
        id.setFocusable(false);
        id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                idFocusLost(evt);
            }
        });
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 250, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Book ID");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        bid.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        bid.setEnabled(false);
        bid.setFocusable(false);
        bid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                bidFocusLost(evt);
            }
        });
        bid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bidActionPerformed(evt);
            }
        });
        jPanel1.add(bid, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 250, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Student ID");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, -1, -1));

        issuDt.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        issuDt.setEnabled(false);
        issuDt.setFocusable(false);
        issuDt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                issuDtFocusLost(evt);
            }
        });
        jPanel1.add(issuDt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 250, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Issued Date");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, -1, -1));

        sid.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        sid.setEnabled(false);
        sid.setFocusable(false);
        sid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sidFocusLost(evt);
            }
        });
        sid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sidActionPerformed(evt);
            }
        });
        jPanel1.add(sid, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 250, 40));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Issued ID");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 0, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Return Book");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 660, 190, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Return Date");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 530, -1, -1));

        rtnDt.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        rtnDt.setEnabled(false);
        rtnDt.setFocusable(false);
        rtnDt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rtnDtFocusLost(evt);
            }
        });
        jPanel1.add(rtnDt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 560, 250, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 780));

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI Emoji", 1, 48)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("Return Book");
        jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 10, 0, new java.awt.Color(255, 0, 0)));
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 290, 70));

        sid_field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sid_fieldFocusLost(evt);
            }
        });
        jPanel3.add(sid_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 250, 50));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("Book ID");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        bid_field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                bid_fieldFocusLost(evt);
            }
        });
        jPanel3.add(bid_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 250, 50));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setText("Student ID");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setText("Find Details");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 240, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 480, 780));

        setBounds(0, 0, 962, 787);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        HomePage pg = new HomePage();
        pg.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bidFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_bidFocusLost

    private void issuDtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_issuDtFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_issuDtFocusLost

    private void sidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sidFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_sidFocusLost

    private void bidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bidActionPerformed

    private void sidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sidActionPerformed

    private void idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idFocusLost

    }//GEN-LAST:event_idFocusLost

    private void sid_fieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sid_fieldFocusLost
      
    }//GEN-LAST:event_sid_fieldFocusLost

    private void bid_fieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bid_fieldFocusLost
        
    }//GEN-LAST:event_bid_fieldFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(!bid_field.getText().equals("") && !sid_field.getText().equals("")){
            int res =JOptionPane.showConfirmDialog(this, "Are you sure want to return book?","Confirm Returning a book", JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_OPTION) {
                if(returnBook()){
                    JOptionPane.showMessageDialog(this, "Successfully Returned");
                    bookCount();
                }
            } 
        }
        else{
            JOptionPane.showMessageDialog(this, "Please Fill all the fields");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(!bid_field.getText().equals("") && !sid_field.getText().equals("")){
            getIssueDetail();
        }
        else{
            JOptionPane.showMessageDialog(this, "Please Fill all the fields");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void rtnDtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rtnDtFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_rtnDtFocusLost

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bid;
    private javax.swing.JTextField bid_field;
    private javax.swing.JTextField id;
    private javax.swing.JTextField issuDt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField rtnDt;
    private javax.swing.JTextField sid;
    private javax.swing.JTextField sid_field;
    // End of variables declaration//GEN-END:variables
}
