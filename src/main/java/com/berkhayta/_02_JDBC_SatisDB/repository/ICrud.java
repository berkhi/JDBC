package com.berkhayta._02_JDBC_SatisDB.repository;

import java.util.List;

public interface ICrud<T> {
    void save(T t);
    void update(T t);
    void delete(int id);
    List<T> findAll();
    T findById(int id);
}
