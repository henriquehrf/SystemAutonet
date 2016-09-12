package controller.cadastro.Consulta;

import classesAuxiliares.NegociosEstaticos;
import classesAuxiliares.Validar;
import controller.PrincipalController;
import controller.cadastro.Cadastro.CadastroFornecedorController;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.NegocioFornecedor;
import utilitarios.Alertas;
import utilitarios.LerProperties;
import vo.Fornecedor;

public class ConsultarFornecedorController {

    @FXML
    private TableView<Fornecedor> tblPrincipal;

    @FXML
    private Button btnInserir;

    @FXML
    private Label title;

    @FXML
    private TextField txtBuscador;

    @FXML
    private TableColumn<Fornecedor, String> tbcRazaoSocial;

    @FXML
    private RadioButton rdbRazaoSocial;

    @FXML
    private TableColumn<Fornecedor, String> tbcPessoaResponsavel;

    @FXML
    private Button btnVoltar;

    @FXML
    private RadioButton rdbNomeFantasia;

    @FXML
    private Button btnAlterar;

    @FXML
    private TableColumn<Fornecedor, String> tbcNomeFantasia;

    @FXML
    private TableColumn<Fornecedor, String> tbcCNPJ;

    @FXML
    private RadioButton rdbCNPJ;

    @FXML
    private RadioButton rdbPessoaResponsavel;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnBuscar;

    //  private NegocioFornecedor negocioF;
    public void initialize() {
        // negocioF = new NegocioFornecedor();
        List<Fornecedor> lista = NegociosEstaticos.getNegocioFornecedor().buscarTodos();
        completarTabela(lista);
        rdbNomeFantasia.setSelected(true);

    }

    void completarTabela(List<Fornecedor> lista) {
        ObservableList<Fornecedor> dado = FXCollections.observableArrayList();
        for (int i = 0; i < lista.size(); i++) {
            dado.add(lista.get(i));
        }
        this.tbcNomeFantasia.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("nome_fantasia"));
        this.tbcCNPJ.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("cnpj"));
        this.tbcPessoaResponsavel.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("pessoa_responsavel"));
        this.tbcRazaoSocial.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("razao_social"));
        this.tblPrincipal.setItems(dado);
    }

    @FXML
    void btnVoltar_OnAction(ActionEvent event) {
        try {
            //  negocioF = null;
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
            CadastroFornecedorController.setCadastrar(true);
            //  negocioF = null;
            Parent root;
            root = FXMLLoader.load(CadastroFornecedorController.class.getClassLoader().getResource("fxml/cadastro/Cadastro/Cadastro_Fornecedor.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    void btnAlterar_OnAction(ActionEvent event) {
        Fornecedor f = tblPrincipal.getSelectionModel().getSelectedItem();

        CadastroFornecedorController.setCadastrar(false);
        CadastroFornecedorController.setAlterar(f);

        try {
            // negocioF = null;
            Parent root;
            root = FXMLLoader.load(CadastroFornecedorController.class.getClassLoader().getResource("fxml/cadastro/Cadastro/Cadastro_Fornecedor.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    void btnExcluir_OnAction(ActionEvent event) {
        try {
            Alertas alert = new Alertas();
            Properties prop;
            prop = LerProperties.getProp();
            if (alert.alerta(Alert.AlertType.CONFIRMATION, "Remoção", prop.getProperty("msg.temcerteza"), "Sim", "Não")) {
                NegociosEstaticos.getNegocioFornecedor().remover(tblPrincipal.getSelectionModel().getSelectedItem());
                completarTabela(NegociosEstaticos.getNegocioFornecedor().buscarTodos());
            }
        } catch (Exception ex) {
            Alertas alert = new Alertas();
            alert.alerta(Alert.AlertType.ERROR, "Erro na remoção", ex.getMessage());
        }
    }

    @FXML
    void btnBuscar_OnAction(ActionEvent event) {
        if (rdbCNPJ.isSelected()) {

            char buscar[] = txtBuscador.getText().toCharArray();

            if (Validar.isDigit(buscar)) {
                Fornecedor f = new Fornecedor();
                f.setCnpj(txtBuscador.getText());
                List<Fornecedor> lista = NegociosEstaticos.getNegocioFornecedor().buscarPorCnpj(f);
                completarTabela(lista);
            } else {
                try {
                    IncompatibilidadeNumero();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }

        }
        if (rdbNomeFantasia.isSelected()) {
            Fornecedor f = new Fornecedor();
            f.setNome_fantasia(txtBuscador.getText());
            List<Fornecedor> lista = NegociosEstaticos.getNegocioFornecedor().buscarPorNomeFantasia(f);
            completarTabela(lista);

        }
        if (rdbPessoaResponsavel.isSelected()) {
            Fornecedor f = new Fornecedor();
            f.setPessoa_responsavel(txtBuscador.getText());
            List<Fornecedor> lista = NegociosEstaticos.getNegocioFornecedor().buscarPorPessoaResponsavel(f);
            completarTabela(lista);

        }
        if (rdbRazaoSocial.isSelected()) {
            Fornecedor f = new Fornecedor();
            f.setRazao_social(txtBuscador.getText());
            List<Fornecedor> lista = NegociosEstaticos.getNegocioFornecedor().buscarPorRazaoSocial(f);
            completarTabela(lista);
        }
    }

    private void IncompatibilidadeNumero() throws Exception {
        LerProperties ler = new LerProperties();
        Properties prop = ler.getProp();
        alerta(Alert.AlertType.ERROR, prop.getProperty("msg.dados.erro"), prop.getProperty("msg.incompatibilidade.numero"));

    }

    void alerta(Alert.AlertType TipoAviso, String cabecalho, String msg) throws Exception {
        LerProperties ler = new LerProperties();

        Properties prop = ler.getProp();
        Alert alert = new Alert(TipoAviso);
        alert.setTitle(cabecalho);
        alert.setHeaderText(null);
        alert.setContentText(msg);

        alert.showAndWait();

    }

}
