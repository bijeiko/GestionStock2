package com.example.gbernardeau.gestionstock.METIER;
/**

 * <p>Nom de la classe : Etat</p>
 * <p></p>Ajoutée le 29/05/2018</p>
 * Descriptif : Classe permettant de gérer un objet Etat.

 */
public class Etat {
    private int id;
    private String libelle;
    /**
     * @param id est un entier
     * @param libelle est une chaîne de caractère
     */
    public Etat(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    /**
     Permet d'obtenir l'Id.
     */
    public int getId() {
        return id;
    }
    /**
     Permet de définir le code.
     */
    public void setId(int id) {
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
