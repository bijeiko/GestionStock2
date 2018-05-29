package com.example.gbernardeau.gestionstock.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gbernardeau.gestionstock.METIER.Etat;

import java.util.ArrayList;


public class EtatDAO extends DAO<Etat> {

    private SQLiteGestionStock dbGestionStock;

    private static final String Table_ETAT = "ETAT";
    private static final String COL_ID_ETAT = "ID";
    private static final String COL_LIBELLE_ETAT = "LIBELLE";

    private SQLiteDatabase db;

    public EtatDAO(Context context) {
        dbGestionStock = new SQLiteGestionStock(context);
    }

    public void open() {
        db = dbGestionStock.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public boolean insert(Etat ma) {
        boolean res;
        long insert;
        res = false;
        ContentValues mavaleur = new ContentValues();
        mavaleur.put(COL_LIBELLE_ETAT, ma.getLibelle());
        insert = db.insert(Table_ETAT, null, mavaleur);
        if (insert != -1) {
            res = true;
        }
        return res;
    }

    public boolean update(Etat obj) {
        boolean res;
        int update;
        res = false;
        ContentValues mavaleur = new ContentValues();
        mavaleur.put(COL_LIBELLE_ETAT, obj.getLibelle());
        update = db.update(Table_ETAT, mavaleur, null, null);
        if (update > 0) {
            res = true;
        }
        return res;
    }

    public boolean delete(Etat obj) {
        boolean res;
        int delete;
        res = false;
        delete = db.delete(Table_ETAT, null, null);
        if (delete > 0) {
            res = true;
        }
        return res;
    }

    public Etat read(long id) {
        Cursor res = db.query(Table_ETAT, null, null, null, null, null, null);
        Etat unEtat = new Etat(res.getInt(0), res.getString(1));
        return unEtat;
    }

    public ArrayList<Etat> read() {
        ArrayList<Etat> listEtat = new ArrayList<Etat>();
        int id;
        String lib;
        Etat ma;
        Cursor res;
        res = db.query(Table_ETAT, null, null, null, null, null, null);
        res.moveToFirst();
        while (!res.isAfterLast()) {
            id = res.getInt(0);
            lib = res.getString(1);
            ma = new Etat(id, lib);
            listEtat.add(ma);
        }

        return listEtat;
    }

}