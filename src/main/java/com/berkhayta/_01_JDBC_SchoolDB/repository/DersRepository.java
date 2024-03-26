package com.berkhayta._01_JDBC_SchoolDB.repository;

import com.berkhayta._01_JDBC_SchoolDB.entity.Ders;
import com.berkhayta._01_JDBC_SchoolDB.repository.ICrud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DersRepository implements ICrud<Ders> {
    private DatabaseHalper databaseHalper;

    public DersRepository() {
        this.databaseHalper = new DatabaseHalper();
    }

    public void save(Ders ders){
        String SQL_INSERT = "INSERT INTO tblders(ad) VALUES ('%s')"
                .formatted(ders.getAd());
        databaseHalper.executeUpdate(SQL_INSERT);
    }
    public void update(Ders ders){
        String SQL_UPDATE = "UPDATE tblders SET ad='%s' where id=%d"
                .formatted(ders.getAd(),ders.getId());
        databaseHalper.executeUpdate(SQL_UPDATE);
    }
    public void delete(int id){
        String SQL_DELETE = "DELETE FROM tblders WHERE id = %d"
                .formatted(id);
        databaseHalper.executeUpdate(SQL_DELETE);
    }

    public List<Ders> findAll(){
        String SQL_SELECT="SELECT * FROM tblders";
        ResultSet resultSet = databaseHalper.executeQuery(SQL_SELECT);
        List<Ders> dersArrayList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String ad = resultSet.getString("ad");

                Ders ders=new Ders(id,ad);
                dersArrayList.add(ders);
            }
        } catch (SQLException e) {
            System.out.println("Veri getirmede sorun oluştu....");
        }
        return dersArrayList;
    }

    @Override
    public Ders findById(int id) {
        return null;
    }

}
