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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ziswaf.model.Jamaah;
import ziswaf.model.Pembayaran;
import ziswaf.model.PembayaranList;
import ziswaf.model.Wakaf;

/**
 * FXML Controller class
 *
 * @author Intel
 */
public class LaporanController implements Initializable {
    private PembayaranList daftarPembayaran;
    
    @FXML
    private TableView<Pembayaran> pembayaranTable;
    @FXML
    private TableColumn<Pembayaran, LocalDate> waktuTransaksi;
    @FXML
    private TableColumn<Pembayaran, Jamaah> namaJamaah;
    @FXML
    private TableColumn<Pembayaran, Wakaf> jenisWakaf;
    @FXML
    private TableColumn<Pembayaran, Integer> nominal;
    @FXML
    private TableColumn<Pembayaran, Integer> jumlah;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        waktuTransaksi.setCellValueFactory(cellData -> cellData.getValue().waktuTransaksiProperty());
        namaJamaah.setCellValueFactory(cellData -> cellData.getValue().jamaahProperty());
        jenisWakaf.setCellValueFactory(cellData -> cellData.getValue().wakafProperty()); 
        nominal.setCellValueFactory(cellData -> cellData.getValue().nominalProperty().asObject());
    //    jumlah.setCellValueFactory(cellData -> cellData.getValue().jumlahProperty().asObject());
        
        daftarPembayaran = new PembayaranList();
        daftarPembayaran.loadXMLFile();
        pembayaranTable.setItems(daftarPembayaran.get());
        //pembayaranTable.setItems(daftarPembayaran.get2());
    }    
    
    @FXML
    private void handleDeletePembayaran(){
        int pilihan = pembayaranTable.getSelectionModel().getSelectedIndex();
        if(pilihan >= 0){
            pembayaranTable.getItems().remove(pilihan);
        } 
        
        daftarPembayaran.saveXMLFile();
    }
    
    @FXML
    private void clearAllData(){
        for (int i= 0; i< pembayaranTable.getItems().size();i++){
            pembayaranTable.getItems().clear();
        }
        daftarPembayaran.saveXMLFile();
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
