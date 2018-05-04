package com.example.gbernardeau.gestionstock.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gbernardeau.gestionstock.METIER.Rayon;

import java.util.ArrayList;


public class RayonDAO extends DAO<Rayon> {

    private SQLiteGestionStock dbGestionStock;

    private static final String Table_RAYON = "RAYON";
    private static final String COL_ID = "ID";
    private static final String COL_LIBELLE = "LIBELLE";

    private SQLiteDatabase db;

    public RayonDAO(Context context) {
        SQLiteOpenHelper dbGestionStock = new SQLiteGestionStock(context);
    }

    public void open() {
        db = dbGestionStock.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public boolean insert(Rayon ma) {
        boolean res;
        long insert;
        res = false;
        ContentValues mavaleur = new ContentValues();
        mavaleur.put(COL_LIBELLE, ma.getLibelle());
        insert = db.insert(Table_RAYON, null, mavaleur);
        if (insert != -1) {
            res = true;
        }
        return res;
    }

    public boolean update(Rayon obj) {
        boolean res;
        int update;
        res = false;
        ContentValues mavaleur = new ContentValues();
        mavaleur.put(COL_LIBELLE, obj.getLibelle());
        update = db.update(Table_RAYON, mavaleur, null, null);
        if (update > 0) {
            res = true;
        }
        return res;
    }

    public boolean delete(Rayon obj) {
        boolean res;
        int delete;
        res = false;
        delete = db.delete(Table_RAYON, null, null);
        if (delete > 0) {
            res = true;
        }
        return res;
    }

    public Rayon read(long id) {
        Cursor res = db.query(Table_RAYON, null, null, null, null, null, null);
        Rayon unRayon = new Rayon(res.getInt(0), res.getString(1));
        return unRayon;
    }

    public ArrayList<Rayon> read() {
        ArrayList<Rayon> listRayon = new ArrayList<Rayon>();
        int id;
        String libelle;
        Rayon ma;
        Cursor res;
        res = db.query(Table_RAYON, null, null, null, null, null, null);
        res.moveToFirst();
        while (!res.isAfterLast()) {
            id = res.getInt(0);
            libelle = res.getString(1);
            ma = new Rayon(id, libelle);
            listRayon.add(ma);
        }

        return listRayon;
    }

}