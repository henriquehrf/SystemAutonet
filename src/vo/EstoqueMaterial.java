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
public class EstoqueMaterial implements Serializable {

    @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_estoque;

    public Local getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Local id_departamento) {
        this.id_departamento = id_departamento;
    }

    public Material getId_material() {
        return id_material;
    }

    public void setId_material(Material id_material) {
        this.id_material = id_material;
    }

    @Column(nullable = false)
    private int quantidade_emprestada;

    @Column(nullable = false)
    private int quantidade;

    @ManyToOne(fetch = FetchType.EAGER)
    private Local id_departamento;

    @ManyToOne(fetch = FetchType.EAGER)
    private Material id_material;

    public Long getId_estoque() {
        return id_estoque;
    }

    public void setId_estoque(Long id_estoque) {
        this.id_estoque = id_estoque;
    }

    public int getQuantidade_emprestada() {
        return quantidade_emprestada;
    }

    public void setQuantidade_emprestada(int quantidade_emprestada) {
        this.quantidade_emprestada = quantidade_emprestada;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
