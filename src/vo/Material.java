/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

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
public class Material {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id_material;
    
    @Column(nullable = false)
    private int quantidade;
    
    @Column(length = 200, nullable = false)
    private String descricao;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private TipoUnidade id_tipo_unidade;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria id_categoria;
    
    

    public long getId_material() {
        return id_material;
    }

    public void setId_material(long id_material) {
        this.id_material = id_material;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoUnidade getId_tipo_unidade() {
        return id_tipo_unidade;
    }

    public void setId_tipo_unidade(TipoUnidade id_tipo_unidade) {
        this.id_tipo_unidade = id_tipo_unidade;
    }

    public Categoria getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Categoria id_categoria) {
        this.id_categoria = id_categoria;
    }
    
}
