package com.example.gbernardeau.gestionstock.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLiteGestionStock extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "GestionDesStock";
    private Context context = null;
    public SQLiteGestionStock(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }



    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("DROP TABLE IF EXISTS FAMILLE");
            db.execSQL("DROP TABLE IF EXISTS FICHEs");
            db.execSQL("DROP TABLE IF EXISTS ETAT");
            db.execSQL("DROP TABLE IF EXISTS EMPLACEMENT");
            db.execSQL("DROP TABLE IF EXISTS RAYON");
            db.execSQL("DROP TABLE IF EXISTS ARTICLE");
            db.execSQL("DROP TABLE IF EXISTS APPARTENIR");

            db.execSQL("CREATE TABLE ETAT ( ID integer AUTO_INCREMENT, LIBELLE CHAR(50) NOT NULL, CONSTRAINT pk_id PRIMARY KEY (id))");
            db.execSQL("INSERT INTO ETAT (libelle) VALUES ('Fini')");
            db.execSQL("INSERT INTO ETAT (libelle) VALUES ('En Attente')");




        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

}