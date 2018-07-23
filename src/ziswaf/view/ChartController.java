/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziswaf.view;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ziswaf.statistics.Frekuensi;
import ziswaf.model.Jamaah;
import ziswaf.model.Pembayaran;
import ziswaf.model.PembayaranList;
import ziswaf.model.Wakaf;

/**
 * FXML Controller class
 *
 * @author Intel
 */
public class ChartController implements Initializable {
    
    @FXML 
    private Label meanLabel;
    @FXML 
    private Label medianLabel;
    @FXML 
    private Label modusLabel;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private Pane paneView;
    @FXML
    private Pane meanPane;
    @FXML
    private TableView rataRata;
    @FXML 
    private TableColumn<Pembayaran, Wakaf> jenisWakaf;
    @FXML
    private TableColumn<String, Integer> frekuensi;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadDataPembayaran();
        meanResult();
        modusResult();
    }       
   
    public void loadDataPembayaran(){
        PembayaranList daftar = new PembayaranList();
        Pembayaran pemb;
        daftar.loadXMLFile();
        paneView.getChildren().clear();
        xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        Map<String, Integer> hitungNama = new HashMap<>();
        for(Pembayaran pp : daftar.get()){
            String nama = pp.getWakaf().getJenisWakaf();
            Integer jumlah = hitungNama.get(nama);
            if(jumlah == null) jumlah = 0;
            hitungNama.put(nama, jumlah+1);
        }
        
        BarChart barChart = new BarChart(xAxis,yAxis);
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        for(Pembayaran pp: daftar.get()){
            String wakaf = pp.getWakaf().getJenisWakaf();
            series.getData().add(new XYChart.Data<>(wakaf, hitungNama.get(wakaf)));
        }                
        
        barChart.getData().add(series);
        paneView.getChildren().add(barChart);
        jenisWakaf.setCellValueFactory(cellData -> cellData.getValue().wakafProperty());
        //frekuensi.setCellValueFactory(cellData -> cellData.getValue().hitungNama.get(wakaf).asObject());
    }
    
    public void meanResult(){
        PembayaranList daftar = new PembayaranList();
        daftar.loadXMLFile();
        Map<String, Integer> hitungNama = new HashMap<>();
        for(Pembayaran pp : daftar.get()){
            String nama = pp.getJamaah().getNamaJamaah();
            Integer jumlah = hitungNama.get(nama);
            if(jumlah == null) jumlah = 0;
            hitungNama.put(nama, jumlah+1);
        }
        
        int totalNama = 0;
        for(Pembayaran p :daftar.get()){
            String nama = p.getJamaah().getNamaJamaah();
            totalNama += hitungNama.get(nama);
        }
        
        Map<String, Integer> hitungWakaf = new HashMap<>();
        for(Pembayaran bayar: daftar.get()){
            String jWakaf = bayar.getWakaf().getJenisWakaf();
            Integer jml = hitungWakaf.get(jWakaf);
            if(jml == null) jml = 0;
            hitungWakaf.put(jWakaf, jml+1);
        }
        
        int totalWakaf = 0;
        for(Pembayaran byr : daftar.get()){
            String wakafj = byr.getWakaf().getJenisWakaf();
            totalWakaf += hitungWakaf.get(wakafj);
        }
        double rataRata = (double) totalNama/hitungWakaf.size();
        meanLabel.setText(Double.toString(rataRata));
    }
    
    public void modusResult(){
        PembayaranList daftar = new PembayaranList();
        daftar.loadXMLFile();
        Map<String, Integer> hitungWakaf = new HashMap<>();
        for(Pembayaran bayar: daftar.get()){
            String jWakaf = bayar.getWakaf().getJenisWakaf();
            Integer jml = hitungWakaf.get(jWakaf);
            if(jml == null) jml = 0;
            hitungWakaf.put(jWakaf, jml+1);
        }
        
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
