package com.berkhayta._03_JDBC_ForumDB.repository;

import com.berkhayta._03_JDBC_ForumDB.entity.Users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepository implements ICrud<Users> {
    String sql;
    private DatabaseHalper databaseHelper;

    public UsersRepository() {
        this.databaseHelper = new DatabaseHalper();
    }

    @Override
    public void save(Users user) {
        sql = "INSERT INTO tblusers(name,lastname,username,password) VALUES ('%s', '%s', '%s','%s')"
                .formatted(user.getName(), user.getLastname(), user.getUsername(), user.getPassword());
        databaseHelper.executeUpdate(sql);
    }

    @Override
    public void update(Users user) {
        sql = "UPDATE tblusers SET name = '%s' , lastname = '%s', username = '%s', password = '%s' WHERE id = '%d' "
                .formatted(user.getName(), user.getLastname(), user.getUsername(), user.getPassword(), user.getId());
        databaseHelper.executeUpdate(sql);
    }

    @Override
    public void delete(int silinecekId) {
        sql = "Delete from tblusers where id=%d"
                .formatted(silinecekId);
        databaseHelper.executeUpdate(sql);

    }

    @Override
    public List<Users> findAll() {
        sql = "SELECT * FROM tblusers ORDER BY id";
        ResultSet resultSet = databaseHelper.executeQuery(sql);
        List<Users> usersList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                Integer state = resultSet.getInt("state");
                Long createat = resultSet.getLong("createat");
                Long updateat = resultSet.getLong("updateat");
                Users m = new Users(id, name, lastname, username, password);
                m.setState(state);
                m.setCreateat(createat);
                m.setUpdateat(updateat);
                usersList.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }
    public Optional<Users> findByUsername(String username) {
        sql = "SELECT * FROM tblusers WHERE username='" + username + "'";
        ResultSet resultSet = databaseHelper.executeQuery(sql);
        Users m = null;
        try {
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                String fetchedUsername = resultSet.getString("username");
                String fetchedPassword = resultSet.getString("password");
                Integer state = resultSet.getInt("state");
                Long createat = resultSet.getLong("createat");
                Long updateat = resultSet.getLong("updateat");
                m = new Users(id, name, lastname, fetchedUsername, fetchedPassword);
                m.setState(state);
                m.setCreateat(createat);
                m.setUpdateat(updateat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(m);
    }

    public Optional<Users> findByUsernameAndPassword(String username, String password) {
        sql = "SELECT * FROM tblusers WHERE username='" + username + "' AND password='" + password + "'";
        ResultSet resultSet = databaseHelper.executeQuery(sql);
        Users m = null;
        try {
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                String fetchedUsername = resultSet.getString("username");
                String fetchedPassword = resultSet.getString("password");
                Integer state = resultSet.getInt("state");
                Long createat = resultSet.getLong("createat");
                Long updateat = resultSet.getLong("updateat");
                m = new Users(id, name, lastname, fetchedUsername, fetchedPassword);
                m.setState(state);
                m.setCreateat(createat);
                m.setUpdateat(updateat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(m);
    }


    @Override
    public Optional<Users> findById(int idargs) {
        sql = "SELECT * FROM tblusers WHERE id=" + idargs;
        ResultSet resultSet = databaseHelper.executeQuery(sql);
        Users m = null;

        try {
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                Integer state = resultSet.getInt("state");
                Long createat = resultSet.getLong("createat");
                Long updateat = resultSet.getLong("updateat");
                m = new Users(id, name, lastname, username, password);
                m.setState(state);
                m.setCreateat(createat);
                m.setUpdateat(updateat);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(m);
    }
}
