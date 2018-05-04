package com.example.gbernardeau.gestionstock.METIER;

/*

 * Nom de la classe : Article
 * Ajoutée le 04/05/2018
 * Descriptif : Classe permettant de gérer un objet Article.

 */

public class Article {
    private String code;
    private String designation;
    private int stock;

    public Article(String code, String designation, int stock) {
        this.code = code;
        this.designation = designation;
        this.stock = stock;
    }

    /*

     * Ajoutée le 04/05/2018
     * Descriptif : Méthodes getters/setters pour le code, designation et stock.

     */
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
