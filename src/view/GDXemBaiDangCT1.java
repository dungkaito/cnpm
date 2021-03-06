/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.BinhLuanControl;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.BaiDang;
import model.BinhLuan;

/**
 *
 * @author Dinh Dung
 */
public class GDXemBaiDangCT1 extends javax.swing.JFrame {
    
    private BaiDang post;
    private DefaultTableModel tm;

    /**
     * Creates new form GDXemBaiDangCT1
     */
    public GDXemBaiDangCT1(BaiDang post) {
        initComponents();
        
        this.post = post;
        
        tm = (DefaultTableModel) tblCommentList.getModel();
        
        displayData();
    }
    
    public void displayData() {
        // display post
        txtKhuVuc.setText("Khu vực: "+post.getKhuVuc());
        txtTenCT.setText("Tên chủ trọ: "+post.getTenCT());
        txtChiTiet.setText(post.getChiTiet());
        
        //format double diem danh gia
        String tmp = (post.getDiemDanhGia()+"");
        if (post.getDiemDanhGia()<10) tmp = tmp.substring(0, 3);
        else tmp = tmp.substring(0, 2);
        //end format double diem danh gia
        
        txtDanhGia.setText("Đánh giá: "+tmp+"/10");
        txtGia.setText("Giá phòng: "+post.getGia()+"");
        txtSoPhongTrong.setText("Số phòng trống: "+post.getSoPhongTrong()+"");
        // end display post
    
        // display comment
        BinhLuanControl c = new BinhLuanControl();
        List<BinhLuan> comments = c.getAllComments(post.getId());
        c.closeDBConnection();
        
        tm.setRowCount(0);
        for (BinhLuan b : comments) {
            tm.addRow(new Object[]{b.getId(),b.getUnameTP(),b.getNoiDung()});
        }
    }
    
    public void highlightCommentByID(int id) {
        int row = 0;
        for (int i=0 ;i<tm.getRowCount(); i++) {
            if ((int) tm.getValueAt(i, 0) == id) {
                row = i;
                break;
            }
        }
        tblCommentList.setRowSelectionInterval(row, row);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtChiTiet = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCommentList = new javax.swing.JTable();
        txtTenCT = new javax.swing.JLabel();
        txtKhuVuc = new javax.swing.JLabel();
        txtGia = new javax.swing.JLabel();
        txtSoPhongTrong = new javax.swing.JLabel();
        txtDanhGia = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tìm Phòng Trọ - NL5N12");
        setPreferredSize(new java.awt.Dimension(950, 650));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 6));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NL5N12");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("CHI TIẾT BÀI ĐĂNG");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Chi tiết bài đăng:");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtChiTiet.setEditable(false);
        txtChiTiet.setColumns(20);
        txtChiTiet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtChiTiet.setRows(5);
        jScrollPane1.setViewportView(txtChiTiet);

        tblCommentList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tài khoản", "Bình luận"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblCommentList);
        if (tblCommentList.getColumnModel().getColumnCount() > 0) {
            tblCommentList.getColumnModel().getColumn(0).setMinWidth(0);
            tblCommentList.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblCommentList.getColumnModel().getColumn(0).setMaxWidth(0);
            tblCommentList.getColumnModel().getColumn(1).setMinWidth(80);
            tblCommentList.getColumnModel().getColumn(1).setPreferredWidth(120);
            tblCommentList.getColumnModel().getColumn(1).setMaxWidth(200);
        }

        txtTenCT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTenCT.setText("Tên chủ trọ");
        txtTenCT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtKhuVuc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtKhuVuc.setText("Khu vực");
        txtKhuVuc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtGia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtGia.setText("Giá phòng");
        txtGia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtSoPhongTrong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSoPhongTrong.setText("Số phòng trống");
        txtSoPhongTrong.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtDanhGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDanhGia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtDanhGia.setText("Điểm đánh giá");
        txtDanhGia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addComponent(jLabel9)
                        .addGap(0, 304, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTenCT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(txtKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(txtSoPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(258, 258, 258))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDanhGia, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(26, 26, 26)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenCT, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDanhGia)
                        .addComponent(txtSoPhongTrong)
                        .addComponent(txtKhuVuc)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtGia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(GDXemBaiDangCT1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GDXemBaiDangCT1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GDXemBaiDangCT1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GDXemBaiDangCT1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GDXemBaiDangCT1().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblCommentList;
    private javax.swing.JTextArea txtChiTiet;
    private javax.swing.JLabel txtDanhGia;
    private javax.swing.JLabel txtGia;
    private javax.swing.JLabel txtKhuVuc;
    private javax.swing.JLabel txtSoPhongTrong;
    private javax.swing.JLabel txtTenCT;
    // End of variables declaration//GEN-END:variables
}
