package controller.cadastro.Consulta;

import controller.PrincipalController;
import controller.cadastro.Cadastro.CadastroPessoaController;
import gui.SystemAutonet;
import java.util.ResourceBundle;
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

public class ConsultarPessoaController {

    @FXML
    private TableColumn<?, ?> tbcCPF;

    @FXML
    private TableView<?> tblPrincipal;

    @FXML
    private TableColumn<?, ?> tbcNome;

    @FXML
    private Button btnInserir;

    @FXML
    private Label Title;

    @FXML
    private TextField txtBuscador;

    @FXML
    private TableColumn<?, ?> tbcNumMatricula;

    @FXML
    private RadioButton rdbRG;

    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnAlterar;

    @FXML
    private TableColumn<?, ?> tbcRG;

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

    public void initialize() {

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
}
