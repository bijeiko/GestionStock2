package com.example.gbernardeau.gestionstock.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gbernardeau.gestionstock.METIER.Fiches;

import java.util.ArrayList;


public class FichesDAO extends DAO<Fiches> {

    private SQLiteGestionStock dbGestionStock;

    private static final String Table_FICHES = "FICHES";
    private static final String COL_ID = "ID";
    private static final String COL_QUANTITE = "QUANTITE";

    private SQLiteDatabase db;

    public FichesDAO(Context context) {
        SQLiteOpenHelper dbGestionStock = new SQLiteGestionStock(context);
    }

    public void open() {
        db = dbGestionStock.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public boolean insert(Fiches ma) {
        boolean res;
        long insert;
        res = false;
        ContentValues mavaleur = new ContentValues();
        mavaleur.put(COL_QUANTITE, ma.getQuantite());
        insert = db.insert(Table_FICHES, null, mavaleur);
        if (insert != -1) {
            res = true;
        }
        return res;
    }

    public boolean update(Fiches obj) {
        boolean res;
        int update;
        res = false;
        ContentValues mavaleur = new ContentValues();
        mavaleur.put(COL_QUANTITE, obj.getQuantite());
        update = db.update(Table_FICHES, mavaleur, null, null);
        if (update > 0) {
            res = true;
        }
        return res;
    }

    public boolean delete(Fiches obj) {
        boolean res;
        int delete;
        res = false;
        delete = db.delete(Table_FICHES, null, null);
        if (delete > 0) {
            res = true;
        }
        return res;
    }

    public Fiches read(long id) {
        Cursor res = db.query(Table_FICHES, null, null, null, null, null, null);
        Fiches uneFiche = new Fiches(res.getInt(0), res.getInt(1));
        return uneFiche;
    }

    public ArrayList<Fiches> read() {
        ArrayList<Fiches> listFiches = new ArrayList<Fiches>();
        int id;
        int qte;
        Fiches ma;
        Cursor res;
        res = db.query(Table_FICHES, null, null, null, null, null, null);
        res.moveToFirst();
        while (!res.isAfterLast()) {
            id = res.getInt(0);
            qte = res.getInt(1);
            ma = new Fiches(id, qte);
            listFiches.add(ma);
        }

        return listFiches;
    }

}