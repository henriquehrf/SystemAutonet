/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import controller.cadastro.Consulta.PrincipalController;

/**
 *
 * @author Henrique
 */
public class SystemAutonet extends Application {
    
    
    public static Scene SCENE;
    
    @Override
     public void start(Stage stage) throws Exception{
         
        BorderPane pane =null;
        
        pane = FXMLLoader.load(PrincipalController.class.getClassLoader().getResource("fxml/Principal.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
        
        Scene scene = new Scene(pane,800,600);
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
