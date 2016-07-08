/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Henrique
 */
public class SystemAutonet extends Application {
    
    
    public static Scene SCENE;
    
    @Override
     public void start(Stage stage) throws Exception{
         
         Parent root = FXMLLoader.load(getClass().getResource("/fxml/Principal.fxml"));
        
        

        
        Scene scene = new Scene(root,800,600);
        stage.setResizable(false);
        SCENE = scene;
        stage.setTitle("SystemAutonet - Sistema de Controle Simplificado");
        
        stage.setScene(scene);
        stage.show();
         
     }
     
       public static void main(String[] args) {
        
        launch(args);
    }
}
