/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Eduardo
 */
@Entity
public class Local implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id_local;
    
    @Column(length = 100, nullable = false)
    private String descricao;
    
    @Column(nullable = false)
    private int numero;
    
    @Column(length = 100, nullable = false)
    private String responsavel;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Departamento id_departamento;

    public long getId_local() {
        return id_local;
    }

    public void setId_local(long id_local) {
        this.id_local = id_local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Departamento getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Departamento id_departamento) {
        this.id_departamento = id_departamento;
    }
    
    
    
    
}
