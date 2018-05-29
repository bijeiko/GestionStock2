package com.example.gbernardeau.gestionstock.METIER;

/**

 * Nom de la classe : Famile
 * Ajoutée le 29/05/2018
 * Descriptif : Classe permettant de gérer un objet Famille.

 */

public class Famille {
    private int id;
    private String libelle;

    public Famille(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    /**

     * Ajoutée le 29/05/2018
     * Descriptif : Méthodes permettant d'obtenir l'Id et le libellé d'un emplacement ainsi que ses
     * setter pour l'Id et le libellé.

     */


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}

