/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import static java.sql.DriverManager.getConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Dell
 */
public class BD {
    //Pour se connecter à la base de données
    private Connection connecte;
    //Pour recuperer les resultats des requêtes select
    private ResultSet resultat;
    //Pour executer les requetes preparees
    private PreparedStatement prst;
    //Recuperation des requetes INSERT, DELETE, UPDATE
    private int passe;
    
    
    //Methode pour ouvrir la connexion
    private void getConnexion(){
         String url = "jdbc:mysql://localhost:3306/javaproject";
         String username = "root";
         String password = "";
        try {
          Class.forName("com.mysql.jdbc.Driver");
          connecte = DriverManager.getConnection(url, username, password);
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Preparation des requêtes
    public void initPrepare(String sql){
        getConnexion();
        try {
            if (sql.toLowerCase().startsWith("insert")){
                prst = connecte.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            }else
            {
                prst = connecte.prepareStatement(sql);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Execution des requêtes de mis à jour
    public int executeMAJ(){
        try {
            passe = prst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return passe;
    }
    //Execution des requêtes Select
    public ResultSet executeSelect(){
        try {
            resultat = prst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultat;
    }

    public PreparedStatement getPrst() {
        return this.prst;
    }
    //Fermeture de la connecion à la base
    public void closeConnexion(){
        try {
            if (connecte != null){
                connecte.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
