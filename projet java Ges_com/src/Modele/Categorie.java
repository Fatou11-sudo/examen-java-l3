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
public class Categorie {
    private int idCat;
    private String libCat;
    //Constructeur
    public Categorie(){
    }
    //Getters
    public int getIdCat(){
        return idCat; 
    }
    public String getLibCat(){
        return libCat;
    }
    //Setters
    public void setIdCat(int idCat){
        this.idCat = idCat;
    }
    public void setLibCat(String libCat){
        this.libCat = libCat;
    }
}
