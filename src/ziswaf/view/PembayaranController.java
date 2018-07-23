/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziswaf.view;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ziswaf.model.*;

/**
 * FXML Controller class
 *
 * @author Aditya Raka
 */
public class PembayaranController implements Initializable {
    private JamaahList daftarJamaah;
    private WakafList daftarWakaf;

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private ChoiceBox tesPilihan;
    
    @FXML
    private ChoiceBox tesPilihan2;
    
    @FXML
    private TextField nominal;   
    
    private PembayaranList daftarPembayaran;
    private ObservableList<Pembayaran> addPembayaran;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        daftarJamaah = new JamaahList();
        daftarJamaah.loadXMLFile();
        daftarJamaah.toString();
        tesPilihan.setItems(daftarJamaah.get());
        
        
        daftarWakaf = new WakafList();
        daftarWakaf.loadXMLFile();
        daftarWakaf.toString();
        tesPilihan2.setItems(daftarWakaf.get());
    }    
    
    @FXML
    private void handleSubmit(ActionEvent event){
        Jamaah jamaah = (Jamaah) tesPilihan.getSelectionModel().getSelectedItem();
        Wakaf wakaf = (Wakaf) tesPilihan2.getSelectionModel().getSelectedItem();
        int nml = Integer.parseInt(nominal.getText().replace(".", ""));
        LocalDate date = LocalDate.now();
        Pembayaran pembayaran = new Pembayaran(jamaah, wakaf, nml, date);
        
        daftarPembayaran = new PembayaranList();
        daftarPembayaran.loadXMLFile();
        daftarPembayaran.addData(pembayaran);
        daftarPembayaran.saveXMLFile();
        nominal.setText("");
        tesPilihan.setValue(null);
        tesPilihan2.setValue(null);
        
    }
    
        //switch Scene
    public void changeToJamaahLayout(ActionEvent event) throws IOException{
        Parent jamaahParent = FXMLLoader.load(getClass().getResource("JamaahLayout.fxml"));
        Scene jamaahScene = new Scene(jamaahParent);
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(jamaahScene);
        window.show();
    }
    
    public void changeToPembayaran(ActionEvent event) throws IOException{
        Parent pembayaranParent = FXMLLoader.load(getClass().getResource("Pembayaran.fxml"));
        Scene pembayaranScene = new Scene(pembayaranParent);
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(pembayaranScene);
        window.show();
    }
    
    public void changeToWakaf(ActionEvent event) throws IOException{
        Parent wakafParent = FXMLLoader.load(getClass().getResource("Wakaf.fxml"));
        Scene wakafScene = new Scene(wakafParent);
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(wakafScene);
        window.show();
    }
    
    public void changeToLaporan(ActionEvent event) throws IOException{
        Parent laporanParent = FXMLLoader.load(getClass().getResource("Laporan.fxml"));
        Scene laporanScene = new Scene(laporanParent);
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(laporanScene);
        window.show();
    }
    
    public void changeToChart(ActionEvent event) throws IOException{
        Parent chartParent = FXMLLoader.load(getClass().getResource("Chart.fxml"));
        Scene chartScene = new Scene(chartParent);
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(chartScene);
        window.show();
    }
}
