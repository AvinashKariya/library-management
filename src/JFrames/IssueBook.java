package JFrames;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public class IssueBook extends javax.swing.JFrame {
    public IssueBook() {
        initComponents();
        issueDt.setDate(new java.util.Date());
        issueDt.setEnabled(false);
    }
    
    //Fetching Book Details based upon enterd book id
    public void getBookDetails(){
        String b_id = bid_field.getText();
        
        try{
            Connection con = DbConnect.getConnection();
            String qur="select * from book where bid = ?";
            PreparedStatement pst = con.prepareStatement(qur);
            pst.setString(1, b_id);
            ResultSet rs = pst.executeQuery();
            if(rs.isBeforeFirst()){
                while(rs.next()){
                    id.setText(rs.getString("bid"));
                    bname.setText(rs.getString("bname"));
                    bauthor.setText(rs.getString("author"));
                    bqty.setText(rs.getString("quantity"));
                }
            }else{
                JOptionPane.showMessageDialog(this, "Please Enter valid book id. There is no such book exsits.");
                bid_field.setText("");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    //Fetching Student Details based upon enterd student id
    public void getStudentDetails(){
        String s_id = sid_field.getText();
        
        try{
            Connection con = DbConnect.getConnection();
            String qur="select * from student where sid = ?";
            PreparedStatement pst = con.prepareStatement(qur);
            pst.setString(1, s_id);
            ResultSet rs = pst.executeQuery();
            if(rs.isBeforeFirst()){
                while(rs.next()){
                    sid.setText(rs.getString("sid"));
                    sname.setText(rs.getString("sname"));
                    course.setText(rs.getString("scourse"));
                    branch.setText(rs.getString("sbranch"));
                }
            }else{
                JOptionPane.showMessageDialog(this, "Please Enter valid student id. There is no such book registered.");
                sid_field.setText("");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    //Issuing a book to student.
    public boolean issuBook(){
        boolean flag=false;
        String b_id = bid_field.getText();
        String s_id = sid_field.getText();
        String b_name=bname.getText();
        String s_name=sname.getText();
        java.util.Date idt = issueDt.getDate();
        java.sql.Date idat = new java.sql.Date(idt.getTime());
        java.util.Date rdt = returnDt.getDate();
        java.sql.Date rdat = new java.sql.Date(rdt.getTime());
        
        try{
            Connection con = DbConnect.getConnection();
            String qur = "insert into issue_book(bid,sid,bname,sname,issue_dt,return_dt,status) values(?,?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(qur);
            pst.setString(1, b_id);
            pst.setString(2, s_id);
            pst.setString(3, b_name);
            pst.setString(4, s_name);
            pst.setDate(5, idat);
            pst.setDate(6, rdat);
            pst.setString(7, "pending");
            
            int rowcnt=pst.executeUpdate();
            if(rowcnt>0){
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
        int c = Integer.parseInt(bqty.getText())-1;
        try{
            Connection con = DbConnect.getConnection();
            String qur = "update book set quantity = ? where bid = ?";
            PreparedStatement pst = con.prepareStatement(qur);
            pst.setString(1, Integer.toString(c));
            pst.setString(2, b_id);
            pst.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    //Validating student whether book is already issued or not!
    public boolean isIssued(){
        boolean flag=true;
        String b_id = bid_field.getText();
        String s_id = sid_field.getText();
        
        try{
            Connection con = DbConnect.getConnection();
            String qur="select * from issue_book where bid = ? and sid = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(qur);
            pst.setString(1, b_id);
            pst.setString(2, s_id);
            pst.setString(3, "pending");
            
            ResultSet rs = pst.executeQuery();
            if(rs.isBeforeFirst()){
                flag = false;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return flag;
    }
    
    //Clearing all fields after issuing
    public void clearFields(){
        id.setText("");
        bname.setText("");
        bauthor.setText("");
        bqty.setText("");
        sid.setText("");
        sname.setText("");
        course.setText("");
        branch.setText("");
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
        bname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        bqty = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        bauthor = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        sid = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        sname = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        branch = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        course = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        sid_field = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        bid_field = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        issueDt = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        returnDt = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();

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
        jLabel4.setText("Book Details");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 290, 70));

        id.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        id.setEnabled(false);
        id.setFocusable(false);
        id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                idFocusLost(evt);
            }
        });
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 250, 50));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Book Name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        bname.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        bname.setEnabled(false);
        bname.setFocusable(false);
        bname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                bnameFocusLost(evt);
            }
        });
        bname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnameActionPerformed(evt);
            }
        });
        jPanel1.add(bname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 250, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Book Auther");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, -1));

        bqty.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        bqty.setEnabled(false);
        bqty.setFocusable(false);
        bqty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                bqtyFocusLost(evt);
            }
        });
        jPanel1.add(bqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 250, 50));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Quantity");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, -1, -1));

        bauthor.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        bauthor.setEnabled(false);
        bauthor.setFocusable(false);
        bauthor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                bauthorFocusLost(evt);
            }
        });
        bauthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bauthorActionPerformed(evt);
            }
        });
        jPanel1.add(bauthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 250, 50));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Book ID");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 780));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sid.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        sid.setEnabled(false);
        sid.setFocusable(false);
        sid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sidFocusLost(evt);
            }
        });
        jPanel2.add(sid, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 250, 50));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Student Name");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        sname.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        sname.setEnabled(false);
        sname.setFocusable(false);
        sname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                snameFocusLost(evt);
            }
        });
        sname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snameActionPerformed(evt);
            }
        });
        jPanel2.add(sname, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 250, 50));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Course");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, -1, -1));

        branch.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        branch.setEnabled(false);
        branch.setFocusable(false);
        branch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                branchFocusLost(evt);
            }
        });
        jPanel2.add(branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, 250, 50));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("Branch");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, -1, -1));

        course.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        course.setEnabled(false);
        course.setFocusable(false);
        course.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                courseFocusLost(evt);
            }
        });
        course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseActionPerformed(evt);
            }
        });
        jPanel2.add(course, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 250, 50));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("Student ID");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI Emoji", 1, 48)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 51));
        jLabel18.setText("Student Details");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 350, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 390, 780));

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI Emoji", 1, 48)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("Issue Book");
        jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 10, 0, new java.awt.Color(255, 0, 0)));
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 240, 70));

        sid_field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sid_fieldFocusLost(evt);
            }
        });
        jPanel3.add(sid_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 250, 50));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("Issue Date");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("Book ID");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, -1));

        bid_field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                bid_fieldFocusLost(evt);
            }
        });
        jPanel3.add(bid_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 250, 50));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setText("Student ID");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, -1, -1));

        issueDt.setBackground(new java.awt.Color(255, 255, 255));
        issueDt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel3.add(issueDt, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 250, 50));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setText("Return Date");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, -1, -1));

        returnDt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                returnDtFocusLost(evt);
            }
        });
        returnDt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                returnDtMouseExited(evt);
            }
        });
        jPanel3.add(returnDt, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 540, 250, 50));

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setText("Issue Book");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 660, 190, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 710, 780));

        setBounds(0, 0, 1472, 787);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        HomePage pg = new HomePage();
        pg.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bnameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_bnameFocusLost

    private void bqtyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bqtyFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_bqtyFocusLost

    private void bauthorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bauthorFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_bauthorFocusLost

    private void bnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bnameActionPerformed

    private void bauthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bauthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bauthorActionPerformed

    private void idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idFocusLost

    }//GEN-LAST:event_idFocusLost

    private void sidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sidFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_sidFocusLost

    private void snameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_snameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_snameFocusLost

    private void snameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_snameActionPerformed

    private void branchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_branchFocusLost
        
    }//GEN-LAST:event_branchFocusLost

    private void courseFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_courseFocusLost
       
    }//GEN-LAST:event_courseFocusLost

    private void courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseActionPerformed
        
    }//GEN-LAST:event_courseActionPerformed

    private void sid_fieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sid_fieldFocusLost
       if(!sid_field.getText().equals("")){
            getStudentDetails();
        }
        else{
            JOptionPane.showMessageDialog(this, "Please Enter student id");
        }
    }//GEN-LAST:event_sid_fieldFocusLost

    private void bid_fieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bid_fieldFocusLost
        if(!bid_field.getText().equals("")){
            getBookDetails();
        }
        else{
            JOptionPane.showMessageDialog(this, "Please Enter book id");
        }
    }//GEN-LAST:event_bid_fieldFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //check whether all fields are empty or not
        if(!bid_field.getText().equals("") && !sid_field.getText().equals("")){
            int qt = Integer.parseInt(bqty.getText());
            //check if quantity is not zero
            if(qt>0){
                //if book already issued or not
                if(isIssued()){
                    //issue book
                    if(issuBook()){
                       JOptionPane.showMessageDialog(this, "Book issued succefully");
                       bookCount();
                       clearFields();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, "Book already issued");
                    clearFields();
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Sorry, all books were issued!!");
                clearFields();
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Please fill all fields");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void returnDtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_returnDtFocusLost
        
    }//GEN-LAST:event_returnDtFocusLost

    private void returnDtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnDtMouseExited

    }//GEN-LAST:event_returnDtMouseExited

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bauthor;
    private javax.swing.JTextField bid_field;
    private javax.swing.JTextField bname;
    private javax.swing.JTextField bqty;
    private javax.swing.JTextField branch;
    private javax.swing.JTextField course;
    private javax.swing.JTextField id;
    private com.toedter.calendar.JDateChooser issueDt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private com.toedter.calendar.JDateChooser returnDt;
    private javax.swing.JTextField sid;
    private javax.swing.JTextField sid_field;
    private javax.swing.JTextField sname;
    // End of variables declaration//GEN-END:variables
}
