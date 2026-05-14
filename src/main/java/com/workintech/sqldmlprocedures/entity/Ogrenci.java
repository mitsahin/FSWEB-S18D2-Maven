package com.workintech.sqldmlprocedures.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ogrenci")
public class Ogrenci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ogrno;
    private String ad;
    private String soyad;
    private String cinsiyet;
    private String sinif;
    private int puan;
    @Column(nullable = true)
    private String dtarih;

    public Ogrenci() {
    }

    public Ogrenci(Long ogrno, String ad, String soyad, String cinsiyet, String sinif, int puan, String dtarih) {
        this.ogrno = ogrno;
        this.ad = ad;
        this.soyad = soyad;
        this.cinsiyet = cinsiyet;
        this.sinif = sinif;
        this.puan = puan;
        this.dtarih = dtarih;
    }

    public Long getOgrno() {
        return ogrno;
    }

    public void setOgrno(Long ogrno) {
        this.ogrno = ogrno;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getSinif() {
        return sinif;
    }

    public void setSinif(String sinif) {
        this.sinif = sinif;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public String getDtarih() {
        return dtarih;
    }

    public void setDtarih(String dtarih) {
        this.dtarih = dtarih;
    }
}
