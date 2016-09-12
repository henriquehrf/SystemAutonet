package controller.cadastro.Consulta;

import classesAuxiliares.NegociosEstaticos;
import classesAuxiliares.Validar;
import controller.PrincipalController;
import controller.cadastro.Cadastro.CadastroMaterialController;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.NegocioPessoa;
import utilitarios.Alertas;
import utilitarios.LerProperties;
import vo.Categoria;
import vo.Material;

public class ConsultarMaterialController {

    @FXML
    private RadioButton rdbQuantidade;

    @FXML
    private TableColumn<Material, Number> tbcQuantidade;

    @FXML
    private TableView<Material> tblPrincipal;

    @FXML
    private TableColumn<Material, String> tbcCategoria;

    @FXML
    private Button btnInserir;

    @FXML
    private Label Title;

    @FXML
    private ComboBox<String> cmbCategoria;

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
    private TableColumn<Material, String> tbcDescricao;

    @FXML
    private RadioButton rdbDescricao;

    @FXML
    private TableColumn<Material, String> tbcUnidadeMedida;

    public void initialize() {

        List<Material> lista = NegociosEstaticos.getNegocioMaterial().buscarTodos();
        List<Categoria> lista2 = NegociosEstaticos.getNegocioCategoria().bucarTodos();
        ObservableList<String> dado2 = FXCollections.observableArrayList();

        for (int i = 0; i < lista2.size(); i++) {
            dado2.add(lista2.get(i).getDescricao());
        }

        cmbCategoria.setItems(dado2);
       
        rdbDescricao.setSelected(true);
        completarTabela(lista);

    }

    @FXML
    void cmbCategoria_OnAction(ActionEvent event) {
         Categoria cat = new Categoria();
         cat.setDescricao(cmbCategoria.getValue());
         completarTabela(NegociosEstaticos.getNegocioMaterial().buscarPorCategoria( NegociosEstaticos.getNegocioCategoria().buscarPorDescricao(cat).get(0)));
    }

    void completarTabela(List<Material> lista) {
        ObservableList<Material> dado = FXCollections.observableArrayList();
        for (int i = 0; i < lista.size(); i++) {
            dado.add(lista.get(i));
        }
        this.tbcDescricao.setCellValueFactory(new PropertyValueFactory<Material, String>("descricao"));
        this.tbcQuantidade.setCellValueFactory(new PropertyValueFactory<Material, Number>("quantidade"));
        this.tbcUnidadeMedida.setCellValueFactory(new PropertyValueFactory<Material, String>("unidadeMedida"));
        this.tbcCategoria.setCellValueFactory(new PropertyValueFactory<Material, String>("CategoriaNome"));
        this.tblPrincipal.setItems(dado);
    }

    @FXML
    void btnVoltar_OnAction(ActionEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(PrincipalController.class.getClassLoader().getResource("fxml/Principal.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @FXML
    void btnBusca_OnAction(ActionEvent event) {
        if (rdbDescricao.isSelected()) {
            Material material = new Material();
            material.setDescricao(txtBuscador.getText());
            completarTabela(NegociosEstaticos.getNegocioMaterial().buscarPorDescricao(material));
        }
        if (rdbQuantidade.isSelected()) {
            char buscar[] = txtBuscador.getText().toCharArray();
            if (Validar.isDigit(buscar)) {
                Material material = new Material();
                material.setQuantidade(Integer.parseInt(txtBuscador.getText()));
                completarTabela(NegociosEstaticos.getNegocioMaterial().buscarPorQuantidade(material));
            } else {
                try {
                    IncompatibilidadeNumero();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    @FXML
    void btnAlterar_OnAction(ActionEvent event) {
        try {
            Material p = tblPrincipal.getSelectionModel().getSelectedItem();
            CadastroMaterialController.setCadastrar(false);
            CadastroMaterialController.setAlterar(p);
            Parent root;
            root = FXMLLoader.load(CadastroMaterialController.class.getClassLoader().getResource("fxml/cadastro/Cadastro/Cadastro_Material.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
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
                NegociosEstaticos.getNegocioMaterial().remover(tblPrincipal.getSelectionModel().getSelectedItem());
                completarTabela(NegociosEstaticos.getNegocioMaterial().buscarTodos());
            }
        } catch (Exception ex) {
            Alertas alert = new Alertas();
            alert.alerta(Alert.AlertType.ERROR, "Erro na remoção", ex.getMessage());
        }
    }

    @FXML
    void btnInserir_OnAction(ActionEvent event) {
        try {
            CadastroMaterialController.setCadastrar(true);
            Parent root;
            root = FXMLLoader.load(CadastroMaterialController.class.getClassLoader().getResource("fxml/cadastro/Cadastro/Cadastro_Material.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
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
