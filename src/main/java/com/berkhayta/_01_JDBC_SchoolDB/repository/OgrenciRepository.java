package com.berkhayta._01_JDBC_SchoolDB.repository;

import com.berkhayta._01_JDBC_SchoolDB.entity.Ogrenci;
import com.berkhayta._01_JDBC_SchoolDB.repository.ICrud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OgrenciRepository implements ICrud<Ogrenci> {

    private DatabaseHalper databaseHalper;

    public OgrenciRepository() {
        this.databaseHalper = new DatabaseHalper();
    }

    public void save(Ogrenci ogrenci){
        String SQL_INSERT = "INSERT INTO tblogrenci(ad,soyad,yas,veliadi,iletisimtel) VALUES ('%s', '%s', %d, '%s', '%s')"
                .formatted(ogrenci.getAd(), ogrenci.getSoyad(), ogrenci.getYas(), ogrenci.getVeliadi(), ogrenci.getIletisimtel());
        databaseHalper.executeUpdate(SQL_INSERT);
    }
    public void update(Ogrenci ogrenci){
        String SQL_UPDATE = "UPDATE tblogrenci SET ad='%s', soyad='%s', yas=%d, veliadi='%s', iletisimtel='%s' where id=%d"
                .formatted(ogrenci.getAd(), ogrenci.getSoyad(), ogrenci.getYas(), ogrenci.getVeliadi(), ogrenci.getIletisimtel(),ogrenci.getId());
        databaseHalper.executeUpdate(SQL_UPDATE);
    }
    public void delete(int id){

    }
    public List<Ogrenci> findAll(){
        String SQL_SELECT="SELECT * FROM tblogrenci";
        ResultSet resultSet = databaseHalper.executeQuery(SQL_SELECT);
        List<Ogrenci> ogrenciList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String ad = resultSet.getString("ad");
                String soyad = resultSet.getString("soyad");
                int yas = resultSet.getInt("yas");
                String veliadi = resultSet.getString("veliadi");
                String iletisimtel = resultSet.getString("iletisimtel");

                Ogrenci ogrenci=new Ogrenci(id,ad,soyad,yas,veliadi,iletisimtel);
                ogrenciList.add(ogrenci);
            }
        } catch (SQLException e) {
            System.out.println("Veri getirmede sorun oluştu....");
        }
        return ogrenciList;
    }

    @Override
    public Ogrenci findById(int id) {
        return null;
    }


}
