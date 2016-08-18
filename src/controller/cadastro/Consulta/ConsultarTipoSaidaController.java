package controller.cadastro.Consulta;

import controller.PrincipalController;
import controller.cadastro.Cadastro.CadastroTipoSaidaController;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.NegocioTipoSaida;
import vo.TipoSaida;

public class ConsultarTipoSaidaController {

    @FXML
    private Button btnVoltar;

    @FXML
    private TableView<TipoSaida> tblPrincipal;

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
    private TableColumn<TipoSaida, String> tbcDescricao;

    @FXML
    private Button btnBuscar;

    private NegocioTipoSaida negocioTS;

    public void initialize() {
        negocioTS = new NegocioTipoSaida();
        List<TipoSaida> lista = negocioTS.buscarTodos();

        completarTabela(lista);

    }

    @FXML
    void btnVoltar_OnAction(ActionEvent event) {
        try {
            Parent root;
            negocioTS = null;
            root = FXMLLoader.load(PrincipalController.class.getClassLoader().getResource("fxml/Principal.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    void btnInserir_OnAction(ActionEvent event) {
        try {
            CadastroTipoSaidaController.setCadastrar(true);
            Parent root;
            negocioTS = null;
            root = FXMLLoader.load(CadastroTipoSaidaController.class.getClassLoader().getResource("fxml/cadastro/Cadastro/Cadastro_Tipo_Saida.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    void btnAlterar_OnAction(ActionEvent event) {
        TipoSaida p = tblPrincipal.getSelectionModel().getSelectedItem();
        try {
            CadastroTipoSaidaController.setCadastrar(false);
            CadastroTipoSaidaController.setAlterar(p);            
            Parent root;
            negocioTS = null;
            root = FXMLLoader.load(CadastroTipoSaidaController.class.getClassLoader().getResource("fxml/cadastro/Cadastro/Cadastro_Tipo_Saida.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
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
        
        TipoSaida tps = new TipoSaida();
        tps.setDescricao(txtBuscador.getText());
        completarTabela(negocioTS.buscarPorDescricao(tps));

    }

    private void completarTabela(List<TipoSaida> lista) {
        ObservableList<TipoSaida> dado = FXCollections.observableArrayList();
        for (int i = 0; i < lista.size(); i++) {
            dado.add(lista.get(i));
        }
        this.tbcDescricao.setCellValueFactory(new PropertyValueFactory<TipoSaida, String>("descricao"));

        this.tblPrincipal.setItems(dado);

    }

}
