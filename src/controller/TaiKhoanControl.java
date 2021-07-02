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
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.TaiKhoan;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author Dinh Dung
 */
public class TaiKhoanControl {
    private Connection conn;

    public TaiKhoanControl() {
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
    
    public boolean getInfoByUsername(TaiKhoan account, String username){
        boolean value = false;
        PreparedStatement ps = null;
        String sql = "select * from tai_khoan where username = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                account.setHoTen(rs.getString("hoTen"));
                account.setDiaChi(rs.getString("diaChi"));
                account.setSdt(rs.getString("sdt"));
                value = true;
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
    
    public boolean checkNewPassword(String passOne, String passTwo){
        if(passOne.matches("[a-zA-Z_0-9]{8,20}") == true && passOne.equals(passTwo) == true){
            return true;
        }
        return false;
    }
    
    public boolean checkCurrentPassword(String username, String currentPass){
        PreparedStatement ps = null;
        String sql = "select password from tai_khoan where username = ?";
        boolean value = false;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(currentPass.equals(rs.getString("password")) == true){
                    value = true;
                }
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
    
    public void updateChangePassword(String username, String passOne){
        PreparedStatement ps = null;
        String sql = "update tai_khoan set password = ? where username = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, passOne);
            ps.setString(2, username);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean getUserByEmail(String email){
        PreparedStatement preparedStatement = null;
        String sql = "select * from tai_khoan where email = ?";
        boolean value = false;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                value = true;
            }
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
    
    public String updateForgotPassword(String email){
        PreparedStatement preparedStatement = null;
        String sql = "update tai_khoan set password = ? where email = ?";
        String randomPass = RandomStringUtils.randomAlphanumeric(8);
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, randomPass);
            preparedStatement.setString(2, email);
            int x = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return randomPass;
    }
    
    public boolean connectServerSmtpAndSendData(String email, String password){
        final int TLS_PORT = 587;
        final String FROM_EMAIL = "huynhminhcuong51020@gmail.com";
        final String PASSWORD_EMAIL = "cng20000";
        Properties properties;
        Session session;
        Message message;
        
        properties = new Properties();
        properties.put("mail.smtp.port", TLS_PORT);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        
        session = Session.getDefaultInstance(properties, null);
        message = new MimeMessage(session);
        
        try {
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("Đặt lại mật khẩu mới");
            message.setText(password);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", FROM_EMAIL, PASSWORD_EMAIL);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void deleteUsers(List<Integer> ids) {
        for (int id : ids) {
            delete(id);
        }
    }
    
    public void delete(int id) {
        String sql = "DELETE FROM tai_khoan WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<TaiKhoan> getUsersByName(String name) {
        List<TaiKhoan> users = new ArrayList<>();
        
        String sql = "SELECT * FROM tai_khoan WHERE hoTen LIKE ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+name+"%");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                TaiKhoan user = new TaiKhoan();
                
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setSdt(rs.getString("sdt"));
                user.setHoTen(rs.getString("hoTen"));
                user.setDiaChi(rs.getString("diaChi"));
                user.setRole(rs.getInt("role"));
                
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
    
    public TaiKhoan getUserByUsername(String username) {
        TaiKhoan user = new TaiKhoan();
        user.setUsername("");
        
        String sql = "SELECT * FROM tai_khoan WHERE username=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsername(username);
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setSdt(rs.getString("sdt"));
                user.setHoTen(rs.getString("hoTen"));
                user.setDiaChi(rs.getString("diaChi"));
                user.setRole(rs.getInt("role"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return user;
    }
    
    public void update(TaiKhoan user) {
        String sql = "UPDATE tai_khoan SET password=?, email=?, sdt=?, hoTen=?, diaChi=? WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getSdt());
            ps.setString(4, user.getHoTen());
            ps.setString(5, user.getDiaChi());
            ps.setInt(6, user.getId());
            
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int login(TaiKhoan user) {
        if (checkLogin(user))
            return user.getRole();
        return 0;
    }
    
    public boolean checkLogin(TaiKhoan user) {
        String sql = "SELECT * FROM tai_khoan WHERE username=? AND password=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setHoTen(rs.getString("hoTen"));
                user.setSdt(rs.getString("sdt"));
                user.setDiaChi(rs.getString("diaChi"));
                user.setRole(rs.getInt("role"));
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public String signUp(TaiKhoan user) {
        String email = user.getEmail();
        String username = user.getUsername();
        
        if (checkIfEmailExists(email)) {
            return "Email đã tồn tại trên hệ thống.";
        }
        
        if (checkIfUsernameExists(username)) {
            return "Tên đăng nhập đã tồn tại trên hệ thống.";
        }
        
        insert(user);
        return "Đăng ký thành công.";
    }
    
    public boolean checkIfEmailExists(String email) {
        String sql = "SELECT id FROM tai_khoan WHERE email=?";
        try {
            PreparedStatement prstm = conn.prepareStatement(sql);
            prstm.setString(1, email);
            ResultSet rs = prstm.executeQuery();
            if (rs.next()) return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean checkIfUsernameExists(String username) {
        String sql = "SELECT id FROM tai_khoan WHERE username=?";
        try {
            PreparedStatement prstm = conn.prepareStatement(sql);
            prstm.setString(1, username);
            ResultSet rs = prstm.executeQuery();
            if (rs.next()) return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void insert(TaiKhoan user) {
        String sql = "INSERT INTO tai_khoan(username, password, email, sdt, hoTen, diaChi, role) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getSdt());
            ps.setString(5, user.getHoTen());
            ps.setString(6, user.getDiaChi());
            ps.setInt(7, user.getRole());
            
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
