package com.example.gbernardeau.gestionstock.METIER;

/**

 * <p>Nom de la classe : Famille</p>
 * <p>Ajoutée le 29/05/2018</p>
 * Descriptif : Classe permettant de gérer un objet Famille.

 */

/**
 * Classe possédant 2 attributs : id & libelle.
 */
public class Famille {
    private Integer id;
    private String libelle;

    /**
     *
     * @param id est un entier
     * @param libelle est une chaîne de caractère
     */
    public Famille(Integer id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    /**
     * Constructeur optionnel ne prenant pas en compte l'id.
     * @param libelle
     */
    public Famille(String libelle){
        this.libelle=libelle;
    }

    /**
     * Permet de retourner l'Id.
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Permet de définir l'Id passé en paramètre.
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Permet de retourner le libellé.
     * @return libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Permet de définir le libellé passé en paramètre.
     * @param libelle
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}

