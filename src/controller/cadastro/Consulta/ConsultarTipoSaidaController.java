package controller.cadastro.Consulta;

import classesAuxiliares.NegociosEstaticos;
import controller.PrincipalController;
import controller.cadastro.Cadastro.CadastroTipoSaidaController;
import gui.SystemAutonet;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.NegocioTipoSaida;
import utilitarios.Alertas;
import utilitarios.LerMessage;
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

   // private NegocioTipoSaida negocioTS;

    public void initialize() {
       // negocioTS = new NegocioTipoSaida();
        List<TipoSaida> lista = NegociosEstaticos.getNegocioTipoSaida().buscarTodos();

        completarTabela(lista);

    }

    @FXML
    void btnVoltar_OnAction(ActionEvent event) {
        try {
            Parent root;
           // negocioTS = null;
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
           // negocioTS = null;
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
           // negocioTS = null;
            root = FXMLLoader.load(CadastroTipoSaidaController.class.getClassLoader().getResource("fxml/cadastro/Cadastro/Cadastro_Tipo_Saida.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    void btnExcluir_OnAction(ActionEvent event) {
         try {
            Alertas alert = new Alertas();
            LerMessage ler = new LerMessage();
            if (alert.alerta(Alert.AlertType.CONFIRMATION, "Remoção", ler.getMessage("msg.temcerteza"), "Sim", "Não")) {
                NegociosEstaticos.getNegocioTipoSaida().remover(tblPrincipal.getSelectionModel().getSelectedItem());
                completarTabela(NegociosEstaticos.getNegocioTipoSaida().buscarTodos());
            }
        } catch (Exception ex) {
            Alertas alert = new Alertas();
            alert.alerta(Alert.AlertType.ERROR, "Erro na remoção", ex.getMessage());
        }
    }

    @FXML
    void btnBuscar_OnAction(ActionEvent event) {
        
        TipoSaida tps = new TipoSaida();
        tps.setDescricao(txtBuscador.getText());
        completarTabela(NegociosEstaticos.getNegocioTipoSaida().buscarPorDescricao(tps));

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
