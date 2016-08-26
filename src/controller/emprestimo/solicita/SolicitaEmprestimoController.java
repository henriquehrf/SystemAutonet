/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.emprestimo.solicita;

import controller.PrincipalController;
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
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import vo.Material;

/**
 * FXML Controller class
 *
 * @author Henrique
 */
public class SolicitaEmprestimoController {

    @FXML
    private Button btnAdicionar;

    @FXML
    private TabPane tabPanePrincipal;

    @FXML
    private TableView<Material> tblBuscaMateriais;

    @FXML
    private Button btnExclur;

    @FXML
    private TableView<Material> tblListaMateriais;

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
    private Button btnVoltar;

    @FXML
    private Button btnCancelar;

    @FXML
    private TextArea txtObservacao;

    @FXML
    private Label finalidadeObrigatorio;

    @FXML
    private DatePicker dtpDataEmprestimo;

    @FXML
    private Label dataObrigatorio;

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
            root = FXMLLoader.load(PrincipalController.class.getClassLoader().getResource("fxml/Principal.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @FXML
    void btnVoltarOnAction(ActionEvent event) {

        tabBuscarMaterial.setDisable(false);
        tabListaMaterial.setDisable(true);
        tabPanePrincipal.getSelectionModel().select(tabBuscarMaterial);

    }

    @FXML
    void btnAdicionarOnAction(ActionEvent event) {
        tabListaMaterial.setDisable(false);
        tabPanePrincipal.getSelectionModel().select(tabListaMaterial);
        tabBuscarMaterial.setDisable(true);

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

        tabListaMaterial.setDisable(true);
        dataObrigatorio.setVisible(false);
        finalidadeObrigatorio.setVisible(false);

    }

}
