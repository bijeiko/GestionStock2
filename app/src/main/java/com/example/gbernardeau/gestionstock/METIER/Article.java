package com.example.gbernardeau.gestionstock.METIER;

/**

 * <p>Nom de la classe : Article;</p>
 * <p>Ajoutée le 04/05/2018;</p>
 * Descriptif : Classe permettant de gérer un objet Article.

 */

public class Article {
    private String code;
    private String libelle;
    private Integer stock;
    private Integer idfam;
    private Integer idemp;

    /**
     * @param code est une chaîne de caractère
     * @param libelle est une chaîne de caractère
     * @param stock est un entier
     */
    public Article(String code, String libelle, Integer stock,Integer idemp, Integer idfam) {
        this.code = code;
        this.libelle = libelle;
        this.stock = stock;
        this.idemp = idemp;
        this.idfam = idfam;
    }

    /**
     * Constructeur optionnel ne prenant pas en compte le code (l'id d'article).
     * @param libelle
     * @param stock
     * @param idemp
     * @param idfam
     */
    public Article(String libelle, Integer stock, Integer idemp, Integer idfam){
        this.libelle = libelle;
        this.stock = stock;
        this.idemp = idemp;
        this.idfam = idfam;
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
    public String getLibelle() {
        return libelle;
    }
    /**
     Permet de définir la désignation.
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
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

    /**
     * Permet de retourner une chaîne de caractère avec la valeur des attributs de Article.
     */
    public String toString(){
        return "Code : " + code + "; Désignation : " + libelle + " & Stock : " + stock;
    }

    public Integer getIdfam() {
        return idfam;
    }

    public void setIdfam(Integer idfam) {
        this.idfam = idfam;
    }

    public Integer getIdemp() {
        return idemp;
    }

    public void setIdemp(Integer idemp) {
        this.idemp = idemp;
    }
}
