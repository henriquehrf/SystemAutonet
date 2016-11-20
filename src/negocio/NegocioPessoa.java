/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import DAO.PessoaDAO;
import classesAuxiliares.NegociosEstaticos;
import classesAuxiliares.Validar;
import enumm.Atividade;
import java.util.List;
import java.util.Properties;
import utilitarios.LerMessage;
import vo.Emprestimo;
import vo.EmprestimoEstoqueMaterial;
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
  
    
    public void Inativar(Pessoa pessoa) throws Exception {
        List<Emprestimo> listaEmprestimo = NegociosEstaticos.getNegocioEmprestimo().buscarPorIdPessoa(pessoa);
       
        LerMessage ler = new LerMessage();
        for (Emprestimo vo : listaEmprestimo) {
            List<EmprestimoEstoqueMaterial> listaEmprestimoEstoqueMaterial = NegociosEstaticos.getNegocioEmprestiomEstoqueMaterial().consultarPorNaoDevolvido(vo);

            if (listaEmprestimoEstoqueMaterial.size() > 0) {
                throw new Exception(ler.getMessage("msg.cadastro.remover.pendenteEmprestimo"));                
            }
        }
    
        pessoa.setAtivo(Atividade.I);
        salvar(pessoa);

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

    public Pessoa buscarPorUsuario(Pessoa pessoa) {
        return pessoaDAO.BuscarPorUsuario(pessoa);
    }

    private String validarPessoa(Pessoa pessoa) throws Exception {
        String erro = "";
        LerMessage ler = new LerMessage();

        
        if (pessoa.getNome().isEmpty()) {
            erro += ler.getMessage("msg.cadastro.sem.nome");
        }

        if (pessoa.getNome().length() < 3) {
            erro += ler.getMessage("msg.cadastro.curto.nome");
        }

        if (pessoa.getDt_nascimento() == null) {
            erro += ler.getMessage("msg.cadastro.sem.dtNascimento");
        }

        if (!Validar.isCPF(pessoa.getCpf())) {
            erro += ler.getMessage("msg.cadastro.cpfInvalido");
        }

        if (pessoa.getFone_principal().isEmpty()) {
            erro += ler.getMessage("msg.cadastro.principalVazio");
        }

        if (pessoa.getNum_matricula().isEmpty()) {
            erro += ler.getMessage("msg.cadastro.numMatriculaVazio");
        }

        if (pessoa.getEndereco().isEmpty()) {
            erro += ler.getMessage("msg.cadastro.enderecoVazio");
        }

        if (pessoa.getSenha().isEmpty()) {
            erro += ler.getMessage("msg.cadastro.senhaVazio");
        }

        if (pessoa.getSenha().length() < 4) {
            erro += ler.getMessage("msg.cadastro.senhaPequena");
        }
        if (!pessoa.getEmail().isEmpty()) {
            if (!Validar.isEmail(pessoa.getEmail())) {
                erro += ler.getMessage("msg.cadastro.emailInvalido");
            }
        }
        if (pessoa.getId() == null || pessoa.getId() == 0) {

            if (pessoaDAO.EncontrarUsuario(pessoa)) {
                erro += ler.getMessage("msg.cadastro.usuarioJaCadastrado");
            }

            if (pessoa.getId() == null || pessoa.getId() == 0) {
                if (!buscarPorCPF(pessoa).isEmpty()) {
                    erro += ler.getMessage("msg.cadastro.cpfJaCadastrado");
                }

                if (!buscarPorRG(pessoa).isEmpty()) {
                    erro += ler.getMessage("msg.cadastro.rgJaCadastrado");
                }

                if (!buscarPorMatricula(pessoa).isEmpty()) {
                    erro += ler.getMessage("msg.cadastro.MatriculaJaCadastrada");
                }

            }
        }
        return erro;

    }

}
