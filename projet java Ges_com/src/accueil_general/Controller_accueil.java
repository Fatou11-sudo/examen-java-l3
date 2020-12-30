/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accueil_general;

import Modele.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import tools.Outil;

/**
 *
 * @author Dell
 */
public class Controller_accueil implements Initializable {
    @FXML
    private Label parametres;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        parametres.setText(User.config_connexion);
    }
    public void loadCat (ActionEvent event) throws IOException{
        String url = "/Produit_manage/Categorie.fxml";
        Outil.load(event, url);
     }
     @FXML
     public void loadProd (ActionEvent event) throws IOException{
        String url = "/Produit_manage/Produit.fxml";
        Outil.load(event, url);
     }
}
