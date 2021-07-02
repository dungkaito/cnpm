/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Dinh Dung
 */
public class BaiDang {
    private int id;
    private int idChuTro;
    private String tenCT;
    private String khuVuc;
    private int soPhongTrong;
    private int gia;
    private String chiTiet;
    private double diemDanhGia;

    public BaiDang() {
    }

    public BaiDang(int id, int idChuTro, String tenCT, String khuVuc, int soPhongTrong, int gia, String chiTiet, double diemDanhGia) {
        this.id = id;
        this.idChuTro = idChuTro;
        this.tenCT = tenCT;
        this.khuVuc = khuVuc;
        this.soPhongTrong = soPhongTrong;
        this.gia = gia;
        this.chiTiet = chiTiet;
        this.diemDanhGia = diemDanhGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdChuTro() {
        return idChuTro;
    }

    public void setIdChuTro(int idChuTro) {
        this.idChuTro = idChuTro;
    }

    public String getTenCT() {
        return tenCT;
    }

    public void setTenCT(String tenCT) {
        this.tenCT = tenCT;
    }

    public String getKhuVuc() {
        return khuVuc;
    }

    public void setKhuVuc(String khuVuc) {
        this.khuVuc = khuVuc;
    }

    public int getSoPhongTrong() {
        return soPhongTrong;
    }

    public void setSoPhongTrong(int soPhongTrong) {
        this.soPhongTrong = soPhongTrong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(String chiTiet) {
        this.chiTiet = chiTiet;
    }

    public double getDiemDanhGia() {
        return diemDanhGia;
    }

    public void setDiemDanhGia(double diemDanhGia) {
        this.diemDanhGia = diemDanhGia;
    }

    public void setDiemDanhGia(List<Integer> diem) {
        double sum=0;
        for (int x:diem) sum+=x;
        sum/=diem.size();
        this.diemDanhGia=sum;
    }
    
}
