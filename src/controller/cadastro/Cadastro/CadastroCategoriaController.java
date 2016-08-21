/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cadastro.Cadastro;

import controller.PrincipalController;
import controller.cadastro.Consulta.ConsultarUnidadeMedidaController;
import gui.SystemAutonet;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Henrique
 */
public class CadastroCategoriaController implements Initializable {

  
    @FXML
    private TextField txtCategoria;

    @FXML
    private Label lblCategoriaObrigatorio;

    @FXML
    private Button btnCancelar;

    @FXML
    private Label Title;

    @FXML
    private Button btnsalvar;

    @FXML
    void btnsalvar_OnAction(ActionEvent event) {

    }

    @FXML
    void btnCancelar_OnAction(ActionEvent event) {
         try {
            Parent root;
            root = FXMLLoader.load(PrincipalController.class.getClassLoader().getResource("fxml/Principal.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblCategoriaObrigatorio.setVisible(false);
        // TODO
    }    
    
}
