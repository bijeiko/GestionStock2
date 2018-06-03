package com.example.gbernardeau.gestionstock.IHM;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.gbernardeau.gestionstock.DAO.ArticleDAO;
import com.example.gbernardeau.gestionstock.DAO.FichesDAO;
import com.example.gbernardeau.gestionstock.METIER.Article;
import com.example.gbernardeau.gestionstock.METIER.Fiches;
import com.example.gbernardeau.gestionstock.R;

import java.util.ArrayList;

public class ArticlesAdapter extends ArrayAdapter<Article> {

    String libemp;
    String libarticle;
    String libfamille;
    Context context;
    int layoutResourceId;
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
        ArticlesAdapter.MatiereHolder holder = null;
        ArticleDAO ArtDAO = new ArticleDAO(this.getContext());
        ArtDAO.open();
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ArticlesAdapter.MatiereHolder();
            holder.code = (TextView)row.findViewById(R.id.article_code);
            holder.designation = (TextView)row.findViewById(R.id.article_designation);
            holder.stock = (TextView)row.findViewById(R.id.article_stock);
            holder.emplacement = (TextView)row.findViewById(R.id.article_emplacement);
            holder.famille = (TextView)row.findViewById(R.id.article_famille);
            row.setTag(holder);
        }
        else
        {
            holder = (ArticlesAdapter.MatiereHolder)row.getTag();
        }
        Article articles = listArticle.get(position);

        libemp = ArtDAO.selectlibEmp(articles.getIdemp());
        libfamille = ArtDAO.selectlibFamille(articles.getIdfam());

        holder.code.setText(articles.getCode());
        holder.designation.setText(articles.getLibelle());
        holder.stock.setText(Integer.toString(articles.getStock()));
        holder.emplacement.setText(libemp.toString());
        holder.famille.setText(libfamille.toString());

        return row;
    }

    static class MatiereHolder
    {
        TextView code;
        TextView designation;
        TextView stock;
        TextView emplacement;
        TextView famille;
    }

}
