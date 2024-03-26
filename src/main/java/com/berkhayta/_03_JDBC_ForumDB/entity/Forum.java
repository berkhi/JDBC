package com.berkhayta._03_JDBC_ForumDB.entity;

import java.text.DateFormat;
import java.time.LocalDate;

public class Forum extends BaseEntity{
    int id;
    String postTitle;
    String postContent;
    String postAuthor;
    LocalDate postDate;

    public Forum() {
    }

    public Forum(String postTitle, String postContent, String postAuthor) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postAuthor = postAuthor;
        this.postDate = LocalDate.now();
    }

    public Forum(int id, String postTitle, String postContent, String postAuthor) {
        this.id = id;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postAuthor = postAuthor;
        this.postDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Forum{" +
                "id=" + id +
                ", postTitle='" + postTitle + '\'' +
                ", postContent='" + postContent + '\'' +
                ", postAuthor='" + postAuthor + '\'' +
                ", postDate=" + postDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(String postAuthor) {
        this.postAuthor = postAuthor;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }
}
