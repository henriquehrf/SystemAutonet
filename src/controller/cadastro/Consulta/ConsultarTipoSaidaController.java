package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ConsultarTipoSaidaController {

    @FXML
    private Button btnVoltar;

    @FXML
    private TableView<?> tblPrincipal;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnInserir;

    @FXML
    private Label Title;

    @FXML
    private Button btnExcluir;

    @FXML
    private TextField txtBuscador;

    @FXML
    private TableColumn<?, ?> tbcDescricao;

    @FXML
    private Button btnBuscar;

}
