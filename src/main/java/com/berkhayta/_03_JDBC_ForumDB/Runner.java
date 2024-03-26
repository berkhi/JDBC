package com.berkhayta._03_JDBC_ForumDB;

import com.berkhayta._03_JDBC_ForumDB.controller.ForumController;
import com.berkhayta._03_JDBC_ForumDB.controller.UserController;
import com.berkhayta._03_JDBC_ForumDB.entity.Users;
import com.berkhayta._03_JDBC_ForumDB.repository.UsersRepository;

import java.util.Optional;
import java.util.Scanner;

public class Runner {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }
    public static void menu() {
        do{
            System.out.println("""
                    1-Login
                    2-Register
                    """);
            int secim = scanner.nextInt();
            switch (secim){
                case 1:
                    new UserController().Login();
                    break;
                case 2:
                    new UserController().Register();
                    break;
                default:
                    System.out.println("Lütfen geçerli bir seçim yapınız.");
                    break;
            }
        }while(true);
    }


}
