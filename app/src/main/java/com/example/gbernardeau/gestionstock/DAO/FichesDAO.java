package com.example.gbernardeau.gestionstock.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gbernardeau.gestionstock.METIER.Fiches;

import java.util.ArrayList;


public class FichesDAO extends DAO<Fiches> {
    /**

     * <p>Nom de la classe : FichesDAO;</p>
     * <p>Ajoutée le 29/05/2018;</p>
     * Descriptif : Classe permettant de gérer un objet FichesDAO.

     */
    private SQLiteGestionStock dbGestionStock;

    private static final String Table_FICHES = "FICHE";
    private static final String COL_ID = "ID";
    private static final String COL_ID_AVOIR = "ID_AVOIR";
    private static final String COL_QUANTITE = "QUANTITE";

    private static final String COL_DATE_INSERTION = "DATE_INSERTION";


    /**
     * Les constantes sont définis avec les valeurs correspondantes.
     */

    private SQLiteDatabase db;
    /**
     * Permet d'instancier un nouvel objet de SQLiteGestionStock en tenant compte de context passé en paramètre.
     * @param context
     */
    public FichesDAO(Context context) {
        dbGestionStock = new SQLiteGestionStock(context);
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
     * Permet d'effectuer un INSERT en tenant compte de ma qui est un objet de Fiches.
     * En fonction du résultat, un booléen sera retourné.
     * @param ma
     * @return res
     */
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
    /**
     * Permet d'effectuer un UPDATE en tenant compte de obj qui est un objet de Fiches, passé en paramètre.
     * La fonction retourne un booléen en fonction du résultat.
     * @param obj
     * @return res
     */
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
    /**
     * Permet d'effectuer un DELETE en tenant compte de obj qui est un objet de Fiches, passé en paramètre.
     * La fonction retourne un booléen en fonction du résultat.
     * @param obj
     * @return res
     */
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
    /**
     * Permet d'effectuer un READ par le biais d'un curseur qui permet d'intéragir avec les résultats d'une requête SQL.
     * Id est passé en paramètre et la fonction retourne uneFiche de la classe Fiches.
     * @param id
     * @return uneFiche
     */
    public Fiches read(long id) {
        Cursor res = db.query(Table_FICHES, null, null, null, null, null, null);
        Fiches uneFiche = new Fiches(res.getInt(0), res.getInt(1), null);
        return uneFiche;
    }
    /**
     * Fonction retournant un ArrayList peuplé de curseur ayant des données qui sont ajoutées à chaque tour de boucle.
     * @return listFiches
     */
    public ArrayList<Fiches> read() {
        ArrayList<Fiches> listFiches = new ArrayList<Fiches>();
        int id;
        int qte;
        Fiches ma;
        Cursor res;
        res = db.query(Table_FICHES, null, null, null, null, null, null, "10");
        res.moveToFirst();
        while (!res.isAfterLast()) {
            id = res.getInt(0);
            qte = res.getInt(1);
            ma = new Fiches(id, qte, null);
            listFiches.add(ma);
        }

        return listFiches;
    }

}