/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.emprestimo.solicita;

import controller.cadastro.Consulta.ConsultarFornecedorController;
import gui.SystemAutonet;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Henrique
 */
public class SolicitaEmprestimoController {

    @FXML
    private Button btnAdicionar;

    @FXML
    private TableView<?> tblPrincipalListaEmprestimo;

    @FXML
    private TableColumn<?, ?> tbcQuantidade;

    @FXML
    private Label dtEmprestimoObrigatorio;

    @FXML
    private Button btnExclur;

    @FXML
    private TableColumn<?, ?> tbcCategoria;

    @FXML
    private TextField txtFinalidade;

    @FXML
    private TextField txtBuscador;

    @FXML
    private Button btnEditar;

    @FXML
    private Tab tabListaMaterial;

    @FXML
    private Tab tabBuscarMaterial;

    @FXML
    private TableView<?> tblPrincipalBuscarMaterial;

    @FXML
    private TableColumn<?, ?> tbcDescricaoBusca;

    @FXML
    private TableColumn<?, ?> tbcQuantidadeBusca;

    @FXML
    private Button btnCancelar;

    @FXML
    private TextArea txtObservacao;

    @FXML
    private Label finalidadeObrigatorio;

    @FXML
    private DatePicker dtEmprestimo;

    @FXML
    private TableColumn<?, ?> tbcDescricao;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnSolicitar;

    @FXML
    void btnSolicitarOnAction(ActionEvent event) {

    }

    @FXML
    void btnCancelarOnAction(ActionEvent event) {
          try {
            Parent root;
            root = FXMLLoader.load(ConsultarFornecedorController.class.getClassLoader().getResource("fxml/Principal.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @FXML
    void btnAdicionarOnAction(ActionEvent event) {
        tabBuscarMaterial.setDisable(false);
        

    }

 
    @FXML
    void btnEditarOnAction(ActionEvent event) {

    }

    @FXML
    void btnExclurOnAction(ActionEvent event) {

    }

    @FXML
    void btnBuscarOnAction(ActionEvent event) {

    }

    public void initialize() {
        finalidadeObrigatorio.setVisible(false);
        dtEmprestimoObrigatorio.setVisible(false);
        tabBuscarMaterial.setDisable(true);
        // TODO
    }

}
