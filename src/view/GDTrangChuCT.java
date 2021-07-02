/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.BaiDangControl;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BaiDang;
import model.TaiKhoan;

/**
 *
 * @author Dinh Dung
 */
public class GDTrangChuCT extends javax.swing.JFrame {
    
    private TaiKhoan user;
    private DefaultTableModel tm1, tm2;

    /**
     * Creates new form GDTrangChuCT
     */
    public GDTrangChuCT(TaiKhoan user) {
        initComponents();
        
        this.user = user;
        
        labelWelcome.setText("Xin chào, " + user.getHoTen());
        
        tm1 = (DefaultTableModel) tblCongDong.getModel();
        displayAllPosts();
        
        tm2 = (DefaultTableModel) tblBaiDaDang.getModel();
        displayUploadedPost();
    }
    
    public void displayUploadedPost() {
        BaiDangControl c = new BaiDangControl();
        List<BaiDang> posts = c.getAllPosts();
        c.closeDBConnection();
        
        tm2.setRowCount(0);
        for (BaiDang b : posts) {
            if (b.getIdChuTro()== user.getId())
                tm2.addRow(new Object[]{b.getId(),b.getKhuVuc(),b.getSoPhongTrong(),b.getGia(),b.getChiTiet()+"...","Xem chi tiết","Cập nhật bài đăng","Xoá bài đăng"});
        }
    }

