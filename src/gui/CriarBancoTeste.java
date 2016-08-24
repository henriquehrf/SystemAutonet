/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import classesAuxiliares.NegociosEstaticos;
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
import vo.Departamento;
import vo.Local;

/**
 *
 * @author Eduardo
 */
public class CriarBancoTeste {

    public static void main(String[] args) {
        EntityManagerFactory fabricaEntityManager = null;
        EntityManager entityManager = null;
//        NegociosEstaticos.iniciar();
//        Departamento dp = new Departamento();
//        dp.setNome("Departamento da Area de Informática");
//        dp.setSigla("DAI");
//
//        Local local = new Local();
//        local.setDescricao("Teste");
//        local.setId_departamento(dp);
//        local.setNumero(21);
//        local.setResponsavel("Eduardo");
//        local.setId_local(101L);
//        Local local2 ;
//        try {
//           
//            local2=NegociosEstaticos.getNegocioLocal().consultarPorId(local);
//            System.out.println(local2.getId_departamento().getNome());
        try {
            fabricaEntityManager = Persistence.createEntityManagerFactory("SystemAutonetPU");
            entityManager = fabricaEntityManager.createEntityManager();
            System.out.println("De boa é pra ter criado as tabelas");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
//        
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }

    }

}
