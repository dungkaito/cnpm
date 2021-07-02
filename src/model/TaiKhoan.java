/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dinh Dung
 */
public class TaiKhoan {
//    private static int sid = 1;
    private int id;
    private String username;
    private String password;
    private String email;
    private String sdt;
    private String hoTen;
    private String diaChi;
    private int role;

    public TaiKhoan() {
//        id = sid++; diaChi="";
    }

    public TaiKhoan(int id, String username, String password, String email, String sdt, String hoTen, String diaChi, int role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.sdt = sdt;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.role = role;
    }

//    public static int getSid() {
//        return sid;
//    }
//
//    public static void setSid(int sid) {
//        TaiKhoan.sid = sid;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
    
}
