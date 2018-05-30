package com.example.gbernardeau.gestionstock.IHM;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import com.example.gbernardeau.gestionstock.DAO.EtatDAO;
import com.example.gbernardeau.gestionstock.DAO.FamilleDAO;
import com.example.gbernardeau.gestionstock.DAO.FichesDAO;
import com.example.gbernardeau.gestionstock.DAO.SQLiteGestionStock;
import com.example.gbernardeau.gestionstock.METIER.Fiches;
import com.example.gbernardeau.gestionstock.R;

/**
 * Classe publique MainActivity qui hérite de la classe AppCompatActivity
 */

public class MainActivity extends AppCompatActivity {

    /**
     * Déclaration des éléments utiles à la classe
     */

    private Button bSearch, bTri, Accueil, CreateFiches, ToutesLesFiches, ToutLesArticles;
    private EditText Search;
    private ListView ListViewAccueil;

    /**
     * Fonction onCreate qui se déclenche lors de l'ouverture de la page
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         * Appel de la fonction onCreate() du parent
         */
        super.onCreate(savedInstanceState);
        /**
         * Affichage de la vue associée
         */
        setContentView(R.layout.activity_main);

        /**
         * Fonctions associées à la redirection lors d'un click sur les boutons
         */
        ToutLesArticles = (Button) findViewById(R.id.ToutLesArticles);
        ToutLesArticles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityarticle = new Intent(getApplicationContext(), ListeArticleActivity.class);
                startActivity(activityarticle);
            }
        });

        CreateFiches = (Button) findViewById(R.id.CreateFiches);
        CreateFiches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activitycreation = new Intent(getApplicationContext(), CreationFicheActivity.class);
                startActivity(activitycreation);
            }
        });

        ToutesLesFiches = (Button) findViewById(R.id.ToutesLesFiches);
        ToutesLesFiches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityfiche = new Intent(getApplicationContext(), ListeFichesActivity.class);
                startActivity(activityfiche);
            }
        });

        /**
         * Test population ListView
         */

        FichesDAO FicDAO = new FichesDAO(this);
        FicDAO.open();

        ArrayList<Fiches> lesFiches = FicDAO.read();
        ArrayList<String> Fiches = new ArrayList<String>();

        for(Fiches uneFiche : lesFiches){
            Fiches.add(uneFiche.getId()+"\n"+uneFiche.getQuantite());
        }

        /**
         *
         */

        ListViewAccueil.setAdapter(new ArrayAdapter<String>(this,R.layout.activity_main,R.id.ListViewAccueil,Fiches));

        FicDAO.close();

    }
}
