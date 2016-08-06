/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

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
public class TipoSaida implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id_tipo_saida;
    
    @Column(length = 50, nullable = false)
    private String descricao;

    
    public long getId_tipo_saida() {
        return id_tipo_saida;
    }

    public void setId_tipo_saida(long id_tipo_saida) {
        this.id_tipo_saida = id_tipo_saida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
