/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import negocio.NegocioPessoa;
import vo.Pessoa;
import java.util.Date;

/**
 *
 * @author Eduardo
 */
public class CriarBancoTeste {
    
    public static void main(String[] args) {
        EntityManagerFactory fabricaEntityManager = null;
        EntityManager entityManager = null;
        NegocioPessoa NegocioP = new NegocioPessoa();
        List<Pessoa> list;
        Date nascimento = new Date(1995, 12, 28);
        Date ultimoAcesso = new java.sql.Date(2016, 8, 13);
        Pessoa pessoa = new Pessoa();

        try {
            fabricaEntityManager = Persistence.createEntityManagerFactory("SystemAutonetPU");
            entityManager = fabricaEntityManager.createEntityManager();
            System.out.println("De boa é pra ter criado as tabelas");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    }