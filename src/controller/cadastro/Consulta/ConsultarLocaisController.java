package controller.cadastro.Consulta;

import classesAuxiliares.NegociosEstaticos;
import classesAuxiliares.Validar;
import controller.PrincipalController;
import controller.cadastro.Cadastro.CadastroSalaBlocoController;
import gui.SystemAutonet;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
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
import utilitarios.Alertas;
import utilitarios.LerMessage;
import vo.Departamento;
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
    private RadioButton rdbDescricao;

    @FXML
    private TableColumn<Local, String> tbcDescricao;

    @FXML
    private Button btnBuscar;

    @FXML
    private ComboBox<String> cbmDepartamento;

    @FXML
    private TableColumn<Local, String> tbcDepartamento;

    //  private NegocioLocal negocioLocal;
    public void initialize() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                txtBuscador.requestFocus();
            }
        });

        //  negocioLocal = new NegocioLocal();
        List<Local> lista = NegociosEstaticos.getNegocioLocal().buscarTodos();
        List<Departamento> aux = NegociosEstaticos.getNegocioDepartamento().buscarTodos();

        rdbDescricao.setSelected(true);
        completarCombo(aux);
        completarTabela(lista);
        

    }

    void completarCombo(List<Departamento> lista) {
        ObservableList<String> dado = FXCollections.observableArrayList();
        for (int i = 0; i < lista.size(); i++) {
            dado.add(lista.get(i).getSigla());
        }
        dado.add("TODOS");
        cbmDepartamento.setItems(dado);
        cbmDepartamento.setValue("TODOS");
    }

    @FXML
    void btnVoltar_OnAction(ActionEvent event) {
        try {
            Parent root;
            //  negocioLocal = null;
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
            //  negocioLocal = null;
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
            //   negocioLocal = null;
            root = FXMLLoader.load(CadastroSalaBlocoController.class.getClassLoader().getResource("fxml/cadastro/Cadastro/Cadastro_SalaBloco.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
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
                NegociosEstaticos.getNegocioLocal().remover(tblPrincipal.getSelectionModel().getSelectedItem());
                completarTabela(NegociosEstaticos.getNegocioLocal().buscarTodos());
            }
        } catch (Exception ex) {
            Alertas alert = new Alertas();
            alert.alerta(Alert.AlertType.ERROR, "Erro na remoção", ex.getMessage());
        }
    }

    @FXML
    void btnBuscar_OnAction(ActionEvent event) {
//        if (rdbBloco.isSelected()) {
//            Local local = new Local();
////            local.setBloco(txtBuscador.getText());
//            completarTabela(NegociosEstaticos.getNegocioLocal().buscarPorBloco(local));
//        }

        if (rdbNumero.isSelected()) {
            Local local = new Local();
            char buscar[] = txtBuscador.getText().toCharArray();

            if (Validar.isDigit(buscar)) {
                if (txtBuscador.getText().isEmpty()) {
                    completarTabela(NegociosEstaticos.getNegocioLocal().buscarTodos());
                } else {

                    local.setNumero(Integer.parseInt(txtBuscador.getText()));
                    completarTabela(NegociosEstaticos.getNegocioLocal().buscarPorNumero(local));
                }
            } else {
                try {
                    LerMessage ler = new LerMessage();
                    Alertas aviso = new Alertas();
                    aviso.alerta(Alert.AlertType.ERROR, ler.getMessage("msg.incompatibilidade.numero"), ler.getMessage("msg.incompatibilidade.numero"));
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        if (rdbPessoaResponsavel.isSelected()) {
            Local local = new Local();
            local.setResponsavel(txtBuscador.getText());
            completarTabela(NegociosEstaticos.getNegocioLocal().buscarPorPessoaResponsavel(local));
        }
        if (rdbDescricao.isSelected()) {
            Local local = new Local();
            local.setDescricao(txtBuscador.getText());
            completarTabela(NegociosEstaticos.getNegocioLocal().buscarPorPessoaResponsavel(local));
        }
    }

    void completarTabela(List<Local> lista) {
        ObservableList<Local> dado = FXCollections.observableArrayList();
        for (int i = 0; i < lista.size(); i++) {
            dado.add(lista.get(i));
        }

        if (rdbDescricao.isSelected()) {
            Comparator<Local> cmp = new Comparator<Local>() {
                @Override
                public int compare(Local loc1, Local loc2) {
                    return loc1.getDescricao().compareTo(loc2.getDescricao());
                }
            };

            Collections.sort(dado, cmp);
        }
        
        
        this.tbcDescricao.setCellValueFactory(new PropertyValueFactory<Local, String>("descricao"));
        this.tbcNumero.setCellValueFactory(new PropertyValueFactory<Local, Integer>("numero"));
        this.tbcPessoaResponsavel.setCellValueFactory(new PropertyValueFactory<Local, String>("responsavel"));
        this.tbcDepartamento.setCellValueFactory(new PropertyValueFactory<Local, String>("Sigla"));

        this.tblPrincipal.setItems(dado);

    }

}
