/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author Dell
 */
public class Produit {
    // Attributs 
    private int idprod;
    private Categorie idcat;
    private String libProd;
    private int qte;
    private int PU;
    //Constructeur
    public Produit() {
    }
    //Getters
     public int getIdprod() {
        return idprod;
    }

    public Categorie getIdcat() {
        return idcat;
    }

    public String getLibProd() {
        return libProd;
    }

    public int getQte() {
        return qte;
    }

    public int getPU() {
        return PU;
    }
    //Setters
    public void setIdprod(int idprod) {
        this.idprod = idprod;
    }

    public void setIdcat(Categorie idcat) {
        this.idcat = idcat;
    }

    public void setLibProd(String libProd) {
        this.libProd = libProd;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public void setPU(int PU) {
        this.PU = PU;
    }
    

    
  }
