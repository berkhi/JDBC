package com.berkhayta._03_JDBC_ForumDB.controller;

import com.berkhayta._03_JDBC_ForumDB.Runner;
import com.berkhayta._03_JDBC_ForumDB.entity.Users;
import com.berkhayta._03_JDBC_ForumDB.repository.UsersRepository;

import java.util.Scanner;

import static java.lang.StringTemplate.STR;


public class MainController {
    static Scanner scanner = new Scanner(System.in);
    public static void loginMenu(Users users) {
        System.out.println("Hoş Geldin " + users.getLastname() + " " + users.getName());
        do {
            System.out.println(STR."""
                    1- Postları görüntüle
                    2- Post Paylaş
                    3- Kullanıcıları görüntüle
                    4- Logout
                    """);
            int secim = scanner.nextInt();
            switch (secim) {
                case 1:
                    new ForumController().getPosts(users);
                    break;
                case 2:
                    new ForumController().createPost(users);
                    break;
                case 3:
                    new UsersRepository().findAll().forEach(System.out::println);
                    break;
                case 4:
                    new Runner().menu();
                    break;
                default:
                    System.out.println("Lütfen geçerli bir seçim yapınız.");
                    break;
            }
        }while (true);
    }
}
