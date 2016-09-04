/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.estoque.entrada;

import controller.PrincipalController;
import gui.SystemAutonet;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;
import utilitarios.mock.auxiliar.EntradaMaterial;
import vo.Fornecedor;
import vo.Local;
import vo.Material;

/**
 * FXML Controller class
 *
 * @author Henrique
 */
public class EntradaMaterialController implements Initializable {

    @FXML
    private TabPane TabPai;

    @FXML
    private RadioButton rdbPessoaResponsavelFornecedor;

    @FXML
    private Button btnDarEntrada;

    @FXML
    private Button btnVoltarBuscarFornecedor;

    @FXML
    private Button btnAdicionarFornecedor;
    @FXML
    private Button btncancelarEntrada;

    @FXML
    // arrumar
    private TableView<EntradaMaterial> tblEntradaMaterial;

    @FXML
    private Tab tabMaterial;

    @FXML
    private TextField txtValorNF;

    @FXML
    private TextField txtCNPJ;

    @FXML
    private TableColumn<Fornecedor, String> tbcPessoaResponsavel;

    @FXML
    private TextField txtBuscadorLocal;

    @FXML
    private TableColumn<EntradaMaterial, String> tbcMaterial;

    @FXML
    private RadioButton rdbNumeroLocal;

    @FXML
    private TableColumn<EntradaMaterial, Float> tbcValorUnitario;

    @FXML
    private Button btnBuscarMaterial;

    @FXML
    private TableColumn<EntradaMaterial, Integer> tbcQtd;

    @FXML
    private TextField txtValorMaterialTotalGeral;

    @FXML
    private TextField txtQtdMaterial;

    @FXML
    private Tab tabLocal;

    @FXML
    private TableColumn<Local, Integer> tbcNumeroBuscarLocal;

    @FXML
    private TableColumn<Local, String> tbcPessoaResponsavelBuscarLocal;

    @FXML
    private TableColumn<Fornecedor, String> tbcNomeFantasia;

    @FXML
    private Button btnEditarFornecedor;

    @FXML
    private DatePicker dtEntrada;

    @FXML
    private Button btnAdicionarBuscarFornecedor;

    @FXML
    private RadioButton rdbRazaoSocialFornecedor;

    @FXML
    private TableColumn<Material, Integer> tbcQuantidadeBuscaMaterial;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnVoltarBuscaMaterial;

    @FXML
    private TextField txtFornecedor;

    @FXML
    private Tab tabEntrada;

    @FXML
    private ToggleGroup FiltroLocal;

    @FXML
    private TableView<Local> tblBuscarLocal;

    @FXML
    private Button btnEditarTabelaEntrada;

    @FXML
    private ToggleGroup Filtro;

    @FXML
    private TextField txtNumNF;

    @FXML
    private TableView<Fornecedor> tblBuscarFornecedor;

    @FXML
    private TableColumn<EntradaMaterial, String> tbcLocal;

    @FXML
    private Button btnVoltarBuscarLocal;

    @FXML
    private RadioButton rdbNomeFantasiaFornecedor;

    @FXML
    private TableView<Material> tblBuscaMaterial;

    @FXML
    private Button btnAdicionarTabelaEntrada;

    @FXML
    private TextField txtBuscadorMaterial;

    @FXML
    private TableColumn<Local, String> tbcDescricaoBuscarLocal;

    @FXML
    private Button btnAdicionarBuscaMaterial;

    @FXML
    private Button btnBuscarLocal;

    @FXML
    private RadioButton rdbDescricaoLocal;

    @FXML
    private TableColumn<Material, String> tbcMaterialBuscaMaterial;

    @FXML
    private TableColumn<Fornecedor, String> tbcRazaoSocial;

    @FXML
    private TableColumn<EntradaMaterial, Float> tbcValorTotal;

    @FXML
    private Tab tabFornecedor;

    @FXML
    private Button btnRemoverTabelaEntrada;

    @FXML
    private Button btnAdicionarBuscarLocal;

    @FXML
    private TextField txtBuscadorFornecedor;

    @FXML
    private RadioButton rdbPessoaRespBuscaLocal;

    @FXML
    private TableColumn<Fornecedor, String> tbcCNPJ;

    @FXML
    private TableColumn<EntradaMaterial, Float> tbcValorMaterial;

    @FXML
    private TableColumn<Material, String> tbcCategoriaBuscaMaterial;

    @FXML
    private RadioButton rdbCNPJFornecedor;

    // Ajusta este campo para o VO
    ArrayList<EntradaMaterial> Itens = new ArrayList<>();
    EntradaMaterial ent = new EntradaMaterial();

