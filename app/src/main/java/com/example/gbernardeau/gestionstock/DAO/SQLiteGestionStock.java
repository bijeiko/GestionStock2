package com.example.gbernardeau.gestionstock.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class SQLiteGestionStock extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 136;
    private static final String DATABASE_NAME = "GestionDesStock";
    private Context context = null;
    public SQLiteGestionStock(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }



    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("DROP TABLE ETAT");
            db.execSQL("DROP TABLE RAYON");
            db.execSQL("DROP TABLE EMPLACEMENT");
            db.execSQL("DROP TABLE FAMILLE");
            db.execSQL("DROP TABLE ARTICLE");
            db.execSQL("DROP TABLE FICHE");

            db.execSQL("CREATE TABLE ETAT (ID integer PRIMARY KEY autoincrement, LIBELLE CHAR(50) NOT NULL)");
            db.execSQL("INSERT INTO ETAT (libelle) VALUES ('Fini')");
            db.execSQL("INSERT INTO ETAT (libelle) VALUES ('En Attente')");

            db.execSQL("CREATE TABLE RAYON (ID integer PRIMARY KEY autoincrement, LIBELLE CHAR(50) NOT NULL)");
            db.execSQL("INSERT INTO RAYON (libelle) VALUES ('RC5')");
            db.execSQL("INSERT INTO RAYON (libelle) VALUES ('RC8')");

            db.execSQL("CREATE TABLE EMPLACEMENT (ID integer PRIMARY KEY autoincrement, IDRAYON integer NOT NULL, LIBELLE CHAR(32) NOT NULL, CONSTRAINT fk_idrayon FOREIGN KEY (idrayon) REFERENCES RAYON (id))");
            db.execSQL("INSERT INTO EMPLACEMENT (ID, idrayon, libelle) VALUES (1, 1, 'A')");
            db.execSQL("INSERT INTO EMPLACEMENT (ID, idrayon, libelle) VALUES (2, 2, 'B')");
            db.execSQL("INSERT INTO EMPLACEMENT (ID, idrayon, libelle) VALUES (3, 1, 'C')");
            db.execSQL("INSERT INTO EMPLACEMENT (ID, idrayon, libelle) VALUES (4, 2, 'D')");

            db.execSQL("CREATE TABLE FAMILLE (ID integer PRIMARY KEY autoincrement, LIBELLE CHAR(150) NOT NULL)");
            db.execSQL("INSERT INTO FAMILLE (libelle) VALUES ('Legume')");
            db.execSQL("INSERT INTO FAMILLE (libelle) VALUES ('Fruits')");

            db.execSQL("CREATE TABLE ARTICLE (CODE CHAR(32) NOT NULL, LIBELLE CHAR(150) NOT NULL, IDEMP INTEGER NOT NULL, IDFAM INTEGER NOT NULL, CONSTRAINT pk_code PRIMARY KEY (code), CONSTRAINT fk_idemp FOREIGN KEY (idemp) REFERENCES EMPLACEMENT (id), CONSTRAINT fk_idfam FOREIGN KEY (idfam) REFERENCES FAMILLE(id))");
            db.execSQL("INSERT INTO ARTICLE (code, libelle, idemp, idfam) VALUES ('a45', 'pomme', 2, 2)");
            db.execSQL("INSERT INTO ARTICLE (code, libelle, idemp, idfam) VALUES ('a286', 'patate', 1, 1)");

            db.execSQL("CREATE TABLE FICHE (ID integer PRIMARY KEY autoincrement, QUANTITE integer NOT NULL, IDETAT integer NOT NULL, IDARTICLE integer NOT NULL, IDEMP integer NOT NULL, CONSTRAINT fk_idetat FOREIGN KEY (idetat) REFERENCES ETAT (ID))");
            db.execSQL("INSERT INTO FICHE (quantite, idetat, idarticle, idemp) VALUES (5, 1, 1, 1)");
            db.execSQL("INSERT INTO FICHE (quantite, idetat, idarticle, idemp) VALUES (2, 2, 2, 2)");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);

    }

}