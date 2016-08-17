/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import DAO.PessoaDAO;
import classesAuxiliares.ValidarCpf;
import classesAuxiliares.ValidarEmail;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import utilitarios.LerProperties;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
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
    
    public List<Pessoa> buscarPorCPF(Pessoa pessoa) {
        return pessoaDAO.buscarPorCPF(pessoa);
    }
    
    public List<Pessoa> buscarPorRG(Pessoa pessoa) {
        return pessoaDAO.buscarPorRg(pessoa);
    }
    
    public List<Pessoa> buscarPorMatricula(Pessoa pessoa) {
        return pessoaDAO.buscarPorMatricula(pessoa);
    }
    
    public List<Pessoa> buscarTodos() {
        return pessoaDAO.buscarTodos();
    }

    private String validarPessoa(Pessoa pessoa) throws Exception {
        String erro = "";
        LerProperties ler = new LerProperties();
        
        Properties prop = ler.getProp();
        if (pessoa.getNome().isEmpty()) {
            erro += prop.getProperty("msg.cadastro.sem.nome");
        }
        
        if (pessoa.getNome().length() < 3) {
            erro += prop.getProperty("msg.cadastro.curto.nome");
        }
        
        if (pessoa.getDt_nascimento() == null) {
            erro += prop.getProperty("msg.cadastro.sem.dtNascimento");
        }
        
        if (!ValidarCpf.isCPF(pessoa.getCpf())) {
            erro += prop.getProperty("msg.cadastro.cpfInvalido");
        }
        
        if (pessoa.getFone_principal().isEmpty()) {
            erro += prop.getProperty("msg.cadastro.principalVazio");
        }
        
        if (pessoa.getNum_matricula().isEmpty()) {
            erro += prop.getProperty("msg.cadastro.numMatriculaVazio");
        }
        
        if (pessoa.getEndereco().isEmpty()) {
            erro += prop.getProperty("msg.cadastro.enderecoVazio");
        }
        
        if (pessoa.getSenha().isEmpty()) {
            erro += prop.getProperty("msg.cadastro.senhaVazio");
        }
        
        if (pessoa.getSenha().length() < 4) {
            erro += prop.getProperty("msg.cadastro.senhaPequena");
        }
        
        if (pessoaDAO.EncontrarUsuario(pessoa)) {
            erro += prop.getProperty("msg.cadastro.usuarioJaCadastrado");
        }
        
        if (!pessoa.getEmail().isEmpty()) {
            if (!ValidarEmail.validar(pessoa.getEmail())) {
                erro += prop.getProperty("msg.cadastro.emailInvalido");
            }
        }
        
        if (pessoa.getId() == null || pessoa.getId() == 0) {
            if (buscarPorCPF(pessoa) != null) {
                erro += prop.getProperty("msg.cadastro.cpfJaCadastrado");
            }
            
            if (buscarPorRG(pessoa) != null) {
                erro += prop.getProperty("msg.cadastro.rgJaCadastrado");
            }
            
            if (buscarPorMatricula(pessoa) != null) {
                erro += prop.getProperty("msg.cadastro.MatriculaJaCadastrada");
            }
            
        }
        return erro;
        
    }
    
}
