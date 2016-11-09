/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cadastro.Cadastro;

import classesAuxiliares.NegociosEstaticos;
import controller.cadastro.Consulta.ConsultarTipoSaidaController;
import gui.SystemAutonet;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import negocio.NegocioTipoSaida;
import utilitarios.LerProperties;
import vo.TipoSaida;

/**
 *
 * @author PET Autonet
 */
public class CadastroTipoSaidaController {

    @FXML
    private Label Title;

    @FXML
    private TextField txtfinalidade;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnsalvar;

    @FXML
    private Label lblfinalidadeobrigatorio;

 //   private NegocioTipoSaida NegocioT;

    private static TipoSaida alterar;

    private static boolean cadastrar;

    public static TipoSaida getAlterar() {
        return alterar;
    }

    public static void setAlterar(TipoSaida alterar) {
        CadastroTipoSaidaController.alterar = alterar;
    }

    public static boolean isCadastrar() {
        return cadastrar;
    }

    public static void setCadastrar(boolean cadastrar) {
        CadastroTipoSaidaController.cadastrar = cadastrar;
    }

    public void initialize() {
      //  NegocioT = new NegocioTipoSaida();
      
        setcamposObrigatorio();

        if (!isCadastrar()) {
            completar();
        } else {
            alterar = null;
        }

    }

    @FXML
    void btnsalvar_OnAction(ActionEvent event) throws Exception {
        if (verificaCampoObrigatorio()) {
            if (alterar != null) {
                salvar(alterar);
            } else {
                TipoSaida ts = new TipoSaida();
                salvar(ts);
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
           // NegocioT = null;
            alterar = null;
            root = FXMLLoader.load(ConsultarTipoSaidaController.class.getClassLoader().getResource("fxml/cadastro/Consulta/Consultar_TipoSaida.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void setcamposObrigatorio() {
        lblfinalidadeobrigatorio.setVisible(false);
    }

    private boolean verificaCampoObrigatorio() {
        setcamposObrigatorio();
        boolean verifica = true;
        if (txtfinalidade.getText().isEmpty()) {
            lblfinalidadeobrigatorio.setVisible(true);
            verifica = false;
        }
        return verifica;
    }

    private void salvar(TipoSaida ts) throws Exception {

        ts.setDescricao(txtfinalidade.getText());

        try {
           // NegocioT.salvar(ts);
            NegociosEstaticos.getNegocioTipoSaida().salvar(ts);
            alterar = null;
           
            Parent root;
            LerProperties ler = new LerProperties();
            Properties prop = ler.getProp();
         //   NegocioT = null;
            alerta(AlertType.INFORMATION, prop.getProperty("msg.cadastro.confirmacao"), prop.getProperty("msg.cadastro.sucesso"));
            root = FXMLLoader.load(ConsultarTipoSaidaController.class.getClassLoader().getResource("fxml/cadastro/Consulta/Consultar_TipoSaida.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            LerProperties ler = new LerProperties();
            Properties prop = ler.getProp();
            alerta(AlertType.ERROR, prop.getProperty("msg.cadastro.erro"), ex.getMessage());
        }
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

    private void completar() {
        txtfinalidade.setText(alterar.getDescricao());

        try {
            LerProperties ler = new LerProperties();
            Properties prop = ler.getProp();
            Title.setText(prop.getProperty("title.alterar.TipoSaida"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
