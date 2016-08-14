package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ConsultarPessoaController {

    @FXML
    private TableColumn<?, ?> tbcCPF;

    @FXML
    private TableView<?> tblPrincipal;

    @FXML
    private TableColumn<?, ?> tbcNome;

    @FXML
    private Button btnInserir;

    @FXML
    private Label Title;

    @FXML
    private TextField txtBuscador;

    @FXML
    private TableColumn<?, ?> tbcNumMatricula;

    @FXML
    private RadioButton rdbRG;

    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnAlterar;

    @FXML
    private TableColumn<?, ?> tbcRG;

    @FXML
    private RadioButton rgbNumMatricula;

    @FXML
    private Button btnExcluir;

    @FXML
    private RadioButton rdbNome;

    @FXML
    private Button btnBuscar;

    @FXML
    private RadioButton rdbCPF;

}
