package controller.cadastro.Consulta;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class ConsultarLocaisController {

    @FXML
    private RadioButton rdbNumero;

    @FXML
    private RadioButton rdbBloco;

    @FXML
    private Button btnInserir;

    @FXML
    private Label Title;

    @FXML
    private TableColumn<?, ?> tbcNumero;

    @FXML
    private TextField txtBuscador;

    @FXML
    private TableColumn<?, ?> tbcPessoaResponsavel;

    @FXML
    private TableColumn<?, ?> tbcBloco;

    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnAlterar;

    @FXML
    private RadioButton rdbPessoaResponsavel;

    @FXML
    private Button btnExcluir;

    @FXML
    private RadioButton rdbDepartamento;

    @FXML
    private TableColumn<?, ?> tbcDescricao;

    @FXML
    private Button btnBuscar;

}
