/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziswaf.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import ziswaf.MainApp;
import ziswaf.model.Jamaah;
import ziswaf.model.Wakaf;
import ziswaf.model.WakafList;

/**
 * FXML Controller class
 *
 * @author Intel
 */
public class WakafController implements Initializable {
    private WakafList daftarWakaf;
    private MainApp mainApp;
    
    @FXML
    private TableView<Wakaf> wakafTable;
    
    @FXML
    private TableColumn<Wakaf, Integer> no;
    
    @FXML
    private TableColumn<Wakaf, String> jenisWakaf;
    
    @FXML
    private TableColumn<Wakaf, Integer> targetWakaf;
    
    @FXML
    private TableColumn<Wakaf, String> progresWakaf;
         
    @FXML
    private TextField jenisWakafField;
    
    @FXML
    private TextField targetWakafField;
    
    @FXML
    private TextField progressWakafField;
    
    @FXML
    private AnchorPane dialogNewWakaf;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dialogNewWakaf.setVisible(false);
        no.setCellValueFactory(cellData -> cellData.getValue().noProperty().asObject());
        jenisWakaf.setCellValueFactory(cellData -> cellData.getValue().jenisWakafProperty());
        targetWakaf.setCellValueFactory(cellData -> cellData.getValue().targetWakafProperty().asObject());
        progresWakaf.setCellValueFactory(cellData -> cellData.getValue().progressWakafProperty());
        
        daftarWakaf = new WakafList();
        daftarWakaf.loadXMLFile();
        wakafTable.setItems(daftarWakaf.get());
        
        wakafTable.setEditable(true);
        jenisWakaf.setCellFactory(TextFieldTableCell.forTableColumn());
        targetWakaf.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        progresWakaf.setCellFactory(TextFieldTableCell.forTableColumn());
    }    
    
    @FXML
    private void handleDeleteWakaf(){
        int pilihan = wakafTable.getSelectionModel().getSelectedIndex();
        if(pilihan >= 0){
            wakafTable.getItems().remove(pilihan);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Tidak Ada Pilihan");
            alert.setHeaderText("Tidak Ada Jamaah Terpilih");
            alert.setContentText("Silakan pilih jamaah terlebih dahulu!");
            alert.showAndWait();
        }
        
        daftarWakaf.saveXMLFile();
    }
    
    @FXML
    private void handleNewWakaf(){
        Wakaf wakaf = new Wakaf();
        wakaf.setJenisWakaf(jenisWakafField.getText());
        wakaf.setTargetWakaf(Integer.parseInt(targetWakafField.getText().replace(".","")));
        wakaf.setProgressBar(progressWakafField.getText());
        wakafTable.getItems().add(wakaf);
        daftarWakaf.saveXMLFile();
        dialogNewWakaf.setVisible(false);
        jenisWakafField.setText("");
        targetWakafField.setText("");
        progressWakafField.setText("");
    }
    
    @FXML
    public void editJenisWakaf(TableColumn.CellEditEvent<Wakaf, String> wakafStringCellEditEvent){
        Wakaf wakaf = wakafTable.getSelectionModel().getSelectedItem();
        wakaf.setJenisWakaf(wakafStringCellEditEvent.getNewValue());
        daftarWakaf.saveXMLFile();
    }
    
    @FXML
    public void editTargetWakaf(TableColumn.CellEditEvent<Wakaf, Integer> wakafIntegerCellEditEvent){
        Wakaf wakaf = wakafTable.getSelectionModel().getSelectedItem();
        wakaf.setTargetWakaf(wakafIntegerCellEditEvent.getNewValue());
        daftarWakaf.saveXMLFile();
    }
    
    @FXML
    public void editProgressWakaf(TableColumn.CellEditEvent<Wakaf, String> wakafStringCellEditEvent){
        Wakaf wakaf = wakafTable.getSelectionModel().getSelectedItem();
        wakaf.setProgressBar(wakafStringCellEditEvent.getNewValue());
        daftarWakaf.saveXMLFile();
    }
  
    //move dialog
    @FXML
    private void btnAddWakaf(ActionEvent event){
        dialogNewWakaf.setVisible(true);
    }
    
    @FXML
    private void handleCancel(ActionEvent event){
        dialogNewWakaf.setVisible(false);
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
