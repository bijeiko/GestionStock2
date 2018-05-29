package com.example.gbernardeau.gestionstock.DAO;

/**
 * Classe mère faisant hériter de ses méthodes à ses classes filles.
 */

public abstract class DAO<T> {
    public abstract boolean insert(T obj);
    public abstract boolean update(T obj);
    public  abstract boolean delete(T obj);
}
