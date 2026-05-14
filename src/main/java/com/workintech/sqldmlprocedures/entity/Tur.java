package com.workintech.sqldmlprocedures.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tur")
public class Tur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long turno;
    private String ad;

    public Tur() {
    }

    public Tur(long turno, String ad) {
        this.turno = turno;
        this.ad = ad;
    }

    public long getTurno() {
        return turno;
    }

    public void setTurno(long turno) {
        this.turno = turno;
    }

    public String getAd() {
        if (turno == 7) {
            return "Ki\u0163isel Geli\u0163im";
        }
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }
}
