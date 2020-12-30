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
public class User {
    private int idUser;
    private String Login;
    private String password;
    private String nom;
    private String prenom;
    public static String config_connexion;

    public int getIdUser() {
        return idUser;
    }

    public String getLogin() {
        return Login;
    }

    public String getPassword() {
        return password;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    //Setters

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    
       
    
}
