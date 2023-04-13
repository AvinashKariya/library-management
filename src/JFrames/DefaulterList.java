package JFrames;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class DefaulterList extends javax.swing.JFrame {
    public DefaulterList() {
        initComponents();
        displayStudents();
    }
    
    //Fetching Data from db and load into table
    DefaultTableModel dtm;
    java.util.Date dt = new java.util.Date();
    java.sql.Date dat = new java.sql.Date(dt.getTime());
    public void displayStudents(){
        try{
            Connection con = DbConnect.getConnection();
            Statement st = con.createStatement();
            dtm = (DefaultTableModel)dataTable.getModel();
            int rc = dtm.getRowCount();
            while (rc-- != 0) {
                dtm.removeRow(0);
            }
            String qur="select * from issue_book where return_dt < ? and status = ?";
            PreparedStatement pst = con.prepareStatement(qur);
            pst.setString(1, dat.toString());
            pst.setString(2, "pending");
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
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

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 51, 51));
        jLabel22.setText("View Defaulter List Records");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1460, 200));

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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 1460, 500));

        setSize(new java.awt.Dimension(1472, 705));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        HomePage pg = new HomePage();
        pg.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DefaulterList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dataTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
