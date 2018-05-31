package com.example.gbernardeau.gestionstock.IHM;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gbernardeau.gestionstock.DAO.ArticleDAO;
import com.example.gbernardeau.gestionstock.DAO.FichesDAO;
import com.example.gbernardeau.gestionstock.METIER.Article;
import com.example.gbernardeau.gestionstock.METIER.Fiches;
import com.example.gbernardeau.gestionstock.R;

import java.util.ArrayList;


/**
 * Created by gbernardeau on 03/04/2018.
 */

public class ListeFichesActivity extends AppCompatActivity {
    private Button Accueilbtn, CreateFiche, ToutLesArticles;
    private ListView mListView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_fiches);

        ArrayList<Fiches> listesArticle = new ArrayList<Fiches>();

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

//A revoir (ligne de 60 à 77
/*
        //Création d'une instance de ma classe ETATDAO
        FichesDAO articles = new FichesDAO(this.getApplicationContext());

        //On ouvre la base de données pour écrire dedans
        articles.open();

        // on récupere les donnees
        listesArticle = articles.read();

        //On les affiches
        for (Fiches unArticle: listesArticle) {
            Log.v(unArticle.getQuantite().toString(), "Quantite");

        }

        articles.close();*/

        //---------------------------------------------------------------------------------------------------------
        //afficher le SQL dans la listview (Exemple avec Article)
        FichesDAO FicDao = new FichesDAO(this);


        setContentView(R.layout.liste_fiches);
        mListView = (ListView) findViewById(R.id.listViewFiches);

        //Co à la bdd
        FicDao.open();
        //récupération des données
        ArrayList<Fiches> ListFiche = FicDao.read();
        //Passage dans un ArrayList mais en STRING, pour être géré plus simplement.
        ArrayList<String> Fiches = new ArrayList<String>();
        //Ajout data dans la liste.
        for (Fiches uneFiche : ListFiche) {
            Fiches.add(uneFiche.getId().toString() + uneFiche.getIdetat().toString()+ uneFiche.getQuantite().toString());
        }
        //déco de la bdd
        FicDao.close();
        //L'adapter sert à afficher la liste dans la listeView.
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Fiches);
        mListView.setAdapter(adapter);
    }

}