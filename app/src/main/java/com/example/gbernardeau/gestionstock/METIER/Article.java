package com.example.gbernardeau.gestionstock.METIER;

/**

 * <p>Nom de la classe : Article;</p>
 * <p>Ajoutée le 04/05/2018;</p>
 * Descriptif : Classe permettant de gérer un objet Article.

 */

public class Article {
    private String code;
    private String designation;
    private Integer stock;

    /**
     * @param code est une chaîne de caractère
     * @param designation est une chaîne de caractère
     * @param stock est un entier
     */
    public Article(String code, String designation, Integer stock) {
        this.code = code;
        this.designation = designation;
        this.stock = stock;
    }

    /**
    Permet d'obtenir le code.
     */
    public String getCode() {
        return code;
    }
    /**
     Permet de définir le code.
     */
    public void setCode(String code) {
        this.code = code;
    }
    /**
     Permet d'obtenir la désignation.
     */
    public String getDesignation() {
        return designation;
    }
    /**
     Permet de définir la désignation.
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    /**
     Permet d'obtenir le stock.
     */
    public int getStock() {
        return stock;
    }
    /**
     Permet de définir le stock.
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
