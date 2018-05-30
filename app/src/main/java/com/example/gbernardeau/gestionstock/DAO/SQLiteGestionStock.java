package com.example.gbernardeau.gestionstock.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLiteGestionStock extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 7;
    private static final String DATABASE_NAME = "GestionDesStock";
    private Context context = null;
    public SQLiteGestionStock(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }



    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE TABLE ETAT(ID integer AUTO_INCREMENT, LIBELLE CHAR(50) NOT NULL, CONSTRAINT pk_id PRIMARY KEY (id)),");
            db.execSQL("INSERT INTO ETAT (libelle) VALUES ('Fini')");
            db.execSQL("INSERT INTO ETAT (libelle) VALUES ('En Attente')");

            db.execSQL("CREATE TABLE RAYON(ID integer AUTO_INCREMENT, LIBELLE CHAR(50) NOT NULL, CONSTRAINT pk_id PRIMARY KEY (id)),");
            db.execSQL("INSERT INTO RAYON (libelle) VALUES ('RC5')");
            db.execSQL("INSERT INTO RAYON (libelle) VALUES ('RC8')");

            db.execSQL("CREATE TABLE FAMILLE(ID integer AUTO_INCREMENT, LIBELLE CHAR(50) NOT NULL, CONSTRAINT pk_id PRIMARY KEY (id)),");
            db.execSQL("INSERT INTO FAMILLE (LIBELLE) VALUES ('High Tech')");
            db.execSQL("INSERT INTO FAMILLE (LIBELLE) VALUES ('Informatique')");

            db.execSQL("CREATE TABLE FICHE(ID integer AUTO_INCREMENT, QUANTITE INTEGER NOT NULL, ID_ETAT, CONSTRAINT pk_id PRIMARY KEY (id)), CONSTRAINT fk_idEtat FOREIGN KEY (ID_ETAT) REFERENCES ETAT(id)");
            db.execSQL("INSERT INTO FICHE (QUANTITE, ID_ETAT) VALUES (30, 1)");
            db.execSQL("INSERT INTO FICHE (QUANTITE, ID_ETAT) VALUES (20, 1)");



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

}