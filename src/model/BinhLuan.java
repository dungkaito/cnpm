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
public class BinhLuan {
    private int id;
    private int idBaiDang;
    private int idThuePhong;
    private String unameTP;
    private String noiDung;

    public BinhLuan() {
    }

    public BinhLuan(int id, int idBaiDang, int idThuePhong, String unameTP, String noiDung) {
        this.id = id;
        this.idBaiDang = idBaiDang;
        this.idThuePhong = idThuePhong;
        this.unameTP = unameTP;
        this.noiDung = noiDung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBaiDang() {
        return idBaiDang;
    }

    public void setIdBaiDang(int idBaiDang) {
        this.idBaiDang = idBaiDang;
    }

    public int getIdThuePhong() {
        return idThuePhong;
    }

    public void setIdThuePhong(int idThuePhong) {
        this.idThuePhong = idThuePhong;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getUnameTP() {
        return unameTP;
    }

    public void setUnameTP(String unameTP) {
        this.unameTP = unameTP;
    }
    
    
    
}
