/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cadastro.Cadastro;

import controller.cadastro.Consulta.ConsultarLocaisController;
import gui.SystemAutonet;
import java.io.IOException;
import java.util.ArrayList;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import negocio.NegocioDepartamento;
import negocio.NegocioLocal;
import utilitarios.LerProperties;
import vo.Departamento;
import vo.Local;

/**
 *
 * @author PET Autonet
 */
public class CadastroSalaBlocoController {

    @FXML
    private Button btnSalvar;

    @FXML
    private ComboBox<String> cmbDepartamento;

    @FXML
    private TextField txtnumero;

    @FXML
    private TextField txtresponsavel;

    @FXML
    private Button btnCancelar;

    @FXML
    private TextField txtdescricao;

    @FXML
    private Label Title;

    @FXML
    private Label lblNumeroObrigatorio;

    @FXML
    private Label lblResponsavelObrigatorio;

    @FXML
    private Label lblDepartamentoObrigatorio;

    @FXML
    private Label lblDescricaoObrigatorio;

    private NegocioLocal NegocioL;

    private static Local alterar;

    private static boolean cadastrar;

    private NegocioDepartamento negocioDepartamento;

    List<Departamento> lista;

    public void initialize() {
        NegocioL = new NegocioLocal();
        negocioDepartamento = new NegocioDepartamento();
        setcamposObrigatorio();
        lista = negocioDepartamento.buscarTodos();

        ObservableList<String> dado = FXCollections.observableArrayList();
        for (int i = 0; i < lista.size(); i++) {
            dado.add(lista.get(i).getSigla());
        }

        cmbDepartamento.setItems(dado);

        if (!isCadastrar()) {
            completar();
        } else {
            alterar = null;
        }

    }

    @FXML
    void btnSalvar_OnAction(ActionEvent event) {

        if (verificaCampoObrigatorio()) {
            try {
                if (alterar != null) {
                    salvar(alterar);
                } else {
                    Local local = new Local();
                    salvar(local);
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
    void btnCancelar_OnAction(ActionEvent event) {
        try {
            Parent root;
            NegocioL = null;
            alterar = null;
            negocioDepartamento = null;
            root = FXMLLoader.load(ConsultarLocaisController.class.getClassLoader().getResource("fxml/cadastro/Consulta/Consultar_Locais.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Local getAlterar() {
        return alterar;
    }

    public static void setAlterar(Local alterar) {
        CadastroSalaBlocoController.alterar = alterar;
    }

    public static boolean isCadastrar() {
        return cadastrar;
    }

    public static void setCadastrar(boolean cadastrar) {
        CadastroSalaBlocoController.cadastrar = cadastrar;
    }

    private void setcamposObrigatorio() {
        lblDepartamentoObrigatorio.setVisible(false);
        lblDescricaoObrigatorio.setVisible(false);
        lblNumeroObrigatorio.setVisible(false);
        lblResponsavelObrigatorio.setVisible(false);
    }

    private boolean verificaCampoObrigatorio() {
        setcamposObrigatorio();
        boolean verifica = true;
        if (txtdescricao.getText().isEmpty()) {
            lblDescricaoObrigatorio.setVisible(true);
            verifica = false;
        }
        if (txtnumero.getText().isEmpty()) {
            lblNumeroObrigatorio.setVisible(true);
            verifica = false;
        }
        if (txtresponsavel.getText().isEmpty()) {
            lblResponsavelObrigatorio.setVisible(true);
            verifica = false;
        }
        return verifica;
    }

    private void completar() {
        txtdescricao.setText(alterar.getDescricao());
        txtnumero.setText(String.valueOf(alterar.getNumero()));
        txtresponsavel.setText(alterar.getResponsavel());
        cmbDepartamento.setValue(alterar.getId_departamento().getSigla());
        try {
            LerProperties ler = new LerProperties();
            Properties prop = ler.getProp();
            Title.setText(prop.getProperty("title.alterar.TipoSaida"));
        } catch (IOException ex) {
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

    private void salvar(Local local) throws Exception {

        local.setDescricao(txtdescricao.getText());
        local.setNumero(Integer.parseInt(txtnumero.getText()));
        local.setResponsavel(txtresponsavel.getText());
        Departamento dp = new Departamento();
        for (Departamento vo : lista) {
            if (vo.getSigla().equals(cmbDepartamento.getValue())) {
                dp = vo;
                break;
            }
        }
        local.setId_departamento(dp);
        try {
            NegocioL.salvar(local);

            NegocioL = null;
            alterar = null;
            negocioDepartamento = null;

            Parent root;
            LerProperties ler = new LerProperties();

            Properties prop = ler.getProp();
            alerta(AlertType.INFORMATION, prop.getProperty("msg.cadastro.confirmacao"), prop.getProperty("msg.cadastro.sucesso"));
            root = FXMLLoader.load(ConsultarLocaisController.class.getClassLoader().getResource("fxml/cadastro/Consulta/Consultar_Locais.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));

            SystemAutonet.SCENE.setRoot(root);

        } catch (Exception ex) {
            LerProperties ler = new LerProperties();
            Properties prop = ler.getProp();
            alerta(AlertType.ERROR, prop.getProperty("msg.cadastro.erro"), ex.getMessage());
        }
    }

}
