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


public class CreationFicheActivity extends AppCompatActivity {

    private Button bSearch, bTri, accueilbtn, ToutesLesFiches, ToutLesArticles;

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

    }



}
