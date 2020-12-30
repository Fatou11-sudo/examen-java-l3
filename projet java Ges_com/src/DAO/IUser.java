/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modele.User;

/**
 *
 * @author Dell
 */
public interface IUser {
    public User getLogin(String Login, String password);
    
}
