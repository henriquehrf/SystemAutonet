/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import java.io.IOException;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Henrique
 */
public class Alertas {

    public void alerta(Alert.AlertType TipoAviso, String cabecalho, String msg) {
        try {
            LerProperties ler = new LerProperties();

            Properties prop = ler.getProp();
            Alert alert = new Alert(TipoAviso);
            alert.setTitle(cabecalho);
            alert.setHeaderText(null);
            alert.setContentText(msg);

            alert.showAndWait();

        } catch (Exception ex) {
            alerta(Alert.AlertType.ERROR, ex.getMessage(), "ERRO");
        }

    }

    public boolean alerta(Alert.AlertType TipoAviso, String cabecalho, String msg,String Opcao1,String Opcao2) {

        if (TipoAviso.equals(Alert.AlertType.CONFIRMATION)) {
            Alert alert = new Alert(TipoAviso);
            alert.setTitle(cabecalho);
            alert.setHeaderText(null);
            alert.setContentText(msg);

            ButtonType buttonTypeSIM = new ButtonType(Opcao1);
            ButtonType buttonTypeNAO = new ButtonType(Opcao2);

            alert.getButtonTypes().setAll(buttonTypeSIM, buttonTypeNAO);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeSIM) {
                return true;
            } else {
                return false;
            }

        }
        return false;
    }

}