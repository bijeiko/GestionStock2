package com.example.gbernardeau.gestionstock.IHM;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import com.example.gbernardeau.gestionstock.DAO.FamilleDAO;
import com.example.gbernardeau.gestionstock.METIER.Famille;
import com.example.gbernardeau.gestionstock.R;

import java.util.ArrayList;


/**
 * Created by gbernardeau on 03/04/2018.
 */

public class ListeFichesActivity extends AppCompatActivity {
    private Button Accueilbtn, CreateFiche, ToutLesArticles;
    private ListView Listfiches;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_fiches);

        ArrayList<Famille> listesemplacements = new ArrayList<Famille>();

        // Bouton navigation
        Accueilbtn = (Button) findViewById(R.id.Accueilbtn);
        Accueilbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activitiemain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(activitiemain);
            }
        });
        CreateFiche = (Button) findViewById(R.id.CreateFiche);
        CreateFiche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activitycreatefiche = new Intent(getApplicationContext(), CreationFicheActivity.class);
                startActivity(activitycreatefiche);
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



        //Création d'une instance de ma classe ETATDAO
        FamilleDAO emplacements = new FamilleDAO(this.getApplicationContext());

        //On ouvre la base de données pour écrire dedans
        emplacements.open();

        // on récupere les donnees
        listesemplacements = emplacements.read();

        //On les affiches
        for (Famille unEmplacement: listesemplacements) {
            Log.v(unEmplacement.getLibelle().toString(), "Famille");

        }

        emplacements.close();
    }

}