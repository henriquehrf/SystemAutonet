/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cadastro.Cadastro;

import classesAuxiliares.NegociosEstaticos;
import controller.cadastro.Consulta.ConsultarDepartamentoController;
import controller.cadastro.Consulta.ConsultarPessoaController;
import gui.SystemAutonet;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import negocio.NegocioDepartamento;
import utilitarios.LerProperties;
import vo.Departamento;

/**
 *
 * @author PET Autonet
 */
public class CadastroDepartamentoController {

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnCancelar;

    @FXML
    private TextField txtNome;

    @FXML
    private Label Title;

    @FXML
    private Label lblSiglaObrigatorio;

    @FXML
    private Label lblNomeObrigatorio;

    @FXML
    private TextField txtSigla;

 //   private NegocioDepartamento NegocioP;

    private static Departamento alterar;

    private static boolean cadastrar;

    public void initialize() {
        setcamposObrigatorio();
       // NegocioP = new NegocioDepartamento();

        if (!isCadastrar()) {
            completar();
        } else {
            alterar = null;
        }

    }

    @FXML
    void btnSalvar_OnAction(ActionEvent event) {
        if (verificaCampoObrigatorio()) {
            if (alterar != null) {
                try {
                    salvar(alterar);
                } catch (Exception ex) {
                    Logger.getLogger(CadastroDepartamentoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Departamento departamento = new Departamento();

                try {
                    salvar(departamento);
                } catch (Exception ex) {

                    try {
                        LerProperties ler = new LerProperties();
                        Properties prop = ler.getProp();
                        alerta(AlertType.ERROR, prop.getProperty("msg.cadastro.erro"), ex.getMessage());
                    } catch (Exception ex1) {
                        Logger.getLogger(CadastroDepartamentoController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
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
            alterar = null;
           // NegocioP = null;
            Parent root;
            root = FXMLLoader.load(ConsultarDepartamentoController.class.getClassLoader().getResource("fxml/cadastro/Consulta/Consultar_Departamento.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Departamento getAlterar() {
        return alterar;
    }

    public static void setAlterar(Departamento alterar) {
        CadastroDepartamentoController.alterar = alterar;
    }

    public static boolean isCadastrar() {
        return cadastrar;
    }

    public static void setCadastrar(boolean cadastrar) {
        CadastroDepartamentoController.cadastrar = cadastrar;
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
        lblNomeObrigatorio.setVisible(false);
        lblSiglaObrigatorio.setVisible(false);
    }

    private boolean verificaCampoObrigatorio() {
        setcamposObrigatorio();
        boolean verifica = true;

        if (txtNome.getText().isEmpty()) {
            lblNomeObrigatorio.setVisible(true);
            verifica = false;
        }
        if (txtSigla.getText().isEmpty()) {
            lblSiglaObrigatorio.setVisible(true);
            verifica = false;
        }

        return verifica;

    }

    private void salvar(Departamento departamento) throws Exception {

        departamento.setNome(txtNome.getText());
        departamento.setSigla(txtSigla.getText());

        try {
           // NegocioP.salvar(departamento);
            NegociosEstaticos.getNegocioDepartamento().salvar(departamento);
            alterar = null;
           // NegocioP = null;
            Parent root;
            LerProperties ler = new LerProperties();
            Properties prop = ler.getProp();
            alerta(AlertType.INFORMATION, prop.getProperty("msg.cadastro.confirmacao"), prop.getProperty("msg.cadastro.sucesso"));
            root = FXMLLoader.load(ConsultarPessoaController.class.getClassLoader().getResource("fxml/cadastro/Consulta/Consultar_Departamento.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            LerProperties ler = new LerProperties();
            Properties prop = ler.getProp();
            alerta(AlertType.ERROR, prop.getProperty("msg.cadastro.erro"), ex.getMessage());
        }
    }

    private void completar() {
        LerProperties ler = new LerProperties();

        txtNome.setText(alterar.getNome());
        txtSigla.setText(alterar.getSigla());
        try {
            Properties prop = ler.getProp();
            Title.setText(prop.getProperty("title.alterar.pessoa"));
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }

}
