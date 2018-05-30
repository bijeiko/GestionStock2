package com.example.gbernardeau.gestionstock.IHM;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.gbernardeau.gestionstock.DAO.ArticleDAO;
import com.example.gbernardeau.gestionstock.METIER.Article;
import com.example.gbernardeau.gestionstock.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gbernardeau on 03/04/2018.
 */


public class ListeArticleActivity extends AppCompatActivity {
    private ListView listViewArticle;
    private ArticleDAO ArtDAO;
    private Button bSearch, bTri, Accueilbtn, ToutesLesFiches, CreateFiche;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_article);

        // Bouton navigation
        Accueilbtn = (Button) findViewById(R.id.Accueilbtn);
        Accueilbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityaccueil = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(activityaccueil);
            }
        });
        // Bouton Créer fiche
        CreateFiche = (Button) findViewById(R.id.CreateFiche);
        CreateFiche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activitycreationfiche = new Intent(getApplicationContext(), CreationFicheActivity.class);
                startActivity(activitycreationfiche);
            }
        });
        // Bouton Toutes les fiches
        ToutesLesFiches = (Button) findViewById(R.id.ToutesLesFiches);
        ToutesLesFiches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityfiches = new Intent(getApplicationContext(), ListeFichesActivity.class);
                startActivity(activityfiches);
            }
        });


    }



}
