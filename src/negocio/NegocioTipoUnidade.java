/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import DAO.TipoUnidadeDAO;
import java.util.List;
import java.util.Properties;
import utilitarios.LerProperties;
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

        try {
            tuDAO.remover(TipoUnidade.class, tu);

        } catch (Exception ex) {
            Properties prop = LerProperties.getProp();
            throw new Exception(prop.getProperty("msg.remover"));
        }
    }

    public TipoUnidade consultarPorId(TipoUnidade tu) {
        return tuDAO.consutarPorId(TipoUnidade.class, tu);
    }

    public List<TipoUnidade> buscarPorDescricao(TipoUnidade tu) {
        return tuDAO.buscarPorDescricao(tu);
    }

    public List<TipoUnidade> buscarTodos() {
        return tuDAO.buscarTodos();
    }

    public List<TipoUnidade> buscarPorSigla(TipoUnidade tu) {
        return tuDAO.buscarPorSigla(tu);
    }

}
