package com.example.gbernardeau.gestionstock.IHM;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import com.example.gbernardeau.gestionstock.DAO.EmplacementDAO;
import com.example.gbernardeau.gestionstock.METIER.Emplacement;
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

        ArrayList<Emplacement> listesemp = new ArrayList<Emplacement>();
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
        EmplacementDAO emp = new EmplacementDAO(this.getApplicationContext());

        //On ouvre la base de données pour écrire dedans
        emp.open();

        // on récupere les données
        listesemp = emp.read();

        //on les affiches
        for (Emplacement unEmp: listesemp) {
            Log.v(unEmp.getLibelle().toString() + " " + unEmp.getId_rayon().toString(), "emplacements");

        }

        emp.close();
    }

}