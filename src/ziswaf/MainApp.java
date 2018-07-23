/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziswaf;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import ziswaf.view.JamaahLayoutController;
import ziswaf.model.Jamaah;
import ziswaf.model.JamaahList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
/*import ziswaf.view.JamaahDialogController;

/**
 *
 * @author intel
 */
public class MainApp extends Application {
    private Stage primaryStage;
    private Jamaah jamaah;
    
    @Override
    public void start(Stage primaryStage){
        try{
        Parent root = FXMLLoader.load(getClass().getResource("view/Beranda.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        } catch(IOException e){
            e.printStackTrace();
        }
    }
        

    public static void main(String[] args) {
        launch(args);
    }
    
    public Stage getPrimaryStage(){
        return primaryStage;
    }    
}
