package com.example.gbernardeau.gestionstock.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLiteGestionStock extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 79;
    private static final String DATABASE_NAME = "GestionDesStock";
    private Context context = null;
    public SQLiteGestionStock(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }



    public void onCreate(SQLiteDatabase db) {
        try {

            db.execSQL("CREATE TABLE ETAT (ID integer AUTO_INCREMENT, LIBELLE CHAR(50) NOT NULL, CONSTRAINT pk_id PRIMARY KEY (id))");
            db.execSQL("INSERT INTO ETAT (libelle) VALUES ('Fini')");
            db.execSQL("INSERT INTO ETAT (libelle) VALUES ('En Attente')");

            db.execSQL("CREATE TABLE RAYON (ID integer AUTO_INCREMENT, LIBELLE CHAR(50) NOT NULL, CONSTRAINT pk_id PRIMARY KEY (id))");
            db.execSQL("INSERT INTO RAYON (libelle) VALUES ('RC5')");
            db.execSQL("INSERT INTO RAYON (libelle) VALUES ('RC8')");

            db.execSQL("CREATE TABLE EMPLACEMENT (ID integer AUTO_INCREMENT, IDRAYON integer NOT NULL, LIBELLE CHAR(32) NOT NULL, CONSTRAINT pk_id PRIMARY KEY (id), CONSTRAINT fk_idrayon FOREIGN KEY (idrayon) REFERENCES RAYON (id))");
            db.execSQL("INSERT INTO EMPLACEMENT (idrayon, libelle) VALUES (1, 'A')");
            db.execSQL("INSERT INTO EMPLACEMENT (idrayon, libelle) VALUES (2, 'B')");
            db.execSQL("INSERT INTO EMPLACEMENT (idrayon, libelle) VALUES (1, 'C')");
            db.execSQL("INSERT INTO EMPLACEMENT (idrayon, libelle) VALUES (2, 'D')");

            db.execSQL("CREATE TABLE FAMILLE (ID integer AUTO_INCREMENT, LIBELLE CHAR(150) NOT NULL, CONSTRAINT pk_id PRIMARY KEY (id))");
            db.execSQL("INSERT INTO FAMILLE (libelle) VALUES ('Legume')");
            db.execSQL("INSERT INTO FAMILLE (libelle) VALUES ('Fruits')");

            db.execSQL("CREATE TABLE ARTICLE (CODE CHAR(32) NOT NULL, LIBELLE CHAR(150) NOT NULL, STOCK INTEGER NOT NULL, IDEMP INTEGER NOT NULL, IDFAM INTEGER NOT NULL,CONSTRAINT pk_code PRIMARY KEY (code), CONSTRAINT fk_idemp FOREIGN KEY (IDEMP) REFERENCES EMPLACEMENT (id), CONSTRAINT fk_idfam FOREIGN KEY (idfam) REFERENCES FAMILLE (id))");
            db.execSQL("INSERT INTO ARTICLE (code, libelle, stock, idemp, idfam) VALUES ('a45', 'pomme', 42, 2, 2)");
            db.execSQL("INSERT INTO ARTICLE (code, libelle, stock, idemp, idfam) VALUES ('a286', 'patate', 15, 1, 1)");




        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*onCreate(db);*/
        db.execSQL("CREATE TABLE FICHE (ID integer AUTO_INCREMENT, QUANTITE integer NOT NULL, IDETAT integer NOT NULL, CONSTRAINT pk_id PRIMARY KEY (ID),CONSTRAINT fk_idetat) FOREIGN KEY (idetat) REFERENCES ETAT (id))");
        db.execSQL("INSERT INTO FICHE (quantite, idetat) VALUES (5, 1)");
        db.execSQL("INSERT INTO FICHE (quantite, idetat) VALUES (2, 2)");
    }

}