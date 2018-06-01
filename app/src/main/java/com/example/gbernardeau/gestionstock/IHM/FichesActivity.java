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
import android.widget.Spinner;
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
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0bc637")));

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
        listContent.setOnItemClickListener(OnClickItem);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_action_action, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_ajouter:
                AlertAjout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void AlertAjout(){
        LayoutInflater inflater = getLayoutInflater();
        View promptsView = inflater.inflate(R.layout.dialog_ajout_fiches, null);
        AlertDialog.Builder Builder = new AlertDialog.Builder(this);
        // set title
        Builder.setTitle("Ajouter une matiere");

        // set dialog message
        Builder.setView(promptsView);
        final EditText eTQuantite = (EditText) promptsView.findViewById(R.id.TQuantite);
        final EditText eTDesignation = (EditText) promptsView.findViewById(R.id.TDesignation);
        final Spinner Semplacement = (Spinner) promptsView.findViewById(R.id.Semplacement);
        final Spinner Sfamille = (Spinner) promptsView.findViewById(R.id.Sfamille);
        final Spinner Setat = (Spinner) promptsView.findViewById(R.id.Setat);

        Builder
            .setMessage("Ajouter une matière")
            .setCancelable(true)
            .setPositiveButton("Ajouter", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog,int id) {
                        Context context = FichesActivity.this;
                        int duration = Toast.LENGTH_LONG;

                        if(!(eTQuantite.getText().length() == 0) && !(eTDesignation.getText().length() == 0)){
                            Fiches ma= new Fiches( DAOF.getLastIdFiches(),Integer.getInteger(eTQuantite.getText().toString()), Setat.getId(), Sfamille.getId(), Semplacement.getId());
                            DAOF.create(ma);
                            refrech_list();
                            CharSequence text = "Fiche Ajoutée!";
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        }else{
                            CharSequence text = "Champs vide!";
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        }

                    }

                })
                .setNegativeButton("Annuler",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });
                // create alert dialog
                AlertDialog alertDialog = Builder.create();

                // show it
                alertDialog.show();

    }

    public AdapterView.OnItemClickListener OnClickItem = new AdapterView.OnItemClickListener(){

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            final Fiches cl = DAOF.readAtCursor(position);
            LayoutInflater inflater = getLayoutInflater();
            View promptsView = inflater.inflate(R.layout.dialog_ajout_fiches, null);
            AlertDialog.Builder Builder = new AlertDialog.Builder(FichesActivity.this);
            // set title
            Builder.setTitle("Modifier/Supprimer une fiche");
            // set dialog message
            Builder.setView(promptsView);
            final EditText eTQuantite = (EditText) promptsView.findViewById(R.id.TQuantite);
            final EditText eTDesignation = (EditText) promptsView.findViewById(R.id.TDesignation);
            final Spinner Semplacement = (Spinner) promptsView.findViewById(R.id.Semplacement);
            final Spinner Sfamille = (Spinner) promptsView.findViewById(R.id.Sfamille);
            final Spinner Setat = (Spinner) promptsView.findViewById(R.id.Setat);

            eTQuantite.setText(Integer.toString(cl.getQuantite()));
            eTDesignation.setText(Integer.toString(cl.getIdarticle()));
            /*Semplacement.setText(Integer.toString(cl.getIdarticle()));
            Sfamille.setAdapter(Integer.toString(Sfamille.getAdapter()));
            Setat.setAdapter(Integer.toString(Setat.getAdapter()));*/
            Builder
                    .setMessage("Modifier une fiche")
                    .setCancelable(true)
                    .setPositiveButton("Modifier",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            Log.v("test", "test");
                            Context context = getApplicationContext();
                            int duration = Toast.LENGTH_LONG;
                            if(!(eTQuantite.getText().length() == 0) && !(eTDesignation.getText().length() == 0)){
                                Fiches ma= new Fiches( cl.getId() ,Integer.getInteger(eTQuantite.getText().toString()), Setat.getId(), Sfamille.getId(), Semplacement.getId());
                                DAOF.update(ma);
                                refrech_list();

                                CharSequence text = "Fiche modifiée!";
                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                            }else{
                                CharSequence text = "Champs vide!";
                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                            }
                        }

                    })
                    .setNegativeButton("Annuler",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, just close
                            // the dialog box and do nothing
                            dialog.cancel();
                        }
                    })
                    .setNeutralButton("Supprimer",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            AlertDialog.Builder Builder = new AlertDialog.Builder(FichesActivity.this);
                            // set title
                            Builder.setTitle("Voulez-vous vraiment supprimer cette fiche ?");

                            // set dialog message
                            Builder
                                    .setMessage("Supprimer une fiche")
                                    .setCancelable(true)
                                    .setPositiveButton("Oui",new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,int id) {
                                            Context context = getApplicationContext();
                                            int duration = Toast.LENGTH_LONG;
                                            Fiches ma= new Fiches(cl.getId() ,Integer.getInteger(eTQuantite.getText().toString()), Setat.getId(), Sfamille.getId(), Semplacement.getId());
                                            Log.v(ma.getId().toString(), "fiche");
                                            DAOF.delete(ma);
                                            refrech_list();

                                            CharSequence text = "Fiche supprimée!";
                                            Toast toast = Toast.makeText(context, text, duration);
                                            toast.show();
                                        }
                                    })
                                    .setNegativeButton("Non",new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,int id) {
                                            dialog.cancel();
                                        }
                                    });

                            // create alert dialog
                            AlertDialog alertDialog = Builder.create();

                            // show it
                            alertDialog.show();
                        }
                    });
            // create alert dialog
            AlertDialog alertDialog = Builder.create();

            // show it
            alertDialog.show();


        }

    };
}