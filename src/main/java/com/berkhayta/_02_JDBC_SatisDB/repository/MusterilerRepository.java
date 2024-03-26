package com.berkhayta._02_JDBC_SatisDB.repository;

import com.berkhayta._02_JDBC_SatisDB.entity.Musteriler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MusterilerRepository implements ICrud<Musteriler>{
    String sql;
    private DatabaseHalper databaseHalper;

    public MusterilerRepository() {
        this.databaseHalper = new DatabaseHalper();
    }

    public void save(Musteriler musteriler){
        String sql = "INSERT INTO tblmusteriler(ad,soyad,cinsiyet,dtarih,email,tel) VALUES ('%s', '%s', '%s', '%s', '%s', '%s')"
                .formatted(musteriler.getAd(), musteriler.getSoyad(), musteriler.getCinsiyet(),musteriler.getEmail(),musteriler.getTel());
        databaseHalper.executeUpdate(sql);
    }
    public void update(Musteriler musteriler){
        String sql = "UPDATE tblmusteriler SET ad='%s', soyad='%s',cinsiyet='%s',dtarih='%s',email='%s',tel='%s' where id=%d"
                .formatted(musteriler.getAd(),musteriler.getSoyad(),musteriler.getCinsiyet(),musteriler.getDtarih(),musteriler.getEmail(),musteriler.getTel(),musteriler.getId());
        databaseHalper.executeUpdate(sql);
    }
    public void delete(int id){
        String sql = "DELETE FROM tblmusteriler WHERE id = %d"
                .formatted(id);
        databaseHalper.executeUpdate(sql);
    }

    public List<Musteriler> findAll(){
        String SQL_SELECT="SELECT * FROM tblmusteriler";
        ResultSet resultSet = databaseHalper.executeQuery(SQL_SELECT);
        List<Musteriler> dersArrayList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String ad = resultSet.getString("ad");
                String soyad = resultSet.getString("soyad");
                String cinsiyet = resultSet.getString("cinsiyet");
                int dtarih = resultSet.getInt("dtarih");
                String email = resultSet.getString("email");
                String tel = resultSet.getString("tel");

                Musteriler musteriler=new Musteriler(id,ad,soyad,cinsiyet,dtarih,email,tel);
                dersArrayList.add(musteriler);
            }
        } catch (SQLException e) {
            System.out.println("Veri getirmede sorun oluştu....");
        }
        return dersArrayList;
    }

    @Override
    public Musteriler findById(int id) {
        return null;
    }

}
