package com.berkhayta._02_JDBC_SatisDB.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Musteriler {
    Integer id;
    String ad;
    String soyad;
    String cinsiyet;
    int dtarih;
    String email;
    String tel;

    public Musteriler() {
    }

    public Musteriler(String ad, String soyad, String cinsiyet, int dtarih, String email, String tel) {
        this.ad = ad;
        this.soyad = soyad;
        this.cinsiyet = cinsiyet;
        this.dtarih = dtarih;
        this.email = email;
        this.tel = tel;
    }

    public Musteriler(Integer id, String ad, String soyad, String cinsiyet, int dtarih, String email, String tel) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.cinsiyet = cinsiyet;
        this.dtarih = dtarih;
        this.email = email;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Musteriler{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", cinsiyet='" + cinsiyet + '\'' +
                ", dtarih=" + dtarih +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getDtarih() {
        return dtarih;
    }

    public void setDtarih(int dtarih) {
        this.dtarih = dtarih;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
