package JFrames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class HomePage extends javax.swing.JFrame {
    public HomePage() {
        initComponents();
        displayStudents();
        displayBooks();
        setCountToCards();
        showPieChart();
    }
    
    //Creating color codes for mouse hovering effect
    Color mouseEnter = new Color(204,0,51);
    Color mouseExit = new Color(255,102,102);
    
    //Creating Pie-Chart for Summery
    public void showPieChart(){
    
    //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      try{
          Connection conn = DbConnect.getConnection();
          String sql = "select bname,count(*) as issue_count from issue_book group by bid";
          Statement st = conn.createStatement();
          ResultSet rs = st.executeQuery(sql);
          while(rs.next()){
              barDataset.setValue( rs.getString("bname"),new Double(rs.getDouble("issue_count")));
          }
      }catch(Exception e){
          System.out.println(e);
      }
      
      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Issued Book States",barDataset, false,true,false);//explain
       PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelPie.removeAll();
        panelPie.add(barChartPanel, BorderLayout.CENTER);
        panelPie.validate();
    }
    
    //fetching data from db to diplay in tables
    //first for students data
    DefaultTableModel dtm,dtm2;
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
    //second for books
    public void displayBooks(){
        try{
            Connection con = DbConnect.getConnection();
            Statement st = con.createStatement();
            dtm2 = (DefaultTableModel)bookTable.getModel();
            int rc = dtm2.getRowCount();
            while (rc-- != 0) {
                dtm2.removeRow(0);
            }
            ResultSet rs = st.executeQuery("select * from book");
            while(rs.next()){
                String id=rs.getString("bid");
                String name=rs.getString("bname");
                String aname=rs.getString("author");
                int qty=rs.getInt("quantity");
                
                Object[] o={id,name,aname,qty};
                dtm2 = (DefaultTableModel)bookTable.getModel();
                dtm2.addRow(o);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    //Setting up Counting
    public void setCountToCards(){
        java.util.Date date = new Date();
        java.sql.Date dt = new java.sql.Date(date.getTime());
        int rowCount1 = 0,rowCount2 = 0,rowCount3=0,rowCount4=0;
        ResultSet rs,rs2,rs3,rs4;
        Statement stmt,stmt2,stmt3,stmt4;
       
        try{
            Connection conn = DbConnect.getConnection();
            stmt = conn.createStatement();
            stmt2 = conn.createStatement();
            stmt3 = conn.createStatement();
            stmt4 = conn.createStatement();
            String query = "SELECT COUNT(*) AS total_rows FROM book";
            String query2 = "select count(*) as total_rows from student";
            String query3 = "select count(*) as total_rows from issue_book where status = '"+"pending"+"'";
            String query4 = "select count(*) as total_rows from issue_book where return_dt < '"+dt+"' and status = '"+"pending"+"'";
            rs = stmt.executeQuery(query);
            rs2 = stmt2.executeQuery(query2);
            rs3 = stmt3.executeQuery(query3);
            rs4 = stmt4.executeQuery(query4);
           
            if (rs.next()) {
                rowCount1 = rs.getInt("total_rows");
            }
            if (rs2.next()) {
                rowCount2 = rs2.getInt("total_rows");
            }
            if (rs3.next()) {
                rowCount3 = rs3.getInt("total_rows");
            }
            if (rs4.next()) {
                rowCount4 = rs4.getInt("total_rows");
            }
            nob.setText(Integer.toString(rowCount1));
            nos.setText(Integer.toString(rowCount2));
            noib.setText(Integer.toString(rowCount3));
            nodl.setText(Integer.toString(rowCount4));
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        nodl = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        noib = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        nos = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        nob = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        panelPie = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Library Management System");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        jLabel2.setText("The Maharaja Saiyaji Rao University");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 20, 320, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 70));

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 0, 51));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Home");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 220, 40));

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Manage Books");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel4)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 102, 102));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Manage Students");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel6)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, -1, -1));

        jPanel7.setBackground(new java.awt.Color(255, 102, 102));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Issue Book");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel8)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 220, -1));

        jPanel8.setBackground(new java.awt.Color(255, 102, 102));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Return Book");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel9)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 220, -1));

        jPanel9.setBackground(new java.awt.Color(255, 102, 102));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("View Records");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(52, 52, 52))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 220, -1));

        jPanel10.setBackground(new java.awt.Color(255, 102, 102));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("View Issue Books");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel11)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
        );

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 220, -1));

        jPanel11.setBackground(new java.awt.Color(255, 102, 102));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Defaulter List");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel12)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 220, -1));

        jPanel12.setBackground(new java.awt.Color(153, 51, 0));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Log Out");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel13)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
        );

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 220, -1));

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel7.setText("Features");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 220, 710));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 0, 0, 0, new java.awt.Color(255, 0, 0)));

        nodl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nodl.setText("20");

        jLabel20.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel20.setText("Defaulter List");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel20))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(nodl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nodl, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 30, 200, 130));

        jPanel17.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 0, 0, 0, new java.awt.Color(255, 0, 0)));

        noib.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        noib.setText("20");

        jLabel22.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel22.setText("Issued Books");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel22))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(noib, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noib, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, -1, -1));

        jPanel18.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 0, 0, 0, new java.awt.Color(255, 0, 0)));

        nos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nos.setText("20");

        jLabel24.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel24.setText("No. Of Students");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel24))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(nos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, 120));

        jPanel19.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 0, 0, 0, new java.awt.Color(255, 0, 0)));

        nob.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nob.setText("20");

        jLabel26.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel26.setText("No. Of Books");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel26))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(nob, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nob, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 120));

        bookTable.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Book Id", "Name", "Author", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(bookTable);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, 190));

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel5.setText("Student Details");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel14.setText("Book Details");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        studentTable.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Student Id", "Name", "Course", "Branch"
            }
        ));
        jScrollPane2.setViewportView(studentTable);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 190));

        panelPie.setLayout(new java.awt.BorderLayout());
        jPanel6.add(panelPie, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 210, 540, 460));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 1280, 710));

        setBounds(0, 0, 1514, 787);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        ManageBooks pg = new ManageBooks();
        pg.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jPanel4.setBackground(mouseEnter);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jPanel4.setBackground(mouseExit);
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        jPanel5.setBackground(mouseEnter);
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        jPanel5.setBackground(mouseExit);
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        jPanel7.setBackground(mouseEnter);
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        jPanel7.setBackground(mouseExit);
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        jPanel8.setBackground(mouseEnter);
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        jPanel8.setBackground(mouseExit);
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        jPanel9.setBackground(mouseEnter);
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        jPanel9.setBackground(mouseExit);
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        jPanel10.setBackground(mouseEnter);
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        jPanel10.setBackground(mouseExit);
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        jPanel11.setBackground(mouseEnter);
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        jPanel11.setBackground(mouseExit);
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        ManageStudents pg = new ManageStudents();
        pg.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        IssueBook pg = new IssueBook();
        pg.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        ReturnBook pg=new ReturnBook();
        pg.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        ViewIssuedBooksOnly pg=new ViewIssuedBooksOnly();
        pg.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        ViewAllRecord pg=new ViewAllRecord();
        pg.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        DefaulterList pg=new DefaulterList();
        pg.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bookTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nob;
    private javax.swing.JLabel nodl;
    private javax.swing.JLabel noib;
    private javax.swing.JLabel nos;
    private javax.swing.JPanel panelPie;
    private javax.swing.JTable studentTable;
    // End of variables declaration//GEN-END:variables
}
