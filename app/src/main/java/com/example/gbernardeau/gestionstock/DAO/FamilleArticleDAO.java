package com.example.gbernardeau.gestionstock.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gbernardeau.gestionstock.METIER.Famille_Article;

import java.util.ArrayList;


public class FamilleArticleDAO extends DAO<Famille_Article> {

    private SQLiteGestionStock dbGestionStock;

    private static final String Table_FAMILLE_ARTICLE = "FAMILLEARTICLE";
    private static final String COL_ID = "ID";
    private static final String COL_ID_FAMILLE = "ID_FAMILLE";
    private static final String COL_CODE = "CODE_ARTICLE";

    private SQLiteDatabase db;

    public FamilleArticleDAO(Context context) {
        SQLiteOpenHelper dbGestionStock = new SQLiteGestionStock(context);
    }

    public void open() {
        db = dbGestionStock.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public boolean insert(Famille_Article ma) {
        boolean res;
        long insert;
        res = false;
        ContentValues mavaleur = new ContentValues();
        mavaleur.put(COL_ID_FAMILLE, ma.getIdfamille());
        mavaleur.put(COL_CODE, ma.getCodearticle());
        insert = db.insert(Table_FAMILLE_ARTICLE, null, mavaleur);
        if (insert != -1) {
            res = true;
        }
        return res;
    }

    public boolean update(Famille_Article obj) {
        boolean res;
        int update;
        res = false;
        ContentValues mavaleur = new ContentValues();
        mavaleur.put(COL_ID_FAMILLE, obj.getIdfamille());
        mavaleur.put(COL_CODE, obj.getCodearticle());
        update = db.update(Table_FAMILLE_ARTICLE, mavaleur, null, null);
        if (update > 0) {
            res = true;
        }
        return res;
    }

    public boolean delete(Famille_Article obj) {
        boolean res;
        int delete;
        res = false;
        delete = db.delete(Table_FAMILLE_ARTICLE, null, null);
        if (delete > 0) {
            res = true;
        }
        return res;
    }

    public Famille_Article read(long id) {
        Cursor res = db.query(Table_FAMILLE_ARTICLE, null, null, null, null, null, null);
        Famille_Article uneFamille = new Famille_Article(res.getInt(0), res.getInt(1), res.getString(2));
        return uneFamille;
    }

    public ArrayList<Famille_Article> read() {
        ArrayList<Famille_Article> listFamilleArticle = new ArrayList<Famille_Article>();
        int id;
        int idfamille;
        String code;
        Famille_Article ma;
        Cursor res;
        res = db.query(Table_FAMILLE_ARTICLE, null, null, null, null, null, null);
        res.moveToFirst();
        while (!res.isAfterLast()) {
            id = res.getInt(0);
            idfamille = res.getInt(1);
            code = res.getString(2);
            ma = new Famille_Article(id, idfamille, code);
            listFamilleArticle.add(ma);
        }

        return listFamilleArticle;
    }

}