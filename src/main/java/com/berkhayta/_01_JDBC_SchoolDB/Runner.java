package com.berkhayta._01_JDBC_SchoolDB;

import com.berkhayta._01_JDBC_SchoolDB.entity.Ders;
import com.berkhayta._01_JDBC_SchoolDB.entity.Ogrenci;
import com.berkhayta._01_JDBC_SchoolDB.repository.DersRepository;
import com.berkhayta._01_JDBC_SchoolDB.repository.OgrenciRepository;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int secim;
        do {
            System.out.println("""
                    ****** OKUL OTOMASYONU *******
                    1- Öğrenci Ekle
                    2- Öğrenci Listele
                    3- Öğrenci Düzenle
                    4- Ders Ekle
                    5- Ders Listele
                    6- Ders Düzenle
                    7- Ders Sil
                    0- ÇIKIŞ
                    """
            );
            System.out.print("Lütfen seçiminizi giriniz.....:");
            secim = new Scanner(System.in).nextInt();
            switch (secim) {
                case 1: ogrenciEkle(); break;
                case 2: ogrenciListele(); break;
                case 3: ogrenciGuncelle(); break;
                case 4: dersEkle(); break;
                case 5: dersListele(); break;
                case 6: dersGuncelle(); break;
                case 7: dersSil(); break;
                case 0:
                    System.out.println("Çıkış yapıldı...");
                    break;
                default:
                    System.out.println("Geçersiz seçim yapıldı...");
                    break;
            }
        }while(secim!=0);
        System.out.println("PROGRAM SONLANDI...");
    }

    private static void dersEkle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ders adi: ");
        String ad = scanner.nextLine();
        Ders yeniDers= new Ders(ad);
        new DersRepository().save(yeniDers);
    }
    private static void dersListele() {
        new DersRepository().findAll().forEach(System.out::println);
    }

    private static void dersGuncelle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Güncellenecek ders id giriniz:");
        int guncellenecekDersId= scanner.nextInt();scanner.nextLine();

        System.out.println("Ders adi: ");
        String ad = scanner.nextLine();

        Ders guncellenenDers= new Ders(guncellenecekDersId,ad);
        new DersRepository().update(guncellenenDers);
    }

    private static void dersSil() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Silinecek dersin ID'sini girin: ");
        int dersId = scanner.nextInt();
        new DersRepository().delete(dersId);
        System.out.println("Ders başarıyla silindi.");
    }

    private static void ogrenciEkle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ogrenci adi: ");
        String ad = scanner.nextLine();
        System.out.println("Ogrenci soyadi: ");
        String soyad = scanner.nextLine();
        System.out.println("Ogrenci yas: ");
        int yas = scanner.nextInt();   scanner.nextLine();
        System.out.println("Veli adi : ");
        String veliad = scanner.nextLine();
        System.out.println("Iletisim tel: ");
        String iletisimtel = scanner.nextLine();
        Ogrenci yeniOgrenci= new Ogrenci(ad,soyad,yas,veliad,iletisimtel);
        new OgrenciRepository().save(yeniOgrenci);
    }
    private static void ogrenciListele() {
       new OgrenciRepository().findAll().forEach(System.out::println);
    }

    private static void ogrenciGuncelle() {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Güncellenecek öğrenci id giriniz:");
        int guncellenecekOgrenciId= scanner.nextInt();scanner.nextLine();

        System.out.println("Ogrenci adi: ");
        String ad = scanner.nextLine();
        System.out.println("Ogrenci soyadi: ");
        String soyad = scanner.nextLine();
        System.out.println("Ogrenci yas: ");
        int yas = scanner.nextInt();   scanner.nextLine();
        System.out.println("Veli adi : ");
        String veliad = scanner.nextLine();
        System.out.println("Iletisim tel: ");
        String iletisimtel = scanner.nextLine();

        Ogrenci guncellenenOgrenci= new Ogrenci(guncellenecekOgrenciId,ad,soyad,yas,veliad,iletisimtel);
        new OgrenciRepository().update(guncellenenOgrenci);
    }




}
