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
    private Date date_insertion;

    /**
     *
     * @param id est un entier
     * @param quantite est un entier
     */
    public Fiches(Integer id, Integer quantite, Date date_insertion) {
        this.id = id;
        this.quantite = quantite;
        this.date_insertion = date_insertion;


    }

    /**
     * Permet de retourner l'id.
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Permet de définir l'id passé en paramètre.
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Permet de retourner la quantite.
     * @return quantite
     */
    public Integer getQuantite() {
        return quantite;
    }

    /**
     * Permet de définir la quantite passée en paramètre.
     * @param quantite
     */
    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    /**
     * Permet de retourner la valeur de l'attribut date_insertion
     * @return
     */
    public Date getDate_insertion() {
        return date_insertion;
    }

    /**
     * Permet de définire la valeur de l'attribut date_insertion
     * @param date_insertion
     */
    public void setDate_insertion(Date date_insertion) {
        this.date_insertion = date_insertion;
    }
}
