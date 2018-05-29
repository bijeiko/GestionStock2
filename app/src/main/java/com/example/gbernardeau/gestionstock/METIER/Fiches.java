package com.example.gbernardeau.gestionstock.METIER;

/**

 * <p>Nom de la classe : Fiches</p>
 * <p></p>Ajoutée le 29/05/2018</p>
 * Descriptif : Classe permettant de gérer un objet Fiches.

 */

/**
 * Classe possédant 2 attributs : id & quantite.
 */
public class Fiches {
    private int id;
    private int quantite;

    /**
     *
     * @param id est un entier
     * @param quantite est un entier
     */
    public Fiches(int id, int quantite) {
        this.id = id;
        this.quantite = quantite;

    }

    /**
     * Permet de retourner l'id.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Permet de définir l'id passé en paramètre.
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Permet de retourner la quantite.
     * @return quantite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Permet de définir la quantite passée en paramètre.
     * @param quantite
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
