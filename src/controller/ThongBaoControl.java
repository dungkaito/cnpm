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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.ThongBao;

/**
 *
 * @author Dinh Dung
 */
public class ThongBaoControl {
    private Connection conn;

    public ThongBaoControl() {
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
    
    public List<ThongBao> getListThongBaoById(int idUser) {
        List<ThongBao> tbs = new ArrayList<>();
        String sql = "SELECT * FROM thong_bao WHERE idUser=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongBao tb = new ThongBao();
                
                tb.setId(rs.getInt("id"));
                tb.setIdUser(rs.getInt("idUser"));
                tb.setNoiDung(rs.getString("noiDung"));
                tb.setThoiGian(rs.getDate("thoiGian"));
                
                tbs.add(tb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbs;
    }
    
    public void insert(ThongBao tb) {
        String sql = "INSERT INTO thong_bao(idUser, noiDung, thoiGian) VALUES(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, tb.getIdUser());
            ps.setString(2, tb.getNoiDung());
            ps.setDate(3, new java.sql.Date(tb.getThoiGian().getTime()));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void insert(List<Integer> ids, String noiDung) {
        String sql = "INSERT INTO thong_bao(idUser, noiDung, thoiGian) VALUES(?,?,?)";
        PreparedStatement ps = null;
        for(int id:ids) {
            try {
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.setString(2, noiDung);
                ps.setDate(3, new java.sql.Date((new Date()).getTime()));
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
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
