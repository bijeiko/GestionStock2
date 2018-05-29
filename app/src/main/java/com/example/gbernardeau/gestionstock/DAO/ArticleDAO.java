package com.example.gbernardeau.gestionstock.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gbernardeau.gestionstock.METIER.Article;

import java.util.ArrayList;
  //test

public class ArticleDAO extends DAO<Article> {

    private SQLiteGestionStock dbGestionStock;

    private static final String Table_ARTICLE = "ARTICLE";
    private static final String COL_ID_ARTICLE = "ID";
    private static final String COL_DESIGNATION_ARTICLE = "DESIGNATION";
    private static final String COL_STOCK_ARTICLE = "STOCK";

    private SQLiteDatabase db;

    public ArticleDAO(Context context) {
        SQLiteOpenHelper dbGestionStock = new SQLiteGestionStock(context);
    }

    public void open() {
        db = dbGestionStock.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public boolean insert(Article ma) {
        boolean res;
        long insert;
        res = false;
        ContentValues mavaleur = new ContentValues();
        mavaleur.put(COL_DESIGNATION_ARTICLE, ma.getDesignation());
        mavaleur.put(COL_STOCK_ARTICLE, ma.getStock());
        insert = db.insert(Table_ARTICLE, null, mavaleur);
        if (insert != -1) {
            res = true;
        }
        return res;
    }

    public boolean update(Article obj) {
        boolean res;
        int update;
        res = false;
        ContentValues mavaleur = new ContentValues();
        mavaleur.put(COL_DESIGNATION_ARTICLE, obj.getDesignation());
        mavaleur.put(COL_STOCK_ARTICLE, obj.getStock());
        update = db.update(Table_ARTICLE, mavaleur, null, null);
        if (update > 0) {
            res = true;
        }
        return res;
    }

    public boolean delete(Article obj) {
        boolean res;
        int delete;
        res = false;
        delete = db.delete(Table_ARTICLE, null, null);
        if (delete > 0) {
            res = true;
        }
        return res;
    }

    public Article read(long id) {
        Cursor res = db.query(Table_ARTICLE, null, null, null, null, null, null);
        Article unArticle = new Article(res.getString(0), res.getString(1), res.getInt(2));
        return unArticle;
    }

    public ArrayList<Article> read() {
        ArrayList<Article> listArticle = new ArrayList<Article>();
        String code;
        String lib;
        int stock;
        Article ma;
        Cursor res;
        res = db.query(Table_ARTICLE, null, null, null, null, null, null);
        res.moveToFirst();
        while (!res.isAfterLast()) {
            code = res.getString(0);
            lib = res.getString(1);
            stock = res.getInt(2);
            ma = new Article(code, lib, stock);
            listArticle.add(ma);
        }

        return listArticle;
    }

}