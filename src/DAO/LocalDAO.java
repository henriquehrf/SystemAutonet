/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import vo.Local;

/**
 *
 * @author Eduardo
 */
public class LocalDAO extends GenericoDAO<Local> {

    public List<Local> buscarPorDescricao(Local local) {
        EntityManager em = getEM();
        List<Local> list;
        try {
            Query query = em.createNamedQuery("Local.consultarPorDescricao");
            query.setParameter("descricao", "%" + local.getDescricao().toUpperCase() + "%");
            list = query.getResultList();

        } catch (Exception ex) {
            list = new ArrayList();

        } finally {
            em.close();
        }

        return list;
    }

    public Local buscarPorNumero(Local local) {
        EntityManager em = getEM();
        Local l;
        try {
            Query query = em.createNamedQuery("Local.consultarPorNumero");
            query.setParameter("numero", local.getNumero());
            l = (Local) query.getSingleResult();

        } catch (Exception ex) {
            l = null;

        } finally {
            em.close();
        }

        return l;
    }

    public List<Local> buscarPorPessoaResponsavel(Local local) {
        EntityManager em = getEM();
        List<Local> list;
        try {
            Query query = em.createNamedQuery("Local.consultarPorPessoaResponsavel");
            query.setParameter("responsavel", "%" + local.getResponsavel().toUpperCase() + "%");
            list = query.getResultList();

        } catch (Exception ex) {
            list = new ArrayList();

        } finally {
            em.close();
        }
        return list;
    }

//    public List<Local> buscarPorBloco(Local local) {
//        EntityManager em = getEM();
//        List<Local> list;
//        try {
//            Query query = em.createNamedQuery("Local.consultarPorBloco");
//            query.setParameter("bloco", "%" + + "%");
//            list = query.getResultList();
//
//        } catch (Exception ex) {
//            list = new ArrayList();
//
//        } finally {
//            em.close();
//        }
//        return list;
//    }

}
