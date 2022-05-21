package com.todotic.apiaccount.services;

import java.util.List;

public interface ICRUDService<T, ID> {
    public List<T> findAll();
    public T create(T o);
    //public T findById(ID id);
    //void delete(T o);
    //void deleteById(ID id);
    //public T update(T o);
}
