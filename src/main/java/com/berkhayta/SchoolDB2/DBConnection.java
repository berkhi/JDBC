package com.berkhayta.SchoolDB2;

import java.sql.*;

public class DBConnection {
    public static void main(String[] args){
//        ogrenciEkle("Ali","Ali",20,"Ahmet","0555555444");
        ogrenciListele();
        ogrenciGuncelle(1,"Osman","Veli",12,"Ahmet","0555555444");
        ogrenciListele();

    }

    public static void ogrenciEkle(String ad, String soyad, int yas, String veliadi, String iletisimtel) {
        String ADRES_INSERT_SQL = "INSERT INTO tblogrenci(ad,soyad,yas,veliadi,iletisimtel) VALUES (?,?,?,?,?)";
        String connectionString = "jdbc:postgresql://localhost:5432/SchoolDB";
        String username = "postgres";
        String password = "1234";
        int i = 0;
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(ADRES_INSERT_SQL);
        ) {
            preparedStatement.setString(1, ad);
            preparedStatement.setString(2, soyad);
            preparedStatement.setInt(3, yas);
            preparedStatement.setString(4, veliadi);
            preparedStatement.setString(5, iletisimtel);
            i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("Kayıt başarıyla eklendi.");
            } else {
                System.out.println("Kaydetmede sorun var....");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void ogrenciListele(){
        String ADRES_SELECT_SQL = "SELECT * FROM tblogrenci";
        String connectionString = "jdbc:postgresql://localhost:5432/SchoolDB?user=postgres&password=1234";

        try (Connection connection = DriverManager.getConnection(connectionString);
             PreparedStatement preparedStatement = connection.prepareStatement(ADRES_SELECT_SQL);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String ad = resultSet.getString("ad");
                String soyad = resultSet.getString("soyad");
                int yas = resultSet.getInt("yas");
                String veliadi = resultSet.getString("veliadi");
                String iletisimtel = resultSet.getString("iletisimtel");

                System.out.println("id: "+ id+ " ad: " + ad + " soyad: " + soyad + " yas: " + yas + " veliadi: " + veliadi + "iletisimtel: " +iletisimtel);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void ogrenciGuncelle(int id, String ad, String soyad, int yas, String veliadi, String iletisimtel){
        String ADRES_UPDATE_SQL = "UPDATE tblogrenci SET ad =?, soyad =?, yas =?, veliadi =?, iletisimtel =? WHERE id =?";
        String connectionString = "jdbc:postgresql://localhost:5432/SchoolDB";
        String username = "postgres";
        String password = "1234";
        int i = 0;
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(ADRES_UPDATE_SQL);
        ) {
            preparedStatement.setString(1, ad);
            preparedStatement.setString(2, soyad);
            preparedStatement.setInt(3, yas);
            preparedStatement.setString(4, veliadi);
            preparedStatement.setString(5, iletisimtel);
            preparedStatement.setInt(6, id);
            i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("Kayıt başarıyla güncellendi.");
            } else {
                System.out.println("Güncellemede sorun var....");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void ogreciSil(int id) {
        String ADRES_DELETE_SQL = "DELETE FROM tblogrenci WHERE id =?";
        String connectionString = "jdbc:postgresql://localhost:5432/SchoolDB";
        String username = "postgres";
        String password = "1234";
        int i = 0;
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(ADRES_DELETE_SQL);
        ) {
            preparedStatement.setInt(1, id);
            i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("Kayıt başarıyla silindi.");
            } else {
                System.out.println("Silmede sorun var....");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
