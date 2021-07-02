/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.BaiDaLuu;
import model.BaiDang;
import model.BaoCao;
import model.DanhGia;
import model.TaiKhoan;

/**
 *
 * @author Dinh Dung
 */
public class BaiDangControl {
    private Connection conn;

    public BaiDangControl() {
        String dbUrl = "jdbc:mysql://localhost:3306/cnpm";
        String dbClass = "com.mysql.cj.jdbc.Driver";
        String user = "root";
        String password = "toor";
        try {
            Class.forName(dbClass);
            conn = DriverManager.getConnection(dbUrl,user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<BaiDang> searchRoom(String loaiTK, String keyword) {
        List<BaiDang> result = new ArrayList<>();
        
        if (null != loaiTK) switch (loaiTK) {
            case "Nội dung bài":
                result = searchRoomByContent(keyword);
                break;
            case "Khu vực":
                result = searchRoomByPlace(keyword);
                break;
            case "Giá thành":
                result = searchRoomByCost(keyword);
                break;
            default:
                break;
        }
        
        return result;
    }
    
    public List<BaiDang> searchRoomByCost(String key) {
        List<BaiDang> result = new ArrayList<>();
        String sql = "SELECT * FROM bai_dang WHERE gia<=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(key));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BaiDang b = new BaiDang();
                b.setId(rs.getInt("id"));
                b.setChiTiet(rs.getString("chiTiet"));
                b.setDiemDanhGia(rs.getDouble("diemDanhGia"));
                b.setGia(rs.getInt("gia"));
                b.setIdChuTro(rs.getInt("idChuTro"));
                b.setKhuVuc(rs.getString("khuVuc"));
                b.setSoPhongTrong(rs.getInt("soPhongTrong"));
                b.setTenCT(rs.getString("tenCT"));
                result.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public List<BaiDang> searchRoomByPlace(String key) {
        List<BaiDang> result = new ArrayList<>();
        String sql = "SELECT * FROM bai_dang WHERE khuVuc LIKE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+key+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BaiDang b = new BaiDang();
                b.setId(rs.getInt("id"));
                b.setChiTiet(rs.getString("chiTiet"));
                b.setDiemDanhGia(rs.getDouble("diemDanhGia"));
                b.setGia(rs.getInt("gia"));
                b.setIdChuTro(rs.getInt("idChuTro"));
                b.setKhuVuc(rs.getString("khuVuc"));
                b.setSoPhongTrong(rs.getInt("soPhongTrong"));
                b.setTenCT(rs.getString("tenCT"));
                result.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public List<BaiDang> searchRoomByContent(String key) {
        List<BaiDang> result = new ArrayList<>();
        String sql = "SELECT * FROM bai_dang WHERE chiTiet LIKE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+key+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BaiDang b = new BaiDang();
                b.setId(rs.getInt("id"));
                b.setChiTiet(rs.getString("chiTiet"));
                b.setDiemDanhGia(rs.getDouble("diemDanhGia"));
                b.setGia(rs.getInt("gia"));
                b.setIdChuTro(rs.getInt("idChuTro"));
                b.setKhuVuc(rs.getString("khuVuc"));
                b.setSoPhongTrong(rs.getInt("soPhongTrong"));
                b.setTenCT(rs.getString("tenCT"));
                result.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public void setDanhGiaTrungBinh(BaiDang post) {
        List<Integer> diem = getAllDiemDanhGia(post.getId());
        post.setDiemDanhGia(diem);
    }
    
    public List<Integer> getAllDiemDanhGia(int idBaiDang) {
        List<Integer> diem = new ArrayList<>();
        
        String sql = "SELECT * FROM danh_gia WHERE idBaiDang=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idBaiDang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                diem.add(rs.getInt("soDiem"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return diem;
    }
    
    public boolean insert(DanhGia d) {
        String sqlInsert = "INSERT INTO danh_gia(idBaiDang,idThuePhong,soDiem) VALUES(?,?,?)";
        String sqlSelect = "SELECT id FROM danh_gia WHERE idBaiDang=? AND idThuePhong=?";
        try {
            PreparedStatement ps;
            
            // check đã đánh giá chưa
            ps = conn.prepareStatement(sqlSelect);
            ps.setInt(1, d.getIdBaiDang());
            ps.setInt(2, d.getIdThuePhong());
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) return false;
            
            // nếu chưa từng đánh giá
            ps = conn.prepareStatement(sqlInsert);
            ps.setInt(1, d.getIdBaiDang());
            ps.setInt(2, d.getIdThuePhong());
            ps.setInt(3, d.getSoDiem());
            
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public void delete(BaiDaLuu bdl) {
        String sql = "DELETE FROM bai_da_luu WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bdl.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public BaiDaLuu getBdlById(int id, TaiKhoan user) {
        BaiDaLuu bdl = new BaiDaLuu();
        bdl.setId(-1);
        
        String sql = "SELECT * FROM bai_da_luu WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                bdl.setId(id);
                bdl.setIdBaiDang(rs.getInt("idBaiDang"));
                bdl.setIdThuePhong(rs.getInt("idThuePhong"));
                bdl.setThuePhong(user);
                bdl.setBaiDang(getPostById(rs.getInt("idBaiDang")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bdl;
    }
    
    public List<BaiDaLuu> getAllSavedPosts(TaiKhoan user) {
        List<BaiDaLuu> bdls = new ArrayList<>();
        String sql = "SELECT * FROM bai_da_luu WHERE idThuePhong=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                BaiDaLuu bdl = new BaiDaLuu();
                
                bdl.setId(rs.getInt("id"));
                bdl.setIdBaiDang(rs.getInt("idBaiDang"));
                bdl.setIdThuePhong(rs.getInt("idThuePhong"));
                bdl.setThuePhong(user);
                bdl.setBaiDang(getPostById(rs.getInt("idBaiDang")));
                
                bdls.add(bdl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bdls;
    }
    
    public boolean checkSavedBefore(BaiDaLuu link) {
        String sql = "SELECT * FROM bai_da_luu WHERE idThuePhong=? AND idBaiDang=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, link.getThuePhong().getId());
            ps.setInt(2, link.getBaiDang().getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void insert(BaiDaLuu link) {
        String sql = "INSERT INTO bai_da_luu(idThuePhong,idBaiDang) VALUES(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, link.getThuePhong().getId());
            ps.setInt(2, link.getBaiDang().getId());
            
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(BaiDang post) {
        String sql = "DELETE FROM bai_dang WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, post.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(int idBaiDang) {
        String sql = "DELETE FROM bai_dang WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idBaiDang);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(BaiDang post) {
        String sql = "UPDATE bai_dang SET khuVuc=?,gia=?,soPhongTrong=?,chiTiet=?,diemDanhGia=? WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, post.getKhuVuc());
            ps.setInt(2, post.getGia());
            ps.setInt(3, post.getSoPhongTrong());
            ps.setString(4, post.getChiTiet());
            ps.setDouble(5, post.getDiemDanhGia());
            ps.setInt(6, post.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public BaiDang getPostById(int id) {
        BaiDang post = new BaiDang();
        post.setId(-1);
        
        String sql = "SELECT * FROM bai_dang WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                post.setId(id);
                post.setChiTiet(rs.getString("chiTiet"));
                post.setDiemDanhGia(rs.getDouble("diemDanhGia"));
                post.setGia(rs.getInt("gia"));
                post.setIdChuTro(rs.getInt("idChuTro"));
                post.setKhuVuc(rs.getString("khuVuc"));
                post.setSoPhongTrong(rs.getInt("soPhongTrong"));
                post.setTenCT(rs.getString("tenCT"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return post;
    }
    
    public List<BaiDang> getAllPosts() {
        List<BaiDang> posts = new ArrayList<>();
        
        String sql = "SELECT * FROM bai_dang";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                BaiDang post = new BaiDang();
                
                post.setId(rs.getInt("id"));
                post.setIdChuTro(rs.getInt("idChuTro"));
                post.setTenCT(rs.getString("tenCT"));
                post.setKhuVuc(rs.getString("khuVuc"));
                post.setSoPhongTrong(rs.getInt("soPhongTrong"));
                post.setGia(rs.getInt("gia"));
                post.setChiTiet(rs.getString("chiTiet"));
                post.setDiemDanhGia(rs.getDouble("diemDanhGia"));
                
                posts.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return posts;
    }
    
    public void insert(BaiDang post) {
        String sql = "INSERT INTO bai_dang(idChuTro,tenCT,khuVuc,soPhongTrong,gia,chiTiet,diemDanhGia) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, post.getIdChuTro());
            ps.setString(2, post.getTenCT());
            ps.setString(3, post.getKhuVuc());
            ps.setInt(4, post.getSoPhongTrong());
            ps.setInt(5, post.getGia());
            ps.setString(6, post.getChiTiet());
            ps.setDouble(7, post.getDiemDanhGia());
            
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void closeDBConnection() {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
