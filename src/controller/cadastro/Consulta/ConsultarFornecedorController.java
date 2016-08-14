package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ConsultarFornecedorController {

    @FXML
    private TableView<?> tblPrincipal;

    @FXML
    private Button btnInserir;

    @FXML
    private Label title;

    @FXML
    private TextField txtBuscador;

    @FXML
    private TableColumn<?, ?> tbcRazaoSocial;

    @FXML
    private RadioButton rdbRazaoSocial;

    @FXML
    private TableColumn<?, ?> tbcPessoaResponsavel;

    @FXML
    private Button btnVoltar;

    @FXML
    private RadioButton rdbNomeFantasia;

    @FXML
    private Button btnAlterar;

    @FXML
    private TableColumn<?, ?> tbcNomeFantasia;

    @FXML
    private TableColumn<?, ?> tbcCNPJ;

    @FXML
    private RadioButton rdbCNPJ;

    @FXML
    private RadioButton rdbPessoaResponsavel;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnBuscar;

}
