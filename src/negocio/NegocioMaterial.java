/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import DAO.CategoriaDAO;
import DAO.MaterialDAO;
import DAO.TipoUnidadeDAO;
import java.util.List;
import vo.Categoria;
import vo.Material;
import vo.TipoUnidade;

/**
 *
 * @author Eduardo
 */
public class NegocioMaterial {

    private MaterialDAO materialDAO;
    private TipoUnidadeDAO tuDAO;
    private CategoriaDAO categoriaDAO;

    public NegocioMaterial() {
        materialDAO = new MaterialDAO();
        tuDAO = new TipoUnidadeDAO();
        categoriaDAO = new CategoriaDAO();
    }

    public Material salvar(Material material) throws Exception {
        String erro = validar(material);

        if (erro.equals("")) {
            return materialDAO.salvar(Material.class, material);
        } else {
            throw new Exception(erro);
        }
    }

    public void remover(Material material) throws Exception {
        materialDAO.remover(Material.class, material);
    }

    public Material consultarPorId(Material material) {
        Material mat = materialDAO.consutarPorId(Material.class, material);
        mat.setCategoriaNome(mat.getId_categoria().getDescricao());
        return mat;
    }

    public List<Material> buscarPorDescricao(Material material) {
        return preencher(materialDAO.buscarPorDescricao(material));
    }

    public List<Material> buscarPorQuantidade(Material material) {

        return preencher(materialDAO.buscarPorQuantidade(material));
    }

    public List<Material> buscarTodos() {
        return preencher(materialDAO.buscarTodos());

    }

    public List<Material> buscarPorCategoria(Categoria categoria) {
        return preencher(materialDAO.buscarPorCategoria(categoria));
    }

    private String validar(Material material) {
        String erro = "";

        if (material.getId_categoria() == null) {
            erro += "Favor selecionar a categoria do material\n";
        }

        if (material.getId_tipo_unidade() == null) {
            erro += "Favor selecionar a unidade do material";
        }

        return erro;
    }

    private List<Material> preencher(List<Material> buscarTodos) {

        for (int i = 0; i < buscarTodos.size(); i++) {
            buscarTodos.get(i).setCategoriaNome(buscarTodos.get(i).getId_categoria().getDescricao());
            buscarTodos.get(i).setUnidadeMedida(buscarTodos.get(i).getId_tipo_unidade().getSigla());
        }
        return buscarTodos;
    }

}
