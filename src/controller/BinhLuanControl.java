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
import model.BinhLuan;

/**
 *
 * @author Dinh Dung
 */
public class BinhLuanControl {
    private Connection conn;

    public BinhLuanControl() {
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
    
    public void delete(int idBinhLuan) {
        String sql = "DELETE FROM binh_luan WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idBinhLuan);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public BinhLuan getCommentById(int id) {
        BinhLuan b = new BinhLuan();
        String sql = "SELECT * FROM binh_luan WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                b.setId(id);
                b.setIdBaiDang(rs.getInt("idBaiDang"));
                b.setIdThuePhong(rs.getInt("idThuePhong"));
                b.setNoiDung(rs.getString("noiDung"));
                b.setUnameTP(rs.getString("unameTP"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
    
    public void insert(BinhLuan comment) {
        String sql = "INSERT INTO binh_luan(idBaiDang,idThuePhong,noiDung,unameTP) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, comment.getIdBaiDang());
            ps.setInt(2, comment.getIdThuePhong());
            ps.setString(3, comment.getNoiDung());
            ps.setString(4, comment.getUnameTP());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<BinhLuan> getAllComments(int idPost) {
        List<BinhLuan> comments = new ArrayList<>();
        
        String sql = "SELECT * FROM binh_luan WHERE idBaiDang=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idPost);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BinhLuan comment = new BinhLuan();
                
                comment.setId(rs.getInt("id"));
                comment.setIdBaiDang(rs.getInt("idBaiDang"));
                comment.setIdThuePhong(rs.getInt("idThuePhong"));
                comment.setNoiDung(rs.getString("noiDung"));
                comment.setUnameTP(rs.getString("unameTP"));
                
                comments.add(comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return comments;
    }
    
    public void closeDBConnection() {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
}
