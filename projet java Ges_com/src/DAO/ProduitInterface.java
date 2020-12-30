/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modele.Categorie;
import Modele.Produit;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface ProduitInterface {
    public Produit getProduitbyIdProd(int idprod);
    public List<String> getCategorietbyIdCat();
    public boolean AjouterProd(Produit prod);
    public int AjouterCat(Categorie cat);
    public boolean ModifierCat(Categorie cat);
    public boolean SupprimerCat(int idCat);
    public List<Produit> Consulter();
    public List<Categorie>  Verif_cat();
    public boolean Modifier(Produit p);
    public boolean Supprimer(int idprod);
    
}
