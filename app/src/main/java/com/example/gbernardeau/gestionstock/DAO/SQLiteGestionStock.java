package com.example.gbernardeau.gestionstock.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLiteGestionStock extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 11;
    private static final String DATABASE_NAME = "GestionDesStock";
    private Context context = null;
    public SQLiteGestionStock(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }



    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE TABLE ETAT(ID integer AUTO_INCREMENT, LIBELLE CHAR(50) NOT NULL, CONSTRAINT pk_id PRIMARY KEY (id)),");
            db.execSQL("INSERT INTO ETAT (id, libelle) VALUES (1, 'Fini'),");
            db.execSQL("INSERT INTO ETAT (id, libelle) VALUES (2, 'En Attente'),");

            db.execSQL("CREATE TABLE RAYON(ID integer AUTO_INCREMENT, LIBELLE CHAR(50) NOT NULL, CONSTRAINT pk_id PRIMARY KEY (id)),");
            db.execSQL("INSERT INTO RAYON (id, libelle) VALUES (1, 'RC5'),");
            db.execSQL("INSERT INTO RAYON (id, libelle) VALUES (2, 'RC8'),");

            db.execSQL("CREATE TABLE EMPLACEMENT (ID INTEGER AUTO_INCREMENT, ID_RAYON CHAR(32) NOT NULL, LIBELLE CHAR(32) NOT NULL, CONSTRAINT pk_id PRIMARY KEY (ID), CONSTRAINT fk_id_rayon FOREIGN KEY (ID_RAYON) REFERENCES RAYON (ID)),");
            db.execSQL("INSERT INTO EMPLACEMENT (id, id_rayon, libelle) VALUES (1, 1, 'A'),");
            db.execSQL("INSERT INTO EMPLACEMENT (id, id_rayon, libelle) VALUES (2, 2, 'B'),");
            db.execSQL("INSERT INTO EMPLACEMENT (id, id_rayon, libelle) VALUES (3, 1, 'C'),");
            db.execSQL("INSERT INTO EMPLACEMENT (id, id_rayon, libelle) VALUES (4, 2, 'D')");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

}