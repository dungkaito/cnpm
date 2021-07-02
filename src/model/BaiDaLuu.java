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
public class BaiDaLuu {
    private int id;
    private int idThuePhong;
    private int idBaiDang;
    private TaiKhoan thuePhong;
    private BaiDang baiDang;

    public BaiDaLuu() {
    }

    public BaiDaLuu(int id, int idThuePhong, int idBaiDang, TaiKhoan thuePhong, BaiDang baiDang) {
        this.id = id;
        this.idThuePhong = idThuePhong;
        this.idBaiDang = idBaiDang;
        this.thuePhong = thuePhong;
        this.baiDang = baiDang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdThuePhong() {
        return idThuePhong;
    }

    public void setIdThuePhong(int idThuePhong) {
        this.idThuePhong = idThuePhong;
    }

    public int getIdBaiDang() {
        return idBaiDang;
    }

    public void setIdBaiDang(int idBaiDang) {
        this.idBaiDang = idBaiDang;
    }

    public TaiKhoan getThuePhong() {
        return thuePhong;
    }

    public void setThuePhong(TaiKhoan thuePhong) {
        this.thuePhong = thuePhong;
    }

    public BaiDang getBaiDang() {
        return baiDang;
    }

    public void setBaiDang(BaiDang baiDang) {
        this.baiDang = baiDang;
    }
    
    
}
