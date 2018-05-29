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
            db.execSQL("DROP TABLE IF EXISTS FICHE");
            db.execSQL("DROP TABLE IF EXISTS ETAT");
            db.execSQL("DROP TABLE IF EXISTS EMPLACEMENT");
            db.execSQL("DROP TABLE IF EXISTS RAYON");
            db.execSQL("DROP TABLE IF EXISTS ARTICLE");
            db.execSQL("DROP TABLE IF EXISTS APPARTENIR");

            db.execSQL("CREATE TABLE IF NOT EXISTS FAMILLE  (ID INTEGER AUTOINCREMENT PRIMARY KEY, LIBELLE CHAR(32) NULL)");
            db.execSQL("CREATE TABLE IF NOT EXISTS FICHE (ID INTEGER AUTOINCREMENT PRIMARY KEY, ID_AVOIR CHAR(32) NOT NULL, QUANTITE CHAR(32) NULL, DATE_INSERTION DATE NOT NULL)");
            db.execSQL("CREATE  INDEX I_FK_FICHE_ETAT ON FICHE (ID_AVOIR ASC);");
            db.execSQL("CREATE TABLE IF NOT EXISTS ETAT (ID INTEGER AUTOINCREMENT PRIMARY KEY, LIBELLE CHAR(32) NULL)");
            db.execSQL("CREATE TABLE IF NOT EXISTS EMPLACEMENT ( ID INTEGER AUTOINCREMENT PRIMARY KEY, ID_CORRESPOND CHAR(32) NOT NULL, LIBELLE CHAR(32) NULL)");
            db.execSQL("CREATE  INDEX I_FK_EMPLACEMENT_RAYON ON EMPLACEMENT (ID_CORRESPOND ASC);");
            db.execSQL("CREATE TABLE IF NOT EXISTS RAYON (ID INTEGER AUTOINCREMENT PRIMARY KEY, LIBELLE CHAR(32) NULL)");
            db.execSQL("CREATE TABLE IF NOT EXISTS ARTICLE (CODE CHAR(32) PRIMARY KEY, ID CHAR(32) NOT NULL, ID_CONTENIR CHAR(32) NOT NULL, DÉSIGNATION CHAR(32) NULL, STOCK CHAR(32) NULL)");
            db.execSQL("CREATE UNIQUE INDEX I_FK_ARTICLE_FICHE ON ARTICLE (ID ASC);");
            db.execSQL("CREATE UNIQUE INDEX I_FK_ARTICLE_EMPLACEMENT ON ARTICLE (ID_CONTENIR ASC);");
            db.execSQL("CREATE TABLE IF NOT EXISTS APPARTENIR ( ID CHAR(32) NOT NULL, CODE CHAR(32) NOT NULL, PRIMARY KEY (ID,CODE))");
            db.execSQL("CREATE  INDEX I_FK_APPARTENIR_FAMILLE ON APPARTENIR (ID ASC);");
            db.execSQL("CREATE  INDEX I_FK_APPARTENIR_ARTICLE ON APPARTENIR (CODE ASC);");
            db.execSQL("ALTER TABLE FICHE ADD FOREIGN KEY FK_FICHE_ETAT (ID_AVOIR) REFERENCES ETAT (ID);");
            db.execSQL("ALTER TABLE EMPLACEMENT ADD FOREIGN KEY FK_EMPLACEMENT_RAYON (ID_CORRESPOND) REFERENCES RAYON (ID);");
            db.execSQL("ALTER TABLE ARTICLE ADD FOREIGN KEY FK_ARTICLE_FICHE (ID) REFERENCES FICHE (ID);");
            db.execSQL("ALTER TABLE ARTICLE ADD FOREIGN KEY FK_ARTICLE_EMPLACEMENT (ID_CONTENIR) REFERENCES EMPLACEMENT (ID);");
            db.execSQL("ALTER TABLE APPARTENIR ADD FOREIGN KEY FK_APPARTENIR_FAMILLE (ID) REFERENCES FAMILLE (ID);");
            db.execSQL("ALTER TABLE APPARTENIR ADD FOREIGN KEY FK_APPARTENIR_ARTICLE (CODE) REFERENCES ARTICLE (CODE);");
            db.execSQL("INSERT INTO ETAT (LIBELLE) VALUES ('Fini')");
            db.execSQL("INSERT INTO ETAT (LIBELLE) VALUES ('En attentes')");
            db.execSQL("INSERT INTO FAMILLE (LIBELLE) VALUES ('Test famille 1')");
            db.execSQL("INSERT INTO FICHE (ID_AVOIR, QUANTITE, DATE_INSERTION) VALUES (1, 5, date('now'))");
            db.execSQL("INSERT INTO RAYON (LIBELLE) VALUES ('RC5')");
            db.execSQL("INSERT INTO EMPLACEMENT (ID_CORRESPOND, LIBELLE) VALUES (1, 'EB3')");
            db.execSQL("INSERT INTO ARTICLE (CODE, LIBELLE) VALUES (1, 'EB3')");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

}