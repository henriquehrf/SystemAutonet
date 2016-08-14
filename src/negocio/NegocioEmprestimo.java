/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import DAO.EmprestimoDAO;
import vo.Emprestimo;

/**
 *
 * @author Eduardo
 */
public class NegocioEmprestimo {
    private EmprestimoDAO empDAO;
    
    public NegocioEmprestimo(){
        empDAO = new EmprestimoDAO();
    }
    
    public Emprestimo salvar(Emprestimo emp) throws Exception{
        String erro = validar(emp);
        
        if(erro.equals("")){
            return empDAO.salvar(Emprestimo.class, emp);
        }else{
            throw new Exception(erro);
        }
        
    }
    
    public void remover(Emprestimo emp) throws Exception{
        empDAO.remover(Emprestimo.class, emp);
    }
    
    public Emprestimo consultarPorId(Emprestimo emp){
        return empDAO.consutarPorId(Emprestimo.class, emp);
    }
    
    
    private String validar(Emprestimo emp){
        String erro = "";
        
        if(emp.getId_pessoa_solicita() == null) erro += "A pessoa que solicita não pode ser nulo";       
        
        return erro;
    }
}
