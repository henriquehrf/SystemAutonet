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

        Categoria cat = categoriaDAO.consutarPorId(Categoria.class, material.getId_categoria());
        TipoUnidade tu = tuDAO.consutarPorId(TipoUnidade.class, material.getId_tipo_unidade());
        material.setCategoriNome(cat.getDescricao());
        material.setUnidadeMedida(tu.getDescricao());
        
        return materialDAO.consutarPorId(Material.class, material);
    }

    public List<Material> buscarPorDescricao(Material material) {
        return preencher(materialDAO.buscarPorDescricao(material));
    }

    public List<Material> buscarPorQuantidade(Material material) {

        return preencher(materialDAO.buscarPorQuantidade(material));
    }

    public List<Material> buscarTodos() {

        List<Material> list = materialDAO.buscarTodos();
        return preencher(list);
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

    private List<Material> preencher(List<Material> list) {

        for (int i = 0; i < list.size(); i++) {
            Categoria cat = categoriaDAO.consutarPorId(Categoria.class, list.get(i).getId_categoria());
            TipoUnidade tu = tuDAO.consutarPorId(TipoUnidade.class, list.get(i).getId_tipo_unidade());

            list.get(i).setCategoriNome(cat.getDescricao());
            list.get(i).setUnidadeMedida(tu.getDescricao());
        }
        return list;

    }
}
