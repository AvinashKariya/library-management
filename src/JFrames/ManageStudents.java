package JFrames;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public class ManageStudents extends javax.swing.JFrame {
    public ManageStudents() {
        initComponents();
        displayStudents();
    }
    
    //Displaying All Students in Table
    String s_id,s_name,s_branch,s_course;
    DefaultTableModel dtm;
    public void displayStudents(){
        try{
            Connection con = DbConnect.getConnection();
            Statement st = con.createStatement();
            dtm = (DefaultTableModel)studentTable.getModel();
            int rc = dtm.getRowCount();
            while (rc-- != 0) {
                dtm.removeRow(0);
            }
            ResultSet rs = st.executeQuery("select * from student");
            while(rs.next()){
                String id=rs.getString("sid");
                String name=rs.getString("sname");
                String course=rs.getString("scourse");
                String branch=rs.getString("sbranch");
                
                Object[] o={id,name,course,branch};
                dtm = (DefaultTableModel)studentTable.getModel();
                dtm.addRow(o);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    //Adding New Student in Database
    public boolean addStudents(){
        boolean f=false;
        s_id=sid.getText();
        s_name=sname.getText();
        s_course=(String)course.getSelectedItem();
        s_branch=(String)branch.getSelectedItem();
        try{
            Connection con = DbConnect.getConnection();
            String qur="insert into student(sid,sname,scourse,sbranch) values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(qur);
            pst.setString(1, s_id);
            pst.setString(2, s_name);
            pst.setString(3, s_course);
            pst.setString(4, s_branch);
            
            int flag=pst.executeUpdate();
            if(flag>0){
                f=true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return f;
    }
    
    //searching student
    public boolean searchBook(){
        boolean f=false;
        String sid=srchField.getText();
        try{
            Connection con = DbConnect.getConnection();
            dtm = (DefaultTableModel)studentTable.getModel();
            int rc = dtm.getRowCount();
            while (rc-- != 0) {
                dtm.removeRow(0);
            }
            String qur = "select * from student where sid = ?";
            PreparedStatement pst = con.prepareStatement(qur);
            pst.setString(1, sid);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String id=rs.getString("sid");
                String name=rs.getString("sname");
                String cs=rs.getString("scourse");
                String br=rs.getString("sbranch");
                
                Object[] o={id,name,cs,br};
                dtm = (DefaultTableModel)studentTable.getModel();
                dtm.addRow(o);
                f=true;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return f;
    }
    
    //Updating Existing Student
    public boolean updateStudent(){
        boolean f=false;
        s_id=sid.getText();
        s_name=sname.getText();
        s_course=(String)course.getSelectedItem();
        s_branch=(String)branch.getSelectedItem();
        
        try{
            Connection con = DbConnect.getConnection();
            String qur="update student set sname = ?,scourse = ? , sbranch = ? where sid = ?";
            PreparedStatement pst = con.prepareStatement(qur);
            pst.setString(1, s_name);
            pst.setString(2, s_course);
            pst.setString(3, s_branch);
            pst.setString(4, s_id);
            
            int flag=pst.executeUpdate();
            if(flag>0){
                f=true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return f;
    }
    
    //Deleting selected student
    public boolean deleteStudent(){
        boolean f=false;
        s_id=sid.getText();
        try{
            Connection con = DbConnect.getConnection();
            String qur="delete from student where sid = ?";
            PreparedStatement pst = con.prepareStatement(qur);
            pst.setString(1, s_id);
            int flag=pst.executeUpdate();
            if(flag>0){
                f=true;
            }
        }catch(Exception e){
            System.out.println(e);
        }

        
        return f;
    }
    
    //Clearing All fields after each operations.
    public void clearFields(){
        sid.setText("");
        sname.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        sid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        sname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        addBook1 = new javax.swing.JButton();
        branch = new javax.swing.JComboBox<>();
        course = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        srchField = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        updtBook = new javax.swing.JButton();
        dltBook = new javax.swing.JButton();
        restBook = new javax.swing.JButton();

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

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Enter Student ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        sid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sidFocusLost(evt);
            }
        });
        jPanel1.add(sid, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 250, 50));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Enter Student Name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

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
        jPanel1.add(sname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 250, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Select Course");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Select Branch");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        addBook1.setBackground(new java.awt.Color(153, 255, 102));
        addBook1.setText("Add");
        addBook1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBook1ActionPerformed(evt);
            }
        });
        jPanel1.add(addBook1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 520, 120, 40));

        branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CS", "IT", "PLAIN", "EC", "CIVIL", "MECH", "ELECTRONICS" }));
        jPanel1.add(branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 250, 50));

        course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSC", "MSC", "PhD", "BE", "ME", "BCA", "MCA" }));
        course.setSelectedIndex(3);
        jPanel1.add(course, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 250, 50));

        jButton3.setBackground(new java.awt.Color(255, 51, 51));
        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 570, 90, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 780));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Arial Narrow", 1, 48)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 255));
        jLabel14.setText("Manage Students");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 330, 70));

        studentTable.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Name", "Course", "Branch"
            }
        ));
        studentTable.setRowHeight(40);
        studentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(studentTable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 710, 360));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Enter Student Id:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 150, 30));
        jPanel2.add(srchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 210, 30));

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 200, 100, 30));

        updtBook.setBackground(new java.awt.Color(153, 255, 102));
        updtBook.setText("Update");
        updtBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updtBookActionPerformed(evt);
            }
        });
        jPanel2.add(updtBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 660, 240, 40));

        dltBook.setBackground(new java.awt.Color(255, 51, 51));
        dltBook.setText("Delete");
        dltBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dltBookActionPerformed(evt);
            }
        });
        jPanel2.add(dltBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 660, 220, 40));

        restBook.setBackground(new java.awt.Color(102, 102, 255));
        restBook.setText("Reset");
        restBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restBookActionPerformed(evt);
            }
        });
        jPanel2.add(restBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 660, 210, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 1150, 780));

        setBounds(0, 0, 1472, 787);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        HomePage pg = new HomePage();
        pg.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void snameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_snameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_snameFocusLost

    private void snameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_snameActionPerformed

    private void studentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentTableMouseClicked
    
    }//GEN-LAST:event_studentTableMouseClicked

    private void sidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sidFocusLost

    }//GEN-LAST:event_sidFocusLost

    private void addBook1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBook1ActionPerformed
        //Here we are doing multiple operation. 
        //if button value is Add then perform insertion
        if(addBook1.getText().equals("Add")){
            if(!sid.getText().equals("") && !sname.getText().equals("")){
                if(addStudents()){
                    JOptionPane.showMessageDialog(this, "Book Added Successfully");
                    displayStudents();
                    clearFields();
                }
            }else{
                JOptionPane.showMessageDialog(this, "Please Fill all the fields");
            }
        }
        //if button value is update then perform updation
        else if(addBook1.getText().equals("Update")){
            if(updateStudent()){
                JOptionPane.showMessageDialog(this, "Book Added Successfully");
                displayStudents();
                clearFields();
                updtBook.setEnabled(true);
                addBook1.setText("Add");
                sid.setEditable(true);
            }
        }
    }//GEN-LAST:event_addBook1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(!srchField.getText().equals("")){
            String bid=(String)srchField.getText();
            if(!searchBook()){
                JOptionPane.showMessageDialog(this, "No Such book exsist!");
                displayStudents();
            }
            srchField.setText("");
        }
        else{
            JOptionPane.showMessageDialog(this, "Please Enter Book Id");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void updtBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updtBookActionPerformed
        int ri = studentTable.getSelectedRow();
        if(ri!=-1){
            String sid1 =(String) studentTable.getValueAt(ri, 0);
            String sname1=(String) studentTable.getValueAt(ri,1);
            String s_course=(String)studentTable.getValueAt(ri,2);
            String s_branch=(String)studentTable.getValueAt(ri,3);
            sid.setText(sid1);
            sname.setText(sname1);
            course.setSelectedItem(s_course);
            branch.setSelectedItem(s_branch);
            sid.setEditable(false);
            addBook1.setText("Update");
            updtBook.setEnabled(false);
            
        }
        else{
            JOptionPane.showMessageDialog(null,"Select a row before updating it");
        }
    }//GEN-LAST:event_updtBookActionPerformed

    private void dltBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dltBookActionPerformed
        int ri = studentTable.getSelectedRow();
        if (ri != -1){
            int res = JOptionPane.showConfirmDialog(null, "Do you want to delete this record?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_OPTION) {
                if(deleteStudent()){
                    JOptionPane.showMessageDialog(this, "Student Deleted Successfully");
                    displayStudents();
                    clearFields();
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select a row before deleting");
        }
    }//GEN-LAST:event_dltBookActionPerformed

    private void restBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restBookActionPerformed
        displayStudents();
    }//GEN-LAST:event_restBookActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        sid.setText("");
        sname.setText("");
        sid.setEditable(true);
        addBook1.setText("Add");
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBook1;
    private javax.swing.JComboBox<String> branch;
    private javax.swing.JComboBox<String> course;
    private javax.swing.JButton dltBook;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton restBook;
    private javax.swing.JTextField sid;
    private javax.swing.JTextField sname;
    private javax.swing.JTextField srchField;
    private javax.swing.JTable studentTable;
    private javax.swing.JButton updtBook;
    // End of variables declaration//GEN-END:variables
}
