/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import classesAuxiliares.ClasseDoSistemaEstatico;
import classesAuxiliares.NegociosEstaticos;
import controller.PrincipalController;
import static gui.SystemAutonet.SCENE;
import java.awt.Event;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vo.Pessoa;

/**
 * FXML Controller class
 *
 * @author Henrique
 */
public class LoginController {

    @FXML
    private Label labelUsuarioAlerta;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Button btnLogin;

    @FXML
    private Label labelSenhaAlerta;

    @FXML
    private Label lblautenticacao;

    @FXML
    private Button btnCancelar;

    @FXML
    private TextField txtUsuario;

    private boolean autenticar() {
        labelSenhaAlerta.setVisible(false);
        labelUsuarioAlerta.setVisible(false);
        lblautenticacao.setVisible(false);

        Pessoa user = new Pessoa();
        Pessoa otherUser = null;
        user.setUsuario(txtUsuario.getText());
        user.setSenha(txtSenha.getText());
        try {
            otherUser = NegociosEstaticos.getNegocioPessoa().buscarPorUsuario(user);
            if (otherUser.getId() != null) {
                if (otherUser.getSenha().equals(txtSenha.getText())) {
                    ClasseDoSistemaEstatico.setPessoa(otherUser);
                    return true;
                } else {
                    lblautenticacao.setText("*Senha Inválida");
                    labelSenhaAlerta.setVisible(true);
                    lblautenticacao.setVisible(true);
                    return false;
                }
            } else {
                lblautenticacao.setText("Usuário não encontrado");
                labelSenhaAlerta.setVisible(true);
                lblautenticacao.setVisible(true);
                return false;
            }

        } catch (Exception ex) {
            lblautenticacao.setText("Usuário Inválido");
            labelUsuarioAlerta.setVisible(true);
            lblautenticacao.setVisible(true);
            System.out.println("erro");
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        if (autenticar()) {

            BorderPane root = null;
            try {
                root = FXMLLoader.load(PrincipalController.class.getClassLoader().getResource("fxml/Principal.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
            Scene scene = new Scene(root);
            SystemAutonet.SCENE = scene;
            SystemAutonet.login.setScene(scene);
            SystemAutonet.login.centerOnScreen();
        }
    }

    @FXML
    void btnCancelarOnAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void txtUsuarioOnKeyPressed(KeyEvent event) {
        habilitarLogin();
        labelUsuarioAlerta.setVisible(false);
        lblautenticacao.setVisible(false);
        labelSenhaAlerta.setVisible(false);
    }

    void habilitarLogin() {
        if (!txtSenha.getText().isEmpty()) {
            if (!txtUsuario.getText().isEmpty()) {
                btnLogin.setDisable(false);
                btnLogin.setDefaultButton(true);
            }
        } else {
            btnLogin.setDisable(true);
        }
    }

    @FXML
    void txtSenhaonKeyPressed(KeyEvent event) {
        habilitarLogin();
            labelUsuarioAlerta.setVisible(false);
            lblautenticacao.setVisible(false);
            labelSenhaAlerta.setVisible(false);
    }

    public void initialize() {
        NegociosEstaticos.iniciar();
        labelSenhaAlerta.setVisible(false);
        labelUsuarioAlerta.setVisible(false);
        btnLogin.setDisable(true);
        lblautenticacao.setVisible(false);
    }

}
