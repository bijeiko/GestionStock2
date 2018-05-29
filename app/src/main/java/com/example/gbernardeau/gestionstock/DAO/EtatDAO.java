package com.example.gbernardeau.gestionstock.DAO;
/**

 * <p>Nom de la classe : EtatDAO;</p>
 * <p>Ajoutée le 29/05/2018;</p>
 * Descriptif : Classe permettant de gérer un objet EtattDAO.

 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gbernardeau.gestionstock.METIER.Etat;

import java.util.ArrayList;


public class EtatDAO extends DAO<Etat> {

    private SQLiteGestionStock dbGestionStock;

    private static final String Table_ETAT = "ETAT";
    private static final String COL_ID_ETAT = "ID";
    private static final String COL_LIBELLE_ETAT = "LIBELLE";
    /**
     * Les constantes sont définis avec les valeurs correspondantes.
     */
    private SQLiteDatabase db;

    /**
     * Permet d'instancier un nouvel objet de SQLiteGestionStock en tenant compte de context passé en paramètre.
     * @param context
     */
    public EtatDAO(Context context) {
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
     * Permet d'effectuer un INSERT en tenant compte de ma qui est un objet d'Etat.
     * En fonction du résultat, un booléen sera retourné.
     * @param ma
     * @return res
     */
    public boolean insert(Etat ma) {
        boolean res;
        long insert;
        res = false;
        ContentValues mavaleur = new ContentValues();
        mavaleur.put(COL_LIBELLE_ETAT, ma.getLibelle());
        insert = db.insert(Table_ETAT, null, mavaleur);
        if (insert != -1) {
            res = true;
        }
        return res;
    }
    /**
     * Permet d'effectuer un UPDATE en tenant compte de obj qui est un objet de Etat, passé en paramètre.
     * La fonction retourne un booléen en fonction du résultat.
     * @param obj
     * @return res
     */
    public boolean update(Etat obj) {
        boolean res;
        int update;
        res = false;
        ContentValues mavaleur = new ContentValues();
        mavaleur.put(COL_LIBELLE_ETAT, obj.getLibelle());
        update = db.update(Table_ETAT, mavaleur, null, null);
        if (update > 0) {
            res = true;
        }
        return res;
    }
    /**
     * Permet d'effectuer un DELETE en tenant compte de obj qui est un objet de Etat, passé en paramètre.
     * La fonction retourne un booléen en fonction du résultat.
     * @param obj
     * @return res
     */
    public boolean delete(Etat obj) {
        boolean res;
        int delete;
        res = false;
        delete = db.delete(Table_ETAT, null, null);
        if (delete > 0) {
            res = true;
        }
        return res;
    }
    /**
     * Permet d'effectuer un READ par le biais d'un curseur qui permet d'intéragir avec les résultats d'une requête SQL.
     * Id est passé en paramètre et la fonction retourne unEtat de la classe Etat.
     * @param id
     * @return unEtat
     */
    public Etat read(long id) {
        Cursor res = db.query(Table_ETAT, null, null, null, null, null, null);
        Etat unEtat = new Etat(res.getInt(0), res.getString(1));
        return unEtat;
    }
    /**
     * Fonction retournant un ArrayList peuplé de curseur ayant des données qui sont ajoutées à chaque tour de boucle.
     * @return listEtat
     */
    public ArrayList<Etat> read() {
        ArrayList<Etat> listEtat = new ArrayList<Etat>();
        int id;
        String lib;
        Etat ma;
        Cursor res;
        res = db.query(Table_ETAT, null, null, null, null, null, null);
        res.moveToFirst();
        while (!res.isAfterLast()) {
            id = res.getInt(0);
            lib = res.getString(1);
            ma = new Etat(id, lib);
            listEtat.add(ma);
        }

        return listEtat;
    }

}