/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cadastro.Cadastro;

import classesAuxiliares.NegociosEstaticos;
import controller.cadastro.Consulta.ConsultarMaterialController;
import enumm.PoliticaUso;
import gui.SystemAutonet;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import utilitarios.LerProperties;
import vo.Categoria;
import vo.Material;
import vo.TipoUnidade;

/**
 *
 * @author PET Autonet
 */
public class CadastroMaterialController {

    @FXML
    private Label lblDadostecnicosObrigatorio;

    @FXML
    private Label lbldescricaoObrigatorio;

    @FXML
    private Label lblcategorioobrigatorio;

    @FXML
    private Label lblUnidadeMedidaObrigatorio;

    @FXML
    private Label lblPolitacaDeUsoObrigatorio;

    @FXML
    private ComboBox<PoliticaUso> cmbPoliticaUso;

    @FXML
    private Button btnSalvar;

    @FXML
    private TextArea txtDadosTecnicos;

    @FXML
    private Button btnCancelar;

    @FXML
    private TextField txtdescricao;

    @FXML
    private Label Title;

    @FXML
    private ComboBox<String> cmbCategoria;

    @FXML
    private ComboBox<String> cmbUnidadeMedida;

    private static Material alterar;

    private static boolean cadastrar;

    public static Material getAlterar() {
        return alterar;
    }

    public static void setAlterar(Material alterar) {
        CadastroMaterialController.alterar = alterar;
    }

    public static boolean isCadastrar() {
        return cadastrar;
    }

    public static void setCadastrar(boolean cadastrar) {
        CadastroMaterialController.cadastrar = cadastrar;
    }

    public void initialize() {

        ObservableList<PoliticaUso> perf = FXCollections.observableArrayList((PoliticaUso.values()));
        List<TipoUnidade> lista = NegociosEstaticos.getNegocioTipoUnidade().buscarTodos();
        ObservableList<String> dado = FXCollections.observableArrayList();
        for (int i = 0; i < lista.size(); i++) {
            dado.add(lista.get(i).getSigla());
        }
        
        setcamposObrigatorio();
        cmbPoliticaUso.setItems(perf);
        cmbUnidadeMedida.setItems(dado);
        
        if (!isCadastrar()) {
            completar();
        } else {
            alterar = null;
        }

    }

    private void setcamposObrigatorio() {
        lblDadostecnicosObrigatorio.setVisible(false);
        lblPolitacaDeUsoObrigatorio.setVisible(false);
        lblUnidadeMedidaObrigatorio.setVisible(false);
        lblcategorioobrigatorio.setVisible(false);
        lbldescricaoObrigatorio.setVisible(false);
    }

    private void completar() {
        txtDadosTecnicos.setText(alterar.getDadosTecnicos());
        txtdescricao.setText(alterar.getDescricao());
        cmbCategoria.setValue(alterar.getCategoriNome());
        cmbUnidadeMedida.setValue(alterar.getUnidadeMedida());
        cmbPoliticaUso.setValue(alterar.getPoliticaUso());
        LerProperties ler = new LerProperties();
        try {
            Properties prop = ler.getProp();
            Title.setText(prop.getProperty("title.alterar.material"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    void alerta(Alert.AlertType TipoAviso, String cabecalho, String msg) throws Exception {
        LerProperties ler = new LerProperties();

        Properties prop = ler.getProp();
        Alert alert = new Alert(TipoAviso);
        alert.setTitle(cabecalho);
        alert.setHeaderText(null);
        alert.setContentText(msg);

        alert.showAndWait();

    }

    private boolean verificaCampoObrigatorio() {
        setcamposObrigatorio();
        boolean verifica = true;
        if (txtdescricao.getText().isEmpty()) {
            lblPolitacaDeUsoObrigatorio.setVisible(true);
            verifica = false;
        }
        if (txtdescricao.getText().isEmpty()) {
            lbldescricaoObrigatorio.setVisible(true);
            verifica = false;
        }
        if (cmbCategoria.getValue() == null) {
            lblcategorioobrigatorio.setVisible(true);
            verifica = false;
        }
        if (cmbPoliticaUso.getValue() == null) {
            lblPolitacaDeUsoObrigatorio.setVisible(true);
            verifica = false;
        }
        if (cmbUnidadeMedida.getValue() == null) {
            lblUnidadeMedidaObrigatorio.setVisible(true);
            verifica = false;
        }
        return verifica;
    }

    private void salvar(Material material) throws Exception {

        material.setDescricao(txtdescricao.getText());
        material.setDadosTecnicos(txtDadosTecnicos.getText());
        material.setPoliticaUso(cmbPoliticaUso.getValue());
        material.setQuantidade(0);

        Categoria cat = new Categoria();
        TipoUnidade tu = new TipoUnidade();
        tu.setDescricao(cmbUnidadeMedida.getValue());
        cat.setDescricao(cmbCategoria.getValue());

        List<Categoria> categori = NegociosEstaticos.getNegocioCategoria().buscarPorDescricao(cat);
        List<TipoUnidade> Ltu = NegociosEstaticos.getNegocioTipoUnidade().buscarPorDescricao(tu);
        
        if (categori.size() == 1) {
            material.setId_categoria(categori.get(0));  
        }else{
            System.out.println("erro inesperado Categoria");
            return;
        }
        
        if (Ltu.size() == 1) {
            material.setId_tipo_unidade(Ltu.get(0));
        }else{
            System.out.println("erro inesperado Tipo Unidade");
            return;
        }

        try {
            //   NegocioP.salvar(pessoa);
            NegociosEstaticos.getNegocioMaterial().salvar(material);
            Parent root;
            LerProperties ler = new LerProperties();
            Properties prop = ler.getProp();
            // NegocioP = null;
            alterar = null;

            alerta(AlertType.INFORMATION, prop.getProperty("msg.cadastro.confirmacao"), prop.getProperty("msg.cadastro.sucesso"));
            root = FXMLLoader.load(ConsultarMaterialController.class.getClassLoader().getResource("fxml/cadastro/Consulta/Consultar_Material.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            LerProperties ler = new LerProperties();
            Properties prop = ler.getProp();
            alerta(AlertType.ERROR, prop.getProperty("msg.cadastro.erro"), ex.getMessage());
        }
    }

    @FXML
    void btnSalvar_OnAction(ActionEvent event) {
        if (verificaCampoObrigatorio()) {

            try {
                if (alterar != null) {
                    salvar(alterar);
                } else {
                    Material material = new Material();
                    salvar(material);

                }
            } catch (Exception ex) {
                LerProperties ler = new LerProperties();
                Properties prop;
                try {
                    prop = ler.getProp();
                    alerta(Alert.AlertType.ERROR, prop.getProperty("msg.cadastro.erro"), ex.getMessage());
                } catch (Exception ex1) {
                    System.out.println(ex1.getMessage());
                }
            }

        } else {
            try {
                LerProperties ler = new LerProperties();
                Properties prop = ler.getProp();
                alerta(AlertType.ERROR, prop.getProperty("msg.cadastro.erro"), prop.getProperty("msg.cadastro.incompleto"));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());

            }
        }
    }

    @FXML
    void btnCancelar_OnAction(ActionEvent event) {
        try {
            Parent root;
            // NegocioP = null;
            alterar = null;
            root = FXMLLoader.load(ConsultarMaterialController.class.getClassLoader().getResource("fxml/cadastro/Consulta/Consultar_Material.fxml"), ResourceBundle.getBundle("utilitarios/i18N_pt_BR"));
            SystemAutonet.SCENE.setRoot(root);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
