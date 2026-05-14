package com.workintech.sqldmlprocedures.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "kitap")
public class Kitap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long kitapno;
    private String ad;
    private int puan;
    private long yazarno;
    private long turno;

    public Kitap() {
    }

    public Kitap(long kitapno, String ad, int puan, long yazarno, long turno) {
        this.kitapno = kitapno;
        this.ad = ad;
        this.puan = puan;
        this.yazarno = yazarno;
        this.turno = turno;
    }

    public long getKitapno() {
        return kitapno;
    }

    public void setKitapno(long kitapno) {
        this.kitapno = kitapno;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public long getYazarno() {
        return yazarno;
    }

    public void setYazarno(long yazarno) {
        this.yazarno = yazarno;
    }

    public long getTurno() {
        return turno;
    }

    public void setTurno(long turno) {
        this.turno = turno;
    }
}
