package com.example.gbernardeau.gestionstock.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLiteGestionStock extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 33;
    private static final String DATABASE_NAME = "GestionDesStock";
    private Context context = null;
    public SQLiteGestionStock(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }



    public void onCreate(SQLiteDatabase db) {
        try {
            /*
            db.execSQL("CREATE TABLE ETAT (ID integer AUTO_INCREMENT, LIBELLE CHAR(50) NOT NULL, CONSTRAINT pk_id PRIMARY KEY (id))");
            db.execSQL("INSERT INTO ETAT (libelle) VALUES ('Fini')");
            db.execSQL("INSERT INTO ETAT (libelle) VALUES ('En Attente')");
            */

            db.execSQL("CREATE TABLE RAYON (ID integer AUTO_INCREMENT, LIBELLE CHAR(50) NOT NULL, CONSTRAINT pk_id PRIMARY KEY (id))");
            db.execSQL("INSERT INTO RAYON (libelle) VALUES ('RC5')");
            db.execSQL("INSERT INTO RAYON (libelle) VALUES ('RC8')");

            /*
            db.execSQL("CREATE TABLE EMPLACEMENT (ID integer AUTO_INCREMENT, IDRAYON integer NOT NULL, LIBELLE CHAR(32) NOT NULL, CONSTRAINT pk_id PRIMARY KEY (ID))");
            db.execSQL("INSERT INTO EMPLACEMENT (idrayon, libelle) VALUES (1, 'A')");
            db.execSQL("INSERT INTO EMPLACEMENT (idrayon, libelle) VALUES (2, 'B')");
            db.execSQL("INSERT INTO EMPLACEMENT (idrayon, libelle) VALUES (1, 'C')");
            db.execSQL("INSERT INTO EMPLACEMENT (idrayon, libelle) VALUES (2, 'D')");
            */


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

}