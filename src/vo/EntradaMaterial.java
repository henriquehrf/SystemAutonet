/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Eduardo
 */
@Entity

public class EntradaMaterial implements Serializable{

    @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id_entradaMaterial;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Material id_material;

    @ManyToOne(fetch = FetchType.EAGER)
    private Entrada id_entrada;
    
    @Basic
    private Integer quantidade_material;
    
    @Column(scale = 8, precision = 2)
    private int valor_unitario_material;

    public long getId_entradaMaterial() {
        return id_entradaMaterial;
    }

    public void setId_entradaMaterial(long id_entradaMaterial) {
        this.id_entradaMaterial = id_entradaMaterial;
    }

    public Material getId_material() {
        return id_material;
    }

    public void setId_material(Material id_material) {
        this.id_material = id_material;
    }

    public Entrada getId_entrada() {
        return id_entrada;
    }

    public void setId_entrada(Entrada id_entrada) {
        this.id_entrada = id_entrada;
    }

    public Integer getQuantidade_material() {
        return quantidade_material;
    }

    public void setQuantidade_material(Integer quantidade_material) {
        this.quantidade_material = quantidade_material;
    }

    public int getValor_unitario_material() {
        return valor_unitario_material;
    }

    public void setValor_unitario_material(int valor_unitario_material) {
        this.valor_unitario_material = valor_unitario_material;
    }

    
    
    
}
