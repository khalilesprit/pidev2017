/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karhabti;

import DAO.MoniteurDAO;
import Entity.Agence;
import Entity.Moniteur;
import com.jfoenix.controls.JFXTextField;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author KHALIL-PC
 */
public class ModifMoniteurController implements Initializable {

    @FXML
    public TextField nom;
    
    @FXML
    private JFXTextField searchField;
    @FXML
    public TextField prenom;
    @FXML
    public TextField lieu;
    @FXML
    public TextField codePostal;
    @FXML
    public TextField adresse;
    @FXML
    public TextField mail;
    @FXML
    public TextField telephone;
    @FXML
    public ComboBox<String> civilite;
    @FXML
    public ComboBox<String> ville;
    @FXML
    public ComboBox<String> agence;
    @FXML
    public DatePicker date;
    @FXML
    private Button Modifier;
    @FXML
    private Button consulter;
    @FXML
    private Button retour;
    @FXML
    private Button photo;
    @FXML
    public TextField test;
    @FXML
    public ImageView imageview;
    
    private File file;
    private Image image;    
    private FileChooser fileChooser;
    private FileInputStream fis;
    public Stage primaryStage;
    
    Moniteur m = GestionMoniteurController.gest.getMon();

    
    
    public void affich()
    {
//        System.out.println("*********"+m.getNom());

       MoniteurDAO dao = new MoniteurDAO();
//       agence.setValue(""+a.getNom());
 date.setValue(LocalDate.of(1999, 01, 01));
        nom.setText(m.getNom());
        prenom.setText(m.getPrenom());
        mail.setText(m.getMail());
        telephone.setText(""+m.getTelephone());
        codePostal.setText(""+m.getCodePostal());
        ville.setValue(m.getVille());
        civilite.setValue(m.getCivilite());
//        Date datee = java.sql.Date.valueOf(m.getDateNaissance().toString());
//        date.setValue(date);
        lieu.setText(m.getLieuNaissance());
        adresse.setText(m.getAdresse());
        test.setText(m.getPhoto());
        
    }
    
    @FXML
    public void Modifier() throws IOException
    {
        
        
        int id = GestionMoniteurController.gest.getMon().getId();
        MoniteurDAO pdao = new MoniteurDAO();
        Moniteur m = new Moniteur();
        if (validateFields()) {
        Agence a = pdao.findByIdAgence(pdao.findByNomAgence(agence.getValue()).getId());
        System.out.println(""+a);
        m.setId(id);m.setAgence(a);m.setId_agence(a.getId());m.setNom(nom.getText());m.setPrenom(prenom.getText());m.setCivilite(civilite.getValue());
        m.setAdresse(adresse.getText());m.setVille(ville.getValue());m.setCodePostal(Integer.parseInt(codePostal.getText()));
        m.setTelephone(Integer.parseInt(telephone.getText()));
        m.setLieuNaissance(lieu.getText()); m.setMail(mail.getText());m.setPhoto(test.getText());  
        System.out.println(""+m.getAgence().getNom());
        pdao.modifier(m);
        NotificationType type = NotificationType.INFORMATION;
        TrayNotification tray = new TrayNotification();
        tray.setTitle("Succes");
        tray.setMessage("La modification a été effectué avec succes");
        tray.setNotificationType(type);
        tray.setAnimationType(AnimationType.SLIDE);
        tray.showAndDismiss(Duration.seconds(10));
        JOptionPane j;
        j = new JOptionPane();
        j.showMessageDialog(null, "Moniteur modifié avec succes ", "Informations", JOptionPane.INFORMATION_MESSAGE);

        Stage stage; 
        Parent root;
        //get reference to the button's stage         
        stage=(Stage) Modifier.getScene().getWindow();
        //load up OTHER FXML document
        root = FXMLLoader.load(getClass().getResource("Moniteurs.fxml"));
     //create a new scene with root and set the stage
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
    }
    }
    @FXML
    public void Retour() throws IOException{
        Stage stage; 
        Parent root;
        //get reference to the button's stage         
        stage=(Stage) Modifier.getScene().getWindow();
        //load up OTHER FXML document
        root = FXMLLoader.load(getClass().getResource("Moniteurs.fxml"));
     //create a new scene with root and set the stage
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
    }
    
        public void combo() {
        MoniteurDAO rec = new MoniteurDAO();
        List<String> l = new ArrayList<>();
        l = rec.afficheragence();
        final ObservableList<String> list = FXCollections.<String>observableList(l);
        agence.promptTextProperty().setValue("");
        agence.getItems().addAll(list);
    }
    
