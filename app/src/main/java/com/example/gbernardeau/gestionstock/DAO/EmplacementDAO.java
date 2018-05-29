package com.example.gbernardeau.gestionstock.DAO;
/**

 * <p>Nom de la classe : EmplacementDAO;</p>
 * <p>Ajoutée le 29/05/2018;</p>
 * Descriptif : Classe permettant de gérer un objet EmplacementDAO.

 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gbernardeau.gestionstock.METIER.Emplacement;

import java.util.ArrayList;


public class EmplacementDAO extends DAO<Emplacement> {

    private SQLiteGestionStock dbGestionStock;

    private static final String Table_EMPLACEMENT = "Emplacement";
    private static final String COL_ID_EMPLACEMENT = "ID";
    private static final String COL_LIBELLE_EMPLACEMENT = "LIBELLE";

    private SQLiteDatabase db; //Dans le cas présent, db sera la base de donnée SQLite.

    /**
     * Les constantes sont définis avec les valeurs correspondantes.
     */

    /**
     * Permet d'instancier un nouvel objet de SQLiteGestionStock en tenant compte de context passé en paramètre.
     * @param context
     */
    public EmplacementDAO(Context context) {
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
     * Permet d'effectuer un INSERT en tenant compte de ma qui est un objet d'Emplacement.
     * En fonction du résultat, un booléen sera retourné.
     * @param ma
     * @return res
     */
    public boolean insert(Emplacement ma) {
        boolean res;
        long insert;
        res = false;
        ContentValues mavaleur = new ContentValues();
        mavaleur.put(COL_LIBELLE_EMPLACEMENT, ma.getLibelle());
        insert = db.insert(Table_EMPLACEMENT, null, mavaleur);
        if (insert != -1) {
            res = true;
        }
        return res;
    }

    /**
     * Permet d'effectuer un UPDATE en tenant compte de obj qui est un objet de Emplacement, passé en paramètre.
     * La fonction retourne un booléen en fonction du résultat.
     * @param obj
     * @return res
     */
    public boolean update(Emplacement obj) {
        boolean res;
        int update;
        res = false;
        ContentValues mavaleur = new ContentValues();
        mavaleur.put(COL_LIBELLE_EMPLACEMENT, obj.getLibelle());
        update = db.update(Table_EMPLACEMENT, mavaleur, null, null);
        if (update > 0) {
            res = true;
        }
        return res;
    }

    /**
     * Permet d'effectuer un DELETE en tenant compte de obj qui est un objet de Emplacement, passé en paramètre.
     * La fonction retourne un booléen en fonction du résultat.
     * @param obj
     * @return res
     */
    public boolean delete(Emplacement obj) {
        boolean res;
        int delete;
        res = false;
        delete = db.delete(Table_EMPLACEMENT, null, null);
        if (delete > 0) {
            res = true;
        }
        return res;
    }

    /**
     * Permet d'effectuer un READ par le biais d'un curseur qui permet d'intéragir avec les résultats d'une requête SQL.
     * Id est passé en paramètre et la fonction retourne unArticle de la classe Emplacement.
     * @param id
     * @return unArticle
     */
    public Emplacement read(long id) {
        Cursor res = db.query(Table_EMPLACEMENT, null, null, null, null, null, null);
        Emplacement unArticle = new Emplacement(res.getInt(0), res.getString(1));
        return unArticle;
    }

    /**
     * Fonction retournant un ArrayList peuplé de curseur ayant des données qui sont ajoutées à chaque tour de boucle.
     * @return listEmplacement
     */
    public ArrayList<Emplacement> read() {
        ArrayList<Emplacement> listEmplacement = new ArrayList<Emplacement>();
        int id;
        String lib;
        Emplacement ma;
        Cursor res;
        res = db.query(Table_EMPLACEMENT, null, null, null, null, null, null);
        res.moveToFirst();
        while (!res.isAfterLast()) {
            id = res.getInt(0);
            lib = res.getString(1);
            ma = new Emplacement(id, lib);
            listEmplacement.add(ma);
        }

        return listEmplacement;
    }

}