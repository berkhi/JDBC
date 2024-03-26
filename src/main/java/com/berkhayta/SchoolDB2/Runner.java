package com.berkhayta.SchoolDB2;

import java.util.Scanner;

import static com.berkhayta.SchoolDB2.DBConnection.*;

public class Runner {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        while (true) {
            System.out.println("1-Ogrenci Ekle");
            System.out.println("2-Ogrenci Listele");
            System.out.println("3-Ogrenci Düzenle");
            System.out.println("4-Ogrenci Sil");
            System.out.println("0-Çıkış");
            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    ogrenciEkleMenu();
                    break;
                case 2:
                    ogrenciListele();
                    break;
                case 3:
                    ogrenciListele();
                    ogrenciGuncelleMenu();
                    break;
                case 4:
                    ogrenciListele();
                    ogreciSilMenu();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Geçersiz secim girildi.");
                    break;
            }
        }
    }

    private static void ogreciSilMenu() {
        System.out.println("ID giriniz: ");
        int id = scanner.nextInt();
        ogreciSil(id);
    }

    private static void ogrenciGuncelleMenu() {
        System.out.println("ID giriniz: ");
        int id = scanner.nextInt();
        System.out.println("Ad giriniz: ");
        String ad = scanner.next();
        System.out.println("Soyad giriniz: ");
        String soyad = scanner.next();
        System.out.println("Yas giriniz: ");
        int yas = scanner.nextInt();
        System.out.println("Veli Ad giriniz: ");
        String veliadi = scanner.next();
        System.out.println("İletişim Tel giriniz: ");
        String iletisimtel = scanner.next();
        ogrenciGuncelle(id, ad, soyad, yas, veliadi, iletisimtel);
    }

    private static void ogrenciEkleMenu() {
        System.out.println("Ad giriniz: ");
        String ad = scanner.next();
        System.out.println("Soyad giriniz: ");
        String soyad = scanner.next();
        System.out.println("Yas giriniz: ");
        int yas = scanner.nextInt();
        System.out.println("Veli Ad giriniz: ");
        String veliadi = scanner.next();
        System.out.println("İletişim Tel giriniz: ");
        String iletisimtel = scanner.next();
        ogrenciEkle(ad, soyad, yas, veliadi, iletisimtel);
    }


}
