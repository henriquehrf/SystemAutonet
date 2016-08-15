package controller.cadastro.Consulta;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ConsultarDepartamentoController {

    @FXML
    private RadioButton rdbSigla;

    @FXML
    private Button btnVoltar;

    @FXML
    private TableView<?> tblPrincipal;

    @FXML
    private Button btnAlterar;

    @FXML
    private TableColumn<?, ?> tbcNome;

    @FXML
    private Button btnInserir;

    @FXML
    private Label Title;

    @FXML
    private Button btnExcluir;

    @FXML
    private TableColumn<?, ?> tbcSigla;

    @FXML
    private RadioButton rdbNome;

    @FXML
    private TextField txtBuscador;

    @FXML
    private Button btnBuscar;

}
