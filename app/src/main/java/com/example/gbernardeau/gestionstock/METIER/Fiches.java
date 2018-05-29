package com.example.gbernardeau.gestionstock.METIER;

/*

 * Nom de la classe : Fiches
 * Ajoutée le 29/05/2018
 * Descriptif : Classe permettant de gérer un objet Fiches.

 */


public class Fiches {
    private int id;
    private int quantite;

    public Fiches(int id, int quantite) {
        this.id = id;
        this.quantite = quantite;

    }

    /*

     * Ajoutée le 29/05/2018
     * Descriptif : Méthodes permettant d'obtenir l'Id et la quantité d'un emplacement ainsi que ses
     * setter pour l'Id et la quantité.

     */


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
