package com.example.gbernardeau.gestionstock.DAO;
/**

 * <p>Nom de la classe : ArticleDAO;</p>
 * <p>Ajoutée le 29/05/2018;</p>
 * Descriptif : Classe permettant de gérer un objet ArticleDAO.

 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.gbernardeau.gestionstock.METIER.Article;

import java.util.ArrayList;

public class ArticleDAO extends DAO<Article> {
    private SQLiteGestionStock dbGestionStock;

    private static final String Table_ARTICLE = "ARTICLE";
    private static final String COL_ID_ARTICLE = "ID";
    private static final String COL_DESIGNATION_ARTICLE = "DESIGNATION";
    private static final String COL_ID_FAMILLE = "IDFAM";
    private static final String COL_ID_EMPLACEMENT = "IDEMP";
    private static final String COL_STOCK_ARTICLE = "STOCK";

    private SQLiteDatabase db; //Dans le cas présent, db sera la base de donnée SQLite.

    /**
     * Les constantes sont définis avec les valeurs correspondantes.
     */

    /**
     * Permet d'instancier un nouvel objet de SQLiteGestionStock en tenant compte du context passé en paramètre.
     * @param context
     */
    public ArticleDAO(Context context) {
        dbGestionStock = new SQLiteGestionStock(context);
    }

    /**
     * Permet d'ouvrir la base de données.
     */
    public void open() {
        db = dbGestionStock.getWritableDatabase();
    }

    /**
     * Permet de fermer la connection à la base de données.
     */
    public void close() {
        db.close();
    }

    /**
     * Permet d'effectuer un INSERT en tenant compte de ma qui est un objet d'Article.
     * En fonction du résultat, un booléen sera retourné.
     * @param ma
     * @return res
     */
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

    /**
     * Permet d'effectuer un UPDATE en tenant compte de obj qui est un objet de Article, passé en paramètre.
     * La fonction retourne un booléen en fonction du résultat.
     * @param obj
     * @return res
     */
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

    /**
     * Permet d'effectuer un DELETE en tenant compte de obj qui est un objet de Article, passé en paramètre.
     * La fonction retourne un booléen en fonction du résultat.
     * @param obj
     * @return res
     */
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

    /**
     * Permet d'effectuer un READ par le biais d'un curseur qui permet d'intéragir avec les résultats d'une requête SQL.
     * Id est passé en paramètre et la fonction retourne unArticle de la classe Article.
     * @param id
     * @return unArticle
     */
    public Article read(long id) {
        Cursor res = db.query(Table_ARTICLE, null, null, null, null, null, null);
        Article unArticle = new Article(res.getString(0), res.getString(1), res.getInt(2), res.getInt(3), res.getInt(4));
        return unArticle;
    }

    /**
     * Fonction retournant un ArrayList peuplé de curseur ayant des données qui sont ajoutées à chaque tour de boucle.
     * @return listArticle
     */
    public ArrayList<Article> read() {
        ArrayList<Article> listArticle = new ArrayList<Article>();
        String code;
        String lib;
        Integer idfam;
        Integer idemp;
        Integer stock;

        Integer id;

        Article ma;
        Cursor res;
        res = db.query(Table_ARTICLE, null, null, null, null, null, null);

        id = res.getCount();
        Log.v(id.toString(), "nb elem");

        res.moveToFirst();
        while (!res.isAfterLast()) {
            code = res.getString(0);
            lib = res.getString(1);
            stock = res.getInt(2);
            idemp = res.getInt(3);
            idfam = res.getInt(4);
            ma = new Article(code, lib, stock, idemp, idfam);
            listArticle.add(ma);
            res.moveToNext();
        }

        return listArticle;
    }

}