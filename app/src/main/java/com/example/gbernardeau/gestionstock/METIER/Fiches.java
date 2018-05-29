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
    private Integer id;
    private Integer quantite;

    /**
     *
     * @param id est un entier
     * @param quantite est un entier
     */
    public Fiches(Integer id, Integer quantite) {
        this.id = id;
        this.quantite = quantite;

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
}
