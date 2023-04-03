/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package simwriting;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author alec
 */
public class SimWriting extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Views/MainWindowView.fxml"));
        
        Scene scene = new Scene(root);
        String css = this.getClass().getResource("/simwriting/Styles/Application.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/simwriting/Icons/icon1.png")));
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.setTitle("SIM CARD PROVISIONING APPLICATION");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

