package com.example.gbernardeau.gestionstock.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gbernardeau.gestionstock.METIER.Famille_Article;

import java.util.ArrayList;


public class FamilleArticleDAO extends DAO<Famille_Article> {
    /**

     * <p>Nom de la classe : FamilleArticleDAO;</p>
     * <p>Ajoutée le 29/05/2018;</p>
     * Descriptif : Classe permettant de gérer un objet FamilleArticleDAO.

     */
    private SQLiteGestionStock dbGestionStock;

    private static final String Table_FAMILLE_ARTICLE = "FAMILLEARTICLE";
    private static final String COL_ID = "ID";
    private static final String COL_ID_FAMILLE = "ID_FAMILLE";
    private static final String COL_CODE = "CODE_ARTICLE";
    /**
     * Les constantes sont définis avec les valeurs correspondantes.
     */
    private SQLiteDatabase db;
    /**
     * Permet d'instancier un nouvel objet de SQLiteGestionStock en tenant compte de context passé en paramètre.
     * @param context
     */
    public FamilleArticleDAO(Context context) {
        SQLiteOpenHelper dbGestionStock = new SQLiteGestionStock(context);
    }

    /**
     * Permet d'ouvrir la base de données.
     */
    public void open() {
        db = dbGestionStock.getWritableDatabase();
    }

    /**
     * Permet de fermer la base de données.
     */
    public void close() {
        db.close();
    }

    /**
     * Permet d'effectuer un INSERT en tenant compte de ma qui est un objet d'Famille_Article.
     * En fonction du résultat, un booléen sera retourné.
     * @param ma
     * @return res
     */
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
    /**
     * Permet d'effectuer un UPDATE en tenant compte de obj qui est un objet de Famille_Article, passé en paramètre.
     * La fonction retourne un booléen en fonction du résultat.
     * @param obj
     * @return res
     */
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
    /**
     * Permet d'effectuer un DELETE en tenant compte de obj qui est un objet de Famille_Article, passé en paramètre.
     * La fonction retourne un booléen en fonction du résultat.
     * @param obj
     * @return res
     */
    public Famille_Article delete(Famille_Article obj) {
        boolean res;
        int delete;
        res = false;
        delete = db.delete(Table_FAMILLE_ARTICLE, null, null);
        if (delete > 0) {
            res = true;
        }
        return null;
    }
    /**
     * Permet d'effectuer un READ par le biais d'un curseur qui permet d'intéragir avec les résultats d'une requête SQL.
     * Id est passé en paramètre et la fonction retourne uneFamille de la classe Famille_Article.
     * @param id
     * @return unArticle
     */
    public Famille_Article read(long id) {
        Cursor res = db.query(Table_FAMILLE_ARTICLE, null, null, null, null, null, null);
        Famille_Article uneFamille = new Famille_Article(res.getInt(0), res.getInt(1), res.getString(2));
        return uneFamille;
    }
    /**
     * Fonction retournant un ArrayList peuplé de curseur ayant des données qui sont ajoutées à chaque tour de boucle.
     * @return listFamilleArticle
     */
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