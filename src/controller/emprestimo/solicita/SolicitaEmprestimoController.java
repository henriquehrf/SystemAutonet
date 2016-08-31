/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.emprestimo.solicita;

import classesAuxiliares.ClasseDoSistemaEstatico;
import classesAuxiliares.NegociosEstaticos;
import controller.PrincipalController;
import controller.cadastro.Consulta.ConsultarFornecedorController;
import enumm.StatusEmprestimo;
import gui.SystemAutonet;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import vo.Emprestimo;
import vo.EmprestimoEstoqueMaterial;
import vo.EstoqueMaterial;
import vo.Material;

/**
 * FXML Controller class
 *
 * @author Henrique
 */
public class SolicitaEmprestimoController {

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnAdicionarMaterial;

    @FXML
    private TabPane tabPanePrincipal;

    @FXML
    private TableView<Material> tblBuscaMateriais;

    @FXML
    private Button btnExclur;

    @FXML
    private TableColumn<Material, String> tbcCategoriaListaMaterial;

    @FXML
    private TableView<Material> tblListaMateriais;

    @FXML
    private TextField txtFinalidade;

    @FXML
    private TableColumn<Material, String> tbcMaterialBuscaMaterial;

    @FXML
    private TableColumn<Material, String> tbcDescricaoListaMaterial;

    @FXML
    private TextField txtBuscador;

    @FXML
    private Button btnEditar;

    @FXML
    private Tab tabListaMaterial;

    @FXML
    private TableColumn<Material, Integer> tbcQuantidadeDisponivelBuscaMaterial;

    @FXML
    private TableColumn<Material, Integer> tbcQuantidadeSolicitadaListaMaterial;

    @FXML
    private Tab tabBuscarMaterial;

    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnCancelar;

    @FXML
    private TextArea txtObservacao;

    @FXML
    private Label finalidadeObrigatorio;

    @FXML
    private DatePicker dtpDataEmprestimo;

    @FXML
    private Label dataObrigatorio;

    @FXML
    private TableColumn<Material, String> tbcCategoriaBuscaMaterial;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnSolicitar;

    ObservableList<Material> altertab = FXCollections.observableArrayList();

    @FXML
    void btnSolicitarOnAction(ActionEvent event) {

        if (tblListaMateriais.getItems() == null) {
            return;
        }

        Date data = new Date();
        Emprestimo emp = new Emprestimo();
        emp.setDt_emprestimo(data);
        emp.setFinalidade("sei lá");
        emp.setObservacao("juju Delicia sqn");
        emp.setStatus_emprestimo(StatusEmprestimo.APROVADO);

        emp.setId_pessoa_solicita(ClasseDoSistemaEstatico.getPessoa());
        System.out.println("O Nome aqui Carai" + ClasseDoSistemaEstatico.getPessoa().getNome());
        try {
            emp = NegociosEstaticos.getNegocioEmprestimo().salvar(emp);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(emp.getId());

        for (int i = 0; i < altertab.size(); i++) {
            EmprestimoEstoqueMaterial eem = new EmprestimoEstoqueMaterial();
            eem.setDt_devolucao(data);// obs rever este ponto
            eem.setId_emprestimo(emp);
            eem.setObservacao("dsada");
            eem.setQtd_emprestada(2);
            eem.setQtd_devolvida(2);
            eem.setId_material(altertab.get(i));
            eem.setId_emprestimo(emp);
            
            EstoqueMaterial est = new EstoqueMaterial();
      
            
            try {
                NegociosEstaticos.getNegocioEmprestiomEstoqueMaterial().salvar(eem);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }

//        NegociosEstaticos.getNegocioEmprestiomEstoqueMaterial().salvar(eem);
//        EmprestimoEstoqueMaterial emp = new EmprestimoEstoqueMaterial();
    }

    @FXML
    void btnCancelarOnAction(ActionEvent event) {

        try {
            Parent root;
            root = FXMLLoader.load(PrincipalController.class.getClassLoader().getResource("fxml/Principal.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @FXML
    void btnVoltarOnAction(ActionEvent event) {

        tabBuscarMaterial.setDisable(false);
        tabListaMaterial.setDisable(true);
        tabPanePrincipal.getSelectionModel().select(tabBuscarMaterial);

    }

    @FXML
    void btnAdicionarOnAction(ActionEvent event) {
        tabListaMaterial.setDisable(false);
        tabPanePrincipal.getSelectionModel().select(tabListaMaterial);
        tabBuscarMaterial.setDisable(true);

    }

    @FXML
    void btnAdicionarMaterialOnAction(ActionEvent event) {

        // fazer o tratamento da seleção
        altertab.add(tblBuscaMateriais.getSelectionModel().getSelectedItem());

        tblListaMateriais.setItems(altertab);
        completar_ListaMaterial(altertab);
        btnVoltarOnAction(event);

    }

    void completar_ListaMaterial(List<Material> list) {

        this.tbcCategoriaListaMaterial.setCellValueFactory(new PropertyValueFactory<Material, String>("CategoriaNome"));
        this.tbcDescricaoListaMaterial.setCellValueFactory(new PropertyValueFactory<Material, String>("descricao"));
        this.tbcQuantidadeSolicitadaListaMaterial.setCellValueFactory(new PropertyValueFactory<Material, Integer>("quantidadeDisponivel"));
        tblListaMateriais.setItems(altertab);
    }

    @FXML
    void btnEditarOnAction(ActionEvent event) {

    }

    @FXML
    void btnExclurOnAction(ActionEvent event) {

    }

    @FXML
    void btnBuscarOnAction(ActionEvent event) {

    }

    private void completarTabela(List<Material> lista) {

        ObservableList<Material> dado = FXCollections.observableArrayList();
        for (int i = 0; i < lista.size(); i++) {
            dado.add(lista.get(i));
        }
        this.tbcCategoriaBuscaMaterial.setCellValueFactory(new PropertyValueFactory<Material, String>("CategoriaNome"));
        this.tbcMaterialBuscaMaterial.setCellValueFactory(new PropertyValueFactory<Material, String>("descricao"));
        this.tbcQuantidadeDisponivelBuscaMaterial.setCellValueFactory(new PropertyValueFactory<Material, Integer>("quantidadeDisponivel"));
        this.tblBuscaMateriais.setItems(dado);

    }

    public void initialize() {
        List<Material> lista = NegociosEstaticos.getNegocioMaterial().buscarTodos();
        completarTabela(lista);

        tabListaMaterial.setDisable(true);
        dataObrigatorio.setVisible(false);
        finalidadeObrigatorio.setVisible(false);
    }

}
