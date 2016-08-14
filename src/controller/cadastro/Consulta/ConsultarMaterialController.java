package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ConsultarMaterialController {

    @FXML
    private RadioButton rdbQuantidade;

    @FXML
    private TableColumn<?, ?> tbcQuantidade;

    @FXML
    private TableView<?> tblPrincipal;

    @FXML
    private TableColumn<?, ?> tbcCategoria;

    @FXML
    private Button btnInserir;

    @FXML
    private Label Title;

    @FXML
    private ComboBox<?> cmbCategoria;

    @FXML
    private TextField txtBuscador;

    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnBusca;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnExcluir;

    @FXML
    private TableColumn<?, ?> tbcDescricao;

    @FXML
    private RadioButton rdbDescricao;

    @FXML
    private TableColumn<?, ?> tbcUnidadeMedida;

}
