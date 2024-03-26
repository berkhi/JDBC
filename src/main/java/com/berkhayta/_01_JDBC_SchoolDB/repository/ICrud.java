package com.berkhayta._01_JDBC_SchoolDB.repository;

import com.berkhayta._01_JDBC_SchoolDB.entity.Ogrenci;

import java.util.List;

public interface ICrud<T> {
    void save(T t);
    void update(T t);
    void delete(int id);
    List<T> findAll();
    T findById(int id);
}
