package com.example.gbernardeau.gestionstock.METIER;

/*

* Nom de la classe : Emplacement
* Ajoutée le 04/05/2018
* Descriptif : Classe permettant de gérer un objet Emplacement.

*/

public class Emplacement {

    private int id;
    private String libelle;

    /**
     * Initialise la class
     * @param id int
     * @param libelle string
     */

    public Emplacement(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

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
