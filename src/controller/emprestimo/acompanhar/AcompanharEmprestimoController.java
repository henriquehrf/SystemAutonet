/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.emprestimo.acompanhar;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Henrique
 */
public class AcompanharEmprestimoController implements Initializable {

     @FXML
    private Button btnImprimir;

    @FXML
    private Button btnVoltarDescricao;

    @FXML
    private DatePicker dtpFinal;

    @FXML
    private ComboBox<?> cbmStatus;

    @FXML
    private TableColumn<?, ?> tbcQuantidade;

    @FXML
    private TableView<?> tblPrincipal;

    @FXML
    private TableColumn<?, ?> tbcCategoria;

    @FXML
    private Button btnConsultar;

    @FXML
    private TabPane tabPrincipal;

    @FXML
    private TextField txtBuscador;

    @FXML
    private Label lblData;

    @FXML
    private Label lblFinalidade;

    @FXML
    private Tab tabListaEmprestimo;

    @FXML
    private TableView<?> tblDescricao;

    @FXML
    private Button btnVoltar;

    @FXML
    private TableColumn<?, ?> tbcStatus;

    @FXML
    private TableColumn<?, ?> tbcDtEmprestimo;

    @FXML
    private TableColumn<?, ?> tbcPessoa;

    @FXML
    private Tab tabDescricaoEmprestimo;

    @FXML
    private DatePicker dtpInicial;

    @FXML
    private Button btnBuscar;

    @FXML
    private Label lblObservacao;

    @FXML
    private TableColumn<?, ?> tbcMaterial;

    @FXML
    void btnConsultarOnAction(ActionEvent event) {

    }

    @FXML
    void btnVoltarOnAction(ActionEvent event) {

    }

    @FXML
    void btnBuscarOnAction(ActionEvent event) {

    }

    @FXML
    void dtpInicialOnAction(ActionEvent event) {

    }

    @FXML
    void dtpFinalOnAction(ActionEvent event) {

    }

    @FXML
    void cbmStatusOnAction(ActionEvent event) {

    }

    @FXML
    void btnImprimirOnAction(ActionEvent event) {

    }

    @FXML
    void btnVoltarDescricaoOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        
            // TODO
        }

    }