    @FXML
    void btnDarEntradaOnAction(ActionEvent event) {

        // habilitar o banco de dados
        try {
            Parent root;
            root = FXMLLoader.load(PrincipalController.class.getClassLoader().getResource("fxml/Principal.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @FXML
    void btnAdicionarFornecedorOnAction(ActionEvent event) {

        tabFornecedor.setDisable(false);
        tabEntrada.setDisable(true);
        TabPai.getSelectionModel().select(tabFornecedor);

    }

    @FXML
    void btnEditarFornecedorOnAction(ActionEvent event) {
        btnAdicionarFornecedorOnAction(event);

    }

    @FXML
    void btnAdicionarTabelaEntradaOnAction(ActionEvent event) {

        TabPai.getSelectionModel().select(tabMaterial);
        tabEntrada.setDisable(true);
        tabMaterial.setDisable(false);

    }

    private boolean DadosEntrada() {

        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Dados para entrada do material");
        dialog.setHeaderText("Forneça os dados necessários para a entrada do material");

// Set the button types.
        ButtonType loginButtonType = new ButtonType("OK", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        // Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("Qtd.");
        TextField password = new TextField();
        password.setPromptText("Valor");

        grid.add(new Label("Quantidade:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Valor:"), 0, 1);
        grid.add(password, 1, 1);

        // Enable/Disable login button depending on whether a username was entered.
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

// Do some validation (using the Java 8 lambda syntax).
        username.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

// Request focus on the username field by default.
        Platform.runLater(() -> username.requestFocus());

// Convert the result to a username-password-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(username.getText(), password.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();

        //   result.ifPresent(usernamePassword 
        if (result.isPresent()) {
            ent.setQtd_entrada(Integer.parseInt(result.get().getKey()));
            ent.setValor_unitario(Integer.parseInt(result.get().getValue()));

            if (result.get().getValue() != null && result.get().getValue() != null) {
                return true;
            } else {
                return false;
            }

        }

        return false;
    }

    @FXML
    void btnEditarTabelaEntradaOnAction(ActionEvent event) {

    }

    @FXML
    void btnRemoverTabelaEntradaOnAction(ActionEvent event) {

    }

    @FXML
    void btnAdicionarBuscarFornecedorOnAction(ActionEvent event) {

        txtFornecedor.setText(tblBuscarFornecedor.getSelectionModel().getSelectedItem().getRazao_social());
        txtCNPJ.setText(tblBuscarFornecedor.getSelectionModel().getSelectedItem().getCnpj());
        btnAdicionarFornecedor.setDisable(true);
        btnEditarFornecedor.setDisable(false);
        btnVoltarBuscarFornecedorOnAction(event);

    }

    @FXML
    void btnVoltarBuscarFornecedorOnAction(ActionEvent event) {

        tabFornecedor.setDisable(true);
        tabEntrada.setDisable(false);
        TabPai.getSelectionModel().select(tabEntrada);

    }

    @FXML
    void txtBuscadorFornecedorOnAction(ActionEvent event) {

    }

    @FXML
    void btnAdicionarBuscaMaterialOnAction(ActionEvent event) {

        if (tblBuscaMaterial.getSelectionModel().getSelectedItem() != null) {
            ent.setMaterial(tblBuscaMaterial.getSelectionModel().getSelectedItem().getDescricao());
            if (DadosEntrada()) {
                TabPai.getSelectionModel().select(tabLocal);
                tabMaterial.setDisable(true);
                tabLocal.setDisable(false);
            }
        }

    }

    @FXML
    void btnVoltarBuscaMaterialOnAction(ActionEvent event) {

        TabPai.getSelectionModel().select(tabEntrada);
        tabEntrada.setDisable(false);
        tabMaterial.setDisable(true);

    }

    @FXML
    void btnBuscarMaterialOnAction(ActionEvent event) {

    }

    @FXML
    void btnAdicionarBuscarLocalOnAction(ActionEvent event) {

        if (tblBuscarLocal.getSelectionModel().getSelectedItem() != null) {
            ent.setLocal(tblBuscarLocal.getSelectionModel().getSelectedItem().getDescricao());
            Itens.add(ent);
            completarTabela(Itens);
            ent = new EntradaMaterial();
            TabPai.getSelectionModel().select(tabEntrada);
            tabEntrada.setDisable(false);
            tabLocal.setDisable(true);
        }

    }

    @FXML
    void btnVoltarBuscarLocalOnAction(ActionEvent event) {

        TabPai.getSelectionModel().select(tabMaterial);
        tabMaterial.setDisable(false);
        tabLocal.setDisable(true);

    }

    @FXML
    void btncancelarEntradaOnAction(ActionEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(PrincipalController.class.getClassLoader().getResource("fxml/Principal.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    void btnBuscarLocalOnAction(ActionEvent event) {

    }
    @FXML
    void txtValorNFOnAction(ActionEvent event){
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        TabPai.getSelectionModel().select(tabEntrada);
        tabFornecedor.setDisable(true);
        tabLocal.setDisable(true);
        tabMaterial.setDisable(true);
        rdbNomeFantasiaFornecedor.setSelected(true);
        rdbDescricaoLocal.setSelected(true);
        btnDarEntrada.setDisable(true);

        mockTabelas();

    }

    void mockTabelas() {

        ObservableList<Fornecedor> fornecedor = FXCollections.observableArrayList();
        ObservableList<Material> material = FXCollections.observableArrayList();
        ObservableList<Local> local = FXCollections.observableArrayList();

        Fornecedor forneced = new Fornecedor();
        Material mat = new Material();
        Local loc = new Local();

        forneced.setCnpj("013020304020341");
        forneced.setPessoa_responsavel("Henrique Firmino");
        forneced.setRazao_social("H REF LTDA");
        forneced.setNome_fantasia("Casa do código");
        fornecedor.add(forneced);
        forneced = new Fornecedor();

        forneced.setCnpj("234131230000134");
        forneced.setPessoa_responsavel("Eduardo Rooselvelt");
        forneced.setRazao_social("E REF LTDA");
        forneced.setNome_fantasia("Casa do Programa");
        fornecedor.add(forneced);

        mat.setDescricao("LEGO MIDSTORM EV3");
        mat.setCategoriaNome("ROBOTICA");
        mat.setQuantidade(5);
        material.add(mat);
        mat = new Material();
        mat.setDescricao("LED ALTO-BRILHO AZUL");
        mat.setCategoriaNome("ELETRONICA");
        mat.setQuantidade(10);
        material.add(mat);

        loc.setDescricao("Laboratorio PET Autonet");
        loc.setNumero(234);
        loc.setResponsavel("Ronan Martins");

        local.add(loc);

        //this.tbcCategoriaBuscaMaterial.setCellValueFactory(new PropertyValueFactory<Material, String>("CategoriaNome"));
        this.tbcCNPJ.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("cnpj"));
        this.tbcRazaoSocial.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("razao_social"));
        this.tbcNomeFantasia.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("nome_fantasia"));
        this.tbcPessoaResponsavel.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("pessoa_responsavel"));
        tblBuscarFornecedor.setItems(fornecedor);

        this.tbcMaterialBuscaMaterial.setCellValueFactory(new PropertyValueFactory<Material, String>("descricao"));
        this.tbcCategoriaBuscaMaterial.setCellValueFactory(new PropertyValueFactory<Material, String>("CategoriaNome"));
        this.tbcQuantidadeBuscaMaterial.setCellValueFactory(new PropertyValueFactory<Material, Integer>("quantidade"));
        tblBuscaMaterial.setItems(material);

        this.tbcPessoaResponsavelBuscarLocal.setCellValueFactory(new PropertyValueFactory<Local, String>("responsavel"));
        this.tbcNumeroBuscarLocal.setCellValueFactory(new PropertyValueFactory<Local, Integer>("numero"));
        this.tbcDescricaoBuscarLocal.setCellValueFactory(new PropertyValueFactory<Local, String>("descricao"));
        tblBuscarLocal.setItems(local);

    }

    private void completarTabela(List<EntradaMaterial> lista) {

        ObservableList<EntradaMaterial> dado = FXCollections.observableArrayList();
        float sum = 0;
        int qtdItens = 0;
        EntradaMaterial aux = new EntradaMaterial();
        for (int i = 0; i < lista.size(); i++) {
            aux = lista.get(i);
            aux.setValor_total(aux.getQtd_entrada() * aux.getValor_unitario());
            sum = aux.getValor_total() + sum;
            lista.set(i, aux);
            qtdItens++;
            dado.add(lista.get(i));
        }
        // this.tbcCategoriaBuscaMaterial.setCellValueFactory(new PropertyValueFactory<Material, String>("CategoriaNome"));
        this.tbcMaterial.setCellValueFactory(new PropertyValueFactory<EntradaMaterial, String>("material"));
        this.tbcQtd.setCellValueFactory(new PropertyValueFactory<EntradaMaterial, Integer>("qtd_entrada"));
        this.tbcValorUnitario.setCellValueFactory(new PropertyValueFactory<EntradaMaterial, Float>("valor_unitario"));
        this.tbcValorTotal.setCellValueFactory(new PropertyValueFactory<EntradaMaterial, Float>("valor_total"));
        this.tbcLocal.setCellValueFactory(new PropertyValueFactory<EntradaMaterial, String>("local"));

        this.tblEntradaMaterial.setItems(dado);

        String conversor = "" + sum;
        txtValorMaterialTotalGeral.setText(conversor);
        conversor = "" + qtdItens;
        txtQtdMaterial.setText(conversor);
        //txtValorNF

        if (sum != 0) {
            if (!txtValorNF.getText().isEmpty()) {

                if (sum == Float.parseFloat(txtValorNF.getText())) {
                    if (txtNumNF.getText() != null && dtEntrada.getValue() != null && txtFornecedor.getText() != null
                            && txtCNPJ.getText() != null) {
                        btnDarEntrada.setDisable(false);
                    }
                }
            }
        }

    }

}
