package com.berkhayta._03_JDBC_ForumDB.repository;

import java.util.List;
import java.util.Optional;

public interface ICrud<T> {
    void save(T t);
    void update(T t);
    void delete(int id);
    List<T> findAll();
    Optional<T> findById(int id);
}
