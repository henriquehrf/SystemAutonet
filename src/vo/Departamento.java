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
public class Departamento implements Serializable, EntidadeBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_departamento;
    
    @Column(length = 5, nullable = false)
    private String sigla;
    
    @Column(length = 100, nullable = false)
    private String nome;

    @Override
    public Long getId() {
        return id_departamento;
    }

    public void setId_departamento(long id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
