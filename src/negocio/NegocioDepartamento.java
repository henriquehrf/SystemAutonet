/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import DAO.DepartamentoDAO;
import java.util.List;
import vo.Departamento;

/**
 *
 * @author Eduardo
 */
public class NegocioDepartamento {
    private final DepartamentoDAO departamentoDAO;
    
    public NegocioDepartamento(){
        departamentoDAO = new DepartamentoDAO();
    }
    
    public Departamento salvar(Departamento dp) throws Exception{        
        return departamentoDAO.salvar(Departamento.class, dp);
    }
    
    public void remover(Departamento dp) throws Exception{
        departamentoDAO.remover(Departamento.class, dp);
    }
    
    public Departamento consultarPorId(Departamento dp){
        return departamentoDAO.consutarPorId(Departamento.class, dp);
    }
    
    public List<Departamento> buscarPorNome(Departamento dp){
        return departamentoDAO.buscarPorNome(dp);
    }
    
}
