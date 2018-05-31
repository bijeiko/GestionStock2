package com.example.gbernardeau.gestionstock.IHM;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.gbernardeau.gestionstock.R;

/**
 * Created by gbernardeau on 03/04/2018.
 */

/**
 * Classe correspondant à la page Création de fiches.
 */

public class CreationFicheActivity extends AppCompatActivity {
    /**
     * Ses attributs sont des boutons qui sont :
     * celui de recherche
     * celui de tri
     * celui de redirection à l'acceuil
     * celui de redirection à Toutes les fiches
     * celui de redirection à Tout les articles
     */
    private Button bSearch, bTri, accueilbtn, ToutesLesFiches, ToutLesArticles, btn_annuler;

    /**
     * A la création de la page, des boutons sont créés grâce à la View(R.Layout.creation_fiche)
     * disposant de liens pour accéder aux différentes pages.
     * @param savedInstanceState
     */

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creation_fiche);

        // Bouton navigation
        accueilbtn = (Button) findViewById(R.id.accueilbtn);
        accueilbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityaccueil = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(activityaccueil);
            }
        });
        ToutLesArticles = (Button) findViewById(R.id.ToutLesArticles);
        ToutLesArticles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityarticle = new Intent(getApplicationContext(), ListeArticleActivity.class);
                startActivity(activityarticle);
            }
        });

        ToutesLesFiches = (Button) findViewById(R.id.ToutesLesFiches);
        ToutesLesFiches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityarticle = new Intent(getApplicationContext(), ListeArticleActivity.class);
                startActivity(activityarticle);
            }
        });

        btn_annuler = (Button) findViewById(R.id.btn_annuler);
        btn_annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityarticle = new Intent(getApplicationContext(), ListeArticleActivity.class);
                startActivity(activityarticle);
            }
        });

    }



}
