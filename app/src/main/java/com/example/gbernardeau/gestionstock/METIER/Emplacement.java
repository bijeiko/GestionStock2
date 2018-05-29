package com.example.gbernardeau.gestionstock.METIER;

/**

* <p>Nom de la classe : Emplacement</p>
* <p>Ajoutée le 04/05/2018</p>
* Descriptif : Classe permettant de gérer un objet Emplacement.

*/

/**
 * Classe possédant deux attributs : id & libelle.
 */
public class Emplacement {

    private int id;
    private String libelle;

    /**
     *
     * @param id est un entier
     * @param libelle est une chaîne de caractère
     */

    public Emplacement(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    /**
     *Permet de retourner l'id.
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
     * Permet de retourner le libellé.
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
