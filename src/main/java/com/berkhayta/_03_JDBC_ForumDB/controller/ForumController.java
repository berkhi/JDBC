package com.berkhayta._03_JDBC_ForumDB.controller;

import com.berkhayta._03_JDBC_ForumDB.entity.Forum;
import com.berkhayta._03_JDBC_ForumDB.entity.Users;
import com.berkhayta._03_JDBC_ForumDB.repository.ForumRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ForumController {

//            * * * * * * * * * * * * * * * * * *
//            *         Postu gönderen username *
//            *            post başlık          *
//            * post icerik                     *
//            *                      29.03.2024 *
//            * * * * * * * * * * * * * * * * * *

    public void getPosts(Users user) {
        ForumRepository forumRepository = new ForumRepository();
        List<Forum> userPosts = forumRepository.findAll();
        System.out.println("Kullanıcının postları:");
        for (Forum post : userPosts) {
            if (post.getPostAuthor().equals(user.getUsername())) {
                System.out.println("Post Başlığı: " + post.getPostTitle());
                System.out.println("Post İçeriği: " + post.getPostContent());
                System.out.println("Post Yazarı: " + post.getPostAuthor());
                System.out.println("Post Tarihi: " + post.getPostDate());
                System.out.println("-----------------------------");
            }
        }
    }

    public void createPost(Users user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Post Başlığı: ");
        String postTitle = scanner.nextLine();
        System.out.println("Post İçeriği: ");
        String postContent = scanner.nextLine();

        Forum newPost = new Forum(postTitle, postContent, user.getUsername());

        ForumRepository forumRepository = new ForumRepository();
        forumRepository.save(newPost);

        System.out.println("Yeni post başarıyla oluşturuldu.");
    }

}

