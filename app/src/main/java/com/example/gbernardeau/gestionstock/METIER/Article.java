package com.example.gbernardeau.gestionstock.METIER;

public class Article {
    private String code;
    private String designation;
    private int stock;

    public Article(String code, String designation, int stock) {
        this.code = code;
        this.designation = designation;
        this.stock = stock;
    }

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
