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
public class Client {
    private int idCl;
    private String nom;
    private String prenom;
    private String adresse;
    private int tel;
    private String email;
    //Constructeur
    public Client() {
    }
    //Getters
    public int getIdCl() {
        return idCl;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }
    //Setters
    public void setIdCl(int idCl) {
        this.idCl = idCl;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
