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
            db.execSQL("DROP TABLE IF EXISTS matiere");
            db.execSQL("CREATE TABLE matiere (id INTEGER PRIMARY KEY AUTOINCREMENT, nomMatiere VARCHAR(100), coeffMatiere REAL");
            db.execSQL("INSERT INTO matiere (nomMatiere, coeffMatiere) VALUES ('Math','2')");
            db.execSQL("INSERT INTO matiere (nomMatiere, coeffMatiere) VALUES ('Francais','3')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

}
