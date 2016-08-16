/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cadastro.Cadastro;

import controller.cadastro.Consulta.ConsultarFornecedorController;
import controller.cadastro.Consulta.ConsultarPessoaController;
import gui.SystemAutonet;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.Observable;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.converter.PercentageStringConverter;
import negocio.NegocioPessoa;
import vo.Atividade;
import vo.PerfilUsuario;
import vo.Pessoa;
import vo.Sexo;

/**
 *
 * @author PET Autonet
 */
public class CadastroPessoaController {

    @FXML
    private TextField txtEndereco;

    @FXML
    private PasswordField txtRSenha;

    @FXML
    private Label foneObrigatorio;

    @FXML
    private DatePicker dtpDtNascimento;

    @FXML
    private TextField txtNome;

    @FXML
    private RadioButton rdbMasculino;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtNumMatricula;

    @FXML
    private Button btnSalvar;

    @FXML
    private Label funcaoObrigatorio;

    @FXML
    private CheckBox CheckBoxInativo;

    @FXML
    private Label nomeObrigatorio;

    @FXML
    private Label sexoObrigatorio;

    @FXML
    private Button btnCancelar;

    @FXML
    private ComboBox<PerfilUsuario> cmbFuncao;

    @FXML
    private TextField txtRg;

    @FXML
    private Label usuarioObrigatorio;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Label cpfObrigatorio;

    @FXML
    private Tab tabDadoPessoais;

    @FXML
    private TextField txtSecundario;

    @FXML
    private Label matriculaObrigatorio;

    @FXML
    private Label emailObrigatorio;

    @FXML
    private TextField txtEmail;

    @FXML
    private Label enderecoObrigatorio;

    @FXML
    private CheckBox CheckBoxAtivo;

    @FXML
    private TextField txtUsuario;

    @FXML
    private Label rgObrigatorio;

    @FXML
    private TextField txtPrincipal;

    @FXML
    private Label repSenhaObrigatorio;

    @FXML
    private Label dtNascimentoObrigatorio;

    @FXML
    private Label senhaObrigatorio;

    @FXML
    private RadioButton rdbFeminino;

    private NegocioPessoa NegocioP = new NegocioPessoa();

    ObservableList<PerfilUsuario> perf = FXCollections.observableArrayList((PerfilUsuario.values()));

