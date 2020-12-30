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
public class Commande {
    private int idcmd;
    private Client idCl;
    private Produit idprod;
    private int qteD;
    private int pu;
    private Date dateCmd;
    //Constructeur
    public Commande() {
    }
    //Getters
    public int getIdcmd() {
        return idcmd;
    }

    public Date getDateCmd() {
        return dateCmd;
    }
    

    public Client getIdCl() {
        return idCl;
    }

    public Produit getIdprod() {
        return idprod;
    }

    public int getQteD() {
        return qteD;
    }

    public int getPu() {
        return pu;
    }
    //setters
    public void setIdcmd(int idcmd) {
        this.idcmd = idcmd;
    }

    public void setIdCl(Client idCl) {
        this.idCl = idCl;
    }

    public void setIdprod(Produit idprod) {
        this.idprod = idprod;
    }

    public void setQteD(int qteD) {
        this.qteD = qteD;
    }

    public void setPu(int pu) {
        this.pu = pu;
    }

    public void setDateCmd(Date dateCmd) {
        this.dateCmd = dateCmd;
    }
    
    
    
    
}
