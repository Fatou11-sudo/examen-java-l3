/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modele.User;
import java.sql.ResultSet;

/**
 *
 * @author Dell
 */
public class UserImplement implements IUser {
    public BD bd;

    public UserImplement() {
        bd = new BD(); 
    }
    
    @Override
    public User getLogin(String Login, String password) {
       User u = null;
       String sql = "SELECT * FROM user WHERE Login = ? AND password = ?";
        try {
            bd.initPrepare(sql);
            bd.getPrst().setString(1, Login);
            bd.getPrst().setString(2, password);
            ResultSet resultat = bd.executeSelect();
            while (resultat.next()){
                u = new User();
                u.setIdUser(resultat.getInt(1));
                u.setNom(resultat.getString(2));
                u.setPrenom(resultat.getString(3));
                u.setLogin(resultat.getString(4));
                u.setPassword(resultat.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return u;
    }
    
}
