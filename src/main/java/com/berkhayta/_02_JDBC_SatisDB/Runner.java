package com.berkhayta._02_JDBC_SatisDB;


import com.berkhayta._02_JDBC_SatisDB.entity.Adres;
import com.berkhayta._02_JDBC_SatisDB.entity.Musteriler;
import com.berkhayta._02_JDBC_SatisDB.repository.AdresRepository;
import com.berkhayta._02_JDBC_SatisDB.repository.MusterilerRepository;

import java.time.LocalDate;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int secim;
        do {
            System.out.println("""
                    ******  *******
                    1- Musteri Ekle
                    2- Musteri Listele
                    3- Musteri Düzenle
                    4- Adres Ekle
                    5- Adres Listele
                    6- Adres Düzenle
                    7- Adres Sil
                    0- ÇIKIŞ
                    """
            );
            System.out.print("Lütfen seçiminizi giriniz.....:");
            secim = new Scanner(System.in).nextInt();
            switch (secim) {
                case 1:
                    musteriEkle();
                    break;
                case 2:
                    musteriListele();
                    break;
                case 3:
                    musteriGuncelle();
                    break;
                case 4:
                    adresEkle();
                    break;
                case 5:
                    adresListele();
                    break;
                case 6:
                    adresGuncelle();
                    break;
                case 7:
                    adresSil();
                    break;
                case 0:
                    System.out.println("Çıkış yapıldı...");
                    break;
                default:
                    System.out.println("Geçersiz seçim yapıldı...");
                    break;
            }
        } while (secim != 0);
        System.out.println("PROGRAM SONLANDI...");
    }



    private static void adresEkle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Musteri id: ");
        int musteri_id = scanner.nextInt();
        System.out.println("Musteri il: ");
        String il = scanner.next();
        System.out.println("Musteri ilce: ");
        String ilce = scanner.next();
        System.out.println("Musteri mahalle: ");
        String mahalle = scanner.next();
        System.out.println("Musteri adres: ");
        String adres = scanner.next();
        Adres yeniAdres = new Adres(musteri_id, il, ilce, mahalle, adres);
        new AdresRepository().save(yeniAdres);
    }

    private static void adresListele() {
        new AdresRepository().findAll().forEach(System.out::println);
    }

    private static void adresGuncelle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Güncellenecek adres id giriniz:");
        int guncellenecekMusteriId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Musteri adi: ");
        String ad = scanner.nextLine();
        System.out.println("Musteri soyadi: ");
        String soyad = scanner.nextLine();
        System.out.println("Musteri cinsiyet: ");
        String cinsiyet = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Musteri D.Tarih : ");
        int dtarih = scanner.nextInt();
        System.out.println("Musteri email: ");
        String email = scanner.nextLine();
        System.out.println("Musteri tel: ");
        String tel = scanner.nextLine();

        Musteriler guncellenenMusteri = new Musteriler(guncellenecekMusteriId, ad, soyad, cinsiyet, dtarih, email, tel);
        new MusterilerRepository().update(guncellenenMusteri);
    }

    private static void adresSil() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Silmek istediğiniz adres id giriniz:");
        int guncellenecekMusteriId = scanner.nextInt();scanner.nextLine();
        new AdresRepository().delete(guncellenecekMusteriId);
        System.out.println("Adres başarıyla silindi.");
    }


    private static void musteriEkle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Musteri adi: ");
        String ad = scanner.next();
        System.out.println("Musteri soyadi: ");
        String soyad = scanner.next();
        System.out.println("Musteri cinsiyet: ");
        String cinsiyet = scanner.next();
        System.out.println("Musteri Dogum Tarih: ");
        int dtarih = scanner.nextInt();
        System.out.println("Musteri email: ");
        String email = scanner.next();
        System.out.println("Musteri tel: ");
        String tel = scanner.next();
        Musteriler yeniMusteri = new Musteriler(ad, soyad, cinsiyet, dtarih, email, tel);
        new MusterilerRepository().save(yeniMusteri);
    }

    private static void musteriListele() {
        new MusterilerRepository().findAll().forEach(System.out::println);
    }

    private static void musteriGuncelle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Güncellenecek öğrenci id giriniz:");
        int guncellenecekMusteriId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Musteri adi: ");
        String ad = scanner.next();
        System.out.println("Musteri soyadi: ");
        String soyad = scanner.next();
        System.out.println("Musteri cinsiyet: ");
        String cinsiyet = scanner.next();
        System.out.println("Musteri D.Tarih : ");
        int dtarih = scanner.nextInt(); scanner.nextLine();
        System.out.println("Musteri email: ");
        String email = scanner.next();
        System.out.println("Musteri tel: ");
        String tel = scanner.next();

        Musteriler guncellenenMusteri = new Musteriler(guncellenecekMusteriId, ad, soyad, cinsiyet, dtarih, email, tel);
        new MusterilerRepository().update(guncellenenMusteri);
    }

}
