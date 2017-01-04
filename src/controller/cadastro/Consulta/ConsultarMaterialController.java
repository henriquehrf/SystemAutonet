package controller.cadastro.Consulta;

import classesAuxiliares.NegociosEstaticos;
import classesAuxiliares.Validar;
import controller.PrincipalController;
import controller.cadastro.Cadastro.CadastroMaterialController;
import gui.SystemAutonet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import negocio.NegocioPessoa;
import utilitarios.Alertas;
import utilitarios.LerMessage;
import vo.Categoria;
import vo.Material;

public class ConsultarMaterialController {

    @FXML
    private Slider SliderBarQtd;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private TableColumn<Material, Number> tbcQuantidade;

    @FXML
    private TableView<Material> tblPrincipal;

    @FXML
    private TableColumn<Material, String> tbcCategoria;

    @FXML
    private Button btnInserir;

    @FXML
    private Label Title;

    @FXML
    private ComboBox<String> cmbCategoria;

    @FXML
    private TextField txtBuscador;

    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnBusca;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnExcluir;

    @FXML
    private TableColumn<Material, String> tbcDescricao;

    @FXML
    private TableColumn<Material, String> tbcUnidadeMedida;

    void completarCombo() {
        List<Categoria> lista = NegociosEstaticos.getNegocioCategoria().bucarTodos();
        ObservableList<String> dado = FXCollections.observableArrayList();

        for (int i = 0; i < lista.size(); i++) {
            dado.add(lista.get(i).getDescricao());
        }
        dado.add("TODOS");
        Collections.sort(dado);
        cmbCategoria.setItems(dado);
        //cmbCategoria.setValue("TODOS");
        // cmbCategoria.getSelectionModel().select(cmbCategoria.getItems().size() - 1);
        cmbCategoria.setValue("TODOS");
    }

    public void initialize() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                txtBuscador.requestFocus();
            }
        });
        List<Material> lista = NegociosEstaticos.getNegocioMaterial().buscarTodos();
        completarCombo();
        completarTabela(lista);
        habilitarSlider(lista);

    }

    void habilitarSlider(List<Material> lista) {

        int menor, maior;
        if (lista.isEmpty()) {
            menor = 0;
            maior = 0;
        } else {
            menor = lista.get(0).getQuantidade();
            maior = lista.get(0).getQuantidade();

            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getQuantidade() > maior) {
                    maior = lista.get(i).getQuantidade();
                }
                if (lista.get(i).getQuantidade() < menor) {
                    menor = lista.get(i).getQuantidade();
                }
            }
        }
        txtQuantidade.setText("" + menor);
        SliderBarQtd.setMin(menor);
        SliderBarQtd.setMax(maior);
        SliderBarQtd.setValue(menor);
        SliderBarQtd.setShowTickLabels(true);
        SliderBarQtd.setShowTickMarks(true);
        SliderBarQtd.setMajorTickUnit(50);
        SliderBarQtd.setMinorTickCount(0);
        SliderBarQtd.setBlockIncrement(1);
    }

    @FXML
    void SliderBarQtd_OnDragDetected(MouseEvent event) {
        int qtd = (int) SliderBarQtd.getValue();
        txtQuantidade.setText("" + qtd);
    }

    @FXML
    void SliderBarQtd_OnDragDone(MouseEvent event) {
        int qtd = (int) SliderBarQtd.getValue();
        txtQuantidade.setText("" + qtd);
    }

    @FXML
    void SliderBarQtd_OnDragDropped(MouseEvent event) {
        int qtd = (int) SliderBarQtd.getValue();
        txtQuantidade.setText("" + qtd);
    }

    @FXML
    void SliderBarQtd_OnDragEntered(MouseEvent event) {
        int qtd = (int) SliderBarQtd.getValue();
        txtQuantidade.setText("" + qtd);
    }

    @FXML
    void SliderBarQtd_OnDragExited(MouseEvent event) {
        int qtd = (int) SliderBarQtd.getValue();
        txtQuantidade.setText("" + qtd);
    }

    @FXML
    void SliderBarQtd_OnMouseClicked(MouseEvent event) {
        int qtd = (int) SliderBarQtd.getValue();
        txtQuantidade.setText("" + qtd);
    }

    @FXML
    void SliderBarQtd_OnMouseDragged(MouseEvent event) {
        int qtd = (int) SliderBarQtd.getValue();
        txtQuantidade.setText("" + qtd);
    }

    @FXML
    void SliderBarQtd_OnKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.LEFT) {
            int qtd = (int) SliderBarQtd.getValue();
            txtQuantidade.setText("" + qtd);
        }
    }

    @FXML
    void SliderBarQtd_OnKeyReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.LEFT) {
            int qtd = (int) SliderBarQtd.getValue();
            txtQuantidade.setText("" + qtd);
        }
    }

    @FXML
    void txtQuantidade_OnAction(ActionEvent event) {
        double value = Double.parseDouble(txtQuantidade.getText());
        SliderBarQtd.setValue(value);
//     //   btnBusca_OnAction(event);
//        // tblPrincipal.getItems();
//        List<Material> list =new ArrayList<Material>();
//        for(int i=0;i<tblPrincipal.getItems().size();i++){
//            if(tblPrincipal.getItems().get(i).getQuantidade()<=Integer.parseInt(txtQuantidade.getText())){
//                list.add(tblPrincipal.getItems().get(i));
//            }
//        }
//        completarTabela(list);
    }

    @FXML
    void cmbCategoria_OnAction(ActionEvent event) {

        if (cmbCategoria.getValue().equals("TODOS")) {
            btnBusca_OnAction(event);
            // completarTabela(NegociosEstaticos.getNegocioMaterial().buscarTodos());
        } else {
            btnBusca_OnAction(event);
            CategoriaFilter(tblPrincipal.getItems());
        }
    }

    void CategoriaFilter(List<Material> lista) {

        List<Material> aux = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCategoriaNome().equals(cmbCategoria.getValue())) {
                aux.add(lista.get(i));
            }
        }
        completarTabela(aux);

    }

    @FXML
    void txtBuscador_OnKeyPressed(KeyEvent event) {
        btnBusca_OnKeyPressed(event);

    }

    @FXML
    void cmbCategoria_OnKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {

            if (cmbCategoria.getValue().equals("TODOS")) {
                btnBusca_OnKeyPressed(event);
            } else {
                btnBusca_OnKeyPressed(event);
                CategoriaFilter(tblPrincipal.getItems());
            }
        }

    }

    @FXML
    void btnInserir_OnKeyPressed(KeyEvent event) {

    }

    @FXML
    void btnAlterar_OnKeyPressed(KeyEvent event) {

    }

    @FXML
    void btnExcluir_OnKeyPressed(KeyEvent event) {

    }

    @FXML
    void btnVoltar_OnKeyPressed(KeyEvent event) {

    }

    @FXML
    void btnBusca_OnKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            if (cmbCategoria.getValue().equals("TODOS")) {
                Material material = new Material();
                material.setDescricao(txtBuscador.getText());
                completarTabela(NegociosEstaticos.getNegocioMaterial().buscarPorDescricao(material));
            } else {
                Material material = new Material();
                material.setDescricao(txtBuscador.getText());
                CategoriaFilter(NegociosEstaticos.getNegocioMaterial().buscarPorDescricao(material));

            }
        }

    }

    void completarTabela(List<Material> lista) {
        ObservableList<Material> dado = FXCollections.observableArrayList();
        for (int i = 0; i < lista.size(); i++) {
            dado.add(lista.get(i));
        }
        habilitarSlider(dado);
        this.tbcDescricao.setCellValueFactory(new PropertyValueFactory<Material, String>("descricao"));
        this.tbcQuantidade.setCellValueFactory(new PropertyValueFactory<Material, Number>("quantidade"));
        this.tbcUnidadeMedida.setCellValueFactory(new PropertyValueFactory<Material, String>("unidadeMedida"));
        this.tbcCategoria.setCellValueFactory(new PropertyValueFactory<Material, String>("CategoriaNome"));
        this.tblPrincipal.setItems(dado);

    }
