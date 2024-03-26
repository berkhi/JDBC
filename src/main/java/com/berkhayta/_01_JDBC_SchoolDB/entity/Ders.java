package com.berkhayta._01_JDBC_SchoolDB.entity;

public class Ders {
    Integer id;
    String ad;

    public Ders() {
    }

    public Ders(String ad) {
        this.ad = ad;
    }

    public Ders(Integer id, String ad) {
        this.id = id;
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "Ders{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
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
}
