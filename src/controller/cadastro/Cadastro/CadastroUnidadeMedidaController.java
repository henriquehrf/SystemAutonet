/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cadastro.Cadastro;

import controller.cadastro.Consulta.ConsultarUnidadeMedidaController;
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
import negocio.NegocioTipoUnidade;
import utilitarios.LerProperties;
import vo.TipoUnidade;

/**
 *
 * @author PET Autonet
 */
public class CadastroUnidadeMedidaController {

    @FXML
    private Button btnSalvar;

    @FXML
    private Label Title;

    @FXML
    private Button btnCancelar;

    @FXML
    private Label lbldescricaoOrbrigatorio;

    @FXML
    private Label lblSiglaobrigatorio;

    @FXML
    private TextField txtdescricao;

    @FXML
    private TextField txtsigla;

    private NegocioTipoUnidade NegocioT;

    private static TipoUnidade alterar;

    private static boolean cadastrar;

    public static TipoUnidade getAlterar() {
        return alterar;
    }

    public static void setAlterar(TipoUnidade alterar) {
        CadastroUnidadeMedidaController.alterar = alterar;
    }

    public static boolean isCadastrar() {
        return cadastrar;
    }

    public static void setCadastrar(boolean cadastrar) {
        CadastroUnidadeMedidaController.cadastrar = cadastrar;
    }

    public void initialize() {
        NegocioT = new NegocioTipoUnidade();
        setcamposObrigatorio();

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
                    TipoUnidade ts = new TipoUnidade();
                    salvar(ts);
                }
            } catch (Exception ex) {
                LerProperties ler = new LerProperties();
                Properties prop;
                try {
                    prop = ler.getProp();
                    alerta(AlertType.ERROR, prop.getProperty("msg.cadastro.erro"), ex.getMessage());
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
            NegocioT = null;
            alterar = null;
            root = FXMLLoader.load(ConsultarUnidadeMedidaController.class.getClassLoader().getResource("fxml/cadastro/Consulta/Consultar_UnidadeMedida.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void setcamposObrigatorio() {
        lblSiglaobrigatorio.setVisible(false);
        lbldescricaoOrbrigatorio.setVisible(false);
    }

    private void completar() {

        txtdescricao.setText(alterar.getDescricao());
        txtsigla.setText(alterar.getSigla());

        try {
            LerProperties ler = new LerProperties();
            Properties prop = ler.getProp();
            Title.setText(prop.getProperty("title.alterar.tipounidade"));
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

    private void salvar(TipoUnidade ts) throws Exception {

        ts.setDescricao(txtdescricao.getText());
        ts.setSigla(txtsigla.getText());

        try {
            NegocioT.salvar(ts);
            alterar = null;
            Parent root;
            LerProperties ler = new LerProperties();
            Properties prop = ler.getProp();
            NegocioT = null;
            alerta(AlertType.INFORMATION, prop.getProperty("msg.cadastro.confirmacao"), prop.getProperty("msg.cadastro.sucesso"));
            root = FXMLLoader.load(ConsultarUnidadeMedidaController.class.getClassLoader().getResource("fxml/cadastro/Consulta/Consultar_UnidadeMedida.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            LerProperties ler = new LerProperties();
            Properties prop = ler.getProp();
            alerta(AlertType.ERROR, prop.getProperty("msg.cadastro.erro"), ex.getMessage());
        }
    }

    private boolean verificaCampoObrigatorio() {
        setcamposObrigatorio();
        boolean verifica = true;
        if (txtdescricao.getText().isEmpty()) {
            lbldescricaoOrbrigatorio.setVisible(true);
            verifica = false;
        }
        if (txtsigla.getText().isEmpty()) {
            lblSiglaobrigatorio.setVisible(true);
            verifica = false;
        }
        return verifica;
    }
}
