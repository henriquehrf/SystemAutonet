/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cadastro.Cadastro;

import classesAuxiliares.NegociosEstaticos;
import controller.PrincipalController;
import controller.cadastro.Consulta.ConsultarCategoriaController;
import controller.cadastro.Consulta.ConsultarUnidadeMedidaController;
import gui.SystemAutonet;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utilitarios.Alertas;
import utilitarios.LerProperties;
import vo.Categoria;

/**
 * FXML Controller class
 *
 * @author Henrique
 */
public class CadastroCategoriaController implements Initializable {

    @FXML
    private TextField txtCategoria;

    @FXML
    private Label lblCategoriaObrigatorio;

    @FXML
    private Button btnCancelar;

    @FXML
    private Label Title;

    @FXML
    private Button btnsalvar;

    private static Categoria alterar;

    private static boolean cadastrar;

    public static Categoria getAlterar() {
        return alterar;
    }

    public static void setAlterar(Categoria alterar) {
        CadastroCategoriaController.alterar = alterar;
    }

    public static boolean isCadastrar() {
        return cadastrar;
    }

    public static void setCadastrar(boolean cadastrar) {
        CadastroCategoriaController.cadastrar = cadastrar;
    }

    @FXML
    void btnsalvar_OnAction(ActionEvent event) {
        if (verificaCampoObrigatorio()) {

            try {
                if (alterar != null) {
                    System.out.println("caso 1");
                    salvar(alterar);
                } else {
                    Categoria categoria = new Categoria();
                    System.out.println("caso 2");
                    salvar(categoria);

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
            root = FXMLLoader.load(ConsultarCategoriaController.class.getClassLoader().getResource("fxml/cadastro/Consulta/Consultar_Categoria.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setcamposObrigatorio();

        if (!isCadastrar()) {
            completar();
        } else {
            alterar = null;
        }

    }

    private void setcamposObrigatorio() {
        lblCategoriaObrigatorio.setVisible(false);
    }

    private void completar() {
        txtCategoria.setText(alterar.getDescricao());
        LerProperties ler = new LerProperties();
        try {
            Properties prop = ler.getProp();
            Title.setText(prop.getProperty("title.alterar.categoria"));
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

    private boolean verificaCampoObrigatorio() {
        setcamposObrigatorio();
        boolean verifica = true;

        if (txtCategoria.getText().isEmpty()) {
            lblCategoriaObrigatorio.setVisible(true);
            verifica = false;
        }
        return verifica;

    }

    private void salvar(Categoria categoria) throws Exception {
        categoria.setDescricao(txtCategoria.getText());

        try {
            //   NegocioP.salvar(pessoa);
            NegociosEstaticos.getNegocioCategoria().salvar(categoria);
            Parent root;
            LerProperties ler = new LerProperties();
            Properties prop = ler.getProp();
            // NegocioP = null;
            alterar = null;

            alerta(AlertType.INFORMATION, prop.getProperty("msg.cadastro.confirmacao"), prop.getProperty("msg.cadastro.sucesso"));
            root = FXMLLoader.load(CadastroCategoriaController.class.getClassLoader().getResource("fxml/cadastro/Consulta/Consultar_Categoria.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            LerProperties ler = new LerProperties();
            Properties prop = ler.getProp();
            System.out.println("estou aqui ");
            alerta(AlertType.ERROR, prop.getProperty("msg.cadastro.erro"), ex.getMessage());
        }

    }

}
