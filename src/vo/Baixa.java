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
public class Baixa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id_baixa;
    
    @Column(length = 200, nullable = false)
    private String observacao; 
    
    @Column(nullable = false)
    private Date dt_baixa;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private TipoSaida id_tipo_saida;

    public long getId_baixa() {
        return id_baixa;
    }

    public void setId_baixa(long id_baixa) {
        this.id_baixa = id_baixa;
    } 

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDt_baixa() {
        return dt_baixa;
    }

    public void setDt_baixa(Date dt_baixa) {
        this.dt_baixa = dt_baixa;
    }

    public TipoSaida getId_tipo_saida() {
        return id_tipo_saida;
    }

    public void setId_tipo_saida(TipoSaida id_tipo_saida) {
        this.id_tipo_saida = id_tipo_saida;
    }
    
    
    
}
