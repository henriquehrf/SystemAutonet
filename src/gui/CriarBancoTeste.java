/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public class CriarBancoTeste {

    public static void main(String[] args) {
        EntityManagerFactory fabricaEntityManager = null;
        EntityManager entityManager = null;

        try {
            fabricaEntityManager = Persistence.createEntityManagerFactory("SystemAutonetPU");
            entityManager = fabricaEntityManager.createEntityManager();
            System.out.println("De boa é pra ter criado as tabelas");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
