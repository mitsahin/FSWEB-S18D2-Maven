package com.workintech.sqldmlprocedures.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "yazar")
public class Yazar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long yazarno;
    private String ad;
    private String soyad;

    public Yazar() {
    }

    public Yazar(long yazarno, String ad, String soyad) {
        this.yazarno = yazarno;
        this.ad = ad;
        this.soyad = soyad;
    }

    public long getYazarno() {
        return yazarno;
    }

    public void setYazarno(long yazarno) {
        this.yazarno = yazarno;
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
}
