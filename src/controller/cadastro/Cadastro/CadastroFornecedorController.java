/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cadastro.Cadastro;


import controller.cadastro.Consulta.ConsultarFornecedorController;
import gui.SystemAutonet;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import negocio.NegocioFornecedor;
import utilitarios.LerProperties;
import vo.Fornecedor;

/**
 *
 * @author PET Autonet
 */
public class CadastroFornecedorController {

    private NegocioFornecedor NegocioF = new NegocioFornecedor();

    private static Fornecedor alterar;

    private static boolean cadastrar;

    private NegocioFornecedor negocioF;

    @FXML
    private Label Title;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnCancelar;

    @FXML
    private TextField txtNomeFantasia;

    @FXML
    private TextField txtInscricaoEstadual;

    @FXML
    private TextArea txtEndereco;

    @FXML
    private TextField txtPessoaResponsavel;

    @FXML
    private TextField txtRazaoSocial;

    @FXML
    private TextField txtTelefone;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtCnpj;

    public static Fornecedor getAlterar() {
        return alterar;
    }

    public static void setAlterar(Fornecedor alterar) {
        CadastroFornecedorController.alterar = alterar;
    }

    public static boolean isCadastrar() {
        return cadastrar;
    }

    public static void setCadastrar(boolean cadastrar) {
        CadastroFornecedorController.cadastrar = cadastrar;
    }

    public void initialize() {
        negocioF = new NegocioFornecedor();
        if (!isCadastrar()) {
            completar();
        } else {
            alterar = null;
        }

    }

    @FXML
    void btnSalvar_OnAction(ActionEvent event) throws Exception {
        if (alterar != null) {
            salvar(alterar);
        } else {
            Fornecedor pessoa = new Fornecedor();
            salvar(pessoa);
        }
        try {
            LerProperties ler = new LerProperties();
            Properties prop = ler.getProp();
            alerta(Alert.AlertType.ERROR, prop.getProperty("msg.cadastro.erro"), prop.getProperty("msg.cadastro.incompleto"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    @FXML
    void btnCancelar_OnAction(ActionEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(ConsultarFornecedorController.class.getClassLoader().getResource("fxml/cadastro/Consulta/Consultar_Fornecedor.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void completar() {
        txtCnpj.setText(alterar.getCnpj());
        txtEmail.setText(alterar.getEmail());
        txtEndereco.setText(alterar.getEndereco());
        txtInscricaoEstadual.setText(alterar.getInscricao_estadual());
        txtNomeFantasia.setText(alterar.getNome_fantasia());
        txtPessoaResponsavel.setText(alterar.getPessoa_responsavel());
        txtRazaoSocial.setText(alterar.getRazao_social());
        txtTelefone.setText(alterar.getTelefone());
        LerProperties ler = new LerProperties();

        try {
            Properties prop = ler.getProp();
            Title.setText(prop.getProperty("title.cadastro.fornecedor"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void salvar(Fornecedor fornecedor) throws Exception {

        fornecedor.setCnpj(txtCnpj.getText());
        fornecedor.setEmail(txtEmail.getText());
        fornecedor.setEndereco(txtEndereco.getText());
        fornecedor.setInscricao_estadual(txtInscricaoEstadual.getText());
        fornecedor.setNome_fantasia(txtNomeFantasia.getText());
        fornecedor.setPessoa_responsavel(txtPessoaResponsavel.getText());
        fornecedor.setRazao_social(txtRazaoSocial.getText());
        fornecedor.setTelefone(txtTelefone.getText());

        try {
            NegocioF.salvar(fornecedor);
            alterar = null;
            NegocioF = null;
            Parent root;
            LerProperties ler = new LerProperties();
            Properties prop = ler.getProp();
            alerta(Alert.AlertType.INFORMATION, prop.getProperty("msg.cadastro.confirmacao"), prop.getProperty("msg.cadastro.sucesso"));

            root = FXMLLoader.load(ConsultarFornecedorController.class.getClassLoader().getResource("fxml/cadastro/Consulta/Consultar_Fornecedor.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
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
