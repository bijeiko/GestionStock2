package com.example.gbernardeau.gestionstock.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class SQLiteGestionStock extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 166;
    private static final String DATABASE_NAME = "GestionDesStock";
    private Context context = null;
    public SQLiteGestionStock(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public void onCreate(SQLiteDatabase db) {
        try {

            db.execSQL("DROP TABLE IF EXISTS ETAT");
            db.execSQL("DROP TABLE IF EXISTS RAYON");
            db.execSQL("DROP TABLE IF EXISTS EMPLACEMENT");
            db.execSQL("DROP TABLE IF EXISTS FAMILLE");
            db.execSQL("DROP TABLE IF EXISTS ARTICLE");
            db.execSQL("DROP TABLE IF EXISTS FICHE");

            db.execSQL("CREATE TABLE ETAT (ID integer PRIMARY KEY autoincrement, LIBELLE TEXT NOT NULL)");
            db.execSQL("INSERT INTO ETAT (libelle) VALUES ('Fini')");
            db.execSQL("INSERT INTO ETAT (libelle) VALUES ('En Attente')");

            db.execSQL("CREATE TABLE RAYON (ID integer PRIMARY KEY autoincrement, LIBELLE TEXT NOT NULL)");
            db.execSQL("INSERT INTO RAYON (libelle) VALUES ('RC5')");
            db.execSQL("INSERT INTO RAYON (libelle) VALUES ('RC8')");

            db.execSQL("CREATE TABLE EMPLACEMENT (ID integer PRIMARY KEY autoincrement, IDRAYON integer NOT NULL, LIBELLE TEXT NOT NULL, CONSTRAINT fk_idrayon FOREIGN KEY (IDRAYON) REFERENCES RAYON (ID))");
            db.execSQL("INSERT INTO EMPLACEMENT (idrayon, libelle) VALUES (1, 'A')");
            db.execSQL("INSERT INTO EMPLACEMENT (idrayon, libelle) VALUES (2, 'B')");
            db.execSQL("INSERT INTO EMPLACEMENT (idrayon, libelle) VALUES (1, 'C')");
            db.execSQL("INSERT INTO EMPLACEMENT (idrayon, libelle) VALUES (2, 'D')");

            db.execSQL("CREATE TABLE FAMILLE (ID integer PRIMARY KEY autoincrement, LIBELLE TEXT NOT NULL)");
            db.execSQL("INSERT INTO FAMILLE (libelle) VALUES ('Legume')");
            db.execSQL("INSERT INTO FAMILLE (libelle) VALUES ('Fruits')");

            db.execSQL("CREATE TABLE ARTICLE (CODE TEXT NOT NULL, LIBELLE CHAR(150) NOT NULL, STOCK INTEGER NOT NULL, IDEMP INTEGER NOT NULL, IDFAM INTEGER NOT NULL, CONSTRAINT pk_code PRIMARY KEY (CODE), CONSTRAINT fk_idemp FOREIGN KEY (IDEMP) REFERENCES EMPLACEMENT (ID), CONSTRAINT fk_idfam FOREIGN KEY (IDFAM) REFERENCES FAMILLE(ID))");
            db.execSQL("INSERT INTO ARTICLE (code, libelle, stock, idemp, idfam) VALUES ('a45', 'pomme', 2, 2, 2)");
            db.execSQL("INSERT INTO ARTICLE (code, libelle, stock, idemp, idfam) VALUES ('a287', 'patate', 1, 1, 2)");

            db.execSQL("CREATE TABLE FICHE (ID integer PRIMARY KEY autoincrement, QUANTITE integer NOT NULL, IDETAT integer NOT NULL, IDARTICLE TEXT NOT NULL, IDEMP integer NOT NULL, CONSTRAINT fk_idetat FOREIGN KEY (IDETAT) REFERENCES ETAT (ID), CONSTRAINT fk_idarticle FOREIGN KEY (IDARTICLE) REFERENCES ARTICLE (CODE))");
            db.execSQL("INSERT INTO FICHE (quantite, idetat, idarticle, idemp) VALUES (5, 1, 'a45', 1)");
            db.execSQL("INSERT INTO FICHE (quantite, idetat, idarticle, idemp) VALUES (2, 2, 'a287', 2)");


            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS LibEtat ON ETAT (LIBELLE)");
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS LibRayon ON RAYON (LIBELLE)");
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS LibFamille ON FAMILLE (LIBELLE)");
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS IdRayon ON EMPLACEMENT (IDRAYON)");
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS LibEmplacement ON EMPLACEMENT (LIBELLE)");
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS CodeArticle ON ARTICLE (CODE)");
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS LibArticle ON ARTICLE (LIBELLE)");
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS StockArticle ON ARTICLE (STOCK)");
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS IdEmp ON ARTICLE (IDEMP)");
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS IdFam ON ARTICLE (IDFAM)");
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS Quantite ON Fiches (QUANTITE)");
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS IdEtat ON ARTICLE (IDETAT)");
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS IdArticle ON ARTICLE (IDARTICLE)");
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS IdEMp ON ARTICLE (IDEMP)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);



    }

}