/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import DAO.MaterialDAO;
import vo.Material;

/**
 *
 * @author Eduardo
 */
public class NegocioMaterial {
    private MaterialDAO materialDAO;
    
    
    public NegocioMaterial(){
        materialDAO = new MaterialDAO();
    }
    
    public Material salvar(Material material) throws Exception{
        String erro = validar(material);
        
        if(erro.equals("")){
            return materialDAO.salvar(Material.class, material);
        }else{
            throw new Exception(erro);
        }
    }
    
    public void remover(Material material) throws Exception{
        materialDAO.remover(Material.class, material);
    }
    
    public Material consultarPorId(Material material){
        return materialDAO.consutarPorId(Material.class, material);
    }    
    
    private String validar(Material material){
        String erro = "";
        
        if(material.getId_categoria() == null) erro += "Favor selecionar a categoria do material\n";
        if(material.getId_tipo_unidade() == null)erro+="Favor selecionar a unidade do material";
        return erro;
    }
}
