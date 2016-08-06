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
public class TipoUnidade implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id_tipo_unidade;
    
    @Column(length = 20, nullable = false)
    private String descricao;

    public long getId_tipo_unidade() {
        return id_tipo_unidade;
    }

    public void setId_tipo_unidade(long id_tipo_unidade) {
        this.id_tipo_unidade = id_tipo_unidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
