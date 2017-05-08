/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karhabti;

import DAO.MoniteurDAO;
import Entity.AvisMoniteur;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author wael nouri
 */
public class ConsulterAvisController implements Initializable {

    @FXML
    private TextField client;
    @FXML
    private Button retour;
    @FXML
    private Rating rating;
    @FXML
    PieChart piee;

    public void AffichRating() {
        MoniteurDAO dao = new MoniteurDAO();
        List<AvisMoniteur> l = dao.afficherAvisByIdClient(1);
        int moy;
        int s = 0;
        for (AvisMoniteur n : l) {
            s += n.getRating();

            System.out.println("*-*-*-**-*-*-*-*-**" + s);

        }
        moy = (int) (s / l.size());
        rating.setRating(moy);
    }

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
    void SetAreaChart() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

      //  String[] months = {"Janvier", "Fevrier", "Mars", "Avril", "May", "Juin", "Juillet", "Aout", "Septembre", "Octobre", "Novembre", "decembre"};
        MoniteurDAO pdao = new MoniteurDAO();

//        for (int i = 0; i < 12; i++) {
//            try {
        //                            pieChartData.addAll(new PieChart.Data("2015",1),
//                                    new PieChart.Data("2014", 2),
//                                    new PieChart.Data("2012", 1),
//                                    new PieChart.Data("2013", 0)
//                                    );
        for(int i = 0;i<pdao.afficherAvisByIdClient(1).size();i++)
                    {
                        pieChartData.add(new PieChart.Data("Note: "+pdao.afficherAvisByIdClient(1).get(i).getRating(), pdao.afficherAvisByIdClient(1).get(i).getRating()));                  
                    }

        piee.setTitle("Les notes de client");

        piee.setData(pieChartData);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        client.setText("clienttest");
        client.setDisable(true);
//        rating.setRating(5);
        AffichRating();
        rating.setDisable(true);
        SetAreaChart();
    }
}
