package com.example.gbernardeau.gestionstock.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gbernardeau.gestionstock.METIER.Emplacement;

import java.util.ArrayList;


public class EmplacementDAO extends DAO<Emplacement> {

    private SQLiteGestionStock dbGestionStock;

    private static final String Table_EMPLACEMENT = "Emplacement";
    private static final String COL_ID_EMPLACEMENT = "ID";
    private static final String COL_LIBELLE_EMPLACEMENT = "LIBELLE";

    private SQLiteDatabase db;

    public EmplacementDAO(Context context) {
        SQLiteOpenHelper dbGestionStock = new SQLiteGestionStock(context);
    }

    public void open() {
        db = dbGestionStock.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public boolean insert(Emplacement ma) {
        boolean res;
        long insert;
        res = false;
        ContentValues mavaleur = new ContentValues();
        mavaleur.put(COL_LIBELLE_EMPLACEMENT, ma.getLibelle());
        insert = db.insert(Table_EMPLACEMENT, null, mavaleur);
        if (insert != -1) {
            res = true;
        }
        return res;
    }

    public boolean update(Emplacement obj) {
        boolean res;
        int update;
        res = false;
        ContentValues mavaleur = new ContentValues();
        mavaleur.put(COL_LIBELLE_EMPLACEMENT, obj.getLibelle());
        update = db.update(Table_EMPLACEMENT, mavaleur, null, null);
        if (update > 0) {
            res = true;
        }
        return res;
    }

    public boolean delete(Emplacement obj) {
        boolean res;
        int delete;
        res = false;
        delete = db.delete(Table_EMPLACEMENT, null, null);
        if (delete > 0) {
            res = true;
        }
        return res;
    }

    public Emplacement read(long id) {
        Cursor res = db.query(Table_EMPLACEMENT, null, null, null, null, null, null);
        Emplacement unArticle = new Emplacement(res.getInt(0), res.getString(1));
        return unArticle;
    }

    public ArrayList<Emplacement> read() {
        ArrayList<Emplacement> listEmplacement = new ArrayList<Emplacement>();
        int id;
        String lib;
        Emplacement ma;
        Cursor res;
        res = db.query(Table_EMPLACEMENT, null, null, null, null, null, null);
        res.moveToFirst();
        while (!res.isAfterLast()) {
            id = res.getInt(0);
            lib = res.getString(1);
            ma = new Emplacement(id, lib);
            listEmplacement.add(ma);
        }

        return listEmplacement;
    }

}