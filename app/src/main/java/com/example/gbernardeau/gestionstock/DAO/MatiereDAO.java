/*package com.example.gbernardeau.gestionstock.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import gbernardeau.gestiondesnotes.Metier.Matiere;

public class MatiereDAO extends DAO<Matiere> {

    private SQLiteGestionNotes dbGestionNotes;

    private static final String Table_MATIERE = "MATIERE";
    private static final String COL_ID_MATIERE = "IDMATIERE";
    private static final String COL_NOMMATIERE = "NOMMATIERE";
    private static final String COL_COEFMATIERE = "COEFMATIERE";

    private SQLiteDatabase db;

    public MatiereDAO (Context context){
        SQLiteOpenHelper dbGestionNotes = new SQLiteGestionNotes(context);
    }

    public void open(){
        db = dbGestionNotes.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public boolean insert(Matiere ma) {
        boolean res;
        long insert;
        res = false;
        ContentValues mavaleur = new ContentValues();
        mavaleur.put(COL_NOMMATIERE, ma.getnomMatiere());
        mavaleur.put(COL_COEFMATIERE, ma.getcoeffMatiere());
        insert = db.insert(Table_MATIERE, null, mavaleur);
        if (insert != -1) {
            res = true;
        }
        return res;
    }

    public boolean update(Matiere obj) {
        boolean res;
        int update;
        res = false;
        ContentValues mavaleur = new ContentValues();
        mavaleur.put(COL_NOMMATIERE, obj.getnomMatiere());
        mavaleur.put(COL_COEFMATIERE, obj.getcoeffMatiere());
        update = db.update(Table_MATIERE, mavaleur, null, null);
        if (update > 0) {
            res = true;
        }
        return res;
    }

    public boolean delete(Matiere obj) {
        boolean res;
        int delete;
        res = false;
        delete = db.delete(Table_MATIERE, null, null);
        if (delete > 0) {
            res = true;
        }
        return res;
    }

    public Matiere read(long id){
        Cursor res = db.query(Table_MATIERE, null, null, null, null, null, null);
        Matiere laMatiere = new Matiere(res.getInt(0), res.getString(1), res.getFloat(2));
        return laMatiere;
    }

    public ArrayList<Matiere> read(){
        ArrayList<Matiere> listMatiere = new ArrayList<Matiere>();
        int id;
        String lib;
        float coeff;
        Matiere ma;
        Cursor res;
        res = db.query(Table_MATIERE, null, null, null, null, null, null);
        res.moveToFirst();
        while (!res.isAfterLast()) {
            id = res.getInt(0);
            lib = res.getString(1);
            coeff = res.getFloat(2);
            ma = new Matiere(id, lib, coeff);
            listMatiere.add(ma);
        }

        return listMatiere;
    }

}
*/