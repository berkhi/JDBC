package com.berkhayta._02_JDBC_SatisDB.repository;

import com.berkhayta._02_JDBC_SatisDB.entity.Adres;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdresRepository implements ICrud<Adres>{
    private DatabaseHalper databaseHalper;

    public AdresRepository() {
        this.databaseHalper = new DatabaseHalper();
    }

    public void save(Adres adres){
        String SQL_INSERT = "INSERT INTO tbladres(musteri_id,il,ilce,mahalle,adres) VALUES ('%s','%s','%s','%s','%s')"
                .formatted(adres.getMusteri_id(),adres.getIl(),adres.getIlce(),adres.getMahalle(),adres.getAdres());
        databaseHalper.executeUpdate(SQL_INSERT);
    }
    public void update(Adres adres){
        String SQL_UPDATE = "UPDATE tbladres SET musteri_id='%s', il='%s', ilce='%s', mahalle='%s', adres='%s' where id=%d"
                .formatted(adres.getMusteri_id(),adres.getIl(),adres.getIlce(),adres.getMahalle(),adres.getAdres(), adres.getId());
        databaseHalper.executeUpdate(SQL_UPDATE);
    }
    public void delete(int id){
        String SQL_DELETE = "DELETE FROM tbladres WHERE id = %d"
                .formatted(id);
        databaseHalper.executeUpdate(SQL_DELETE);
    }

    public List<Adres> findAll(){
        String SQL_SELECT="SELECT * FROM tbladres";
        ResultSet resultSet = databaseHalper.executeQuery(SQL_SELECT);
        List<Adres> adresArrayList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int musteri_id= resultSet.getInt("musteri_id");
                String il = resultSet.getString("il");
                String ilce = resultSet.getString("ilce");
                String mahalle = resultSet.getString("mahalle");
                String adres = resultSet.getString("adres");

                Adres adress=new Adres(id,musteri_id,il,ilce,mahalle,adres);
                adresArrayList.add(adress);
            }
        } catch (SQLException e) {
            System.out.println("Veri getirmede sorun oluştu....");
        }
        return adresArrayList;
    }

    @Override
    public Adres findById(int id) {
        return null;
    }
}
