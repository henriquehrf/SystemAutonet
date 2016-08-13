/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import vo.Pessoa;

/**
 *
 * @author Eduardo
 */
public class PessoaDAO extends GenericoDAO<Pessoa> {

    public boolean EncontrarUsuario(Pessoa pessoa) {
        boolean encontrou = false;
        EntityManager em = getEM();
        Pessoa p = null;
        try {
            Query query = em.createNamedQuery("Pessoa.BuscarUsuario");
            query.setParameter("usuario", pessoa.getUsuario().toUpperCase());
            p = (Pessoa) query.getSingleResult();

            if (p != null) {
                encontrou = true;
            }
        } finally{
            em.close();
        }
        return encontrou;
    }

    public List<Pessoa> buscarPorNome(Pessoa pessoa) {
        EntityManager em = getEM();
        List<Pessoa> list;
        try {
            Query query = em.createNamedQuery("Pessoa.BuscarPorNome");
            query.setParameter("nome", pessoa.getNome());
            list = query.getResultList();
        } catch (Exception ex) {
            list = new ArrayList();
        } finally {
            em.close();
        }

        return list;

    }

}
