/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cadastro.Consulta;

import classesAuxiliares.NegociosEstaticos;
import controller.PrincipalController;
import controller.cadastro.Cadastro.CadastroCategoriaController;
import gui.SystemAutonet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import utilitarios.Alertas;
import vo.Categoria;

/**
 *
 * @author Henrique
 */
public class ConsultarCategoriaController {

    @FXML
    private Button btnVoltar;

    @FXML
    private TableView<Categoria> tblPrincipal;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnInserir;

    @FXML
    private Label Title;

    @FXML
    private Button btnExcluir;

    @FXML
    private TextField txtBuscador;

    @FXML
    private TableColumn<Categoria, String> tbcDescricao;

    @FXML
    private Button btnBuscar;

    @FXML
    void btnVoltar_OnAction(ActionEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(PrincipalController.class.getClassLoader().getResource("fxml/Principal.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @FXML
    void btnInserir_OnAction(ActionEvent event) {
        CadastroCategoriaController.setCadastrar(true);

        try {
            Parent root;
            root = FXMLLoader.load(CadastroCategoriaController.class.getClassLoader().getResource("fxml/cadastro/Cadastro/Cadastro_Categoria.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @FXML
    void btnAlterar_OnAction(ActionEvent event) {
        Categoria p = tblPrincipal.getSelectionModel().getSelectedItem();

        CadastroCategoriaController.setCadastrar(false);
        CadastroCategoriaController.setAlterar(p);
        try {
            Parent root;
            root = FXMLLoader.load(CadastroCategoriaController.class.getClassLoader().getResource("fxml/cadastro/Cadastro/Cadastro_Categoria.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @FXML
    void btnExcluir_OnAction(ActionEvent event) {
        try {
            NegociosEstaticos.getNegocioCategoria().remover(tblPrincipal.getSelectionModel().getSelectedItem());
            completarTabela(NegociosEstaticos.getNegocioCategoria().bucarTodos());
        } catch (Exception ex) {
            Alertas alert = new Alertas();
            alert.alerta(Alert.AlertType.ERROR, "Erro na remoção", ex.getMessage());
        }
    }

    @FXML
    void btnBuscar_OnAction(ActionEvent event) {
        Categoria cat = new Categoria();
        cat.setDescricao(txtBuscador.getText());
        completarTabela(NegociosEstaticos.getNegocioCategoria().buscarPorDescricao(cat));
    }

    public void initialize() {
        List<Categoria> lista = NegociosEstaticos.getNegocioCategoria().bucarTodos();

        completarTabela(lista);
    }

    private void completarTabela(List<Categoria> lista) {

        ObservableList<Categoria> dado = FXCollections.observableArrayList();
        for (int i = 0; i < lista.size(); i++) {
            dado.add(lista.get(i));
        }
        this.tbcDescricao.setCellValueFactory(new PropertyValueFactory<Categoria, String>("descricao"));

        this.tblPrincipal.setItems(dado);

    }

}
