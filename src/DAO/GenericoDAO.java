/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Eduardo
 */
public class GenericoDAO<T extends EntidadeBase> {
    
    public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("SystemAutonetPU");
        return factory.createEntityManager();
    }

    public T salvar(Class<T> clazz , T t) throws Exception {
        EntityManager em = getEM();

        try {
            em.getTransaction().begin();
            if (t.getId() == null) {
                em.persist(t); // executa insert
            } else {
                if (!em.contains(t)) {
                    if (em.find(clazz, t.getId()) == null) {
                        throw new Exception("Erro ao alterar o cadastro.");
                    }
                }
                t = em.merge(t); // executa update
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return t;
    }

    public void remover(Class<T> clazz,T tt) throws Exception{
        EntityManager em = getEM();

        T t = em.find(clazz, tt.getId());

        try {
            em.getTransaction().begin();
            em.remove(t);  // executa o delete
            em.getTransaction().commit();        
        } finally {
            em.close();
        }
    }
    
    public  T consutarPorId(Class<T> clazz,T tt){
        EntityManager em = getEM();
        T t = null; 
        
        try{
            t = em.find(clazz, tt.getId()); // execulta o select no banco de dados
            
        }finally{
            em.close();
        }
        return t;
    }
}
