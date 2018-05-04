package com.example.gbernardeau.gestionstock.DAO;

/**
 * Created by gbernardeau on 08/02/2018.
 */

public abstract class DAO<T> {
    public abstract boolean insert(T obj);
    public abstract boolean update(T obj);
    public  abstract boolean delete(T obj);
}
