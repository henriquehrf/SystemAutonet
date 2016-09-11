/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.emprestimo.analisar;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import vo.Pessoa;

/**
 * FXML Controller class
 *
 * @author Henrique
 */
public class AnalisarEmprestimoController implements Initializable {

   @FXML
    private Button btnRecusar;

    @FXML
    private Button btnAdicionarLocal;

    @FXML
    private Button btnEditarLocal;

    @FXML
    private Button btnSelecionar;

    @FXML
    private TableView<?> tblAguardandoAnalise;

    @FXML
    private TableColumn<?, ?> tbcDisponibilidadeAnalise;

    @FXML
    private TableColumn<?, ?> tbcQuantidadeSolicitadaSeparado;

    @FXML
    private TextField txtQtdSolicitada;

    @FXML
    private TextField txtMaterial;

    @FXML
    private TableColumn<?, ?> tbcQtdSolicitadaBusca;

    @FXML
    private Button btnAprovar;

    @FXML
    private Button btnVoltarAnalise;

    @FXML
    private Button btnAnalisar;

    @FXML
    private Button btnSalvar;

    @FXML
    private TableColumn<?, ?> tbcDescricaoSeparado;

    @FXML
    private Tab tabBuscarMaterial;

    @FXML
    private TableColumn<?, ?> tbcMaterialSeparado;

    @FXML
    private TableView<?> tblPrincipalBuscarMaterial;

    @FXML
    private TableColumn<?, ?> tbcQuantidadeDisponivelSeparado;

    @FXML
    private TableColumn<?, ?> tbcDtEmprestimo;

    @FXML
    private TableColumn<?, ?> tbcMaterialAnalise;

    @FXML
    private Label lblDtEmprestimo;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnVoltarBuscar;

    @FXML
    private Label lblObservacao;

    @FXML
    private Tab tabItensSeparado;

    @FXML
    private TabPane TabPanePrincipal;

    @FXML
    private Button btnVoltarLista;

    @FXML
    private TableColumn<?, ?> tbcCategoriaAnalise;

    @FXML
    private Label lblFinalidade;

    @FXML
    private Button btnRemoverLocal;

    @FXML
    private TableColumn<?, ?> tbcFinalidade;

    @FXML
    private Tab tabListaEmprestimo;

    @FXML
    private TableColumn<?, ?> tbcDescricaoBusca;

    @FXML
    private TableColumn<?, ?> tbcQuantidadeAnalise;

    @FXML
    private TableColumn<?, ?> tbcQuantidadeBusca;

    @FXML
    private TableColumn<?, ?> tbcPessoa;

    @FXML
    private Tab tabAnaliseEmprestimo;

    @FXML
    void btnAnalisarOnAction(ActionEvent event) {

    }

    @FXML
    void btnVoltarListaOnAction(ActionEvent event) {

    }

    @FXML
    void btnAprovarOnAction(ActionEvent event) {

    }

    @FXML
    void btnRecusarOnAction(ActionEvent event) {

    }

    @FXML
    void btnVoltarAnaliseOnAction(ActionEvent event) {

    }

    @FXML
    void btnSalvarOnAction(ActionEvent event) {

    }

    @FXML
    void btnCancelarOnAction(ActionEvent event) {

    }

    @FXML
    void btnAdicionarLocalOnAction(ActionEvent event) {

    }

    @FXML
    void btnEditarLocalOnAction(ActionEvent event) {

    }

    @FXML
    void btnRemoverLocalOnAction(ActionEvent event) {

    }

    @FXML
    void btnSelecionarOnAction(ActionEvent event) {

    }

    @FXML
    void btnVoltarBuscarOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }


}
