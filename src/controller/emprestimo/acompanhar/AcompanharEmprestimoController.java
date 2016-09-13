/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.emprestimo.acompanhar;

import classesAuxiliares.ClasseDoSistemaEstatico;
import classesAuxiliares.NegociosEstaticos;
import enumm.PerfilUsuario;
import enumm.StatusEmprestimo;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import vo.Emprestimo;
import vo.EmprestimoEstoqueMaterial;
import vo.Material;
import vo.Pessoa;

/**
 * FXML Controller class
 *
 * @author Henrique
 */
public class AcompanharEmprestimoController implements Initializable {
    
    @FXML
    private Button btnImprimir;
    
    @FXML
    private Button btnVoltarDescricao;
    
    @FXML
    private DatePicker dtpFinal;
    
    @FXML
    private ComboBox<?> cbmStatus;
    
    @FXML
    private TableColumn<Material, Integer> tbcQuantidade;
    
    @FXML
    private TableView<Emprestimo> tblPrincipal;
    
    @FXML
    private TableColumn<Material, String> tbcCategoria;
    
    @FXML
    private Button btnConsultar;
    
    @FXML
    private TabPane tabPrincipal;
    
    @FXML
    private TextField txtBuscador;
    
    @FXML
    private Label lblData;
    
    @FXML
    private Label lblFinalidade;
    
    @FXML
    private Tab tabListaEmprestimo;
    
    @FXML
    private TableView<Material> tblDescricao;
    
    @FXML
    private Button btnVoltar;
    
    @FXML
    private TableColumn<Emprestimo, Enum> tbcStatus;
    
    @FXML
    private TableColumn<Emprestimo, String> tbcDtEmprestimo;
    
    @FXML
    private TableColumn<Emprestimo, String> tbcPessoa;
    
    @FXML
    private Tab tabDescricaoEmprestimo;
    
    @FXML
    private DatePicker dtpInicial;
    
    @FXML
    private Button btnBuscar;
    
    @FXML
    private Label lblObservacao;
    
    @FXML
    private TableColumn<?, ?> tbcMaterial;
    
    @FXML
    void btnConsultarOnAction(ActionEvent event) {
        
        
        if(tblPrincipal.getSelectionModel().getSelectedItem()!=null){
            tabPrincipal.getSelectionModel().select(tabDescricaoEmprestimo);
            tabListaEmprestimo.setDisable(true);
            tabDescricaoEmprestimo.setDisable(false);
            //arrumar aqui
            completarTabelaDescricao(NegociosEstaticos.getNegocioEmprestiomEstoqueMaterial().consultarListaMaterialEmprestimo(tblPrincipal.getSelectionModel().getSelectedItem()));
            System.out.println(NegociosEstaticos.getNegocioEmprestiomEstoqueMaterial().consultarListaMaterialEmprestimo(tblPrincipal.getSelectionModel().getSelectedItem()).size());
        }else{
            return;
        }
        
    }
    
    @FXML
    void btnVoltarOnAction(ActionEvent event) {
        
    }
    
    @FXML
    void btnBuscarOnAction(ActionEvent event) {
        
    }
    
    @FXML
    void dtpInicialOnAction(ActionEvent event) {
        
    }
    
    @FXML
    void dtpFinalOnAction(ActionEvent event) {
        
    }
    
    @FXML
    void cbmStatusOnAction(ActionEvent event) {
        
    }
    
    @FXML
    void btnImprimirOnAction(ActionEvent event) {
        
    }
    
    @FXML
    void btnVoltarDescricaoOnAction(ActionEvent event) {
        
    }
    
    List<Emprestimo> altertab = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tabDescricaoEmprestimo.setDisable(true);
        Pessoa p = ClasseDoSistemaEstatico.getPessoa();
        if (p.getFuncao().equals(PerfilUsuario.ADMINISTRADOR)) {
            altertab = NegociosEstaticos.getNegocioEmprestimo().buscarPorIdPessoa(p);
            System.out.println(altertab.size());
            completarTabelaPrincipal(altertab);
        }
        // TODO
    }
    
    void completarTabelaPrincipal(List<Emprestimo> emp) {
        
        ObservableList<Emprestimo> dado = FXCollections.observableArrayList();
        for (int i = 0; i < emp.size(); i++) {
            dado.add(emp.get(i));
        }
        
        this.tbcPessoa.setCellValueFactory(new PropertyValueFactory<Emprestimo, String>("Id_pessoa_solicitaNome"));
        this.tbcDtEmprestimo.setCellValueFactory(new PropertyValueFactory<Emprestimo, String>("Dt_emprestimoString"));
        this.tbcStatus.setCellValueFactory(new PropertyValueFactory<>("Status_emprestimo"));
        this.tblPrincipal.setItems(dado);
        
    }  
    void completarTabelaDescricao(List<EmprestimoEstoqueMaterial> mat){
        
         ObservableList<Material> dado = FXCollections.observableArrayList();
//        for (int i = 0; i < mat.size(); i++) {
//            dado.add(mat.get(i));
//            System.out.println(mat.get(i).getDescricao());
//        }
            System.out.println(mat.get(0).getId_material().getDescricao());
            System.out.println(mat.get(0).getId_material().getQuantidadeSolicitada());
            System.out.println(mat.get(0).getId_material().getQuantidade());
            System.out.println(mat.get(0).getId_material().getQuantidadeDisponivel());
        this.tbcMaterial.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        this.tblDescricao.setItems(dado);
        
    }
}
