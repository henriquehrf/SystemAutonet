/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import DAO.PessoaDAO;
import classesAuxiliares.ValidarCpf;
import classesAuxiliares.ValidarEmail;
import java.util.List;
import vo.Pessoa;

/**
 *
 * @author Eduardo
 */
public class NegocioPessoa {
    
    private final PessoaDAO pessoaDAO;
    
    public NegocioPessoa() {
        pessoaDAO = new PessoaDAO();
    }
    
    public Pessoa salvar(Pessoa pessoa) throws Exception {
        String erro = validarPessoa(pessoa);
        if (erro.equals("")) {
            return (pessoaDAO.salvar(Pessoa.class, pessoa));
        } else {
            throw new Exception(erro);
        }
    }
    
    public void remover(Pessoa pessoa) throws Exception {
        pessoaDAO.remover(Pessoa.class, pessoa);
    }
    
    public Pessoa consultarPorId(Pessoa pessoa) {
        return pessoaDAO.consutarPorId(Pessoa.class, pessoa);
    }
    
    public List<Pessoa> buscarPorNome(Pessoa pessoa) {
        return pessoaDAO.buscarPorNome(pessoa);
    }
    
    public Pessoa buscarPorCPF(Pessoa pessoa) {
        return pessoaDAO.buscarPorCPF(pessoa);
    }
    
    public Pessoa buscarPorRG(Pessoa pessoa) {
        return pessoaDAO.buscarPorRg(pessoa);
    }
    
    public Pessoa buscarPorMatricula(Pessoa pessoa) {
        return pessoaDAO.buscarPorMatricula(pessoa);
    }
    
    public List<Pessoa> buscarTodos() {
        return pessoaDAO.buscarTodos();
    }

    private String validarPessoa(Pessoa pessoa) {
        String erro = "";
        
        if (pessoa.getNome().isEmpty()) {
            erro += "Nome não pode ser vazio\n";
        }
        
        if (pessoa.getNome().length() < 3) {
            erro += "Nome não pode ser menor do que 3 caracteres\n";
        }
        
        if (pessoa.getDt_nascimento() == null) {
            erro += "Data de nascimento não pode ser nulo\n";
        }
        
        if (!ValidarCpf.isCPF(pessoa.getCpf())) {
            erro += "CPF inválido\n";
        }
        
        if (pessoa.getFone_principal().isEmpty()) {
            erro += "O telefone principal não pode ser vazio\n";
        }
        
        if (pessoa.getNum_matricula().isEmpty()) {
            erro += "Numero de matricula não pode ser vazio\n";
        }
        
        if (pessoa.getEndereco().isEmpty()) {
            erro += "Endereço não pode ser vazio\n";
        }
        
        if (pessoa.getSenha().isEmpty()) {
            erro += "Senha não pode ser vazio\n";
        }
        
        if (pessoa.getSenha().length() < 8) {
            erro += "Senha tem que ter pelo menos 8 caracteres\n";
        }
        
        if (pessoaDAO.EncontrarUsuario(pessoa)) {
            erro += "Usuário já cadastrado\n";
        }
        
        if (!pessoa.getEmail().isEmpty()) {
            if (!ValidarEmail.validar(pessoa.getEmail())) {
                erro += "Email inválido\n";
            }
        }
        
        if (pessoa.getId() == null || pessoa.getId() == 0) {
            if (buscarPorCPF(pessoa) != null) {
                erro += "CPF já cadastrado\n";
            }
            
            if (buscarPorRG(pessoa) != null) {
                erro += "RG já cadastrado\n";
            }
            
            if (buscarPorMatricula(pessoa) != null) {
                erro += "Matricula já cadastrado\n";
            }
            
        }
        return erro;
        
    }
    
}
