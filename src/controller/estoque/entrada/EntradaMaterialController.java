/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.estoque.entrada;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Henrique
 */
public class EntradaMaterialController implements Initializable {

     @FXML
    private Button btnDarEntrada;

    @FXML
    private Button btnAdicionarLocal;

    @FXML
    private Button btnVoltarBuscarFornecedor;

    @FXML
    private TextField txtMaterial;

    @FXML
    private Button btnAdicionarFornecedor;

    @FXML
    private TableView<?> tblEntradaMaterial;

    @FXML
    private Tab tabMaterial;

    @FXML
    private TextField txtValorNF;

    @FXML
    private TextField txtNumero;

    @FXML
    private TextField txtBuscador;

    @FXML
    private TextField txtCNPJ;

    @FXML
    private TableColumn<?, ?> tbcPessoaResponsavel;

    @FXML
    private TextField txtLocal;

    @FXML
    private Button btnAdicionarMaterial;

    @FXML
    private TextField txtDepartamento;

    @FXML
    private TableColumn<?, ?> tbcMaterial;

    @FXML
    private TableColumn<?, ?> tbcValorUnitario;

    @FXML
    private TableColumn<?, ?> tbcQtd;

    @FXML
    private TextField txtValorMaterialTotalGeral;

    @FXML
    private Button btnEditarMaterial;

    @FXML
    private TextField txtQtdMaterial;

    @FXML
    private Tab tabLocal;

    @FXML
    private TableColumn<?, ?> tbcNumeroBuscarLocal;

    @FXML
    private TableColumn<?, ?> tbcPessoaResponsavelBuscarLocal;

    @FXML
    private TableColumn<?, ?> tbcNomeFantasia;

    @FXML
    private Button btnEditarFornecedor;

    @FXML
    private DatePicker dtEntrada;

    @FXML
    private TextField btnValorTotalMaterialUnitario;

    @FXML
    private RadioButton rdbCNPJ;

    @FXML
    private TextField txtValorMaterial;

    @FXML
    private TableColumn<?, ?> tbcQuantidadeBuscaMaterial;

    @FXML
    private Button btnAdicionarBuscarFornecedor;

    @FXML
    private Button btnVoltarBuscaMaterial;

    @FXML
    private Button btnBuscar;

    @FXML
    private TextField txtFornecedor;

    @FXML
    private Tab tabEntrada;

    @FXML
    private ToggleGroup FiltroLocal;

    @FXML
    private TableView<?> tblBuscarLocal;

    @FXML
    private TextField txtQuantidadeMaterial;

    @FXML
    private Button btnEditarLocal;

    @FXML
    private ToggleGroup Filtro;

    @FXML
    private TextField txtNumNF;

    @FXML
    private TableView<?> tblBuscarFornecedor;

    @FXML
    private TableColumn<?, ?> tbcLocal;

    @FXML
    private Button btnVoltarBuscarLocal;

    @FXML
    private TextField txtQtdEntrada;

    @FXML
    private TableView<?> tblBuscaMaterial;

    @FXML
    private RadioButton rdbDescricao;

    @FXML
    private TextField txtCategoria;

    @FXML
    private RadioButton rdbNumero;

    @FXML
    private TableColumn<?, ?> tbcDescricaoBuscarLocal;

    @FXML
    private Button btnAdicionarBuscaMaterial;

    @FXML
    private TableColumn<?, ?> tbcMaterialBuscaMaterial;

    @FXML
    private Button btnAdicionarTabela;

    @FXML
    private Button btnRemoverTabela;

    @FXML
    private TableColumn<?, ?> tbcRazaoSocial;

    @FXML
    private RadioButton rdbRazaoSocial;

    @FXML
    private TableColumn<?, ?> tbcValorTotal;

    @FXML
    private Tab tabFornecedor;

    @FXML
    private RadioButton rdbNomeFantasia;

    @FXML
    private Button btnAdicionarBuscarLocal;

    @FXML
    private RadioButton rdbPessoaRespBuscaLocal;

    @FXML
    private TableColumn<?, ?> tbcCNPJ;

    @FXML
    private RadioButton rdbPessoaResponsavel;

    @FXML
    private TableColumn<?, ?> tbcValorMaterial;

    @FXML
    private TableColumn<?, ?> tbcCategoriaBuscaMaterial;

    @FXML
    void btnAdicionarTabelaOnAction(ActionEvent event) {

    }

    @FXML
    void btnRemoverTabelaOnAction(ActionEvent event) {

    }

    @FXML
    void btnDarEntradaOnAction(ActionEvent event) {

    }

    @FXML
    void btnAdicionarMaterialOnAction(ActionEvent event) {

    }

    @FXML
    void btnEditarMaterialOnAction(ActionEvent event) {

    }

    @FXML
    void btnAdicionarFornecedorOnAction(ActionEvent event) {

    }

    @FXML
    void btnEditarFornecedorOnAction(ActionEvent event) {

    }

    @FXML
    void btnAdicionarLocalOnAction(ActionEvent event) {

    }

    @FXML
    void btnEditarLocalOnAction(ActionEvent event) {

    }

    @FXML
    void btnAdicionarBuscaMaterialOnAction(ActionEvent event) {

    }

    @FXML
    void btnVoltarBuscaMaterialOnAction(ActionEvent event) {

    }

    @FXML
    void btnAdicionarBuscarFornecedorOnAction(ActionEvent event) {

    }

    @FXML
    void btnVoltarBuscarFornecedorOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
