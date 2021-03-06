/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.BaiDangControl;
import controller.BaoCaoControl;
import controller.BinhLuanControl;
import controller.TaiKhoanControl;
import controller.ThongBaoControl;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BaoCao;
import model.TaiKhoan;
import model.ThongBao;

/**
 *
 * @author Dinh Dung
 */
public class GDTrangChuQT extends javax.swing.JFrame {
    
    private TaiKhoan user;
    private DefaultTableModel tm1, tm2;

    /**
     * Creates new form GDTrangChuQT
     */
    public GDTrangChuQT(TaiKhoan user) {
        initComponents();
        
        this.user = user;
        
        labelWelcome.setText("Xin chào, " + user.getHoTen());
        
        tm1 = (DefaultTableModel) tblPostReports.getModel();
        tm2 = (DefaultTableModel) tblCommentReports.getModel();
        
        displayData();
    }
    
    public void displayData() {
        BaoCaoControl c = new BaoCaoControl();
        List<BaoCao> reports = c.getAllReport();
        c.closeDBConnection();
        
        // list bai dang bi bc
        tm1.setRowCount(0);
        for (BaoCao b : reports) {
            if (b.getLoaiBC() == 1) {
                tm1.addRow(new Object[]{b.getId(),b.getIdBaiDang(),b.getIdGuiBC(),b.getIdBiBC(),b.getNoiDungBC(),"Xem bài đăng", "Xoá bài đăng", "Từ chối, xoá báo cáo"});
            }
        }
        
        // list binh luan bi bc
        tm2.setRowCount(0);
        for (BaoCao b : reports) {
            if (b.getLoaiBC() == 2) {
                tm2.addRow(new Object[]{b.getId(), b.getIdBinhLuan(),b.getIdGuiBC(),b.getIdBiBC(),b.getNoiDungBC(),"Xem bình luận","Xoá bình luận","Từ chối, xoá báo cáo",b.getIdBaiDang()});
            }
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnDoiMatKhau = new javax.swing.JButton();
        btnXemThongTin = new javax.swing.JButton();
        btnSearchByUsername = new javax.swing.JButton();
        btnSearchByName = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        labelWelcome = new javax.swing.JLabel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPostReports = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCommentReports = new javax.swing.JTable();
        btnLogout = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tìm Phòng Trọ - NL5N12");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 6));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NL5N12");

        btnDoiMatKhau.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDoiMatKhau.setText("Đổi mật khẩu");
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });

        btnXemThongTin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnXemThongTin.setText("Xem thông tin cá nhân");
        btnXemThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemThongTinActionPerformed(evt);
            }
        });

        btnSearchByUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSearchByUsername.setText("Tìm thông tin người dùng");
        btnSearchByUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByUsernameActionPerformed(evt);
            }
        });

        btnSearchByName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSearchByName.setText("Tìm kiếm người dùng");
        btnSearchByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByNameActionPerformed(evt);
            }
        });

        txtName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        labelWelcome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelWelcome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelWelcome.setText("Xin chào");

        jTabbedPane4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblPostReports.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID bài đăng", "ID gửi báo cáo", "ID bị báo cáo", "Nội dung báo cáo", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPostReports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPostReportsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPostReports);
        if (tblPostReports.getColumnModel().getColumnCount() > 0) {
            tblPostReports.getColumnModel().getColumn(0).setMinWidth(0);
            tblPostReports.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblPostReports.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jTabbedPane4.addTab("Danh sách bài đăng bị báo cáo", jScrollPane3);

        tblCommentReports.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID bình luận", "ID gửi báo cáo", "ID bị báo cáo", "Nội dung", "", "", "", "idBaiDang"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCommentReports.setColumnSelectionAllowed(true);
        tblCommentReports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCommentReportsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCommentReports);
        tblCommentReports.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tblCommentReports.getColumnModel().getColumnCount() > 0) {
            tblCommentReports.getColumnModel().getColumn(0).setMinWidth(0);
            tblCommentReports.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblCommentReports.getColumnModel().getColumn(0).setMaxWidth(0);
            tblCommentReports.getColumnModel().getColumn(8).setMinWidth(0);
            tblCommentReports.getColumnModel().getColumn(8).setPreferredWidth(0);
            tblCommentReports.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        jTabbedPane4.addTab("Danh sách bình luận bị báo cáo", jScrollPane2);

        btnLogout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLogout.setText("Đăng xuất");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnLamMoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLamMoi.setText("Làm mới danh sách");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 918, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearchByName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnSearchByUsername)
                                        .addGap(90, 90, 90)
                                        .addComponent(btnXemThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnDoiMatKhau)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLogout))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLamMoi)))
                .addGap(0, 28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDoiMatKhau)
                    .addComponent(btnLogout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearchByName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXemThongTin)
                    .addComponent(btnSearchByUsername))
                .addGap(35, 35, 35)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLamMoi)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
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

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO insert your handling code here:
        this.dispose();
        GDDangNhap f = new GDDangNhap();
        f.setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        // TODO insert your handling code here:
        GDDoiMatKhau f = new GDDoiMatKhau(user);
        f.setVisible(true);
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

    private void btnSearchByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByNameActionPerformed
        // TODO insert your handling code here:
        String name = txtName.getText();
        
        if ("".equals(name)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên");
            return;
        }
        
        TaiKhoanControl c = new TaiKhoanControl();
        List<TaiKhoan> users = c.getUsersByName(name);
        c.closeDBConnection();
        
        GDDanhSachTaiKhoan f = new GDDanhSachTaiKhoan(users);
        f.setVisible(true);
    }//GEN-LAST:event_btnSearchByNameActionPerformed

    private void btnSearchByUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByUsernameActionPerformed
        // TODO insert your handling code here:
        GDTimThongTinNguoiDung f = new GDTimThongTinNguoiDung();
        f.setVisible(true);
    }//GEN-LAST:event_btnSearchByUsernameActionPerformed

    private void btnXemThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemThongTinActionPerformed
        // TODO insert your handling code here:
        GDXemThongTinCaNhan f = new GDXemThongTinCaNhan(user);
        f.setVisible(true);
    }//GEN-LAST:event_btnXemThongTinActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        displayData();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tblPostReportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPostReportsMouseClicked
        // TODO add your handling code here:
        int row = tblPostReports.rowAtPoint(evt.getPoint());
        int col = tblPostReports.columnAtPoint(evt.getPoint());
        
        if (col == 5) {
            BaiDangControl c = new BaiDangControl();
            // neu click cột "xem bai dang"
            GDXemBaiDangCT1 f = new GDXemBaiDangCT1(c.getPostById((int) tm1.getValueAt(row, 1)));
            f.setVisible(true);
            c.closeDBConnection();
        } else if (col == 6) {
            // nếu click cột "xoá bài"
            int res = JOptionPane.showConfirmDialog(this, "Xoá bài đăng này vì lý do vi phạm?", "", JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_OPTION) {
                int idBD = (int) tm1.getValueAt(row, 1);
                
                //xoa bai dang
                BaiDangControl c2 = new BaiDangControl();
                c2.delete(idBD);
                c2.closeDBConnection();
                
                // xoa bao cao
                BaoCaoControl c3 = new BaoCaoControl();
                c3.delete((int) tm1.getValueAt(row, 0));
                c3.closeDBConnection();
                
                JOptionPane.showMessageDialog(this, "Bài đăng đã được xoá");
                
                
                
                // thông báo cho người gửi báo cáo
                ThongBao tb = new ThongBao();
                tb.setIdUser((int) tm1.getValueAt(row, 2));
                tb.setNoiDung("Báo cáo bài đăng của bạn đã được xem xét và đồng ý xử lý vi phạm");
                tb.setThoiGian(new Date());
                
                ThongBaoControl c4 = new ThongBaoControl();
                c4.insert(tb);
                c4.closeDBConnection();
                
                displayData();
            }
            
        } else if (col == 7) {
            // nếu click cột "từ chối, xoá bc"
            int res = JOptionPane.showConfirmDialog(this, "Từ chối, xoá báo cáo này và thông báo cho người dùng?", "", JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_OPTION) {
                // xoa bao cao
                BaoCaoControl c1 = new BaoCaoControl();
                c1.delete((int) tm1.getValueAt(row, 0));
                c1.closeDBConnection();
                
                // phản hồi cho người dùng
                ThongBao tb = new ThongBao();
                tb.setIdUser((int) tm1.getValueAt(row, 2));
                tb.setNoiDung("Báo cáo bài đăng của bạn bị từ chối");
                tb.setThoiGian(new Date());
                
                ThongBaoControl c2 = new ThongBaoControl();
                c2.insert(tb);
                c2.closeDBConnection();
                
                // reload
                displayData();
            }
            
        }
        
    }//GEN-LAST:event_tblPostReportsMouseClicked

    private void tblCommentReportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCommentReportsMouseClicked
        // TODO add your handling code here:
        int row = tblCommentReports.rowAtPoint(evt.getPoint());
        int col = tblCommentReports.columnAtPoint(evt.getPoint());
        
        if (col == 5) {
            BaiDangControl c = new BaiDangControl();
            // neu click cột "xem binh luan"
            GDXemBaiDangCT1 f = new GDXemBaiDangCT1(c.getPostById((int) tm2.getValueAt(row, 8)));
            f.highlightCommentByID((int) tm2.getValueAt(row, 1));
            f.setVisible(true);
            c.closeDBConnection();
        } else if (col == 6) {
            // nếu click cột "xoá binhluan"
            int res = JOptionPane.showConfirmDialog(this, "Xoá bình luận này vì lý do vi phạm?", "", JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_OPTION) {
                int idBinhLuan = (int) tm2.getValueAt(row, 1);
                
                //xoá bình luận
                BinhLuanControl c1 = new BinhLuanControl();
                c1.delete(idBinhLuan);
                c1.closeDBConnection();
                
                // xoá báo cáo
                BaoCaoControl c2 = new BaoCaoControl();
                c2.delete((int) tm2.getValueAt(row, 0));
                c2.closeDBConnection();
                
                JOptionPane.showMessageDialog(this, "Bình luận đã được xoá");
                
                
                
                // thông báo cho người gửi báo cáo
                ThongBao tb = new ThongBao();
                tb.setIdUser((int) tm2.getValueAt(row, 2));
                tb.setNoiDung("Báo cáo bình luận của bạn đã được xem xét và đồng ý xử lý vi phạm");
                tb.setThoiGian(new Date());
                
                ThongBaoControl c3 = new ThongBaoControl();
                c3.insert(tb);
                c3.closeDBConnection();
                
                displayData();
            }
            
        } else if (col == 7) {
            // nếu click cột "từ chối, xoá bc"
            int res = JOptionPane.showConfirmDialog(this, "Từ chối, xoá báo cáo này và thông báo cho người dùng?", "", JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_OPTION) {
                // xoa bao cao
                BaoCaoControl c1 = new BaoCaoControl();
                c1.delete((int) tm2.getValueAt(row, 0));
                c1.closeDBConnection();
                
                // phản hồi cho người dùng
                ThongBao tb = new ThongBao();
                tb.setIdUser((int) tm2.getValueAt(row, 2));
                tb.setNoiDung("Báo cáo bình luận của bạn bị từ chối");
                tb.setThoiGian(new Date());
                
                ThongBaoControl c2 = new ThongBaoControl();
                c2.insert(tb);
                c2.closeDBConnection();
                
                // reload
                displayData();
            }
            
        }
        
    }//GEN-LAST:event_tblCommentReportsMouseClicked

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
//            java.util.logging.Logger.getLogger(GDTrangChuQT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GDTrangChuQT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GDTrangChuQT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GDTrangChuQT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GDTrangChuQT().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSearchByName;
    private javax.swing.JButton btnSearchByUsername;
    private javax.swing.JButton btnXemThongTin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JLabel labelWelcome;
    private javax.swing.JTable tblCommentReports;
    private javax.swing.JTable tblPostReports;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
