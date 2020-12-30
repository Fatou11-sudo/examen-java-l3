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
public class Paiement {
    private int idReg;
    private Livraison idL;
    private String libReg;
    private Date dateReg;
    //Constructeur
    public Paiement() {
    }
    //Getters
    public int getIdReg() {
        return idReg;
    }

    public Livraison getIdL() {
        return idL;
    }

    public String getLibReg() {
        return libReg;
    }

    public Date getDateReg() {
        return dateReg;
    }
    //Setters
    public void setIdReg(int idReg) {
        this.idReg = idReg;
    }

    public void setIdL(Livraison idL) {
        this.idL = idL;
    }

    public void setLibReg(String libReg) {
        this.libReg = libReg;
    }

    public void setDateReg(Date dateReg) {
        this.dateReg = dateReg;
    }
    
    
    
}
