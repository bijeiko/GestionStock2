package com.example.gbernardeau.gestionstock.IHM;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gbernardeau.gestionstock.DAO.FichesDAO;
import com.example.gbernardeau.gestionstock.METIER.Fiches;
import com.example.gbernardeau.gestionstock.R;

import java.util.ArrayList;


/**
 * Created by gbernardeau on 03/04/2018.
 */

public class FichesActivity extends AppCompatActivity {
    private Button Accueilbtn, CreateFiches, ToutesLesFiches;
    private ListView Listfiches;
    private FichesDAO DAOF;

    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id){
        return false;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiches);

        setTitle("Gestion des Stocks : Gestion des Fiches");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#C0D904")));

        DAOF = new FichesDAO(this);
        DAOF.open();
        refrech_list();

        // Bouton navigation
        Accueilbtn = (Button) findViewById(R.id.Accueilbtn);
        Accueilbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activitiemain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(activitiemain);
            }
        });
        CreateFiches = (Button) findViewById(R.id.CreateFiches);
        CreateFiches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activitycreatefiche = new Intent(getApplicationContext(), CreationFicheActivity.class);
                startActivity(activitycreatefiche);
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
    }

    public void refrech_list(){

        ListView listContent = (ListView)findViewById(R.id.eLVFiches);
        FichesAdapter adapter = new FichesAdapter(this, R.layout.list_fiches, DAOF.read());
        listContent.setAdapter(adapter);
        //listContent.setOnItemClickListener(OnClickItem);
    }
}