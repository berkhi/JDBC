package com.berkhayta._02_JDBC_SatisDB.repository;

import java.sql.*;

import static com.berkhayta._02_JDBC_SatisDB.utility.Constants.*;

public class DatabaseHalper {
    private Connection conn;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private boolean openConnection(){
        try {
            conn= DriverManager.getConnection("jdbc:postgresql://"+ DB_IP +":"+DB_PORT+"/"+DB_NAME, DB_USERNAME, DB_PASSWORD);
            return true;
        } catch (SQLException e) {
            System.out.println("Bağlantı açma hatası.....:"+e.getMessage());
            return false;
        }
    }

    private void closeConnection(){
        try {
            if(!conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Bağlantı kapatma hatası.....:"+e.getMessage());
        }
    }

    public boolean executeUpdate(String SQL){
        try {
            if(openConnection()){
                conn.prepareStatement(SQL).executeUpdate();
                closeConnection();
                return true;
            }
            else{
                System.out.println("Bağlantı açılamadı");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Sorgu çalıştıralamadı. SQL kodunda hata olabilir..."+e.getMessage());
            return false;
        }
    }

    public ResultSet executeQuery(String SQL){
        try {
            if(openConnection()){
                ResultSet rs = conn.prepareStatement(SQL).executeQuery();
                closeConnection();
                return rs;
            }
            else{
                System.out.println("Bağlantı açılamadı");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Sorgu çalıştıralamadı. SQL kodunda hata olabilir..."+e.getMessage());
            return null;
        }
    }

}
