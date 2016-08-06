/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import DAO.EntidadeBase;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Eduardo
 */
@Entity
public class Fornecedor implements Serializable, EntidadeBase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_fornecedor;
    
    @Column(length = 100, nullable = false)
    private String razao_social;
    
    @Column(length = 100,nullable = false)
    private String nome_fantasia;
    
    @Column(length = 14, nullable = false)
    private String cnpj;
    
    @Column(length = 20, nullable = false)
    private String inscricao_estadual;
    
    @Column(length = 20, nullable = false)
    private String telefone;
    
    @Column(length = 200, nullable = false)
    private String endereco;
    
    @Column(length = 100, nullable = false)
    private String email;
    
    @Column(length = 100, nullable = false)
    private String pessoa_responsavel;
    
    
    @Override
    public Long getId() {
        return id_fornecedor;
    }

    public void setId_fornecedor(Long id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricao_estadual() {
        return inscricao_estadual;
    }

    public void setInscricao_estadual(String inscricao_estadual) {
        this.inscricao_estadual = inscricao_estadual;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPessoa_responsavel() {
        return pessoa_responsavel;
    }

    public void setPessoa_responsavel(String pessoa_responsavel) {
        this.pessoa_responsavel = pessoa_responsavel;
    }
    
    
    
    
    
}
