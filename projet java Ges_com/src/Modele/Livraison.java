/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.Date;

/**
 *
 * @author Dell
 */
public class Livraison {
    private int idL;
    private Commande idcmd;
    private String libL;
    private Date dateL;
    //Constructeur
    public Livraison() {
    }
    //Getters
    public int getIdL() {
        return idL;
    }

    public Commande getIdcmd() {
        return idcmd;
    }

    public String getLibL() {
        return libL;
    }

    public Date getDateL() {
        return dateL;
    }
    //Setters
    public void setIdL(int idL) {
        this.idL = idL;
    }

    public void setIdcmd(Commande idcmd) {
        this.idcmd = idcmd;
    }

    public void setLibL(String libL) {
        this.libL = libL;
    }

    public void setDateL(Date dateL) {
        this.dateL = dateL;
    }
    
    
   
}
