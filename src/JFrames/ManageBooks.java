package JFrames;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public class ManageBooks extends javax.swing.JFrame {
    public ManageBooks() {
        initComponents();
        displayBooks();
    }
    
    //Displaying All Books in Table
    String b_id,b_name,b_aname;
    int b_qty;
    DefaultTableModel dtm;
    public void displayBooks(){
        try{
            Connection con = DbConnect.getConnection();
            Statement st = con.createStatement();
            dtm = (DefaultTableModel)bookTable.getModel();
            int rc = dtm.getRowCount();
            while (rc-- != 0) {
                dtm.removeRow(0);
            }
            ResultSet rs = st.executeQuery("select * from book");
            while(rs.next()){
                String id=rs.getString("bid");
                String name=rs.getString("bname");
                String aname=rs.getString("author");
                int qty=rs.getInt("quantity");
                
                Object[] o={id,name,aname,qty};
                dtm = (DefaultTableModel)bookTable.getModel();
                dtm.addRow(o);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    //search perticular book
    public boolean searchBook(){
        boolean f=false;
        String bookid=srchField.getText();
        try{
            Connection con = DbConnect.getConnection();
            dtm = (DefaultTableModel)bookTable.getModel();
            int rc = dtm.getRowCount();
            while (rc-- != 0) {
                dtm.removeRow(0);
            }
            String qur = "select * from book where bid = ?";
            PreparedStatement pst = con.prepareStatement(qur);
            pst.setString(1, bookid);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String id=rs.getString("bid");
                String name=rs.getString("bname");
                String aname=rs.getString("author");
                int qty=rs.getInt("quantity");
                
                Object[] o={id,name,aname,qty};
                dtm = (DefaultTableModel)bookTable.getModel();
                dtm.addRow(o);
                f=true;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return f;
    }
    //Adding New Book in Database
    public boolean addBook(){
        boolean f=false;
        b_id=bid.getText();
        b_name=bname.getText();
        b_aname=bauthor.getText();
        b_qty=Integer.parseInt(bqty.getText());
        try{
            Connection con = DbConnect.getConnection();
            String qur="insert into book(bid,bname,author,quantity) values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(qur);
            pst.setString(1, b_id);
            pst.setString(2, b_name);
            pst.setString(3, b_aname);
            pst.setInt(4, b_qty);
            
            int flag=pst.executeUpdate();
            if(flag>0){
                f=true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return f;
    }
    
    public boolean updateBook(){
        boolean f=false;
        b_id=bid.getText();
        b_name=bname.getText();
        b_aname=bauthor.getText();
        b_qty=Integer.parseInt(bqty.getText());
        
        try{
            Connection con = DbConnect.getConnection();
            String qur="update book set bname = ?,author = ? , quantity = ? where bid = ?";
            PreparedStatement pst = con.prepareStatement(qur);
            pst.setString(1, b_name);
            pst.setString(2, b_aname);
            pst.setInt(3, b_qty);
            pst.setString(4, b_id);
            
            int flag=pst.executeUpdate();
            if(flag>0){
                f=true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return f;
    }
    
    //Deleting selected book
    public boolean deleteBook(){
        boolean f=false;
        int ri = bookTable.getSelectedRow();
        String bookid =(String) bookTable.getValueAt(ri, 0);
        try{
            Connection con = DbConnect.getConnection();
            String qur="delete from book where bid = ?";
            PreparedStatement pst = con.prepareStatement(qur);
            pst.setString(1, bookid);
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
        bid.setText("");
        bname.setText("");
        bauthor.setText("");
        bqty.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        bid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        bname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        bqty = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        bauthor = new javax.swing.JTextField();
        addBook1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();
        updtBook = new javax.swing.JButton();
        srchField = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        dltBook = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
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
        jLabel4.setText("Enter Book ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        bid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                bidFocusLost(evt);
            }
        });
        jPanel1.add(bid, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 250, 50));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Enter Book Name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

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
        jPanel1.add(bname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 250, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Enter Book Auther");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        bqty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                bqtyFocusLost(evt);
            }
        });
        jPanel1.add(bqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 250, 50));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Quantity");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

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
        jPanel1.add(bauthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 250, 50));

        addBook1.setBackground(new java.awt.Color(153, 255, 102));
        addBook1.setText("Add");
        addBook1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBook1ActionPerformed(evt);
            }
        });
        jPanel1.add(addBook1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 130, 40));

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
        jLabel14.setText("Manage Books");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 280, 70));

        bookTable.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Name", "Author", "Quantity"
            }
        ));
        bookTable.setRowHeight(40);
        bookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bookTable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 720, 350));

        updtBook.setBackground(new java.awt.Color(153, 255, 102));
        updtBook.setText("Update");
        updtBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updtBookActionPerformed(evt);
            }
        });
        jPanel2.add(updtBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 660, 240, 40));
        jPanel2.add(srchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 210, 30));

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 200, 100, 30));

        dltBook.setBackground(new java.awt.Color(255, 51, 51));
        dltBook.setText("Delete");
        dltBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dltBookActionPerformed(evt);
            }
        });
        jPanel2.add(dltBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 660, 220, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Enter Book Id:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 120, 30));

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

    private void bookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookTableMouseClicked

    }//GEN-LAST:event_bookTableMouseClicked

    private void bidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bidFocusLost

    }//GEN-LAST:event_bidFocusLost

    private void addBook1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBook1ActionPerformed
        //Here we are doing multiple operation. 
        //if button value is Add then perform insertion
        if(addBook1.getText().equals("Add")){
            if(!bid.getText().equals("") && !bname.getText().equals("") && !bauthor.getText().equals("") && !bqty.getText().equals("")){
                if(addBook()){
                    JOptionPane.showMessageDialog(this, "Book Added Successfully");
                    displayBooks();
                    clearFields();
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Please fill all fields");
            }
        }
        
        //if button value is update then perform updation
        else if(addBook1.getText().equals("Update")){
            if(updateBook()){
                JOptionPane.showMessageDialog(this, "Book Added Successfully");
                displayBooks();
                clearFields();
                updtBook.setEnabled(true);
                addBook1.setText("Add");
                bid.setEditable(true);
            }
        }
    }//GEN-LAST:event_addBook1ActionPerformed

    private void updtBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updtBookActionPerformed
         int ri = bookTable.getSelectedRow();
        if(ri!=-1){
            String bid1 =(String) bookTable.getValueAt(ri, 0);
            String bname1=(String) bookTable.getValueAt(ri,1);
            String aname1=(String) bookTable.getValueAt(ri,2);
            int qty=(int)bookTable.getValueAt(ri,3);
            bid.setText(bid1);
            bname.setText(bname1);
            bauthor.setText(aname1);
            bqty.setText(""+qty);
            bid.setEditable(false);
            addBook1.setText("Update");
            updtBook.setEnabled(false);
        }
        else{
            JOptionPane.showMessageDialog(null,"Select a row before updating it");
        }
    }//GEN-LAST:event_updtBookActionPerformed

    private void dltBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dltBookActionPerformed
        int ri = bookTable.getSelectedRow();
        if (ri != -1){
            int res = JOptionPane.showConfirmDialog(null, "Do you want to delete this record?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_OPTION) {
                if(deleteBook()){
                    JOptionPane.showMessageDialog(this, "Book Deleted Successfully");
                    displayBooks();
                    clearFields();
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select a row before deleting");
        }
    }//GEN-LAST:event_dltBookActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(!srchField.getText().equals("")){
            if(!searchBook()){
               JOptionPane.showMessageDialog(this, "No Such book exsist!"); 
               displayBooks();
            }
            srchField.setText("");
        }
        else{
           JOptionPane.showMessageDialog(this, "Please Enter Book Id"); 
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void restBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restBookActionPerformed
        displayBooks();
    }//GEN-LAST:event_restBookActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        bid.setText("");
        bname.setText("");
        bauthor.setText("");
        bqty.setText("");
        bid.setEditable(true);
        addBook1.setText("Add");
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ManageBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBook1;
    private javax.swing.JTextField bauthor;
    private javax.swing.JTextField bid;
    private javax.swing.JTextField bname;
    private javax.swing.JTable bookTable;
    private javax.swing.JTextField bqty;
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
    private javax.swing.JTextField srchField;
    private javax.swing.JButton updtBook;
    // End of variables declaration//GEN-END:variables
}
