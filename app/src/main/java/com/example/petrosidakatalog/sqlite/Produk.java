package com.example.petrosidakatalog.sqlite;

import java.io.Serializable;


public class Produk implements Serializable {
    private int produkId;
    private String produkNama;
    private String produkJenis;
    private String produkDeskripsi;
    private String produkKeunggulan;
    private String produkDetail;
    private String ProdukPetunjuk;
    private String produkGambar;
    private String GambarLain;
    private int kategoriId;

    public Produk() {
    }

    public Produk(int produkId, String produkNama, String produkJenis, String produkDeskripsi, String produkKeunggulan, String produkDetail, String ProdukPetunjuk, String produkGambar, String GambarLain, int kategoriId) {
        this.produkId = produkId;
        this.produkNama= produkNama;
        this.produkJenis = produkJenis;
        this.produkDeskripsi = produkDeskripsi;
        this.produkKeunggulan = produkKeunggulan;
        this.produkDetail = produkDetail;
        this.ProdukPetunjuk = ProdukPetunjuk;
        this.produkGambar = produkGambar;
        this.GambarLain = GambarLain;
        this.kategoriId = kategoriId;
    }

    public int getProdukId() {
        return produkId;
    }

    public void setProdukId(int produkId) {
        this.produkId = produkId;
    }

    public String getProdukNama() {
        return produkNama;
    }

    public void setProdukNama(String produkNama) {
        this.produkNama = produkNama;
    }

    public String getProdukJenis() {
        return produkJenis;
    }

    public void setProdukJenis(String produkJenis) {
        this.produkJenis = produkJenis;
    }

    public String getProdukDeskripsi() {
        return produkDeskripsi;
    }

    public void setProdukDeskripsi(String produkDeskripsi) {
        this.produkDeskripsi = produkDeskripsi;
    }

    public String getProdukKeunggulan() {
        return produkKeunggulan;
    }

    public void setProdukKeunggulan(String produkKeunggulan) {
        this.produkKeunggulan = produkKeunggulan;
    }

    public String getProdukDetail() {
        return produkDetail;
    }

    public void setProdukDetail(String produkDetail) {
        this.produkDetail = produkDetail;
    }

    public String getProdukPetunjuk() {
        return ProdukPetunjuk;
    }

    public void setProdukPetunjuk(String ProdukPetunjuk) {
        this.ProdukPetunjuk = ProdukPetunjuk;
    }

    public String getProdukGambar() {
        return produkGambar;
    }

    public void setProdukGambar(String produkGambar) {
        this.produkGambar = produkGambar;
    }

    public String getGambarLain() {
        return GambarLain;
    }

    public void setGambarLain(String GambarLain) {
        this.GambarLain = GambarLain;
    }

    public int getkategoriId() {
        return kategoriId;
    }

    public void setkategoriId(int kategoriId) {
        this.kategoriId = kategoriId;
    }
}
