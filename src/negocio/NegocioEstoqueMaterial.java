/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import DAO.EstoqueMaterialDAO;
import vo.EstoqueMaterial;

/**
 *
 * @author Eduardo
 */
public class NegocioEstoqueMaterial {

    private EstoqueMaterialDAO emDAO;

    public NegocioEstoqueMaterial() {
        emDAO = new EstoqueMaterialDAO();
    }

    public EstoqueMaterial salvar(EstoqueMaterial estoqueMaterial) throws Exception {
        String erro = validar(estoqueMaterial);
        if (erro.equals("")) {
            return emDAO.salvar(EstoqueMaterial.class, estoqueMaterial);
        } else {
            throw new Exception(erro);
        }

    }

    public void remover(EstoqueMaterial estoqueMaterial) throws Exception {
        emDAO.remover(EstoqueMaterial.class, estoqueMaterial);
    }

    public EstoqueMaterial consultarPorId(EstoqueMaterial estoqueMaterial) {
        return emDAO.consutarPorId(EstoqueMaterial.class, estoqueMaterial);
    }

    private String validar(EstoqueMaterial estoqueMaterial) {
        String erro = "";

        if (estoqueMaterial.getId_departamento() == null) {
            erro += "Falto adicionar o local";
        }
        if (estoqueMaterial.getId_material() == null) {
            erro += "\nFalto adicionar o material";
        }

        return erro;
    }
}
