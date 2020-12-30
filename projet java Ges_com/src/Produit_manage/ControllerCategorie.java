package Produit_manage;

import DAO.ProduitBD;
import DAO.ProduitInterface;
import Modele.Categorie;
import Modele.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import tools.Outil;

public class ControllerCategorie implements Initializable {
    
    private ProduitInterface ic;
    @FXML
    private Button valider_bt;

    @FXML
    private TextField nomCat_txt;

    @FXML
    private TableView<Categorie> categorie_table;

    @FXML
    private TableColumn<Categorie, Integer> idCat_column;

    @FXML
    private TableColumn<Categorie, String> nomCat_column;

    @FXML
    private Button modifier_bt;

    @FXML
    private Button supprimer_bt;

    @FXML
    private Label params_lb;
    
    @FXML
    private Button precedent_cat;
    
    @FXML
    void retour_cat(ActionEvent event) throws IOException{
          String url = "/accueil_general/Accueil.fxml";
         Outil.load(event, url);
    }


    @FXML
    void modifier(ActionEvent event) {
          Categorie categorie = categorie_table.getSelectionModel().getSelectedItem();
          String noms = categorie.getLibCat();
          String nom = nomCat_txt.getText();
            ic = new ProduitBD();
            if(ic.ModifierCat(categorie) == true){
                  Outil.showConfirmationMessage("Felicitation", "Categorie modifiée avec succes");
                  categorie.setLibCat(nom);
            }else{
                Outil.showErrorMessage("Erreur", "Données non ajoutées");
            }
        
    }
    
    public void ChangerNom(CellEditEvent edditedCell){
        Categorie categorie = categorie_table.getSelectionModel().getSelectedItem();
        categorie.setLibCat(edditedCell.getNewValue().toString());
    }

    @FXML
    void supprimer(ActionEvent event) {
        Categorie categorie = categorie_table.getSelectionModel().getSelectedItem();
        ic = new ProduitBD();
        int id = categorie.getIdCat();
        if (ic.SupprimerCat(id)==true){
            categorie_table.getItems().removeAll(categorie_table.getSelectionModel().getSelectedItem());
             Outil.showConfirmationMessage("Felicitation", "Categorie supprimée avec succes");
        }else{
                Outil.showErrorMessage("Erreur", "Données non supprimées");
        }
     
    }

    @FXML
    void tableClick(MouseEvent event) {
        Categorie categorie = categorie_table.getSelectionModel().getSelectedItem();
        String nom = categorie.getLibCat();
        int id = categorie.getIdCat();
        nomCat_txt.setText(nom);
 }

    @FXML
    void valider(ActionEvent event) {
        String nom = nomCat_txt.getText();
        if (nom.trim().equals("")){
            Outil.showErrorMessage("Erreur", "Entrez un nom de categorie SVP");
        }else{
            ic = new ProduitBD();
            Categorie c = new Categorie();
            c.setLibCat(nom);
            if(ic.AjouterCat(c) != 0){
                Outil.showConfirmationMessage("Felicitation", "Categorie ajoutée avec succes");
                loadTable();
                nomCat_txt.setText("");
            }else{
                Outil.showErrorMessage("Erreur", "Données non ajoutées");
            }
        }
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Chaque colone correspond a un attribut de la classe Categorie
        idCat_column.setCellValueFactory(new PropertyValueFactory<>("idCat"));
        nomCat_column.setCellValueFactory(new PropertyValueFactory<>("libCat"));
        loadTable();
        
        //Info utilisateur
        params_lb.setText(User.config_connexion);
    }
    
    private void loadTable(){
        ic = new ProduitBD();
        ObservableList<Categorie> l_categorie = FXCollections.observableArrayList();
        ic.Verif_cat().stream()
                .forEach(c->l_categorie.add(c));
        //Chargement des categories dans le tableau
        categorie_table.setItems(l_categorie);
    }

}