     @FXML
    public void addPhoto(){
        photo.setOnAction(e->{
//            file=fileChooser.showOpenDialog(this);
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(((Node) e.getTarget()).getScene().getWindow());
            if (file != null){
                test.setText(file.getAbsolutePath());
                image = new Image(file.toURI().toString(), 100, 100, true, true);
                imageview = new ImageView(image);
                imageview.setFitWidth(100);
                imageview.setFitHeight(150);
                imageview.setPreserveRatio(true);
                
                BorderPane.setAlignment(imageview, Pos.TOP_LEFT);
            }
        });
    }
    @FXML
    public void ConsulterImage() {
        
            JFrame frame = new JFrame();
            ImageIcon icon = new ImageIcon("" + test.getText());
            JLabel label = new JLabel(icon);
            frame.setMaximumSize(new Dimension(300, 600));
            frame.add(label);
            
            frame.pack();
            frame.setVisible(true);

        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//         Moniteur m = GestionMoniteurController.gest.getMon();
//         int id_s = GestionMoniteurController.gest.getMon().getId();
//        Agence a = GestionMoniteurController.gest.getAgenceTABLE();
        MoniteurDAO dao = new MoniteurDAO();
        System.out.println(" *-*-*-*"+GestionMoniteurController.gest.getMon().getId_agence());
        agence.setValue(dao.findByIdAgence(GestionMoniteurController.gest.getMon().getId_agence()).getNom());
//            agence.setValue(dao.findByIdAgence(m.getId_agence()).getNom());
//            Agence a = dao.findByIdAgence(dao.findByNomAgence(m.get).getId());
//            System.out.println(""+a);
//                System.out.println("*********"+m.getNom());
//        final Image image2 = new Image(ModifMoniteurController.class.getResourceAsStream(m.getPhoto()));
//        imageview.setImage(image2);
        System.out.println(m.getPhoto());
        combo();
        affich();
        
        ConsulterImage();
    }
    
     private boolean validateFields() {
        if (date.getValue()==null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Fields");
            alert.setHeaderText(null);
            alert.setContentText("saisissez la date svp");
            alert.showAndWait();
            return false;
        }
        if (nom.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Fields");
            alert.setHeaderText(null);
            alert.setContentText("saisissez le nom svp");
            alert.showAndWait();
            return false;
        }
        if (prenom.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Fields");
            alert.setHeaderText(null);
            alert.setContentText("saisissez le prenom svp");
            alert.showAndWait();
            return false;
        }
        if (adresse.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Fields");
            alert.setHeaderText(null);
            alert.setContentText("saisissez l'adresse svp");
            alert.showAndWait();
            return false;
        }
        if (mail.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Fields");
            alert.setHeaderText(null);
            alert.setContentText("saisissez l'email svp");
            alert.showAndWait();
            return false;
        }
        
        if (!(isValidEmailAddress(mail.getText()))) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Fields");
            alert.setHeaderText(null);
            alert.setContentText("saisissez l'email correct svp");
            alert.showAndWait();
            return false;
        }
        
        if (ville.getValue().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Fields");
            alert.setHeaderText(null);
            alert.setContentText("saisissez la ville svp");
            alert.showAndWait();
            return false;
        }
        if (agence.getValue().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Fields");
            alert.setHeaderText(null);
            alert.setContentText("saisissez l'agence svp");
            alert.showAndWait();
            return false;
        }
        if (!validate(codePostal.getText())) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Fields");
            alert.setHeaderText(null);
            alert.setContentText("le champs code postale est de type entier et de 4 chiffres ");
            alert.showAndWait();
            return false;

        }
        if (!validatee(telephone.getText())) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Fields");
            alert.setHeaderText(null);
            alert.setContentText("le champs telephone est de type entier et de 8 chiffres ");
            alert.showAndWait();
            return false;

        }
        
        if (validatee(date)) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Fields");
            alert.setHeaderText(null);
            alert.setContentText("Votre Age -18 ");
            alert.showAndWait();
            return false;
        }
        if (lieu.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Fields");
            alert.setHeaderText(null);
            alert.setContentText("saisissez le lieu svp");
            alert.showAndWait();
            return false;
        }

        if (test.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Fields");
            alert.setHeaderText(null);
            alert.setContentText("saisissez une photo svp");
            alert.showAndWait();
            return false;
        }

        
        return true;
    }

    
    private boolean validate(String text) {
        return text.matches("[0-9]*")&&(text.length()==4);
    }
    private boolean validatee(String text) {
        return text.matches("[0-9]*")&&(text.length()==8);
    }
    private boolean validatee(DatePicker datee) {
        
        if((2017-datee.getValue().getYear())<=18){
        return false;
    }
        else return true;
        
    }

   public boolean isValidEmailAddress(String email) {
           String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
           java.util.regex.Matcher m = p.matcher(email);
           return m.matches();
    }


}
