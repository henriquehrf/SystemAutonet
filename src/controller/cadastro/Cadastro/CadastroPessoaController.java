/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cadastro.Cadastro;

import classesAuxiliares.Validar;
import controller.cadastro.Consulta.ConsultarPessoaController;
import gui.SystemAutonet;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import negocio.NegocioPessoa;
import utilitarios.LerProperties;
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
    private Label lblsecundario;

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
    private Label Title;

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

    private NegocioPessoa NegocioP;

    private static Pessoa alterar;

    private static boolean cadastrar;

    public static boolean isCadastrar() {
        return cadastrar;
    }

    public static void setCadastrar(boolean cadastra) {
        CadastroPessoaController.cadastrar = cadastra;
    }

    public static Pessoa getAlterar() {
        return alterar;
    }

    public static void setAlterar(Pessoa alterar) {
        CadastroPessoaController.alterar = alterar;
    }

    ObservableList<PerfilUsuario> perf = FXCollections.observableArrayList((PerfilUsuario.values()));

    public void initialize() {

        NegocioP = new NegocioPessoa();
        setcamposObrigatorio();
        cmbFuncao.setItems(perf);
        CheckBoxAtivo.setDisable(true);
        CheckBoxInativo.setDisable(true);
        if (!isCadastrar()) {
            completar();
        } else {
            alterar = null;
        }

    }

    @FXML
    void btnSalvarOnAction(ActionEvent event) {

        if (verificaCampoObrigatorio()) {

            try {
                if (alterar != null) {
                    salvar(alterar);
                } else {
                    Pessoa pessoa = new Pessoa();
                    salvar(pessoa);

                }
            } catch (Exception ex) {
                LerProperties ler = new LerProperties();
                Properties prop;
                try {
                    prop = ler.getProp();
                    alerta(Alert.AlertType.ERROR, prop.getProperty("msg.cadastro.erro"), ex.getMessage());
                } catch (Exception ex1) {
                    System.out.println(ex1.getMessage());
                }
            }

        } else {
            try {
                LerProperties ler = new LerProperties();
                Properties prop = ler.getProp();
                alerta(AlertType.ERROR, prop.getProperty("msg.cadastro.erro"), prop.getProperty("msg.cadastro.incompleto"));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());

            }
        }
    }

    @FXML
    void btnSalvarOnKeyPressed(KeyEvent event) {
    }

    @FXML
    void btnCancelarOnKeyPressed(KeyEvent event) {

    }

    private void IncompatibilidadeNumero() throws Exception {
        LerProperties ler = new LerProperties();
        Properties prop = ler.getProp();
        alerta(Alert.AlertType.ERROR, prop.getProperty("msg.dados.erro"), prop.getProperty("msg.incompatibilidade.numero"));

    }

    private void salvar(Pessoa pessoa) throws Exception {
        boolean trava = false;
        Date data = new Date();
        pessoa.setNome(txtNome.getText());

        pessoa.setEmail(txtEmail.getText());
        pessoa.setEndereco(txtEndereco.getText());

        pessoa.setUsuario(txtUsuario.getText());
        pessoa.setSenha(txtSenha.getText());
        pessoa.setUltimo_acesso(data);
        pessoa.setFuncao(cmbFuncao.getValue());

        if (Validar.isDigit(txtPrincipal.getText().toCharArray())) {
            pessoa.setFone_principal(txtPrincipal.getText());
        } else {
            this.foneObrigatorio.setVisible(true);
            trava = true;
        }

        if (Validar.isDigit(txtSecundario.getText().toCharArray())) {

            pessoa.setFone_secundario(txtSecundario.getText());
        } else {
            this.lblsecundario.setVisible(true);
            trava = true;
        }

        if (Validar.isDigit(txtCpf.getText().toCharArray())) {
            pessoa.setCpf(txtCpf.getText());
        } else {
            this.cpfObrigatorio.setVisible(true);
            trava = true;
        }

        if (Validar.isDigit(txtNumMatricula.getText().toCharArray())) {
            pessoa.setNum_matricula(txtNumMatricula.getText());
        } else {
            this.matriculaObrigatorio.setVisible(true);
            trava = true;
        }

        if (Validar.isDigit(txtRg.getText().toCharArray())) {
            pessoa.setRg(txtRg.getText());
        } else {
            this.rgObrigatorio.setVisible(true);
            trava = true;
        }

        if (trava) {
            IncompatibilidadeNumero();
            return;
        }
        if (rdbFeminino.isSelected()) {
            pessoa.setSexo(Sexo.F);
        }
        if (rdbMasculino.isSelected()) {
            pessoa.setSexo(Sexo.M);
        }
        if (CheckBoxAtivo.isSelected()) {
            pessoa.setAtivo(Atividade.A);
        }
        if (CheckBoxInativo.isSelected()) {
            pessoa.setAtivo(Atividade.I);
        }

        Instant instant = dtpDtNascimento.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        pessoa.setDt_nascimento(Date.from(instant));

        try {
            NegocioP.salvar(pessoa);
            Parent root;
            LerProperties ler = new LerProperties();
            Properties prop = ler.getProp();
            NegocioP = null;
            alterar = null;
            alerta(AlertType.INFORMATION, prop.getProperty("msg.cadastro.confirmacao"), prop.getProperty("msg.cadastro.sucesso"));
            root = FXMLLoader.load(ConsultarPessoaController.class.getClassLoader().getResource("fxml/cadastro/Consulta/Consultar_Pessoa.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            LerProperties ler = new LerProperties();
            Properties prop = ler.getProp();
            alerta(AlertType.ERROR, prop.getProperty("msg.cadastro.erro"), ex.getMessage());
        }
    }

    @FXML
    void btnCancelarOnAction(ActionEvent event) {

        try {
            Parent root;
            NegocioP = null;
            alterar = null;
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

    void alerta(AlertType TipoAviso, String cabecalho, String msg) throws Exception {
        LerProperties ler = new LerProperties();

        Properties prop = ler.getProp();
        Alert alert = new Alert(TipoAviso);
        alert.setTitle(cabecalho);
        alert.setHeaderText(null);
        alert.setContentText(msg);

        alert.showAndWait();

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
        lblsecundario.setVisible(false);
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

    void completar() {
        txtNome.setText(alterar.getNome());
        txtCpf.setText(alterar.getCpf());
        txtEmail.setText(alterar.getEmail());
        txtEndereco.setText(alterar.getEndereco());
        txtNumMatricula.setText(alterar.getNum_matricula());
        txtRSenha.setText(alterar.getSenha());
        txtSenha.setText(alterar.getSenha());
        txtRg.setText(alterar.getRg());
        txtSecundario.setText(alterar.getFone_secundario());
        txtPrincipal.setText(alterar.getFone_principal());
        txtUsuario.setText(alterar.getUsuario());
        cmbFuncao.setValue(alterar.getFuncao());
        LocalDate date = alterar.getDt_nascimento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        dtpDtNascimento.setValue(date);
        if (alterar.getSexo().equals(Sexo.F)) {
            rdbFeminino.setSelected(true);
        } else {
            rdbMasculino.setSelected(true);
        }
        LerProperties ler = new LerProperties();
        try {
            Properties prop = ler.getProp();
            Title.setText(prop.getProperty("title.alterar.departamento"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        CheckBoxAtivo.setDisable(false);
        CheckBoxInativo.setDisable(false);
        //alterar=null;
    }

}
