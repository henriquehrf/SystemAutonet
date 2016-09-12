/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.emprestimo.acompanhar;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Henrique
 */
public class AcompanharEmprestimoController implements Initializable {

    @FXML
    private Button btnAnalisar;

    @FXML
    private Tab tabBuscarMaterial;

    @FXML
    private Button btnVoltar;

    @FXML
    private TableView<?> tblPrincipalBuscarMaterial;

    @FXML
    private TableColumn<?, ?> tbcDescricaoBusca;

    @FXML
    private TableColumn<?, ?> tbcQuantidadeBusca;

    @FXML
    void btnAnalisarOnAction(ActionEvent event) {

    }

    @FXML
    void btnCancelarOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog with Custom Actions");
        alert.setHeaderText("Look, a Confirmation Dialog with Custom Actions");
        alert.setContentText("Choose your option.");

        ButtonType buttonTypeOne = new ButtonType("One");
        ButtonType buttonTypeTwo = new ButtonType("Two");

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            // ... user chose "One"
        } else if (result.get() == buttonTypeTwo) {
        }
        
            // TODO
        }

    }
