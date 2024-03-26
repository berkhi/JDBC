package com.berkhayta._00_JDBC_Baslangic;

import java.sql.*;

public class Runner {
    public static void main(String[] args) {

        //adresEkle(1002,"İzmir","Bornova");
//        adresEklePrepared(1003, "Sakarya", "Ferizli");
//        adresSilPrepared(1054);
//        adresGuncellePrepared(1109, "Bolu", "Mengen");
        adresIleGoreListele("a");
    }

    private static void adresEkle(int musteri_id, String il, String ilce) throws SQLException {
        String ADRES_INSERT_SQL = "INSERT INTO tbladres(musteri_id,il,ilce) VALUES (" + musteri_id + ",'" + il + "','" + ilce + "')";
        String connectionString = "jdbc:postgresql://localhost:5432/SatisDBDers";
        String username = "postgres";
        String password = "1234";
        Connection connection = DriverManager.getConnection(connectionString, username, password);
        PreparedStatement preparedStatement = connection.prepareStatement(ADRES_INSERT_SQL);
        int i = preparedStatement.executeUpdate();
        if (i > 0) {
            System.out.println("Kayıt başarıyla eklendi.");
        } else {
            System.out.println("Kaydetmede sorun var....");
        }
        connection.close();
    }

    private static void adresEklePrepared(int musteri_id, String il, String ilce) {
        String ADRES_INSERT_SQL = "INSERT INTO tbladres(musteri_id,il,ilce) VALUES (?,?,?)";
        String connectionString = "jdbc:postgresql://localhost:5432/SatisDBDers";
        String username = "postgres";
        String password = "1234";
        int i = 0;
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(ADRES_INSERT_SQL);
        ) {
            preparedStatement.setInt(1, musteri_id);
            preparedStatement.setString(2, il);
            preparedStatement.setString(3, ilce);
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

    private static void adresSilPrepared(int id) {
        String ADRES_DELETE_SQL = "DELETE FROM tbladres WHERE id =?";
        String connectionString = "jdbc:postgresql://localhost:5432/SatisDBDers";
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

    private static void adresGuncellePrepared(int id, String il, String ilce){
        String ADRES_UPDATE_SQL = "UPDATE tbladres SET il =?, ilce =? WHERE id =?";
        String connectionString = "jdbc:postgresql://localhost:5432/SatisDBDers";
        String username = "postgres";
        String password = "1234";
        int i = 0;
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(ADRES_UPDATE_SQL);
        ) {
            preparedStatement.setString(1, il);
            preparedStatement.setString(2, ilce);
            preparedStatement.setInt(3, id);
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

    private static void adresIleGoreListele(String ilargs){
        String ADRES_SELECT_SQL = "SELECT * FROM tbladres WHERE il ILIKE ?"; //LIKE yerine ILIKE kullanırsanız ignoreCase gibi davranır.
        String connectionString = "jdbc:postgresql://localhost:5432/SatisDBDers?user=postgres&password=1234";

        try (Connection connection = DriverManager.getConnection(connectionString);
             PreparedStatement preparedStatement = connection.prepareStatement(ADRES_SELECT_SQL);
        ) {
            preparedStatement.setString(1, "%"+ilargs+"%");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
//                int musteriId = resultSet.getInt("musteri_id");
//                String il = resultSet.getString("il");
//                String ilce = resultSet.getString("ilce");
                //eğer get metodlarında columnIndex değeri vermek isterseniz, tablodaki column sırası 1den başlamaktadır.
                //1 nolu index de id değeri olduğu için onu atladık
                int musteriId = resultSet.getInt(2);
                String il = resultSet.getString(3);
                String ilce = resultSet.getString(4);
                System.out.println("Musteri_id: " + musteriId + " il: " + il + " ilce: " + ilce);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}