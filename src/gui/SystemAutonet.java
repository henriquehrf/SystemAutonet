/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.PrincipalController;
import controller.cadastro.Consulta.ConsultarDepartamentoController;
import java.util.ResourceBundle;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 *
 * @author Henrique
 */
public class SystemAutonet extends Application {

    public static Scene SCENE;

    @Override
    public void start(Stage stage) throws Exception {

        Parent pane = null;

        try {

            pane = FXMLLoader.load(PrincipalController.class.getClassLoader().getResource("fxml/Principal.fxml"),ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        Scene scene = new Scene(pane, 800, 600);
        stage.setResizable(false);
        SCENE = scene;
         stage.setTitle("SystemAutonet - Sistema de Controle Simplificado");
         stage.getIcons().add(new Image("/utilitarios/icones/icone.png"));

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        launch(args);
    }
}
