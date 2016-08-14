/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import DAO.EntidadeBase;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Eduardo
 */
@Entity
public class EmprestimoEstoqueMaterial implements Serializable, EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_emprestimoestoquematerial;

    @ManyToOne(fetch = FetchType.EAGER)
    private EstoqueMaterial id_estoquematerial = null;

    @ManyToOne(fetch = FetchType.EAGER)
    private Emprestimo id_emprestimo = null;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dt_devolucao;
    
    @Column(length = 200)
    private String observacao;
    
    @Basic
    private Integer qtd_devolvida;
    
    @Basic
    private Integer qtd_emprestada;

    public Long getId() {
        return id_emprestimoestoquematerial;
    }

    public void setId_emprestimoestoquematerial(Long id_emprestimoestoquematerial) {
        this.id_emprestimoestoquematerial = id_emprestimoestoquematerial;
    }

    public EstoqueMaterial getId_estoquematerial() {
        return id_estoquematerial;
    }

    public void setId_estoquematerial(EstoqueMaterial id_estoquematerial) {
        this.id_estoquematerial = id_estoquematerial;
    }

    public Emprestimo getId_emprestimo() {
        return id_emprestimo;
    }

    public void setId_emprestimo(Emprestimo id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }

    public Date getDt_devolucao() {
        return dt_devolucao;
    }

    public void setDt_devolucao(Date dt_devolucao) {
        this.dt_devolucao = dt_devolucao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getQtd_devolvida() {
        return qtd_devolvida;
    }

    public void setQtd_devolvida(Integer qtd_devolvida) {
        this.qtd_devolvida = qtd_devolvida;
    }

    public Integer getQtd_emprestada() {
        return qtd_emprestada;
    }

    public void setQtd_emprestada(Integer qtd_emprestada) {
        this.qtd_emprestada = qtd_emprestada;
    }
    
    
    
    
}
