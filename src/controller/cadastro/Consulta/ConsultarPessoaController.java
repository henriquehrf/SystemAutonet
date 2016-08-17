package controller.cadastro.Consulta;

import controller.PrincipalController;
import controller.cadastro.Cadastro.CadastroPessoaController;
import gui.SystemAutonet;
import java.util.ArrayList;
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
import negocio.NegocioPessoa;
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

    NegocioPessoa pessoa = new NegocioPessoa();

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

        List<Pessoa> lista = pessoa.buscarTodos();
        completarTabela(lista);
        rdbNome.setSelected(true);

    }

    @FXML
    void btnVoltarOnAction(ActionEvent event) {
        try {
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
            Parent root;
            root = FXMLLoader.load(CadastroPessoaController.class.getClassLoader().getResource("fxml/cadastro/Cadastro/Cadastro_Pessoa.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @FXML
    void btnAlterarOnAction(ActionEvent event) {

    }

    @FXML
    void btnExcluirOnAction(ActionEvent event) {

    }

    @FXML
    void btnBuscarOnAction(ActionEvent event) {

        if (rdbNome.isSelected()) {
            Pessoa p = new Pessoa();
            p.setNome(txtBuscador.getText());
            List<Pessoa> lista = pessoa.buscarPorNome(p);
            completarTabela(lista);

        }
        if (rdbCPF.isSelected()) {
            Pessoa p = new Pessoa();
            p.setCpf(txtBuscador.getText());
            List<Pessoa> lista = pessoa.buscarPorCPF(p);
            completarTabela(lista);

        }
        if (rdbRG.isSelected()) {
            Pessoa p = new Pessoa();
            p.setRg(txtBuscador.getText());
            List<Pessoa> lista = pessoa.buscarPorRG(p);
            completarTabela(lista);

        }
        if(rgbNumMatricula.isSelected()){
            Pessoa p = new Pessoa();
            p.setNum_matricula(txtBuscador.getText());
            List<Pessoa> lista = pessoa.buscarPorMatricula(p);
            completarTabela(lista);
        }
    }

}
