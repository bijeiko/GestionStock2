package com.example.gbernardeau.gestionstock.IHM;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.gbernardeau.gestionstock.DAO.FichesDAO;
import com.example.gbernardeau.gestionstock.METIER.Article;
import com.example.gbernardeau.gestionstock.METIER.Fiches;
import com.example.gbernardeau.gestionstock.R;

import java.util.ArrayList;

public class ArticlesAdapter extends ArrayAdapter<Article> {

    String libemp;
    String libarticle;
    String libetat;
    Context context;
    int layoutResourceId;
    private FichesDAO DAOF;
    ArrayList<Article> listArticle = null;

    public ArticlesAdapter(Context context, int layoutResourceId, ArrayList<Article> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.listArticle = data;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        FichesAdapter.MatiereHolder holder = null;
        DAOF = new FichesDAO(this.getContext());
        DAOF.open();
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new FichesAdapter.MatiereHolder();
            holder.id = (TextView)row.findViewById(R.id.fiches_id);
            holder.famille = (TextView)row.findViewById(R.id.fiches_famille);
            holder.emplacement = (TextView)row.findViewById(R.id.fiches_emplacement);
            holder.etat = (TextView)row.findViewById(R.id.fiches_etat);
            row.setTag(holder);
        }
        else
        {
            holder = (FichesAdapter.MatiereHolder)row.getTag();
        }
        Article articles = listArticle.get(position);

        libemp = DAOF.selectlibEmp(articles.getIdemp());
        libarticle = DAOF.selectlibArticle(articles.getCode());

        holder.id.setText(articles.getCode());
        holder.famille.setText(libarticle.toString());
        holder.emplacement.setText(libemp.toString());
        holder.etat.setText(libetat.toString());

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
