/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import DAO.TipoUnidadeDAO;
import vo.TipoUnidade;

/**
 *
 * @author Eduardo
 */
public class NegocioTipoUnidade {

    private TipoUnidadeDAO tuDAO;

    public NegocioTipoUnidade() {
        tuDAO = new TipoUnidadeDAO();
    }

    public TipoUnidade salvar(TipoUnidade tu) throws Exception {

        return tuDAO.salvar(TipoUnidade.class, tu);
    }

    public void remover(TipoUnidade tu) throws Exception {
        tuDAO.remover(TipoUnidade.class, tu);
    }

    public TipoUnidade consultarPorId(TipoUnidade tu) {
        return tuDAO.consutarPorId(TipoUnidade.class, tu);
    }

}
