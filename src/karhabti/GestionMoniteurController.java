/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karhabti;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import DAO.MoniteurDAO;
import Entity.Agence;
import Entity.Moniteur;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.ConditionalFeature.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 *
 * @author KHALIL-PC
 */
public class GestionMoniteurController implements Initializable {

    public static GestionMoniteurController gest;
        @FXML
    private ObservableList<Moniteur> data;
    @FXML
    private JFXTextField searchField;
    

    @FXML
    private TableView<Moniteur> tableMoniteurs;

    @FXML
    private TableColumn<Integer, Integer> num;
    @FXML
    private TableColumn<Moniteur, String> Nom;
    @FXML
    private TableColumn<Moniteur, String> Email;
    @FXML
    private TableColumn<Moniteur, Integer> Telephone;
    @FXML
    private TableColumn<Moniteur, String> Photo;

    @FXML
    private Button Ajouter;
    @FXML
    private Button Modifier;
    @FXML
    private Button Supprimer;
    @FXML
    private Button Afficher;
    @FXML
    private Button Avis;
    @FXML
    private ProgressBar progress;

    public GestionMoniteurController() {
        gest = this;
    }

    private void Tableau() throws SQLException {
        data = FXCollections.observableArrayList();
        MoniteurDAO dao = new MoniteurDAO();
        for (int i = 0; i < dao.afficherListe().size(); i++) {
            data.add(dao.afficherListe().get(i));
        }
        Nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        Email.setCellValueFactory(new PropertyValueFactory<>("mail"));
        Telephone.setCellValueFactory(new PropertyValueFactory<>("Telephone"));
        Photo.setCellValueFactory(new PropertyValueFactory<>("agence"));
        tableMoniteurs.setItems(data);
    }

    @FXML
    private void AjoutButtonAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        //get reference to the button's stage         
        stage = (Stage) Ajouter.getScene().getWindow();
        //load up OTHER FXML document
        root = FXMLLoader.load(getClass().getResource("AjoutMoniteur.fxml"));
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void deleteMoniteur() {
        int ind = tableMoniteurs.getSelectionModel().getSelectedIndex();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Suppression de profil moniteur");
        alert.setContentText("Vous etes sure de supprimer ce profil moniteur " + data.get(ind).getNom());

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            MoniteurDAO dao = new MoniteurDAO();

            try {
                int idB = data.get(ind).getId();
                dao.deleteMoniteur(idB);
                NotificationType type = NotificationType.WARNING;
                TrayNotification tray = new TrayNotification();
                tray.setTitle("Succes");
                tray.setMessage("La suppression a été éffectué avec succes");
                tray.setNotificationType(type);
                tray.setAnimationType(AnimationType.SLIDE);
                tray.showAndDismiss(Duration.seconds(10));
                Tableau();

            } catch (Exception ex) {
                Logger.getLogger(GestionMoniteurController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    public void ConsulterMoniteur() {
        MoniteurDAO dao = new MoniteurDAO();
        int ind = tableMoniteurs.getSelectionModel().getSelectedIndex();
        ButtonType bt1 = new ButtonType("Image", ButtonBar.ButtonData.NO);
        ButtonType bt2 = new ButtonType("Quitter", ButtonBar.ButtonData.FINISH);
        Alert alert = new Alert(Alert.AlertType.WARNING, "", bt1, bt2);
        alert.setTitle("Informations");

        alert.setHeaderText("Informations sur le moniteur");
        alert.setContentText("Agence :" + dao.findByIdAgence(data.get(ind).getId_agence()).getNom() + "\n Nom : " + data.get(ind).getNom()
                + "\n Prenom  : " + data.get(ind).getPrenom() + "\n Adresse : " + data.get(ind).getAdresse() + "\n ville : " + data.get(ind).getVille()
                + "\n code postal  : " + data.get(ind).getCodePostal() + "\n Prenom  : " + data.get(ind).getMail()
                + "\n Date  : " + data.get(ind).getDateNaissance() + "\n Lieu  : " + data.get(ind).getLieuNaissance());
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == bt1) {
            JFrame frame = new JFrame();
            String str = data.get(ind).getPhoto();
            ImageIcon icon = new ImageIcon("" + str);
            JLabel label = new JLabel(icon);
            frame.setMaximumSize(new Dimension(100, 200));

            frame.add(label);

            frame.pack();
            frame.setVisible(true);

        }
        if (result.get() == bt2) {
            alert.close();
        }
    }

    @FXML
    private void ModifButtonAction() throws IOException {
        Stage stage;
        Parent root;
        //get reference to the button's stage         
        stage = (Stage) Modifier.getScene().getWindow();
        //load up OTHER FXML document
        root = FXMLLoader.load(getClass().getResource("ModifMoniteur.fxml"));
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void AvisButtonAction() throws IOException {
        Stage stage;
        Parent root;
        //get reference to the button's stage         
        stage = (Stage) Avis.getScene().getWindow();
        //load up OTHER FXML document
        root = FXMLLoader.load(getClass().getResource("MenuCrudAvis.fxml"));
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public Agence getAgenceTABLE() {
        Agence a = tableMoniteurs.getSelectionModel().getSelectedItem().getAgence();
        return a;
    }

        @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Tableau();
        } catch (SQLException ex) {
            Logger.getLogger(GestionMoniteurController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Modifier.setDisable(true);
        Afficher.setDisable(true);
        Supprimer.setDisable(true);

        tableMoniteurs.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                Modifier.setDisable(false);
                Afficher.setDisable(false);
                Supprimer.setDisable(false);

            }
        });
          data = FXCollections.observableArrayList();
        MoniteurDAO dao = new MoniteurDAO();
        for (int i = 0; i < dao.afficherListe().size(); i++) {
            data.add(dao.afficherListe().get(i));
        }
        Nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        Email.setCellValueFactory(new PropertyValueFactory<>("mail"));
        Telephone.setCellValueFactory(new PropertyValueFactory<>("Telephone"));
        Photo.setCellValueFactory(new PropertyValueFactory<>("agence"));
        tableMoniteurs.setItems(data);
        ObservableList<Moniteur> list = FXCollections.observableArrayList();
        try{
            list = dao.listeMoniteur();
        }
      catch (SQLException ex) {
            Logger.getLogger(GestionMoniteurController.class.getName()).log(Level.SEVERE, null, ex);
        }
         FilteredList<Moniteur> filteredData = new FilteredList<>(data, e -> true);
        searchField.textProperty().addListener((ObservableValue, oldValue, newValue) ->
                {
                    filteredData.setPredicate((Predicate<? super Moniteur>) clts->{ 
                      
                        if(newValue == null || newValue.isEmpty())
                       {
                           return true;
                       }
                           String lowr = newValue.toLowerCase();
                     
                      if(clts.getNom().toLowerCase().contains(lowr))
                       {
                           return true;
                           
                       }
                      else if (clts.getPrenom().toLowerCase().contains(lowr))
                      {
                          return true;
                      }
                        return false;
                        
                });
                    
                    
            });
                SortedList<Moniteur> sortedData = new SortedList<>(filteredData);
                sortedData.comparatorProperty().bind(tableMoniteurs.comparatorProperty());
                tableMoniteurs.setItems(sortedData);
       
       
        
        

    }

    public Moniteur getMon() {
        Moniteur m = tableMoniteurs.getSelectionModel().getSelectedItem();
        return m;
    }

}