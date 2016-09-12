/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import vo.Emprestimo;
import vo.Pessoa;

/**
 *
 * @author Eduardo
 */
public class EmprestimoDAO extends GenericoDAO<Emprestimo> {

    public List<Emprestimo> buscarPorIdPessoa(Pessoa pessoa) {
        EntityManager em = getEM();
        Query query;
        List<Emprestimo> listaEmprestimo;
        try {
            query = em.createNamedQuery("Emprestimo.BuscarPorIdPessoa");
            query.setParameter("idPessoaSolicita", pessoa.getId());
            listaEmprestimo = query.getResultList();
        }catch(Exception ex){
            listaEmprestimo = new ArrayList();
        }finally{
            em.close();
        }
        return listaEmprestimo;

    }
}
