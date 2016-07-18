/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.util.Date;
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
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id_emprestimo;
    
    @Column(nullable = false)
    private Date dt_emprestimo;
    
    @Column(length = 1, nullable = false)
    private String status_emprestimo;
    
    @Column(length = 100, nullable = false)
    private String finalidade;
    
    @Column(length = 200, nullable = false)
    private String observacao;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Pessoa id_pessoa_solicita;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Pessoa id_pessoa_autoriza;
    

    public long getId_emprestimo() {
        return id_emprestimo;
    }

    public void setId_emprestimo(long id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }

    public Date getDt_emprestimo() {
        return dt_emprestimo;
    }

    public void setDt_emprestimo(Date dt_emprestimo) {
        this.dt_emprestimo = dt_emprestimo;
    }

    public String getStatus_emprestimo() {
        return status_emprestimo;
    }

    public void setStatus_emprestimo(String status_emprestimo) {
        this.status_emprestimo = status_emprestimo;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Pessoa getId_pessoa_solicita() {
        return id_pessoa_solicita;
    }

    public void setId_pessoa_solicita(Pessoa id_pessoa_solicita) {
        this.id_pessoa_solicita = id_pessoa_solicita;
    }

    public Pessoa getId_pessoa_autoriza() {
        return id_pessoa_autoriza;
    }

    public void setId_pessoa_autoriza(Pessoa id_pessoa_autoriza) {
        this.id_pessoa_autoriza = id_pessoa_autoriza;
    }

    
    
    
}
