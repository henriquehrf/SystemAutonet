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

//        try {
//            fabricaEntityManager = Persistence.createEntityManagerFactory("SystemAutonetPU");
//            entityManager = fabricaEntityManager.createEntityManager();
//            System.out.println("De boa é pra ter criado as tabelas");
//
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        
        pessoa.setCpf("05921855162");
//        // testando o metodo salvar
//        pessoa.setCpf("36773389720");
//        pessoa.setEndereco("Rua 48, Quadra 17, Casa 14, CPA 3, Setor 4");
//        pessoa.setNome("Eduardo Roosevelt de Oliveira Silva");
//        pessoa.setFone_principal("92290278");
//        pessoa.setNum_matricula("2013178440267");
//        pessoa.setSexo("M");
//        pessoa.setUsuario("E.Roosevelt");
//        pessoa.setSenha("12345678");
//        pessoa.setAtivo("N");
//        pessoa.setFuncao("UsuarioComum");
//        pessoa.setDt_nascimento(nascimento);
//        pessoa.setRg("123123123");
//        pessoa.setUltimo_acesso(ultimoAcesso);
//
        try {
//            NegocioP.salvar(pessoa);
//            System.out.println("Pessoa salva com sucesso");
//            System.out.println("-------------------------------");
//            pessoa = new Pessoa();
//            pessoa.setId_pessoa(1L);
            Pessoa p = new Pessoa();
//            
            p = NegocioP.buscarPorCPF(pessoa);
//            
//            p.setNome("Eduardo Roosevelt de Oliveira Silva");
//            p.setAtivo("N");
//            pessoa = NegocioP.buscarPorCPF(p);
            System.out.println("Nome: " + p.getNome()
                    + "\nCPF: " + p.getCpf()
                    + "\nNumero da matricula: " + p.getNum_matricula());
//            list = NegocioP.buscarPorNome(pessoa);
//            if (list.isEmpty()) {
//                System.out.println("Erro na lista");
//            } else {
//                for (int i = 0; i < list.size(); i++) {
//                    System.out.println("Nome: " + list.get(i).getNome()
//                            + "\nCPF: " + list.get(i).getCpf()
//                            + "\nNumero da matricula: " + list.get(i).getNum_matricula());
//                }
//            }
        } catch (Exception ex) {
            System.out.println("Erro " + ex.getMessage());
        }

        //Testando o metodo remover
//        pessoa.setId_pessoa(51L);
//        try {
//            NegocioP.remover(pessoa);
//            System.out.println("Pessoa removida com sucesso");
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
    }
}
