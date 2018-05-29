package com.example.gbernardeau.gestionstock.METIER;

/**

 * Nom de la classe : Famille_Article
 * Ajoutée le 29/05/2018
 * Descriptif : Classe permettant de gérer un objet Famille_Article.

 */

public class Famille_Article {
    private int id;
    private int idfamille;
    private String codearticle;

    public Famille_Article(int id, int idfamille, String codearticle) {
        this.id = id;
        this.idfamille = idfamille;
        this.codearticle = codearticle;
    }

    /**

     * Ajoutée le 29/05/2018
     * Descriptif : Méthodes permettant d'obtenir l'Id, l'Idfamille et le code d'article d'un emplacement ainsi que ses
     * setter pour l'Id, l'Idfamille et le code d'article.

     */


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdfamille() {
        return idfamille;
    }

    public void setIdfamille(int idfamille) {
        this.idfamille = idfamille;
    }

    public String getCodearticle() {
        return codearticle;
    }

    public void setCodearticle(String codearticle) {
        this.codearticle = codearticle;
    }
}
