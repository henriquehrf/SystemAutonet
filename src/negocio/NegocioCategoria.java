/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import DAO.CategoriaDAO;
import java.util.List;
import java.util.Properties;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;
import utilitarios.LerProperties;
import vo.Categoria;

/**
 *
 * @author Eduardo
 */
public class NegocioCategoria {

    private final CategoriaDAO categoriaDAO;

    public NegocioCategoria() {
        categoriaDAO = new CategoriaDAO();
    }

    public Categoria salvar(Categoria categoria) throws Exception {
        String erro = validar(categoria);

        if (erro.equals("")) {
            return categoriaDAO.salvar(Categoria.class, categoria);
        } else {
            throw new Exception(erro);
        }

    } 

    public void remover(Categoria categoria) throws Exception {
        try {
           categoriaDAO.remover(Categoria.class, categoria);
            
        }catch(Exception ex){
             Properties prop = LerProperties.getProp();
            throw new Exception(prop.getProperty("msg.remover"));
        }
    }

    public Categoria consultarPorId(Categoria categoria) {
        return categoriaDAO.consutarPorId(Categoria.class, categoria);
    }
    
    
    public List<Categoria> buscarPorDescricao(Categoria categoria) {
        return categoriaDAO.buscarPorDescricao(categoria);
    }

    public List<Categoria> bucarTodos() {
        return categoriaDAO.buscarTodos();
    }
    
    public String validar(Categoria cat){
        String erro = "";
        
        if(buscarPorDescricao(cat).size() > 0){
            erro = "Esse nome ja existe";
        }
        
        
        return erro;       
        
    }
}
