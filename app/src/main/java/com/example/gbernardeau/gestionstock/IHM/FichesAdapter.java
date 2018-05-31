package com.example.gbernardeau.gestionstock.IHM;

/**
 * Created by gbernardeau on 31/05/2018.
 */
import java.util.ArrayList;

import com.example.gbernardeau.gestionstock.METIER.Fiches;
import com.example.gbernardeau.gestionstock.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FichesAdapter extends ArrayAdapter<Fiches> {

    Context context;
    int layoutResourceId;
    ArrayList<Fiches> listfiches = null;

    public FichesAdapter(Context context, int layoutResourceId, ArrayList<Fiches> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.listfiches = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        MatiereHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new MatiereHolder();
            holder.id = (TextView)row.findViewById(R.id.fiches_id);
            holder.famille = (TextView)row.findViewById(R.id.fiches_famille);
            holder.emplacement = (TextView)row.findViewById(R.id.fiches_emplacement);
            holder.etat = (TextView)row.findViewById(R.id.fiches_etat);
            holder.date_entree = (TextView)row.findViewById(R.id.fiches_date_entree);

            row.setTag(holder);
        }
        else
        {
            holder = (MatiereHolder)row.getTag();
        }

        Fiches fiches = listfiches.get(position);
        holder.id.setText(fiches.getId());
        holder.famille.setText(Float.toString(fiches.getQuantite()));
        holder.emplacement.setText(Float.toString(fiches.getQuantite()));
        holder.etat.setText(Float.toString(fiches.getQuantite()));
        holder.date_entree.setText(Float.toString(fiches.getQuantite()));


        return row;
    }

    static class MatiereHolder
    {
        TextView id;
        TextView famille;
        TextView emplacement;
        TextView etat;
        TextView date_entree;
    }
}
