package com.example.gbernardeau.gestionstock.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gbernardeau.gestionstock.METIER.Famille;

import java.util.ArrayList;


public class FamilleDAO extends DAO<Famille> {
    /**

     * <p>Nom de la classe : FamilleDAO;</p>
     * <p>Ajoutée le 29/05/2018;</p>
     * Descriptif : Classe permettant de gérer un objet FamilleDAO.

     */
    private SQLiteGestionStock dbGestionStock;

    private static final String Table_FAMILLE = "FAMILLE";
    private static final String COL_ID_FAMILLE = "ID";
    private static final String COL_LIBELLE_FAMILLE = "LIBELLE";
    /**
     * Les constantes sont définis avec les valeurs correspondantes.
     */
    private SQLiteDatabase db;
    /**
     * Permet d'instancier un nouvel objet de SQLiteGestionStock en tenant compte de context passé en paramètre.
     * @param context
     */
    public FamilleDAO(Context context) {
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
     * Permet d'effectuer un INSERT en tenant compte de ma qui est un objet de Famille.
     * En fonction du résultat, un booléen sera retourné.
     * @param ma
     * @return res
     */
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
    /**
     * Permet d'effectuer un UPDATE en tenant compte de obj qui est un objet de Famille, passé en paramètre.
     * La fonction retourne un booléen en fonction du résultat.
     * @param obj
     * @return res
     */
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
    /**
     * Permet d'effectuer un DELETE en tenant compte de obj qui est un objet de Famille, passé en paramètre.
     * La fonction retourne un booléen en fonction du résultat.
     * @param obj
     * @return res
     */
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
    /**
     * Permet d'effectuer un READ par le biais d'un curseur qui permet d'intéragir avec les résultats d'une requête SQL.
     * Id est passé en paramètre et la fonction retourne uneFamille de la classe Famille.
     * @param id
     * @return unArticle
     */
    public Famille read(long id) {
        Cursor res = db.query(Table_FAMILLE, null, null, null, null, null, null);
        Famille uneFamille = new Famille(res.getInt(0), res.getString(1));
        return uneFamille;
    }
    /**
     * Fonction retournant un ArrayList peuplé de curseur ayant des données qui sont ajoutées à chaque tour de boucle.
     * @return listFamille
     */
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