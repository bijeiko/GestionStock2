package com.example.gbernardeau.gestionstock.IHM;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.gbernardeau.gestionstock.DAO.EmplacementDAO;
import com.example.gbernardeau.gestionstock.DAO.RayonDAO;
import com.example.gbernardeau.gestionstock.METIER.Emplacement;
import com.example.gbernardeau.gestionstock.METIER.Rayon;
import com.example.gbernardeau.gestionstock.R;

import java.util.ArrayList;

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

        //afficher le SQL dans la listview (Exemple avec Emplacement)
        EmplacementDAO emplacementDao = new EmplacementDAO(this);
        //Co à la bdd
        emplacementDao.open();
        //récupération des données
        ArrayList<Emplacement> ListEmplacement = emplacementDao.read();
        //Passage dans un ArrayList mais en STRING, pour être géré plus simplement.
        ArrayList<Integer> Emplacements = new ArrayList<Integer>();
        //Ajout data dans la liste.
        for (Emplacement unEmplacement : ListEmplacement) {
            Emplacements.add(unEmplacement.getId());
            //Log.v(unEmplacement.getId().toString(), "id");
        }
        Log.v("ca passe ici", "emplacement");
        //déco de la bdd
        emplacementDao.close();


        Spinner spinner = (Spinner) findViewById(R.id.Semplacement);
        Log.v("puis ici", "emplacement");
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, Emplacements.get(0), android.R.layout.simple_spinner_item);
        Log.v("et enfin ici", "emplacement");
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    }
}
