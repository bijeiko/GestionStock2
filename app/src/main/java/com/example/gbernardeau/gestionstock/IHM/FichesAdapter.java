package com.example.gbernardeau.gestionstock.IHM;

/**
 * Created by gbernardeau on 31/05/2018.
 */
import java.util.ArrayList;

import com.example.gbernardeau.gestionstock.DAO.FichesDAO;
import com.example.gbernardeau.gestionstock.METIER.Fiches;
import com.example.gbernardeau.gestionstock.R;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FichesAdapter extends ArrayAdapter<Fiches> {
    String libemp;
    Context context;
    int layoutResourceId;
    private FichesDAO DAOF;
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
        DAOF = new FichesDAO(this.getContext());
        DAOF.open();

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new MatiereHolder();
            holder.id = (TextView)row.findViewById(R.id.fiches_id);
            holder.famille = (TextView)row.findViewById(R.id.fiches_famille);
            holder.emplacement = (TextView)row.findViewById(R.id.fiches_emplacement);
            holder.etat = (TextView)row.findViewById(R.id.fiches_etat);
            row.setTag(holder);
        }
        else
        {
            holder = (MatiereHolder)row.getTag();
        }

        Fiches fiches = listfiches.get(position);
        libemp = DAOF.selectlib(fiches.getId()) ;
        holder.id.setText(fiches.getId().toString());
        holder.famille.setText(fiches.getIdarticle().toString());
        holder.emplacement.setText(libemp.toString());
        holder.etat.setText(fiches.getIdetat().toString());

        return row;
    }

    static class MatiereHolder
    {
        TextView id;
        TextView famille;
        TextView emplacement;
        TextView etat;
    }
}
