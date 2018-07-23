/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziswaf.view;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ziswaf.model.Jamaah;
import ziswaf.model.JamaahList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ziswaf.MainApp;

/**
 * FXML Controller class
 *
 * @author Fathi
 */
public class JamaahLayoutController implements Initializable {
    private JamaahList jamaahList;
    private MainApp mainApp;
    
    @FXML
    private TableView<Jamaah> jamaahTable;
    @FXML
    private TableColumn<Jamaah, Integer> idJamaah;
    @FXML
    private TableColumn<Jamaah, String> namaJamaah;
    @FXML
    private TableColumn<Jamaah, String> alamatJamaah;
    @FXML
    private TableColumn<Jamaah, String> statusJamaah;
    
    @FXML
    private TextField namaField;
    
    @FXML
    private TextField alamatField;
    
    @FXML
    private TextField statusField;
    
    @FXML
    private AnchorPane dialogNewJamaah;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dialogNewJamaah.setVisible(false);
        idJamaah.setCellValueFactory(cellData -> cellData.getValue().idJamaahProperty().asObject());
        namaJamaah.setCellValueFactory(cellData -> cellData.getValue().namaJamaahProperty());
        alamatJamaah.setCellValueFactory(cellData -> cellData.getValue().alamatJamaahProperty());
        statusJamaah.setCellValueFactory(cellData -> cellData.getValue().statusJamaahProperty());
        
        jamaahList = new JamaahList();
        jamaahList.loadXMLFile();
        jamaahTable.setItems(jamaahList.get());
        
        jamaahTable.setEditable(true);
        namaJamaah.setCellFactory(TextFieldTableCell.forTableColumn());
        alamatJamaah.setCellFactory(TextFieldTableCell.forTableColumn());
        statusJamaah.setCellFactory(TextFieldTableCell.forTableColumn());
        
    }    
    
    @FXML
    private void handleDeleteJamaah(){
        int pilihan = jamaahTable.getSelectionModel().getSelectedIndex();
        if(pilihan >= 0){
            jamaahTable.getItems().remove(pilihan);
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Tidak Ada Pilihan");
            alert.setHeaderText("Tidak Ada Jamaah Terpilih");
            alert.setContentText("Silakan pilih jamaah terlebih dahulu!");
            alert.showAndWait();
        }
        
        jamaahList.saveXMLFile();
    }
    
    @FXML
    private void handleNewJamaah(){
        Jamaah jamaah = new Jamaah();
        jamaah.setNamaJamaah(namaField.getText());
        jamaah.setAlamatJamaah(alamatField.getText());
        jamaah.setStatusJamaah(statusField.getText());
        jamaahTable.getItems().add(jamaah);
        jamaahList.saveXMLFile();
        dialogNewJamaah.setVisible(false);
    }
    
    @FXML
    public void editNamaJamaah(TableColumn.CellEditEvent<Jamaah, String> jamaahStringCellEditEvent){
        Jamaah jamaah = jamaahTable.getSelectionModel().getSelectedItem();
        jamaah.setNamaJamaah(jamaahStringCellEditEvent.getNewValue());
        jamaahList.saveXMLFile();
    }
    
    @FXML
    public void editAlamatJamaah(TableColumn.CellEditEvent<Jamaah, String> jamaahStringCellEditEvent){
        Jamaah jamaah = jamaahTable.getSelectionModel().getSelectedItem();
        jamaah.setAlamatJamaah(jamaahStringCellEditEvent.getNewValue());
        jamaahList.saveXMLFile();
    }
    
    @FXML
    public void editStatusJamaah(TableColumn.CellEditEvent<Jamaah, String> jamaahStringCellEditEvent){
        Jamaah jamaah = jamaahTable.getSelectionModel().getSelectedItem();
        jamaah.setStatusJamaah(jamaahStringCellEditEvent.getNewValue());
        jamaahList.saveXMLFile();
    }
    
    //move dialog
    @FXML
    private void btnAddJamaah(ActionEvent event){
        dialogNewJamaah.setVisible(true);
    }
    
    @FXML
    private void handleCancel(ActionEvent event){
        dialogNewJamaah.setVisible(false);
    }
    //move Scene
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
