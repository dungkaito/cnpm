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
public class DanhGia {
    private int id;
    private int idBaiDang;
    private int idThuePhong;
    private int soDiem;

    public DanhGia() {
    }

    public DanhGia(int id, int idBaiDang, int idChuTro, int soDiem) {
        this.id = id;
        this.idBaiDang = idBaiDang;
        this.idThuePhong = idThuePhong;
        this.soDiem = soDiem;
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

    public int getSoDiem() {
        return soDiem;
    }

    public void setSoDiem(int soDiem) {
        this.soDiem = soDiem;
    }
    
    
   
}
