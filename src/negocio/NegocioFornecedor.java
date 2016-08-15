/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import DAO.FornecedorDAO;
import java.util.List;
import vo.Fornecedor;

/**
 *
 * @author Eduardo
 */
public class NegocioFornecedor {

    private final FornecedorDAO fornecedorDAO;

    public NegocioFornecedor() {
        fornecedorDAO = new FornecedorDAO();
    }

    public Fornecedor salvar(Fornecedor fornecedor) throws Exception {
        //Faltando as validações
        String erro = validar(fornecedor);
        if(erro.equals("")){
            return fornecedorDAO.salvar(Fornecedor.class, fornecedor);
        }else{
            throw new  Exception(erro);
        }
 
    }

    public void remover(Fornecedor fornecedor) throws Exception {
        fornecedorDAO.remover(Fornecedor.class, fornecedor);
    }

    public Fornecedor consultarPorId(Fornecedor fornecedor) {
        return fornecedorDAO.consutarPorId(Fornecedor.class, fornecedor);
    }

    public List<Fornecedor> buscarPorNomeFantasia(Fornecedor fornecedor) {
        return fornecedorDAO.buscarPorNomeFantasia(fornecedor);
    }

    public List<Fornecedor> buscarPorRazaoSocial(Fornecedor fornecedor) {
        return fornecedorDAO.buscarPorRazaoSical(fornecedor);
    }

    public Fornecedor buscarPorCnpj(Fornecedor fornecedor) {
        return fornecedorDAO.buscarPorCNPJ(fornecedor);
    }

    public List<Fornecedor> buscarPorPessoaResponsavel(Fornecedor fornecedor) {
        return fornecedorDAO.buscarPorPessoaResponsavel(fornecedor);
    }
    
    public String validar(Fornecedor fornecedor){
        String erro ="";
        
        if(fornecedor.getId() == null || fornecedor.getId() == 0){
            if (buscarPorCnpj(fornecedor) != null){
                erro += "Erro: CNPJ já cadastrado";
            }
        }         
        return erro;
    }

}
