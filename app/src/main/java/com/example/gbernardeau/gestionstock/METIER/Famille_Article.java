package com.example.gbernardeau.gestionstock.METIER;

/**

 * <p>Nom de la classe : Famille_Article</p>
 * <p>Ajoutée le 29/05/2018</p>
 * Descriptif : Classe permettant de gérer un objet Famille_Article.

 */

/**
 * Classe possédant 3 attributs : id, idfamille & codearticle.
 */
public class Famille_Article {
    private Integer id;
    private Integer idfamille;
    private String codearticle;

    /**
     *
     * @param id est un entier
     * @param idfamille est un entier
     * @param codearticle est une chaîne de caractère
     */
    public Famille_Article(Integer id, Integer idfamille, String codearticle) {
        this.id = id;
        this.idfamille = idfamille;
        this.codearticle = codearticle;
    }

    /**
     * Permet d'obtenir l'id.
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
     * Permet d'obtenir l'idFamille.
     * @return idFamille
     */
    public Integer getIdfamille() {
        return idfamille;
    }

    /**
     * Permet de définir l'idFamille passé en paramètre.
     * @param idfamille
     */
    public void setIdfamille(Integer idfamille) {
        this.idfamille = idfamille;
    }

    /**
     * Permet de retourner le codeArticle.
     * @return codearticle
     */
    public String getCodearticle() {
        return codearticle;
    }

    /**
     * Permet de définir le codeArticle passé en paramètre.
     * @param codearticle
     */
    public void setCodearticle(String codearticle) {
        this.codearticle = codearticle;
    }
}
