package controller.cadastro.Consulta;

import controller.PrincipalController;
import controller.cadastro.Cadastro.CadastroUnidadeMedidaController;
import gui.SystemAutonet;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.NegocioTipoUnidade;
import vo.TipoUnidade;

public class ConsultarUnidadeMedidaController {

    @FXML
    private Button btnVoltar;

    @FXML
    private TableView<TipoUnidade> tblPrincipal;

    @FXML
    private RadioButton rdbsigla;

    @FXML
    private RadioButton rdbdescricao;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnInserir;

    @FXML
    private Label Title;

    @FXML
    private Button btnExcluir;

    @FXML
    private TableColumn<TipoUnidade, String> tbcSigla;

    @FXML
    private TextField txtBuscador;

    @FXML
    private TableColumn<TipoUnidade, String> tbcDescricao;

    private NegocioTipoUnidade negocioTU;
    @FXML
    private Button btnBuscar;

    public void initialize() {
        negocioTU = new NegocioTipoUnidade();
        List<TipoUnidade> lista = negocioTU.buscarTodos();
        completarTabela(lista);
    }

    @FXML
    void btnVoltar_OnAction(ActionEvent event) {
        try {
            negocioTU = null;
            Parent root;
            root = FXMLLoader.load(PrincipalController.class.getClassLoader().getResource("fxml/Principal.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    void btnInserir_OnAction(ActionEvent event) {
        try {
            CadastroUnidadeMedidaController.setCadastrar(true);
            Parent root;
            negocioTU = null;
            root = FXMLLoader.load(CadastroUnidadeMedidaController.class.getClassLoader().getResource("fxml/cadastro/Cadastro/Cadastro_UnidadeMedida.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    void btnAlterar_OnAction(ActionEvent event) {
        TipoUnidade p = tblPrincipal.getSelectionModel().getSelectedItem();
        try {
            CadastroUnidadeMedidaController.setCadastrar(false);
            CadastroUnidadeMedidaController.setAlterar(p);
            Parent root;
            negocioTU = null;
            root = FXMLLoader.load(CadastroUnidadeMedidaController.class.getClassLoader().getResource("fxml/cadastro/Cadastro/Cadastro_UnidadeMedida.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    void btnExcluir_OnAction(ActionEvent event) {

    }

    @FXML
    void btnBuscar_OnAction(ActionEvent event) {

        if (rdbdescricao.isSelected()) {
            TipoUnidade tu = new TipoUnidade();
            tu.setDescricao(txtBuscador.getText());
            completarTabela(negocioTU.buscarPorDescricao(tu));
        }
        if (rdbsigla.isSelected()) {
            TipoUnidade tu = new TipoUnidade();
            tu.setSigla(txtBuscador.getText());
            completarTabela(negocioTU.buscarPorSigla(tu));
        }
    }

    private void completarTabela(List<TipoUnidade> lista) {
        ObservableList<TipoUnidade> dado = FXCollections.observableArrayList();
        for (int i = 0; i < lista.size(); i++) {
            dado.add(lista.get(i));
        }
        this.tbcDescricao.setCellValueFactory(new PropertyValueFactory<TipoUnidade, String>("descricao"));
        this.tbcSigla.setCellValueFactory(new PropertyValueFactory<TipoUnidade, String>("sigla"));
        this.tblPrincipal.setItems(dado);

    }

}
