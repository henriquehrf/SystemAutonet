package controller;

import gui.SystemAutonet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import controller.cadastro.Consulta.*;
import javafx.scene.Parent;

public class PrincipalController {

    @FXML
    private MenuItem cad_material;

    @FXML
    private Menu mnu_estoque;

    @FXML
    private MenuItem est_entradaMaterial;

    @FXML
    private MenuItem cad_tipoBaixa;

    @FXML
    private MenuItem est_baixarMaterial;

    @FXML
    private BorderPane bdp_principal;

    @FXML
    private MenuItem cad_local;

    @FXML
    private MenuItem emp_acompanhar;

    @FXML
    private MenuItem ajuda_sobre;

    @FXML
    private Menu mnu_emprestimo;

    @FXML
    private MenuBar mnu_bar;

    @FXML
    private MenuItem cad_departamento;

    @FXML
    private MenuItem cons_material;

    @FXML
    private MenuItem cons_pessoa;

    @FXML
    private MenuItem ajuda_manualSistema;

    @FXML
    private Menu mnu_ajuda;

    @FXML
    private MenuItem cad_pessoa;

    @FXML
    private MenuItem cons_local;

    @FXML
    private MenuItem cad_unidadeMedida;

    @FXML
    private Menu mnu_consulta;

    @FXML
    private Menu cons_mnu_Movimetacoes;

    @FXML
    private MenuItem cons_fornecedor;

    @FXML
    private MenuItem emp_analisar;

    @FXML
    private MenuItem cons_mov_saidaMaterial;

    @FXML
    private MenuItem cad_fornecedor;

    @FXML
    private MenuItem cons_emprestimo;

    @FXML
    private MenuItem emp_solicitar;

    @FXML
    private MenuItem cons_mov_entradaMaterial;

    @FXML
    private MenuItem emp_devolver;

    @FXML
    private Menu mnu_Cadastro;

    public void initialize() {

    }

    @FXML
    void cad_departamentoOnAction(ActionEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(ConsultarDepartamentoController.class.getClassLoader().getResource("fxml/cadastro/Consulta/Consultar_Departamento.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @FXML
    void cad_fornecedorOnAction(ActionEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(ConsultarFornecedorController.class.getClassLoader().getResource("fxml/cadastro/Consulta/Consultar_Fornecedor.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @FXML
    void cad_local_OnAction(ActionEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(ConsultarLocaisController.class.getClassLoader().getResource("fxml/cadastro/Consulta/Consultar_Locais.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @FXML
    void cad_materialOnAction(ActionEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(ConsultarMaterialController.class.getClassLoader().getResource("fxml/cadastro/Consulta/Consultar_Material.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @FXML
    void cad_pessoaOnAction(ActionEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(ConsultarPessoaController.class.getClassLoader().getResource("fxml/cadastro/Consulta/Consultar_Pessoa.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @FXML
    void cad_tipoBaixaOnAction(ActionEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(ConsultarTipoSaidaController.class.getClassLoader().getResource("fxml/cadastro/Consulta/Consultar_TipoSaida.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @FXML
    void cad_unidadeMedidaOnAction(ActionEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(ConsultarUnidadeMedidaController.class.getClassLoader().getResource("fxml/cadastro/Consulta/Consultar_UnidadeMedida.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @FXML
    void emp_solicitarOnAction(ActionEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(ConsultarUnidadeMedidaController.class.getClassLoader().getResource("fxml/emprestimo/solicita/SolicitaEmprestimo.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @FXML
    void emp_analisarOnAction(ActionEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(ConsultarUnidadeMedidaController.class.getClassLoader().getResource("fxml/emprestimo/Analisar/AnalisarEmprestimo.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @FXML
    void emp_acompanharOnAction(ActionEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(ConsultarUnidadeMedidaController.class.getClassLoader().getResource("fxml/emprestimo/Acompanhar/AcompanharEmprestimo.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

}
