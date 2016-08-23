/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import DAO.CategoriaDAO;
import java.util.List;
import vo.Categoria;

/**
 *
 * @author Eduardo
 */
public class NegocioCategoria {
    private final CategoriaDAO categoriaDAO;
    
    public NegocioCategoria(){
        categoriaDAO = new CategoriaDAO();
    }
    
    public Categoria salvar(Categoria categoria) throws Exception{
        return categoriaDAO.salvar(Categoria.class, categoria);
    }
    
    public void remover(Categoria categoria) throws Exception{
        categoriaDAO.remover(Categoria.class, categoria);
    }
    
    public Categoria consultarPorId(Categoria categoria){
        return categoriaDAO.consutarPorId(Categoria.class, categoria);
    }
    
    public List<Categoria> buscarPorDescricao(Categoria categoria){
        return categoriaDAO.buscarPorDescricao(categoria);
    }
    
    public List<Categoria> bucarTodos(){
        return categoriaDAO.buscarTodos();
    }
}
