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
import com.example.gbernardeau.gestionstock.METIER.Emplacement;
import com.example.gbernardeau.gestionstock.R;

import java.util.ArrayList;

/**
 * Created by gbernardeau on 03/04/2018.
 */


public class ListeArticleActivity extends AppCompatActivity {
    private ListView mListView;
    private ArticleDAO ArtDAO;
    //Test pour emplacement et rayon pour le select
    private EmplacementDAO emplacementDao;
    private RayonDAO rayonDao;

    private Button bSearch, bTri, Accueilbtn, ToutesLesFiches, CreateFiches;
    private TextView code;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //afficher le SQL dans la listview (Exemple avec Emplacement)
        EmplacementDAO emplacementDao = new EmplacementDAO(this);


        //setContentView(R.layout.liste_article);
        //mListView = (ListView) findViewById(R.id.listViewArticle);

        //Co à la bdd
        emplacementDao.open();
        //récupération des données
        ArrayList<Emplacement> ListEmplacement = emplacementDao.read();
        //Passage dans un ArrayList mais en STRING, pour être géré plus simplement.
        ArrayList<String> Emplacements = new ArrayList<String>();
        //Ajout data dans la liste.
        for (Emplacement unEmplacement : ListEmplacement) {
            Emplacements.add(unEmplacement.getId() + "\n" + unEmplacement.getId_rayon() + "\n" + unEmplacement.getLibelle());
        }
        //déco de la bdd
        emplacementDao.close();
        //L'adapter sert à afficher la liste dans la listeView.
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Emplacements);
        mListView.setAdapter(adapter);

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

        /*code = (TextView) findViewById(R.id.code);
        code.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                listViewArticle.setAdapter(adapter);
            }
        });*/
    }
}