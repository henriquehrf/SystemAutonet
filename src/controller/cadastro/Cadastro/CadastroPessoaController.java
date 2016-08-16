/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cadastro.Cadastro;

import controller.cadastro.Consulta.ConsultarFornecedorController;
import controller.cadastro.Consulta.ConsultarPessoaController;
import gui.SystemAutonet;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import negocio.NegocioPessoa;
import vo.Pessoa;

/**
 *
 * @author PET Autonet
 */
public class CadastroPessoaController {

    @FXML
    private TextField txtEndereco;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private PasswordField txtRSenha;

    @FXML
    private Tab tabDadoPessoais;

    @FXML
    private TextField txtSecundario;

    @FXML
    private DatePicker dtpDtNascimento;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtEmail;

    @FXML
    private RadioButton rdbMasculino;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtNumMatricula;

    @FXML
    private CheckBox CheckBoxAtivo;

    @FXML
    private TextField txtUsuario;

    @FXML
    private Button btnSalvar;

    @FXML
    private TextField txtPrincipal;

    @FXML
    private CheckBox CheckBoxInativo;

    @FXML
    private Button btnCancelar;

    @FXML
    private RadioButton rdbFeminino;

    @FXML
    private ChoiceBox<?> cmbFuncao;

    @FXML
    private TextField txtRg;

    private NegocioPessoa NegocioP = new NegocioPessoa();

    @FXML
    void btnSalvarOnAction(ActionEvent event) {

        Pessoa pessoa = new Pessoa();

        Date data = new Date();

        pessoa.setCpf("05921855162");
        pessoa.setEndereco("Rua 48, Quadra 17, Casa 14, CPA 3, Setor 4");
        pessoa.setNome("Eduardo Roosevelt de Oliveira Silva");
        pessoa.setFone_principal("92290278");
        pessoa.setNum_matricula("2013178440269");
        pessoa.setSexo("M");
        pessoa.setUsuario("E");
        pessoa.setSenha("12345678");
        pessoa.setAtivo("N");
        pessoa.setFuncao("UsuarioComum");
        pessoa.setEmail("eduardo.roosevelt@gmail.com");
        pessoa.setDt_nascimento(data);
        pessoa.setRg("1231232131233");
        pessoa.setUltimo_acesso(data);

        try {
            NegocioP.salvar(pessoa);
            Parent root;
            root = FXMLLoader.load(ConsultarPessoaController.class.getClassLoader().getResource("fxml/cadastro/Consulta/Consultar_Pessoa.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.out.println("Erro "+ex.getMessage());
        }

    }

    @FXML
    void btnCancelarOnAction(ActionEvent event) {
        
          try {
            Parent root;
            root = FXMLLoader.load(ConsultarPessoaController.class.getClassLoader().getResource("fxml/cadastro/Consulta/Consultar_Pessoa.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void initialize() {

    }

}
