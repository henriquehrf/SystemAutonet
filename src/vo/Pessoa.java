/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Eduardo
 */
@Entity
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id_pessoa;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 1, nullable = false)
    private String sexo;

    @Column(length = 11, nullable = false)
    private String cpf;

    @Column(length = 20, nullable = false)
    private String rg;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dt_nascimento;

    @Column(length = 20, nullable = false)
    private String fone_principal;

    @Column(length = 20, nullable = true)
    private String fone_secundario;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 200, nullable = false)
    private String endereco;

    @Column(length = 20, nullable = false)
    private String funcao;

    @Column(length = 20, nullable = false)
    private String num_matricula;

    @Column(length = 1, nullable = false)
    private String ativo;

    @Column(length = 20, nullable = false)
    private String usuario;

    @Column(length = 20, nullable = false)
    private String senha;

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ultimo_acesso;

    public long getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(long id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getFone_principal() {
        return fone_principal;
    }

    public void setFone_principal(String fone_principal) {
        this.fone_principal = fone_principal;
    }

    public String getFone_secundario() {
        return fone_secundario;
    }

    public void setFone_secundario(String fone_secundario) {
        this.fone_secundario = fone_secundario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getNum_matricula() {
        return num_matricula;
    }

    public void setNum_matricula(String num_matricula) {
        this.num_matricula = num_matricula;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getUltimo_acesso() {
        return ultimo_acesso;
    }

    public void setUltimo_acesso(Date ultimo_acesso) {
        this.ultimo_acesso = ultimo_acesso;
    }

}
