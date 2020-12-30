/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e_shop;

import DAO.IUser;
import DAO.UserImplement;
import Modele.User;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tools.Outil;

/**
 *
 * @author Dell
 */
public class EShop extends Application {
    @FXML
    private TextField login_txt;
    @FXML
    private PasswordField password_txt;
    @FXML
    private Button connexion_btn;
    //Cette methode permettra de se connecter a la base
    @FXML
    public void getConnexion(ActionEvent event) throws IOException{
        String login = login_txt.getText();
        String password = password_txt.getText();
        if (login.trim().equals("") || password.trim().equals("")){
            Outil.showErrorMessage("Erreur", "Veuillez remplir les champs!");
        }else{
           IUser iu = new UserImplement();
           User u = iu.getLogin(login, password);
           if (u != null){
               User.config_connexion = "HELLO " + u.getPrenom() + " " + u.getNom();
               String url = "/accueil_general/Accueil.fxml";
               Outil.load(event, url);
           }else{
               Outil.showErrorMessage("Erreur", "Login ou mot de passe incorrect !");
           }
           
        }
    }
            
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}