package com.example.gbernardeau.gestionstock.DAO;
/**

 * <p>Nom de la classe : RayonDAO;</p>
 * <p>Ajoutée le 29/05/2018;</p>
 * Descriptif : Classe permettant de gérer un objet RayonDAO.

 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.gbernardeau.gestionstock.METIER.Rayon;

import java.util.ArrayList;


public class RayonDAO extends DAO<Rayon> {

    private SQLiteGestionStock dbGestionStock;

    private static final String Table_RAYON = "RAYON";
    private static final String COL_ID = "ID";
    private static final String COL_LIBELLE = "LIBELLE";
    /**
     * Les constantes sont définis avec les valeurs correspondantes.
     */
    private SQLiteDatabase db;
    /**
     * Permet d'instancier un nouvel objet de SQLiteGestionStock en tenant compte de context passé en paramètre.
     * @param context
     */
    public RayonDAO(Context context) {
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
     * Permet d'effectuer un INSERT en tenant compte de ma qui est un objet de Rayon.
     * En fonction du résultat, un booléen sera retourné.
     * @param ma
     * @return res
     */
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
    /**
     * Permet d'effectuer un UPDATE en tenant compte de obj qui est un objet de Rayon, passé en paramètre.
     * La fonction retourne un booléen en fonction du résultat.
     * @param obj
     * @return res
     */
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
    /**
     * Permet d'effectuer un DELETE en tenant compte de obj qui est un objet de Rayon, passé en paramètre.
     * La fonction retourne un booléen en fonction du résultat.
     * @param obj
     * @return res
     */
    public Rayon delete(Rayon obj) {
        boolean res;
        int delete;
        res = false;
        delete = db.delete(Table_RAYON, null, null);
        if (delete > 0) {
            res = true;
        }
        return null;
    }
    /**
     * Permet d'effectuer un READ par le biais d'un curseur qui permet d'intéragir avec les résultats d'une requête SQL.
     * Id est passé en paramètre et la fonction retourne unRayon de la classe Rayon.
     * @param id
     * @return unRayon
     */
    public Rayon read(long id) {
        Cursor res = db.query(Table_RAYON, null, null, null, null, null, null);
        Rayon unRayon = new Rayon(res.getInt(0), res.getString(1));
        return unRayon;
    }
    /**
     * Fonction retournant un ArrayList peuplé de curseur ayant des données qui sont ajoutées à chaque tour de boucle.
     * @return listRayon
     */

    public ArrayList<Rayon> read() {
        ArrayList<Rayon> listRayon = new ArrayList<Rayon>();
        Integer id;
        String libelle;
        Rayon ma;
        Cursor res;
        Log.v("Ca passe ici", "test");
        res = db.query(Table_RAYON, null, null, null, null, null, null);
        res.moveToFirst();
        while (!res.isAfterLast()) {
            id = res.getInt(0);
            libelle = res.getString(1);
            Log.v(id + " - " + libelle, "elem");
            ma = new Rayon(id, libelle);
            listRayon.add(ma);
            res.moveToNext();
        }

        return listRayon;
    }

    public int selectId(Rayon Rayon){
        int idRayon;
        Cursor c;

        c = db.rawQuery("SELECT * FROM " + Table_RAYON + " WHERE LIBELLE = '" + Rayon.getLibelle() + "'", null);

        idRayon = c.getInt(0);

        return idRayon;
    }

}