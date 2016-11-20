package controller.cadastro.Consulta;

import classesAuxiliares.NegociosEstaticos;
import classesAuxiliares.Validar;
import controller.PrincipalController;
import controller.cadastro.Cadastro.CadastroPessoaController;
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
import utilitarios.Alertas;
import utilitarios.LerMessage;
import vo.Pessoa;

public class ConsultarPessoaController {

    @FXML
    private TableColumn<Pessoa, String> tbcCPF;

    @FXML
    private TableView<Pessoa> tblPrincipal;

    @FXML
    private TableColumn<Pessoa, String> tbcNome;

    @FXML
    private Button btnInserir;

    @FXML
    private Label Title;

    @FXML
    private TextField txtBuscador;

    @FXML
    private TableColumn<Pessoa, String> tbcNumMatricula;

    @FXML
    private RadioButton rdbRG;

    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnAlterar;

    @FXML
    private TableColumn<Pessoa, String> tbcRG;

    @FXML
    private RadioButton rgbNumMatricula;

    @FXML
    private Button btnExcluir;

    @FXML
    private RadioButton rdbNome;

    @FXML
    private Button btnBuscar;

    @FXML
    private RadioButton rdbCPF;

    //  NegocioPessoa pessoa;
    void completarTabela(List<Pessoa> lista) {
        ObservableList<Pessoa> dado = FXCollections.observableArrayList();
        for (int i = 0; i < lista.size(); i++) {
            dado.add(lista.get(i));
        }
        this.tbcNome.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("nome"));
        this.tbcCPF.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("cpf"));
        this.tbcNumMatricula.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("num_matricula"));
        this.tbcRG.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("rg"));
        this.tblPrincipal.setItems(dado);
    }

    public void initialize() {
        // pessoa = new NegocioPessoa();
        List<Pessoa> lista = NegociosEstaticos.getNegocioPessoa().buscarTodos();

        completarTabela(lista);
        rdbNome.setSelected(true);

    }

    @FXML
    void btnVoltarOnAction(ActionEvent event) {
        try {
            //   pessoa = null;
            Parent root;
            root = FXMLLoader.load(PrincipalController.class.getClassLoader().getResource("fxml/Principal.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @FXML
    void btnInserirOnAction(ActionEvent event) {
        try {
            CadastroPessoaController.setCadastrar(true);
            Parent root;
            // pessoa = null;
            root = FXMLLoader.load(CadastroPessoaController.class.getClassLoader().getResource("fxml/cadastro/Cadastro/Cadastro_Pessoa.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @FXML
    void btnAlterarOnAction(ActionEvent event) {

        Pessoa p = tblPrincipal.getSelectionModel().getSelectedItem();
        CadastroPessoaController.setCadastrar(false);
        CadastroPessoaController.setAlterar(p);
        try {
            Parent root;
            //  pessoa = null;
            root = FXMLLoader.load(CadastroPessoaController.class.getClassLoader().getResource("fxml/cadastro/Cadastro/Cadastro_Pessoa.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @FXML
    void btnExcluirOnAction(ActionEvent event) {
        try {
            Alertas alert = new Alertas();
            LerMessage ler = new LerMessage();
            if (alert.alerta(Alert.AlertType.CONFIRMATION, "Remoção", ler.getMessage("msg.temcerteza"), "Sim", "Não")) {
                NegociosEstaticos.getNegocioPessoa().remover(tblPrincipal.getSelectionModel().getSelectedItem());
            }
        } catch (Exception ex) {

            try {
                NegociosEstaticos.getNegocioPessoa().Inativar(tblPrincipal.getSelectionModel().getSelectedItem());
                completarTabela(NegociosEstaticos.getNegocioPessoa().buscarTodos());
            } catch (Exception ex1) {
                Alertas alert = new Alertas();
                alert.alerta(Alert.AlertType.ERROR, "Erro na remoção", ex1.getMessage());

            }

        }
    }

    @FXML
    void btnBuscarOnAction(ActionEvent event) {

        if (rdbNome.isSelected()) {
            Pessoa p = new Pessoa();
            p.setNome(txtBuscador.getText());
            List<Pessoa> lista = NegociosEstaticos.getNegocioPessoa().buscarPorNome(p);
            completarTabela(lista);

        }
        if (rdbCPF.isSelected()) {
            char buscar[] = txtBuscador.getText().toCharArray();

            if (Validar.isDigit(buscar)) {
                Pessoa p = new Pessoa();
                p.setCpf(txtBuscador.getText());
                List<Pessoa> lista = NegociosEstaticos.getNegocioPessoa().buscarPorCPF(p);
                completarTabela(lista);
            } else {
                try {
                    IncompatibilidadeNumero();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }

        }
        if (rdbRG.isSelected()) {
            char buscar[] = txtBuscador.getText().toCharArray();
            if (Validar.isDigit(buscar)) {
                Pessoa p = new Pessoa();
                p.setRg(txtBuscador.getText());
                List<Pessoa> lista = NegociosEstaticos.getNegocioPessoa().buscarPorRG(p);
                completarTabela(lista);
            } else {
                try {
                    IncompatibilidadeNumero();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }

        }
        if (rgbNumMatricula.isSelected()) {
            char buscar[] = txtBuscador.getText().toCharArray();
            if (Validar.isDigit(buscar)) {

                Pessoa p = new Pessoa();
                p.setNum_matricula(txtBuscador.getText());
                List<Pessoa> lista = NegociosEstaticos.getNegocioPessoa().buscarPorMatricula(p);
                completarTabela(lista);

            } else {
                try {
                    IncompatibilidadeNumero();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }

        }
    }

    private void IncompatibilidadeNumero() throws Exception {
        LerMessage ler = new LerMessage();
        Alertas aviso = new Alertas();
        aviso.alerta(Alert.AlertType.ERROR, ler.getMessage("msg.dados.erro"), ler.getMessage("msg.incompatibilidade.numero"));

    }

}
