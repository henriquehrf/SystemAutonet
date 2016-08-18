package controller.cadastro.Consulta;

import controller.PrincipalController;
import controller.cadastro.Cadastro.CadastroDepartamentoController;
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
import negocio.NegocioDepartamento;
import vo.Departamento;

public class ConsultarDepartamentoController {

    @FXML
    private RadioButton rdbSigla;

    @FXML
    private Button btnVoltar;

    @FXML
    private TableView<Departamento> tblPrincipal;

    @FXML
    private Button btnAlterar;

    @FXML
    private TableColumn<Departamento, String> tbcNome;

    @FXML
    private Button btnInserir;

    @FXML
    private Label Title;

    @FXML
    private Button btnExcluir;

    @FXML
    private TableColumn<Departamento, String> tbcSigla;

    @FXML
    private RadioButton rdbNome;

    @FXML
    private TextField txtBuscador;

    @FXML
    private Button btnBuscar;

    private NegocioDepartamento negocioD;

    public void initialize() {
        negocioD = new NegocioDepartamento();
        List<Departamento> lista = negocioD.buscarTodos();

        completarTabela(lista);
        rdbNome.setSelected(true);

    }

    void completarTabela(List<Departamento> lista) {
        ObservableList<Departamento> dado = FXCollections.observableArrayList();
        for (int i = 0; i < lista.size(); i++) {
            dado.add(lista.get(i));
        }
        this.tbcNome.setCellValueFactory(new PropertyValueFactory<Departamento, String>("nome"));
        this.tbcSigla.setCellValueFactory(new PropertyValueFactory<Departamento, String>("sigla"));
        this.tblPrincipal.setItems(dado);
    }

    @FXML
    void btnInserir_OnAction(ActionEvent event) {
        try {
            negocioD = null;
            CadastroDepartamentoController.setCadastrar(true);
            Parent root;
            root = FXMLLoader.load(CadastroDepartamentoController.class.getClassLoader().getResource("fxml/cadastro/Cadastro/Cadastro_Departamento.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    void btnAlterar_OnAction(ActionEvent event) {
        Departamento p = tblPrincipal.getSelectionModel().getSelectedItem();
        CadastroDepartamentoController.setCadastrar(false);
        CadastroDepartamentoController.setAlterar(p);
        try {
            negocioD = null;
            Parent root;
            root = FXMLLoader.load(CadastroDepartamentoController.class.getClassLoader().getResource("fxml/cadastro/Cadastro/Cadastro_Departamento.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
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
        if (rdbNome.isSelected()) {
            Departamento p = new Departamento();
            p.setNome(txtBuscador.getText());
            List<Departamento> lista = negocioD.buscarPorNome(p);
            completarTabela(lista);
        }

        if (rdbSigla.isSelected()) {
            Departamento p = new Departamento();
            p.setSigla(txtBuscador.getText());
            List<Departamento> lista = negocioD.buscarPorSigla(p);
            completarTabela(lista);
        }
    }

    @FXML
    void btnVoltar_OnAction(ActionEvent event) {
        try {
             negocioD =  null;
            Parent root;
            root = FXMLLoader.load(PrincipalController.class.getClassLoader().getResource("fxml/Principal.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }
}
