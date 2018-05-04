package com.example.gbernardeau.gestionstock.METIER;

/**
 * Created by gbernardeau on 04/05/2018.
 */

public class Famille_Article {
    private int id;
    private int idfamille;
    private String codearticle;

    public Famille_Article(int id, int idfamille, String codearticle) {
        this.id = id;
        this.idfamille = idfamille;
        this.codearticle = codearticle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdfamille() {
        return idfamille;
    }

    public void setIdfamille(int idfamille) {
        this.idfamille = idfamille;
    }

    public String getCodearticle() {
        return codearticle;
    }

    public void setCodearticle(String codearticle) {
        this.codearticle = codearticle;
    }
}
