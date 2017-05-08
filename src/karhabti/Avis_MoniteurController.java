/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karhabti;

import DAO.MoniteurDAO;
import Entity.AvisMoniteur;
import Entity.Client;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import org.controlsfx.control.Rating;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author wael nouri
 */
public class Avis_MoniteurController implements Initializable {

    @FXML
    private TextField client;
    @FXML
    private TextField contenu;
    @FXML
    private Rating rating;
    @FXML
    private Button confirmer;
    @FXML
    private Button retour;

    @FXML
    public void Retour() throws IOException {
        Stage stage;
        Parent root;
        //get reference to the button's stage         
        stage = (Stage) retour.getScene().getWindow();
        //load up OTHER FXML document
        root = FXMLLoader.load(getClass().getResource("MenuCrudAvis.fxml"));
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Confirmer() throws IOException {
        MoniteurDAO rec = new MoniteurDAO();
        AvisMoniteur a = new AvisMoniteur();
        Client c = new Client();
        c.setId(1);
        a.setClient(c);
        a.setContenu(contenu.getText());
        a.setRating((int) rating.getRating());
        rec.insertAvis(a);
        NotificationType type = NotificationType.SUCCESS;
        TrayNotification tray = new TrayNotification();
        tray.setTitle("Succes");
        tray.setMessage("La note sur ce client a été insérée avec succes");
        tray.setNotificationType(type);
        tray.setAnimationType(AnimationType.SLIDE);
        tray.showAndDismiss(Duration.seconds(10));

        Stage stage;
        Parent root;
        //get reference to the button's stage         
        stage = (Stage) confirmer.getScene().getWindow();
        //load up OTHER FXML document
        root = FXMLLoader.load(getClass().getResource("ConsulterAvis.fxml"));
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        client.setText("clienttest");
        client.setDisable(true);
        rating.setRating(5);

    }

}
