package com.example.gbernardeau.gestionstock.METIER;

/**

 * <p>Nom de la classe : Fiches</p>
 * <p></p>Ajoutée le 29/05/2018</p>
 * Descriptif : Classe permettant de gérer un objet Fiches.

 */

import java.util.Date;

/**
 * Classe possédant 3 attributs : id & quantite & date_insertion.
 */
public class Fiches {
    private Integer id;
    private Integer quantite;
    private Integer idetat;
    private Integer idarticle;
    private Integer idemp;


    public Fiches(Integer id, Integer quantite, Integer idetat, Integer idarticle, Integer idemp) {
        this.id = id;
        this.quantite = quantite;
        this.idetat = idetat;
        this.idarticle = idarticle;
        this.idemp = idemp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Integer getIdetat() {
        return idetat;
    }

    public void setIdetat(Integer idetat) {
        this.idetat = idetat;
    }

    public Integer getIdarticle() {
        return idarticle;
    }

    public void setIdarticle(Integer idarticle) {
        this.idarticle = idarticle;
    }

    public Integer getIdemp() {
        return idemp;
    }

    public void setIdemp(Integer idemp) {
        this.idemp = idemp;
    }
}

