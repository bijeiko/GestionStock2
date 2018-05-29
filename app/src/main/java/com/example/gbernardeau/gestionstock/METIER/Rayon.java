package com.example.gbernardeau.gestionstock.METIER;

/**
 * <p>Nom de la classe : Rayon; </p>
 * <p>Ajoutée le 29/05/2018;</p>
 * Descriptif : Classe permettant de gérer un objet Rayon.
 */

public class Rayon {
    private int id;
    private String libelle;

    /**
     * Classe comprenant 2 attributs : id & libelle
     * @param id
     * @param libelle
     */
    public Rayon(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
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
     * Permet de retourner le libelle.
     * @return libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Permet de définir le libelle passé en paramètre.
     * @param libelle
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
