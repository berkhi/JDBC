package com.berkhayta._03_JDBC_ForumDB.controller;

import com.berkhayta._03_JDBC_ForumDB.Runner;
import com.berkhayta._03_JDBC_ForumDB.entity.Users;
import com.berkhayta._03_JDBC_ForumDB.repository.UsersRepository;

import java.util.Optional;
import java.util.Scanner;

public class UserController {
    public void Login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username giriniz: ");
        String username = scanner.nextLine();
        System.out.println("Password giriniz: ");
        String password = scanner.nextLine();

        Optional<Users> user = loginUser(username, password);
        if (user.isPresent()) {
            System.out.println("Başarıyla giriş yapıldı.");
            MainController.loginMenu(user.get());
        } else {
            System.out.println("Kullanıcı adı veya şifre hatalı.");
        }
    }

    private static Optional<Users> loginUser(String username, String password) {
        UsersRepository usersRepository = new UsersRepository();
        return usersRepository.findByUsernameAndPassword(username, password);
    }

    public void Register(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username giriniz: ");
        String username = scanner.nextLine();

        if (existsUsername(username)) {
            System.out.println("Bu kullanıcı zaten kayıtlı.");
        } else {
            System.out.println("Adınızı giriniz:");
            String ad = scanner.nextLine();
            System.out.println("Soyadınızı giriniz: ");
            String soyad = scanner.nextLine();
            System.out.println("Password giriniz: ");
            String password = scanner.nextLine();
            Users yeniUser = new Users(username, ad, soyad, password);
            new UsersRepository().save(yeniUser);
        }
    }
    public static boolean existsUsername(String username) {
        UsersRepository usersRepository = new UsersRepository();
        Optional<Users> user = usersRepository.findByUsername(username);
        return user.isPresent();
    }
}
