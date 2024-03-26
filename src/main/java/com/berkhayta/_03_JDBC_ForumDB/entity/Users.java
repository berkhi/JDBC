package com.berkhayta._03_JDBC_ForumDB.entity;

public class Users extends BaseEntity{
    int id ;
    String username;
    String name;
    String lastname;
    String password;

    public Users() {
    }

    public Users(String username, String name, String lastname, String password) {
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
    }

    public Users(int id, String username, String name, String lastname, String password) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
