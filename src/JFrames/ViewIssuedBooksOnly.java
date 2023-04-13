package JFrames;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class ViewIssuedBooksOnly extends javax.swing.JFrame {
    public ViewIssuedBooksOnly() {
        initComponents();
        displayStudents();
    }
    
    //Fetching Data from db and load into table
    DefaultTableModel dtm;
    public void displayStudents(){
        try{
            Connection con = DbConnect.getConnection();
            Statement st = con.createStatement();
            dtm = (DefaultTableModel)dataTable.getModel();
            int rc = dtm.getRowCount();
            while (rc-- != 0) {
                dtm.removeRow(0);
            }
            String qur="select * from issue_book where status = ?";
            PreparedStatement pst = con.prepareStatement(qur);
            pst.setString(1, "pending");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String id=rs.getString("id");
                String bname=rs.getString("bname");
                String sname=rs.getString("sname");
                String is_dt = rs.getDate("issue_dt").toString();
                String rt_dt = rs.getDate("return_dt").toString();
                String status=rs.getString("status");
                
                Object[] o={id,bname,sname,is_dt,rt_dt,status};
                dtm = (DefaultTableModel)dataTable.getModel();
                dtm.addRow(o);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    //fetching data based upon search input
    public void searchData(){
        java.util.Date idt = issueDt.getDate();
        java.sql.Date idat = new java.sql.Date(idt.getTime());
        java.util.Date rdt = returnDt.getDate();
        java.sql.Date rdat = new java.sql.Date(rdt.getTime());
        
        try{
            Connection con = DbConnect.getConnection();
            String qur = "select * from issue_book where issue_dt between ? and ? and status = ?";
            PreparedStatement pst = con.prepareStatement(qur);
            pst.setDate(1, idat);
            pst.setDate(2, rdat);
            pst.setString(3,"pending");
            ResultSet rs = pst.executeQuery();
            
            dtm = (DefaultTableModel)dataTable.getModel();
            int rc = dtm.getRowCount();
            while (rc-- != 0) {
                dtm.removeRow(0);
            }
            if(rs.isBeforeFirst()){
                while(rs.next()){
                    String id=rs.getString("id");
                    String bname=rs.getString("bname");
                    String sname=rs.getString("sname");
                    String is_dt = rs.getDate("issue_dt").toString();
                    String rt_dt = rs.getDate("return_dt").toString();
                    String status=rs.getString("status");

                    Object[] o={id,bname,sname,is_dt,rt_dt,status};
                    dtm = (DefaultTableModel)dataTable.getModel();
                    dtm.addRow(o);
                }
            }
            else{
               JOptionPane.showMessageDialog(this, "No Record Found!");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        issueDt = new com.toedter.calendar.JDateChooser();
        returnDt = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();

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

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("Issue From");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));

        issueDt.setBackground(new java.awt.Color(255, 255, 255));
        issueDt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(issueDt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 250, 50));

        returnDt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(returnDt, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 180, 260, 50));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 51, 51));
        jLabel22.setText("View Issued Book Records");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, -1, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setText("Issue To");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, 80, 30));

        jButton2.setBackground(new java.awt.Color(255, 204, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Reset Record");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 180, 140, 50));

        jButton3.setBackground(new java.awt.Color(102, 204, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Search Record");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 180, 140, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1460, 290));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Book Name", "Student Name", "Issue Date", "Return Date", "Status"
            }
        ));
        dataTable.setRowHeight(40);
        dataTable.setShowGrid(true);
        jScrollPane1.setViewportView(dataTable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 790, 400));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 1460, 490));

        setSize(new java.awt.Dimension(1472, 787));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        HomePage pg = new HomePage();
        pg.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        displayStudents();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        java.util.Date idt = issueDt.getDate();
        java.util.Date rdt = returnDt.getDate();

        if(idt==null && rdt==null){
            JOptionPane.showMessageDialog(this, "Please Select Duration");
        }else{
            searchData();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewIssuedBooksOnly().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dataTable;
    private com.toedter.calendar.JDateChooser issueDt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser returnDt;
    // End of variables declaration//GEN-END:variables
}
