/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import DAO.TipoSaidaDAO;
import java.util.List;
import vo.TipoSaida;

/**
 *
 * @author Eduardo
 */
public class NegocioTipoSaida {
    
    private TipoSaidaDAO tsDAO;
    
    public NegocioTipoSaida(){
        tsDAO = new TipoSaidaDAO();
    }
    
    public TipoSaida salvar(TipoSaida ts) throws Exception{
        return tsDAO.salvar(TipoSaida.class, ts);
    }
    
    public void remover(TipoSaida ts) throws Exception{
        tsDAO.remover(TipoSaida.class, ts);
    }

    public TipoSaida consultarPorId(TipoSaida ts){
        return tsDAO.consutarPorId(TipoSaida.class, ts);
    }
    
    public List<TipoSaida> buscarPorNome(TipoSaida ts){
        return tsDAO.buscarPorNome(ts);
    }
    
}
