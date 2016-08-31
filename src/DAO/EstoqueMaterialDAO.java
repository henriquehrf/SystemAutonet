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
import vo.EstoqueMaterial;
import vo.Material;

/**
 *
 * @author Eduardo
 */
public class EstoqueMaterialDAO extends GenericoDAO<EstoqueMaterial> {

    public List<EstoqueMaterial> buscarPorIdMaterial(Material material) {
        EntityManager em = getEM();
        Query query;
        List<EstoqueMaterial> lista;

        try {
            query = em.createNamedQuery("EstoqueMaterial.BuscarPorIdMaterial");
            query.setParameter("idMaterial", material.getId());
            lista = query.getResultList();

        } catch (Exception ex) {
            lista = new ArrayList();
        } finally {
            em.close();
        }

        return lista;
    }

    public int QtdDisponivelDoMaterial(Material material) {
        EntityManager em = getEM();
        Query query;
        int qtd;

        try {
            query = em.createNamedQuery("EstoqueMaterial.QtdDisponivelDoMaterial");
            query.setParameter("idMaterial", material.getId());
            qtd = (int) query.getSingleResult();

        } catch (Exception ex) {
            qtd = -1;
        } finally {
            em.close();
        }
        
        return qtd;
    }
}
