package com.example.gbernardeau.gestionstock.IHM;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gbernardeau.gestionstock.DAO.ArticleDAO;
import com.example.gbernardeau.gestionstock.DAO.EmplacementDAO;
import com.example.gbernardeau.gestionstock.DAO.EtatDAO;
import com.example.gbernardeau.gestionstock.DAO.FamilleDAO;
import com.example.gbernardeau.gestionstock.DAO.FichesDAO;
import com.example.gbernardeau.gestionstock.DAO.RayonDAO;
import com.example.gbernardeau.gestionstock.METIER.Article;
import com.example.gbernardeau.gestionstock.METIER.Emplacement;
import com.example.gbernardeau.gestionstock.METIER.Etat;
import com.example.gbernardeau.gestionstock.METIER.Famille;
import com.example.gbernardeau.gestionstock.METIER.Fiches;
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
    private Button bSearch, bTri, accueilbtn, ToutesLesFiches, ToutLesArticles, btn_annuler, btn_ajouter;
    private EditText TEtat, TRayon, TEmplacement, TCode, TDesignation, TQuantite, TFamille, TStock;

    /**
     * A la création de la page, des boutons sont créés grâce à la View(R.Layout.creation_fiche)
     * disposant de liens pour accéder aux différentes pages.
     * @param savedInstanceState
     */

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creation_fiche);

        setTitle("Gestion des Stocks");

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

        btn_ajouter = (Button) findViewById(R.id.btn_ajouter);
        btn_ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
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

    }

    public void add(){

        TEtat = (EditText) findViewById(R.id.TEtat);
        Etat etat = new Etat(TEtat.getText().toString());
        EtatDAO EDAO = new EtatDAO(this);
        EDAO.open();
        EDAO.insert(etat);
        int idEtat = EDAO.selectId(etat);
        EDAO.close();

        TRayon = (EditText) findViewById(R.id.TRayon);
        Rayon rayon = new Rayon(TRayon.getText().toString());
        RayonDAO RDAO = new RayonDAO(this);
        RDAO.open();
        RDAO.insert(rayon);
        int idRayon = RDAO.selectId(rayon);
        RDAO.close();

        TFamille = (EditText) findViewById(R.id.TFamille);
        Famille famille = new Famille(TFamille.getText().toString());
        FamilleDAO FDAO = new FamilleDAO(this);
        FDAO.open();
        FDAO.insert(famille);
        int idFamille = FDAO.selectId(famille);
        FDAO.close();

        TEmplacement = (EditText) findViewById(R.id.TEmplacement);
        Emplacement emplacement = new Emplacement(idRayon, TEmplacement.getText().toString());
        EmplacementDAO EmDAO = new EmplacementDAO(this);
        EmDAO.open();
        EmDAO.insert(emplacement);
        int idEmplacement = EmDAO.selectId(emplacement);
        EmDAO.close();

        TCode = (EditText) findViewById(R.id.TCode);
        TDesignation = (EditText) findViewById(R.id.TDesignation);
        TStock = (EditText) findViewById(R.id.TStock);
        Article article = new Article(TCode.getText().toString(), TDesignation.getText().toString(), Integer.parseInt(TStock.getText().toString()), idEmplacement, idFamille);
        ArticleDAO ArtDAO = new ArticleDAO(this);
        ArtDAO.open();
        ArtDAO.insert(article);
        String idArticle = ArtDAO.selectId(article);
        ArtDAO.close();

        TQuantite = (EditText) findViewById(R.id.TQuantite);
        Fiches fiches = new Fiches(Integer.parseInt(TQuantite.getText().toString()), idEtat, idArticle, idEmplacement);
        FichesDAO FiDAO = new FichesDAO(this);
        FiDAO.open();
        FiDAO.insert(fiches);
        FiDAO.close();

    }

}
