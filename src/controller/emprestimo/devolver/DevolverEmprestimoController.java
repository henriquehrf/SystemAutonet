/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.emprestimo.devolver;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Henrique
 */
public class DevolverEmprestimoController implements Initializable {

     @FXML
    private Button btnBaixarItensEmprestimo;

    @FXML
    private Button btnAdicionarLocal;

    @FXML
    private Button btnBuscarLocalizarEstoque;

    @FXML
    private Button btnCancelarInformarEstoque;

    @FXML
    private Tab tabBuscarMaterial;

    @FXML
    private TableColumn<?, ?> tbcFinalidadeBuscarPorEmprestimo;

    @FXML
    private Button btnBuscarEmprestimo;

    @FXML
    private TextArea txtObservacao;

    @FXML
    private TableColumn<?, ?> tbcMaterialInformarEstoque;

    @FXML
    private DatePicker dtpDtFinal;

    @FXML
    private TableColumn<?, ?> tbcPessoaBuscarEmprestimo;

    @FXML
    private TableColumn<?, ?> tbcResponsavelLocalizarEstoque;

    @FXML
    private Button btnDevolverItensEmprestimo;

    @FXML
    private Button btnVoltarItensEmprestimo;

    @FXML
    private TableColumn<?, ?> tbcDtEmprestimoBuscarEmprestimo;

    @FXML
    private TextField txtBuscadorEmprestimo;

    @FXML
    private TextField txtBuscadorLocalizarEstoque;

    @FXML
    private Button btnConsultarBuscarEmprestimo;

    @FXML
    private TableColumn<?, ?> tbcNumeroLocalizarEstoque;

    @FXML
    private Button btnEditarLocal;

    @FXML
    private ToggleGroup Filtro;

    @FXML
    private TableColumn<?, ?> tbcCategoriaItensEmprestimo;

    @FXML
    private TableColumn<?, ?> tbcDescricaoLocalInformarEstoque;

    @FXML
    private TableColumn<?, ?> tbcMaterialItensEmprestimo;

    @FXML
    private TableColumn<?, ?> tbcQtdItensEmprestimo;

    @FXML
    private Button btnSalvarInformarEstoque;

    @FXML
    private TableView<?> tblPrincipalBuscarMaterial;

    @FXML
    private Button btnSelecionarLocalizarEstoque;

    @FXML
    private RadioButton rdbDescricao;

    @FXML
    private Button btnVoltarObservacao;

    @FXML
    private Label lblDescricao;

    @FXML
    private TableColumn<?, ?> tbcDescricaoLocalizarEstoque;

    @FXML
    private RadioButton rdbNumero;

    @FXML
    private Tab tabItensEmprestimo;

    @FXML
    private Tab tabObservacao;

    @FXML
    private TableView<?> tblPrincipalItensEmprestimo;

    @FXML
    private Button btnVoltarBuscarEmprestimo;

    @FXML
    private DatePicker dtpDtInicial;

    @FXML
    private Tab tabBuscarEmprestimo;

    @FXML
    private TableView<?> tblPrincipalBuscarEmprestimo;

    @FXML
    private Button btnVoltarLocalizarEstoque;

    @FXML
    private Button btnRemoverLocal;

    @FXML
    private Button btnImprimirInformarEstoque;

    @FXML
    private TableColumn<?, ?> tbcDepartamentoLocalizarEstoque;

    @FXML
    private Tab tabInformarEstoque;

    @FXML
    private Button btnSalvarObservacao;

    @FXML
    private TabPane PanePrincipal;

    @FXML
    private RadioButton rdbPessoaResponsavel;

    @FXML
    private TableColumn<?, ?> tbcQtdInformarEstoque;

    @FXML
    private TableView<?> tblPrincipalInformarEstoque;

    @FXML
    void txtBuscadorEmprestimoOnAction(ActionEvent event) {

    }

    @FXML
    void btnBuscarEmprestimoOnAction(ActionEvent event) {

    }

    @FXML
    void dtpDtInicialOnAction(ActionEvent event) {

    }

    @FXML
    void dtpDtFinalOnAction(ActionEvent event) {

    }

    @FXML
    void btnDevolverItensEmprestimoOnAction(ActionEvent event) {

    }

    @FXML
    void btnBaixarItensEmprestimoOnAction(ActionEvent event) {

    }

    @FXML
    void btnVoltarItensEmprestimoOnAction(ActionEvent event) {

    }

    @FXML
    void btnSalvarInformarEstoqueOnAction(ActionEvent event) {

    }

    @FXML
    void btnImprimirInformarEstoqueOnAction(ActionEvent event) {

    }

    @FXML
    void btnCancelarInformarEstoqueOnAction(ActionEvent event) {

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
    void btnSelecionarLocalizarEstoqueOnAction(ActionEvent event) {

    }

    @FXML
    void btnVoltarLocalizarEstoqueOnAction(ActionEvent event) {

    }

    @FXML
    void btnBuscarLocalizarEstoqueOnAction(ActionEvent event) {

    }

    @FXML
    void btnSalvarObservacaoOnAction(ActionEvent event) {

    }

    @FXML
    void btnVoltarObservacaoOnAction(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