    @FXML
    void btnSalvarOnAction(ActionEvent event) {

        if (verificaCampoObrigatorio()) {

        Pessoa pessoa = new Pessoa();
        Date data = new Date();
           pessoa.setNome(txtNome.getText());
           pessoa.setCpf(txtCpf.getText());
           pessoa.setEmail(txtEmail.getText());
           pessoa.setEndereco(txtEndereco.getText());
           pessoa.setFone_principal(txtPrincipal.getText());
           pessoa.setFone_secundario(txtSecundario.getText());
           pessoa.setUsuario(txtUsuario.getText());
           pessoa.setSenha(txtSenha.getText());
           pessoa.setNum_matricula(txtNumMatricula.getText());
           pessoa.setUltimo_acesso(data);
           pessoa.setFuncao(cmbFuncao.getValue());
           pessoa.setRg(txtRg.getText());
           if(rdbFeminino.isSelected()) pessoa.setSexo(Sexo.F);
           if(rdbMasculino.isSelected())pessoa.setSexo(Sexo.M);
           if(CheckBoxAtivo.isSelected())pessoa.setAtivo("S");
           if(CheckBoxInativo.isSelected())pessoa.setAtivo("N");
           
         //  Date dataNascimento = new Date(dtpDtNascimento.getValue().toString());
          // pessoa.setDt_nascimento(dataNascimento);
          
//        pessoa.setCpf("36773389720");
//        pessoa.setEndereco("Rua 48, Quadra 17, Casa 14, CPA 3, Setor 4");
//        pessoa.setNome("Eduardo Roosevelt de Oliveira Silva");
//        pessoa.setFone_principal("92290278");
//        pessoa.setNum_matricula("2013178440267");
//        pessoa.setSexo("M");
//        pessoa.setUsuario("E.Roosevelt");
//        pessoa.setSenha("12345678");
//        pessoa.setAtivo("N");
//        pessoa.setFuncao("UsuarioComum");
            pessoa.setDt_nascimento(data);
//        pessoa.setRg("123123123");
//        pessoa.setUltimo_acesso(data);

            try {
                NegocioP.salvar(pessoa);
                Parent root;
                root = FXMLLoader.load(ConsultarPessoaController.class.getClassLoader().getResource("fxml/cadastro/Consulta/Consultar_Pessoa.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
                SystemAutonet.SCENE.setRoot(root);
            } catch (Exception ex) {
                System.out.println("Erro " + ex.getMessage());
            }
        }
    }

    @FXML
    void btnSalvarOnKeyPressed(KeyEvent event) {
    }

    @FXML
    void btnCancelarOnKeyPressed(KeyEvent event) {

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

    @FXML
    void rdbFemininoOnAction(ActionEvent event) {

    }

    @FXML
    void rdbFemininoOnKeyPressed(KeyEvent event) {

    }

    @FXML
    void rdbMasculinoOnAction(ActionEvent event) {

    }

    @FXML
    void rdbMasculinoOnKeyPressed(KeyEvent event) {

    }

    private void setcamposObrigatorio() {
        nomeObrigatorio.setVisible(false);
        sexoObrigatorio.setVisible(false);
        cpfObrigatorio.setVisible(false);
        rgObrigatorio.setVisible(false);
        dtNascimentoObrigatorio.setVisible(false);
        foneObrigatorio.setVisible(false);
        emailObrigatorio.setVisible(false);
        enderecoObrigatorio.setVisible(false);
        funcaoObrigatorio.setVisible(false);
        matriculaObrigatorio.setVisible(false);
        usuarioObrigatorio.setVisible(false);
        senhaObrigatorio.setVisible(false);
        repSenhaObrigatorio.setVisible(false);
    }

    private boolean verificaCampoObrigatorio() {
        setcamposObrigatorio();
        boolean verifica = true;
        if (txtNome.getText().isEmpty()) {
            nomeObrigatorio.setVisible(true);
            verifica = false;
        }
        if (!rdbFeminino.isSelected() && !rdbMasculino.isSelected()) {
            sexoObrigatorio.setVisible(true);
            verifica = false;
        }
        if (txtCpf.getText().isEmpty()) {
            cpfObrigatorio.setVisible(true);
            verifica = false;
        }
        if (txtRg.getText().isEmpty()) {
            rgObrigatorio.setVisible(true);
            verifica = false;
        }
        if (dtpDtNascimento.getValue() == null) {
            dtNascimentoObrigatorio.setVisible(true);
            verifica = false;
        }
        if (txtPrincipal.getText().isEmpty()) {
            foneObrigatorio.setVisible(true);
            verifica = false;
        }
        if (txtEmail.getText().isEmpty()) {
            emailObrigatorio.setVisible(true);
            verifica = false;
        }
        if (txtEndereco.getText().isEmpty()) {
            enderecoObrigatorio.setVisible(true);
            verifica = false;
        }
        if (cmbFuncao.getValue() == null) {
            funcaoObrigatorio.setVisible(true);
            verifica = false;
        }
        if (txtNumMatricula.getText().isEmpty()) {
            matriculaObrigatorio.setVisible(true);
            verifica = false;
        }
        if (txtUsuario.getText().isEmpty()) {
            usuarioObrigatorio.setVisible(true);
            verifica = false;
        }
        if (txtSenha.getText().isEmpty()) {
            senhaObrigatorio.setVisible(true);
            verifica = false;
        }
        if (txtRSenha.getText().isEmpty()) {
            repSenhaObrigatorio.setVisible(true);
            verifica = false;
        }
        return verifica;
    }

    public void initialize() throws IOException {
        setcamposObrigatorio();
        cmbFuncao.setItems(perf);
        CheckBoxAtivo.setDisable(true);
        CheckBoxInativo.setDisable(true);
//        Properties properties = new Properties();
//        properties.load(new  FileInputStream("utilitarios/i18N_pt_BR.properties"));
        // String msg1 = messages
     
    }

}
