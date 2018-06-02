package com.example.gbernardeau.gestionstock.METIER;

import android.util.Log;

/**

 * <p>Nom de la classe : Etat</p>
 * <p></p>Ajoutée le 29/05/2018</p>
 * Descriptif : Classe permettant de gérer un objet Etat.

 */
public class Etat {
    private Integer id;
    private String libelle;
    /**
     * @param id est un entier
     * @param libelle est une chaîne de caractère
     */
    public Etat(Integer id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    /**
     Permet d'obtenir l'Id.
     */
    public Integer getId() {
        return id;
    }
    /**
     Permet de définir le code.
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     Permet d'obtenir le libellé.
     */
    public String getLibelle() {
        return libelle;
    }
    /**
     Permet de définir le libellé.
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


}
