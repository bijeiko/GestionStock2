package com.example.gbernardeau.gestionstock.IHM;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.List;

import com.example.gbernardeau.gestionstock.DAO.EtatDAO;
import com.example.gbernardeau.gestionstock.R;

public class MainActivity extends AppCompatActivity {


    private Button bSearch, bTri, Accueil, CreateFiches, ToutesLesFiches, ToutLesArticles;
    private EditText Search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bouton navigation
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

        

    }
}