    public void displayAllPosts() {
        BaiDangControl c = new BaiDangControl();
        List<BaiDang> posts = c.getAllPosts();
        c.closeDBConnection();
        
        tm1.setRowCount(0);
        for (BaiDang b : posts) {
            // format double diem danh gia
            String tmp = b.getDiemDanhGia()+"";
            if(b.getDiemDanhGia()<10) tmp=tmp.substring(0, 3);
            else tmp=tmp.substring(0, 2);
            // end format double diem danh gia
            
            tm1.addRow(new Object[]{b.getId(),b.getTenCT(),b.getKhuVuc(),b.getSoPhongTrong(),tmp,b.getGia(),"Xem chi tiết"});
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
        btnDangBai = new javax.swing.JButton();
        labelWelcome = new javax.swing.JLabel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCongDong = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBaiDaDang = new javax.swing.JTable();
        btnLogout = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnThongBao = new javax.swing.JButton();

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

        btnDangBai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDangBai.setText("Đăng bài");
        btnDangBai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangBaiActionPerformed(evt);
            }
        });

        labelWelcome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelWelcome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelWelcome.setText("Xin chào");

        jTabbedPane4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblCongDong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên chủ trọ", "Khu vực", "Số phòng trống", "Điểm đánh giá", "Giá thuê", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCongDong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCongDongMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblCongDong);
        if (tblCongDong.getColumnModel().getColumnCount() > 0) {
            tblCongDong.getColumnModel().getColumn(0).setMinWidth(0);
            tblCongDong.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblCongDong.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jTabbedPane4.addTab("Cộng đồng", jScrollPane3);

        tblBaiDaDang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Khu vực", "Số phòng trống", "Giá thành", "Tiêu đề", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBaiDaDang.setColumnSelectionAllowed(true);
        tblBaiDaDang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBaiDaDangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBaiDaDang);
        tblBaiDaDang.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tblBaiDaDang.getColumnModel().getColumnCount() > 0) {
            tblBaiDaDang.getColumnModel().getColumn(0).setMinWidth(0);
            tblBaiDaDang.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblBaiDaDang.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jTabbedPane4.addTab("Danh sách bài đã đăng", jScrollPane2);

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

        btnThongBao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnThongBao.setText("Thông báo");
        btnThongBao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongBaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLamMoi)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnThongBao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDoiMatKhau)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLogout))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnDangBai)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSearchByUsername)
                                    .addGap(90, 90, 90)
                                    .addComponent(btnXemThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 918, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(24, 24, 24))
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
                    .addComponent(btnLogout)
                    .addComponent(btnThongBao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDangBai)
                    .addComponent(btnXemThongTin)
                    .addComponent(btnSearchByUsername))
                .addGap(35, 35, 35)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLamMoi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        // TODO add your handling code here:
        GDDoiMatKhau f = new GDDoiMatKhau(user);
        f.setVisible(true);
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

    private void btnXemThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemThongTinActionPerformed
        // TODO add your handling code here:
        GDXemThongTinCaNhan f = new GDXemThongTinCaNhan(user);
        f.setVisible(true);
    }//GEN-LAST:event_btnXemThongTinActionPerformed

    private void btnSearchByUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByUsernameActionPerformed
        // TODO add your handling code here:
        GDTimThongTinNguoiDung f = new GDTimThongTinNguoiDung();
        f.setVisible(true);
    }//GEN-LAST:event_btnSearchByUsernameActionPerformed

    private void btnDangBaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangBaiActionPerformed
        // TODO add your handling code here:
        GDDangBai f = new GDDangBai(user);
        f.setVisible(true);
    }//GEN-LAST:event_btnDangBaiActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        GDDangNhap f = new GDDangNhap();
        f.setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void tblCongDongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCongDongMouseClicked
        // TODO add your handling code here:
        int row = tblCongDong.rowAtPoint(evt.getPoint());
        int col = tblCongDong.columnAtPoint(evt.getPoint());
        
        // nếu click vào cột "Xem chi tiết"
        if (col == 6) {
            int id = (int) tm1.getValueAt(row, 0);
            
            BaiDangControl c = new BaiDangControl();
            BaiDang post = c.getPostById(id);
            c.closeDBConnection();
            
            // nếu mở bài đăng của mình
            if (post.getIdChuTro() == user.getId()) {
                // nếu xem bài đăng của chính mình
                GDXemBaiDangCT2 f = new GDXemBaiDangCT2(user, post);
                f.setVisible(true);
            } else {
                // nếu xem bài đăng của chủ trọ khác
                GDXemBaiDangCT1 f = new GDXemBaiDangCT1(post);
                f.setVisible(true);
            }
            
        }
    }//GEN-LAST:event_tblCongDongMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        displayAllPosts();
        displayUploadedPost();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tblBaiDaDangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBaiDaDangMouseClicked
        // TODO add your handling code here:
        int row = tblBaiDaDang.rowAtPoint(evt.getPoint());
        int col = tblBaiDaDang.columnAtPoint(evt.getPoint());
        
        // nếu click vào cột "Xem chi tiết"
        if (col == 5) {
            // get id bài đăng
            int id = (int) tm2.getValueAt(row, 0);
            
            BaiDangControl c = new BaiDangControl();
            BaiDang post = c.getPostById(id);
            c.closeDBConnection();
            
            // nếu mở bài đăng của mình
            if (post.getIdChuTro() == user.getId()) {
                // nếu xem bài đăng của chính mình
                GDXemBaiDangCT2 f = new GDXemBaiDangCT2(user, post);
                f.setVisible(true);
            } else {
                // nếu xem bài đăng của chủ trọ khác
                GDXemBaiDangCT1 f = new GDXemBaiDangCT1(post);
                f.setVisible(true);
            }
            
        } else if (col == 6) {
            // nếu click vào cột cập nhật
            // get id bài đăng
            int id = (int) tm2.getValueAt(row, 0);
            
            BaiDangControl c = new BaiDangControl();
            BaiDang post = c.getPostById(id);
            c.closeDBConnection();
            
            GDCapNhatBai f = new GDCapNhatBai(post);
            f.setVisible(true);
        } else if (col == 7) {
            // nếu click vào cột xoá
            int response = JOptionPane.showConfirmDialog(this, "Xoá bài đăng này?", "", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                
                // get id bài đăng
                int id = (int) tm2.getValueAt(row, 0);
            
                BaiDangControl c = new BaiDangControl();
                BaiDang post = c.getPostById(id);
                c.delete(post);
                c.closeDBConnection();
                
                JOptionPane.showMessageDialog(this, "Xoá bài đăng thành công");
                displayUploadedPost();
                displayAllPosts();
            }
        }
        
    }//GEN-LAST:event_tblBaiDaDangMouseClicked

    private void btnThongBaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongBaoActionPerformed
        // TODO add your handling code here:
        GDDanhSachThongBao f = new GDDanhSachThongBao(user.getId());
        f.setVisible(true);
    }//GEN-LAST:event_btnThongBaoActionPerformed

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
//            java.util.logging.Logger.getLogger(GDTrangChuCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GDTrangChuCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GDTrangChuCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GDTrangChuCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GDTrangChuCT().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangBai;
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSearchByUsername;
    private javax.swing.JButton btnThongBao;
    private javax.swing.JButton btnXemThongTin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JLabel labelWelcome;
    private javax.swing.JTable tblBaiDaDang;
    private javax.swing.JTable tblCongDong;
    // End of variables declaration//GEN-END:variables
}