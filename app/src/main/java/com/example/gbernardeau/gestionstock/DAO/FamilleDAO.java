package com.example.gbernardeau.gestionstock.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gbernardeau.gestionstock.METIER.Famille;

import java.util.ArrayList;


public class FamilleDAO extends DAO<Famille> {

    private SQLiteGestionStock dbGestionStock;

    private static final String Table_FAMILLE = "ETAT";
    private static final String COL_ID_FAMILLE = "ID";
    private static final String COL_LIBELLE_FAMILLE = "LIBELLE";

    private SQLiteDatabase db;

    public FamilleDAO(Context context) {
        SQLiteOpenHelper dbGestionStock = new SQLiteGestionStock(context);
    }

    public void open() {
        db = dbGestionStock.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public boolean insert(Famille ma) {
        boolean res;
        long insert;
        res = false;
        ContentValues mavaleur = new ContentValues();
        mavaleur.put(COL_LIBELLE_FAMILLE, ma.getLibelle());
        insert = db.insert(Table_FAMILLE, null, mavaleur);
        if (insert != -1) {
            res = true;
        }
        return res;
    }

    public boolean update(Famille obj) {
        boolean res;
        int update;
        res = false;
        ContentValues mavaleur = new ContentValues();
        mavaleur.put(COL_LIBELLE_FAMILLE, obj.getLibelle());
        update = db.update(Table_FAMILLE, mavaleur, null, null);
        if (update > 0) {
            res = true;
        }
        return res;
    }

    public boolean delete(Famille obj) {
        boolean res;
        int delete;
        res = false;
        delete = db.delete(Table_FAMILLE, null, null);
        if (delete > 0) {
            res = true;
        }
        return res;
    }

    public Famille read(long id) {
        Cursor res = db.query(Table_FAMILLE, null, null, null, null, null, null);
        Famille uneFamille = new Famille(res.getInt(0), res.getString(1));
        return uneFamille;
    }

    public ArrayList<Famille> read() {
        ArrayList<Famille> listFamille = new ArrayList<Famille>();
        int id;
        String lib;
        Famille ma;
        Cursor res;
        res = db.query(Table_FAMILLE, null, null, null, null, null, null);
        res.moveToFirst();
        while (!res.isAfterLast()) {
            id = res.getInt(0);
            lib = res.getString(1);
            ma = new Famille(id, lib);
            listFamille.add(ma);
        }

        return listFamille;
    }

}