package controller.cadastro.Consulta;

import controller.PrincipalController;
import controller.cadastro.Cadastro.CadastroSalaBlocoController;
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
import negocio.NegocioLocal;
import vo.Local;

public class ConsultarLocaisController {

    @FXML
    private RadioButton rdbNumero;

    @FXML
    private RadioButton rdbBloco;

    @FXML
    private TableView<Local> tblPrincipal;

    @FXML
    private Button btnInserir;

    @FXML
    private Label Title;

    @FXML
    private TableColumn<Local, Integer> tbcNumero;

    @FXML
    private TextField txtBuscador;

    @FXML
    private TableColumn<Local, String> tbcPessoaResponsavel;

    @FXML
    private TableColumn<Local, String> tbcBloco;

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
    private TableColumn<Local, String> tbcDescricao;

    @FXML
    private Button btnBuscar;

    private NegocioLocal negocioLocal;

    public void initialize() {
        negocioLocal = new NegocioLocal();
        List<Local> lista = negocioLocal.buscarTodos();

        completarTabela(lista);

    }

    @FXML
    void btnVoltar_OnAction(ActionEvent event) {
        try {
            Parent root;
            negocioLocal = null;
            root = FXMLLoader.load(PrincipalController.class.getClassLoader().getResource("fxml/Principal.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    void btnInserir_OnAction(ActionEvent event) {
        try {
            CadastroSalaBlocoController.setCadastrar(true);
            Parent root;
            negocioLocal = null;
            root = FXMLLoader.load(CadastroSalaBlocoController.class.getClassLoader().getResource("fxml/cadastro/Cadastro/Cadastro_SalaBloco.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    void btnAlterar_OnAction(ActionEvent event) {
        Local p = tblPrincipal.getSelectionModel().getSelectedItem();
        try {
            CadastroSalaBlocoController.setCadastrar(false);
            CadastroSalaBlocoController.setAlterar(p);
            Parent root;
            negocioLocal = null;
            root = FXMLLoader.load(CadastroSalaBlocoController.class.getClassLoader().getResource("fxml/cadastro/Cadastro/Cadastro_SalaBloco.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
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

    }

    private void completarTabela(List<Local> lista) {
        ObservableList<Local> dado = FXCollections.observableArrayList();
        for (int i = 0; i < lista.size(); i++) {
            dado.add(lista.get(i));
        }
        this.tbcDescricao.setCellValueFactory(new PropertyValueFactory<Local, String>("descricao"));
        this.tbcNumero.setCellValueFactory(new PropertyValueFactory<Local, Integer>("numero"));
        this.tbcPessoaResponsavel.setCellValueFactory(new PropertyValueFactory<Local, String>("responsavel"));
        this.tblPrincipal.setItems(dado);

    }
}
