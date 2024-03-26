package com.berkhayta._00_JDBC_Baslangic;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * VERİTABANI DRIVER:
 * Bir programlama dili ile bir veritabanı arasında iletişim kurmayı sağlayan yazılım veya bileşendir.
 * Veritabanı driverı ile:
 *  Veritabanı sunucuna bağlantı kurabileceğim.
 *  Veritabanı ile iletişim kurup komut gönderebileceğim.
 *  Sorgular gönderebiliriz.
 *  Geri dönen değerleri alabiliriz.
 * gibi işlemleri yerine getirebiliriz.
 *
 * Her bir vt üreticisi her bir programlama dili için driverler üretirler.
 *
 * PostgreSQL - Java Driver'a ihtiyacımız vardı.
 * Bunun için maven repository sitesine girdik.
 * postgresql jdbc driver diyerek arattık.
 * Karşımıza çıkan en son sürümün Gradle bağımlılık cümlesini kopyaladık.
 * Projemizdeki build.gradle dosyasını açtık.
 * Bu dosya içinde dependencies bloğu içine kopyaladığımız bağımlılık cümlesini ekledik:
 * dependencies {
 *     implementation 'org.postgresql:postgresql:42.7.3'
 * }
 * dependencies: bağımlılık. (Projenizde kullandığınız harici kütüphaneler)
 */


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // JDBC kullanımında ilk olarak yapılması gereken DRIVER'in devreye alınmasıdır:
        // Java 1.6 Driver.class.forName("org.postgresql.Driver");

        //javadan postgresql server'a gitmem gerekli.
        // hostname: localhost
        // port: 5432
        // username: postgres
        // password: 1234

        // ConnectionString - Bağlantı Cümlesi
        String connectionString="jdbc:postgresql://localhost:5432/SatisDB";
        String username="postgres";
        String password="1234";
        // Parametrelerle bir connection oluşturduk:
        Connection connection = DriverManager.getConnection(connectionString, username, password);

        //String olarak bir SQL komutu yazalım:
        String ADRES_INSERT_SQL="INSERT INTO tbladres(musteri_id,il,ilce) VALUES (1001,'İstanbul','Kadıköy')";
        // String olarak bir sorgu direkt connection nesnesi aracılığı ile çalıştırılamaz.
        // Bunun için öncelikle bu komutun hazırlanması gerekir.
        PreparedStatement preparedStatement = connection.prepareStatement(ADRES_INSERT_SQL);
        // bu işlem sonucunda artık yazdığımız SQL ifadesi preparedStatement nesnesi ile çalıştırılabilir hale gelmiştir.
        preparedStatement.executeUpdate(); // bu adım sorgumuzun vt serverinde çalıştırılmasını sağlar.
        /*
        preparedStatement: SQL sorgularımızı çalıştırabileceğimiz metodlara sahip bir interfacedir.
         */
        connection.close();

    }



}