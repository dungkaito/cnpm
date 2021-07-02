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
public class BaoCao {
    private int id;
    private int idGuiBC;
    private int idBiBC;
    private int loaiBC; //1: bai dang    2: binh luan
    private String noiDungBC;
    private int idBinhLuan; //for only bao cao binh luan
    private int idBaiDang; // for only bao cao bai dang

    public BaoCao() {
    }

    public BaoCao(int id, int idGuiBC, int idBiBC, int loaiBC, String noiDungBC, int idBinhLuan, int idBaiDang) {
        this.id = id;
        this.idGuiBC = idGuiBC;
        this.idBiBC = idBiBC;
        this.loaiBC = loaiBC;
        this.noiDungBC = noiDungBC;
        this.idBinhLuan = idBinhLuan;
        this.idBaiDang = idBaiDang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGuiBC() {
        return idGuiBC;
    }

    public void setIdGuiBC(int idGuiBC) {
        this.idGuiBC = idGuiBC;
    }

    public int getIdBiBC() {
        return idBiBC;
    }

    public void setIdBiBC(int idBiBC) {
        this.idBiBC = idBiBC;
    }

    public int getLoaiBC() {
        return loaiBC;
    }

    public void setLoaiBC(int loaiBC) {
        this.loaiBC = loaiBC;
    }

    public String getNoiDungBC() {
        return noiDungBC;
    }

    public void setNoiDungBC(String noiDungBC) {
        this.noiDungBC = noiDungBC;
    }

    public int getIdBinhLuan() {
        return idBinhLuan;
    }

    public void setIdBinhLuan(int idBinhLuan) {
        this.idBinhLuan = idBinhLuan;
    }

    public int getIdBaiDang() {
        return idBaiDang;
    }

    public void setIdBaiDang(int idBaiDang) {
        this.idBaiDang = idBaiDang;
    }
    
    
}