//    ObservableList<Material> ListarQtd(ObservableList<Material> lista){
//        ObservableList<Material> aux = FXCollections.observableArrayList();
//        for(int i=0;i<lista.size();i++){
//            if(lista.get(i).getQuantidade()>= Integer.parseInt(txtQuantidade.getText())){
//                aux.add(lista.get(i));
//            }
//        }
//        System.out.println(aux.size());
//        return aux;
//    }

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

    void buscar(String str) {
        Material material = new Material();
        material.setDescricao(str);
        completarTabela(NegociosEstaticos.getNegocioMaterial().buscarPorDescricao(material));
    }

    @FXML
    void btnBusca_OnAction(ActionEvent event) {
        if (cmbCategoria.getValue().equals("TODOS")) {
            buscar(txtBuscador.getText());
        } else {
            Material material = new Material();
            material.setDescricao(txtBuscador.getText());
            CategoriaFilter(NegociosEstaticos.getNegocioMaterial().buscarPorDescricao(material));

        }
    }

    @FXML
    void btnAlterar_OnAction(ActionEvent event) {
        try {
            Material p = tblPrincipal.getSelectionModel().getSelectedItem();
            CadastroMaterialController.setCadastrar(false);
            CadastroMaterialController.setAlterar(p);
            Parent root;
            root = FXMLLoader.load(CadastroMaterialController.class.getClassLoader().getResource("fxml/cadastro/Cadastro/Cadastro_Material.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    void btnExcluir_OnAction(ActionEvent event) {
        try {
            Alertas alert = new Alertas();
            LerMessage ler = new LerMessage();
            if (alert.alerta(Alert.AlertType.CONFIRMATION, "Remoção", ler.getMessage("msg.temcerteza"), "Sim", "Não")) {
                NegociosEstaticos.getNegocioMaterial().remover(tblPrincipal.getSelectionModel().getSelectedItem());
                completarTabela(NegociosEstaticos.getNegocioMaterial().buscarTodos());
            }
        } catch (Exception ex) {
            Alertas alert = new Alertas();
            alert.alerta(Alert.AlertType.ERROR, "Erro na remoção", ex.getMessage());
        }
    }

    @FXML
    void btnInserir_OnAction(ActionEvent event) {
        try {
            CadastroMaterialController.setCadastrar(true);
            Parent root;
            root = FXMLLoader.load(CadastroMaterialController.class.getClassLoader().getResource("fxml/cadastro/Cadastro/Cadastro_Material.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void IncompatibilidadeNumero() throws Exception {
        LerMessage ler = new LerMessage();
        Alertas aviso = new Alertas();
        aviso.alerta(Alert.AlertType.ERROR, ler.getMessage("msg.dados.erro"), ler.getMessage("msg.incompatibilidade.numero"));

    }

}
