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
import model.BaoCao;

/**
 *
 * @author Dinh Dung
 */
public class BaoCaoControl {
    private Connection conn;

    public BaoCaoControl() {
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
    
    public void delete(int id) {
        String sql = "DELETE FROM bao_cao WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<BaoCao> getAllReport() {
        List<BaoCao> reports = new ArrayList<>();
        String sql = "SELECT * FROM bao_cao"; 
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BaoCao r = new BaoCao();
                
                r.setId(rs.getInt("id"));
                r.setIdBiBC(rs.getInt("idBiBC"));
                r.setIdGuiBC(rs.getInt("idGuiBC"));
                r.setIdBinhLuan(rs.getInt("idBinhLuan"));
                r.setLoaiBC(rs.getInt("loaiBC"));
                r.setNoiDungBC(rs.getString("noiDungBC"));
                r.setIdBaiDang(rs.getInt("idBaiDang"));
                
                reports.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reports;
    }
    
    public void insert(BaoCao bc) {
        String sql1 = "INSERT INTO bao_cao(idGuiBC,idBiBC,loaiBC,noiDungBC,idBaiDang) VALUES(?,?,?,?,?)";
        String sql2 = "INSERT INTO bao_cao(idGuiBC,idBiBC,loaiBC,noiDungBC,idBaiDang,idBinhLuan) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = null;
            if (bc.getLoaiBC()==1) {
                // bao cao bai dang
                ps = conn.prepareStatement(sql1);
            
                ps.setInt(1, bc.getIdGuiBC());
                ps.setInt(2, bc.getIdBiBC());
                ps.setInt(3, bc.getLoaiBC());
                ps.setString(4, bc.getNoiDungBC());
                ps.setInt(5, bc.getIdBaiDang());
                
            } else {
                // bao cao binh luan
                ps = conn.prepareStatement(sql2);
            
                ps.setInt(1, bc.getIdGuiBC());
                ps.setInt(2, bc.getIdBiBC());
                ps.setInt(3, bc.getLoaiBC());
                ps.setString(4, bc.getNoiDungBC());
                ps.setInt(5, bc.getIdBaiDang());
                ps.setInt(6, bc.getIdBinhLuan());
            }
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
