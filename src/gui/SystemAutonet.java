/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import classesAuxiliares.ClasseDoSistemaEstatico;
import classesAuxiliares.NegociosEstaticos;
import controller.PrincipalController;
import controller.cadastro.Consulta.ConsultarDepartamentoController;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;
import vo.Emprestimo;
import vo.EmprestimoEstoqueMaterial;
import vo.Pessoa;

/**
 *
 * @author Henrique
 */
public class SystemAutonet extends Application {

    public static Scene SCENE;

    @Override
    public void start(Stage stage) throws Exception {
        NegociosEstaticos.iniciar();

        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Bem vindo ao SystemAutonet");
        dialog.setHeaderText("Seja bem vindo ao sistema SystemAutonet");
        //dialog.setContentText("Forneça um usuário e senha válido para realizar o acesso ao sistema");
        // stage.getIcons().add(new Image("/utilitarios/icones/icone.png"));
        ImageView image = new ImageView(this.getClass().getResource("/utilitarios/icones/networking.png").toString());
        dialog.setGraphic(image);
        ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("Usuário");
        PasswordField password = new PasswordField();
        password.setPromptText("Senha");

        grid.add(new Label("Usuário:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Senha:"), 0, 1);
        grid.add(password, 1, 1);
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);
        username.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

        Platform.runLater(() -> username.requestFocus());

// Convert the result to a username-password-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(username.getText(), password.getText());
            }
            System.exit(0);
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();
        boolean cond = true;
        // Ajustar nesta parte do login
        if (result.isPresent()) {
            Pessoa user = new Pessoa();
            Pessoa otherUser = new Pessoa();
            user.setUsuario(result.get().getKey());
            user.setSenha(result.get().getValue());
            user.setId_pessoa(1L);
            otherUser = NegociosEstaticos.getNegocioPessoa().consultarPorId(user);
            ClasseDoSistemaEstatico.setPessoa(otherUser);
        }
        Parent pane = null;

        try {

            pane = FXMLLoader.load(PrincipalController.class.getClassLoader().getResource("fxml/Principal.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        Scene scene = new Scene(pane, 800, 600);

        stage.setResizable(false);
        SCENE = scene;

        stage.setTitle("SystemAutonet - Sistema de Controle Simplificado");
        stage.getIcons().add(new Image("/utilitarios/icones/icone.png"));

        stage.setScene(scene);

        stage.show();

    }

    public static void main(String[] args) {

        launch(args);
    }
}
