package com.example.gbernardeau.gestionstock.IHM;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gbernardeau.gestionstock.DAO.EtatDAO;
import com.example.gbernardeau.gestionstock.METIER.Etat;
import com.example.gbernardeau.gestionstock.R;

import java.util.ArrayList;


/**
 * Created by gbernardeau on 03/04/2018.
 */

public class ListeFichesActivity extends AppCompatActivity {
    private Button Accueilbtn, CreateFiche, ToutLesArticles;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_fiches);
        ArrayList<Etat> listeetat = new ArrayList<Etat>();
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
        EtatDAO etat = new EtatDAO(this);

        //On ouvre la base de données pour écrire dedans
        etat.open();

        //On insère le livre que l'on vient de créer
        listeetat = etat.read();

        for (Etat unEtat: listeetat) {
            System.out.println(unEtat.getLibelle());
        }

        //Si un livre est retourné (donc si le livre à bien été ajouté à la BDD)
        if(etat != null){
            //On affiche les infos du livre dans un Toast
            Toast.makeText(this, etat.toString(), Toast.LENGTH_LONG).show();
        }

        etat.close();
    }

}