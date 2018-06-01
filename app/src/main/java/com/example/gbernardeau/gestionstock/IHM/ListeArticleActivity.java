package com.example.gbernardeau.gestionstock.IHM;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gbernardeau.gestionstock.DAO.ArticleDAO;
import com.example.gbernardeau.gestionstock.DAO.EmplacementDAO;
import com.example.gbernardeau.gestionstock.DAO.RayonDAO;
import com.example.gbernardeau.gestionstock.METIER.Article;
import com.example.gbernardeau.gestionstock.METIER.Emplacement;
import com.example.gbernardeau.gestionstock.R;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by gbernardeau on 03/04/2018.
 */


public class ListeArticleActivity extends AppCompatActivity {
    private ListView mListView;
    //Test pour emplacement et rayon pour le select
    private EmplacementDAO emplacementDao;
    private RayonDAO rayonDao;

    ArticleDAO ArtDAO = new ArticleDAO(this);

    private Button bSearch, bTri, Accueilbtn, ToutesLesFiches, CreateFiches;
    private TextView code;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //---------------------------------------------------------------------------------------------------------

        //setContentView(R.layout.liste_article);
        //mListView = (ListView) findViewById(R.id.listViewArticle);

    //Co à la bdd
        ArtDAO.open();
    //récupération des données
        ArrayList<Article> ListArticle = ArtDAO.read();
    //Passage dans un ArrayList mais en STRING, pour être géré plus simplement.
        ArrayList<String> Articles = new ArrayList<String>();
    //Ajout data dans la liste.
        for (Article unArticle : ListArticle) {
            Articles.add(unArticle.getCode() + " ensuite " + unArticle.getStock() + " ensuite " +
                    unArticle.getIdemp()+ " ensuite " + unArticle.getIdfam() + " ensuite " +
            unArticle.getDesignation());
        }
    //déco de la bdd
        ArtDAO.close();
    //L'adapter sert à afficher la liste dans la listeView.
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Articles);
        mListView.setAdapter(adapter);
        //---------------------------------------------------------------------------------------------------------

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
        CreateFiches = (Button) findViewById(R.id.CreateFiches);
        CreateFiches.setOnClickListener(new View.OnClickListener() {
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
                Intent activityfiches = new Intent(getApplicationContext(), FichesActivity.class);
                startActivity(activityfiches);
            }
        });

        //Ceci est un essai pour rendre "Code" cliquable pour le tri
        // EN COURS !

        code = (TextView) findViewById(R.id.code);
        code.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ArtDAO.open();
                ArrayList<Article> ListArticle = ArtDAO.readDesc();
                ArrayList<String> Articles = new ArrayList<String>();
                for (Article unArticle : ListArticle) {
                    Articles.add(unArticle.getCode() + " ensuite " + unArticle.getStock() + " ensuite " +
                            unArticle.getIdemp() + " ensuite " + unArticle.getIdfam() + " ensuite " +
                            unArticle.getDesignation());
                }
                ArtDAO.close();
                mListView.setAdapter(adapter);
            }
        });
    }
}