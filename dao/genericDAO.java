package com.tinne.dao;

import java.util.List;

public interface genericDAO<T> {
    boolean add(T t);
    T get(String id);
    List<T> getAll();
    boolean remove(String id);
    boolean remove(T t);
    boolean update(T t);
    List<T> query(String hql);



}
