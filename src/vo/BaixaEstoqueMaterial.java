/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import DAO.EntidadeBase;
import java.io.Serializable;
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
public class BaixaEstoqueMaterial implements Serializable, EntidadeBase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_baixaestoquematerial;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Baixa id_baixa;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private EstoqueMaterial id_estoquematerial;

    @Override
    public Long getId() {
        return id_baixaestoquematerial;
    }

    public void setId_baixaestoquematerial(Long id_baixaestoquematerial) {
        this.id_baixaestoquematerial = id_baixaestoquematerial;
    }

    public Baixa getId_baixa() {
        return id_baixa;
    }

    public void setId_baixa(Baixa id_baixa) {
        this.id_baixa = id_baixa;
    }

    public EstoqueMaterial getId_estoquematerial() {
        return id_estoquematerial;
    }

    public void setId_estoquematerial(EstoqueMaterial id_estoquematerial) {
        this.id_estoquematerial = id_estoquematerial;
    }
    
    
    
    
    
}
