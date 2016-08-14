/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import DAO.FornecedorDAO;
import vo.Fornecedor;

/**
 *
 * @author Eduardo
 */
public class NegocioFornecedor {
    private final FornecedorDAO fornecedorDAO;
    
    public NegocioFornecedor(){
        fornecedorDAO = new FornecedorDAO();
    }
    
    public Fornecedor salvar(Fornecedor fornecedor) throws Exception{
        //Faltando as validações
        return fornecedorDAO.salvar(Fornecedor.class, fornecedor);
    }
    
    public void remover(Fornecedor fornecedor) throws Exception{
        fornecedorDAO.remover(Fornecedor.class, fornecedor);
    }
    
    public Fornecedor consultarPorId(Fornecedor fornecedor){
        return fornecedorDAO.consutarPorId(Fornecedor.class, fornecedor);
    }
    
}
