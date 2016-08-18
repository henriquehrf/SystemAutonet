/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import DAO.LocalDAO;
import java.util.List;
import vo.Local;

/**
 *
 * @author Eduardo
 */
public class NegocioLocal {

    private LocalDAO localDAO;

    public NegocioLocal() {
        localDAO = new LocalDAO();
    }

    public Local salvar(Local local) throws Exception {
        String erro = validar(local);

        if (erro.equals("")) {
            return localDAO.salvar(Local.class, local);
        } else {
            throw new Exception(erro);
        }
    }

    public void remover(Local local) throws Exception {
        localDAO.remover(Local.class, local);
    }

    public Local consultarPorId(Local local) {
        return localDAO.consutarPorId(Local.class, local);
    }

    public String validar(Local local) {
        String erro = "";

        if (local.getId_departamento() == null) {
            erro += "Erro: não foi encontrado o departamento";
        }

        return erro;
    }

    public List<Local> buscarPorDescricao(Local local) {
        return localDAO.buscarPorDescricao(local);
    }

    public List<Local> buscarPorPessoaResponsavel(Local local) {
        return localDAO.buscarPorPessoaResponsavel(local);
    }

    public List<Local> buscarPorNumero(Local local) {
        return localDAO.buscarPorNumero(local);
    }

    public List<Local> buscarTodos() {
        return localDAO.buscarTodos();
    }

    public List<Local> buscarPorBloco(Local local) {
        return localDAO.buscarPorBloco(local);
    }
    
    public List<Local> buscarPorDepartamento(Local local) {
        return localDAO.buscarPorDepartamento(local);
    }
    

}
