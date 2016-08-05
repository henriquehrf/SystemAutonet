/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Eduardo
 */
@Entity
public class Entrada {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id_entrada;

    @Column(length = 20, nullable = false)
    private String numero_nf;

    @Temporal(TemporalType.DATE)
    private Date dt_entrada;

    @Column(scale = 8, precision = 2)
    private float valor_total;

    @ManyToOne(fetch = FetchType.EAGER)
    private Fornecedor id_fornecedor;

    public long getId_entrada() {
        return id_entrada;
    }

    public void setId_entrada(long id_entrada) {
        this.id_entrada = id_entrada;
    }

    public String getNumero_nf() {
        return numero_nf;
    }

    public void setNumero_nf(String numero_nf) {
        this.numero_nf = numero_nf;
    }

    public Date getDt_entrada() {
        return dt_entrada;
    }

    public void setDt_entrada(Date dt_entrada) {
        this.dt_entrada = dt_entrada;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    public Fornecedor getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(Fornecedor id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

}
