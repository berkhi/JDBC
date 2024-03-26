package com.berkhayta._02_JDBC_SatisDB.entity;

public class Adres {
    Integer id;
    Integer musteri_id;
    String il;
    String ilce;
    String mahalle;
    String adres;

    public Adres() {
    }

    public Adres(Integer musteri_id, String il, String ilce, String mahalle, String adres) {
        this.musteri_id = musteri_id;
        this.il = il;
        this.ilce = ilce;
        this.mahalle = mahalle;
        this.adres = adres;
    }

    public Adres(Integer id, Integer musteri_id, String il, String ilce, String mahalle, String adres) {
        this.id = id;
        this.musteri_id = musteri_id;
        this.il = il;
        this.ilce = ilce;
        this.mahalle = mahalle;
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "id=" + id +
                ", musteri_id=" + musteri_id +
                ", il='" + il + '\'' +
                ", ilce='" + ilce + '\'' +
                ", mahalle='" + mahalle + '\'' +
                ", adres='" + adres + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMusteri_id() {
        return musteri_id;
    }

    public void setMusteri_id(Integer musteri_id) {
        this.musteri_id = musteri_id;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public String getMahalle() {
        return mahalle;
    }

    public void setMahalle(String mahalle) {
        this.mahalle = mahalle;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
