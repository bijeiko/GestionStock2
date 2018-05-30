package com.example.gbernardeau.gestionstock.IHM;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import com.example.gbernardeau.gestionstock.DAO.EtatDAO;
import com.example.gbernardeau.gestionstock.DAO.FamilleDAO;
import com.example.gbernardeau.gestionstock.DAO.SQLiteGestionStock;
import com.example.gbernardeau.gestionstock.METIER.Famille;
import com.example.gbernardeau.gestionstock.METIER.Famille_Article;
import com.example.gbernardeau.gestionstock.R;

public class MainActivity extends AppCompatActivity {


    private Button bSearch, bTri, Accueil, CreateFiches, ToutesLesFiches, ToutLesArticles;
    private EditText Search;
    private ListView ListViewAccueil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bouton navigation
        ToutLesArticles = (Button) findViewById(R.id.ToutLesArticles);
        ToutLesArticles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityarticle = new Intent(getApplicationContext(), ListeArticleActivity.class);
                startActivity(activityarticle);
            }
        });

        CreateFiches = (Button) findViewById(R.id.CreateFiches);
        CreateFiches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activitycreation = new Intent(getApplicationContext(), CreationFicheActivity.class);
                startActivity(activitycreation);
            }
        });

        ToutesLesFiches = (Button) findViewById(R.id.ToutesLesFiches);
        ToutesLesFiches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityfiche = new Intent(getApplicationContext(), ListeFichesActivity.class);
                startActivity(activityfiche);
            }
        });

        FamilleDAO FamDAO = new FamilleDAO(this);
        FamDAO.open();

        ArrayList<Famille> ListAccueil = FamDAO.read();



        // utilisez SimpleCursorAdapter pour afficher les
        // éléments dans une ListView
        ArrayAdapter<Famille> adapter = new ArrayAdapter<Famille>(this,
                android.R.layout.simple_list_item_1, ListAccueil);
        ListViewAccueil.setAdapter(adapter);

        FamDAO.close();

    }
}
