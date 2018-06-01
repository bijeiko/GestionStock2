package com.example.gbernardeau.gestionstock.METIER;

/**

* <p>Nom de la classe : Emplacement</p>
* <p>Ajoutée le 04/05/2018</p>
* Descriptif : Classe permettant de gérer un objet Emplacement.

*/

import android.util.Log;

/**
 * Classe possédant deux attributs : id & libelle.
 */
public class Emplacement {

    private Integer id;
    private Integer idrayon;
    private String libelle;

    /**
     *
     * @param id est un entier
     * @param libelle est une chaîne de caractère
     */

    public Emplacement(Integer id, Integer idrayon, String libelle) {
        this.id = id;
        this.idrayon = idrayon;
        this.libelle = libelle;

    }

    /**
     *Permet de retourner l'id.
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
     * Permet de retourner le libellé.
     * @return libelle
     */

    public String getLibelle() {
        return libelle;
    }


    public String getLibelleById(int id) {

        return libelle;
    }

    /**
     * Permet de définir le libelle passé en paramètre.
     * @param libelle
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getId_rayon() {
        return idrayon;
    }

    public void setId_rayon(Integer id_rayon) {
        this.idrayon = id_rayon;
    }
}
