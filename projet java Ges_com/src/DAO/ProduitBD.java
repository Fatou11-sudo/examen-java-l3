/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modele.Categorie;
import Modele.Produit;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ProduitBD implements ProduitInterface {
    private BD bd;
    private int passe;
    private ResultSet resultat;
    public boolean bol;
    
    public ProduitBD(){
        bd = new BD();
    }
    @Override
    public Produit getProduitbyIdProd(int idprod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getCategorietbyIdCat() {
        List<String> lcat =null;  
        String sql = "SELECT * FROM categorie";
        try {
            lcat =new  ArrayList<>();
            bd.initPrepare(sql);
            resultat = bd.executeSelect();
            while (resultat.next()){
                lcat.add(resultat.getString("libCat"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lcat;
    }

    @Override
    public boolean AjouterProd(Produit prod) {
        String sql = "INSERT INTO `javaproject`.`produit` (`idProd`, `libProd`, `Qte`, `Prix`, `idCat`) VALUES (NULL, ?, ?, ?, ?)";
        bol = false;
        try {
            bd.initPrepare(sql);
            bd.getPrst().setString(1, prod.getLibProd());
            bd.getPrst().setInt(2, prod.getQte());
            bd.getPrst().setInt(3, prod.getPU());
            passe = bd.executeMAJ();
            //Gestion des clés primaires autoincrément
            resultat = bd.getPrst().getGeneratedKeys();
            while (resultat.next()){
                passe = resultat.getInt(1);
            }
            if (passe != 0){
                bol = true;
            }
            resultat.close();
            bd.closeConnexion();
        } catch (Exception e) {
            bol = false;
            e.printStackTrace();
        }
        return bol;
    }

    @Override
    public int AjouterCat(Categorie cat) {
        String sql = "INSERT INTO `javaproject`.`categorie` (`idCat`, `libCat`) VALUES (NULL, ?)";
        try {
            //Initialisation
            bd.initPrepare(sql);
            //Passage de valeurs
            bd.getPrst().setString(1, cat.getLibCat());
            //Execution
            passe = bd.executeMAJ();
             //Gestion des clés primaires autoincrément
            resultat = bd.getPrst().getGeneratedKeys();
            while (resultat.next()){
                passe = resultat.getInt(1);
            }
            //Fin gestion des cles primaires auto_increment
            resultat.close();
            bd.closeConnexion();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return passe;
    }

    @Override
    public boolean ModifierCat(Categorie cat) {
         String sql = "UPDATE `javaproject`.`categorie` SET `libCat` = ? WHERE `categorie`.`idCat` =?";
        bol = false;
        try {
            bd.initPrepare(sql);
            bd.getPrst().setString(1, cat.getLibCat());
            bd.getPrst().setInt(2, cat.getIdCat());
            passe = bd.executeMAJ();
            if (passe != 0){
                bol = true;
            }
        } catch (Exception e) {
            bol = false;
            e.printStackTrace();;
            
        }
        return bol;
    }

    @Override
    public boolean SupprimerCat(int idCat) {
        String sql = "DELETE FROM `javaproject`.`categorie` WHERE `categorie`.`idCat` = ?";
        bol = false;
        try {
            bd.initPrepare(sql);
            bd.getPrst().setInt(1, idCat);
            passe = bd.executeMAJ();
            if (passe != 0){
                bol = true;
            }
        } catch (Exception e) {
            bol = false;
            e.printStackTrace();;
            
        }
        return bol;
    }

    @Override
    public List<Produit> Consulter() {
        List<Produit> l_produit = new ArrayList<Produit>();  
        String sql = "SELECT * FROM produit";
        try {
            bd.initPrepare(sql);
            resultat = bd.executeSelect();
            while (resultat.next()){
                Produit p = new Produit();
                p.setIdprod(resultat.getInt(1));//c.setIdCat(resultat.getInt("idCat"));
                p.setLibProd(resultat.getString(2));//c.setLibCat(resultat.getString("libCat"));
                p.setQte(resultat.getInt(3));
                p.setPU(resultat.getInt(4));
                l_produit.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l_produit;
    }
    
    @Override
    public List<Categorie> Verif_cat() {
        List<Categorie> l_categorie = new ArrayList<Categorie>();  
        String sql = "SELECT * FROM categorie";
        try {
            bd.initPrepare(sql);
            resultat = bd.executeSelect();
            while (resultat.next()){
                Categorie c = new Categorie();
                c.setIdCat(resultat.getInt(1));//c.setIdCat(resultat.getInt("idCat"));
                c.setLibCat(resultat.getString(2));//c.setLibCat(resultat.getString("libCat"));
                l_categorie.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l_categorie;
    }

    @Override
    public boolean Modifier(Produit p) {
        return bol;
    }

    @Override
    public boolean Supprimer(int idprod) {
        return bol;
    }
    
}
