/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Projeto;
import Modelo.Sala;
import Modelo.ws.SalaWS;
import Visao.ConfiguracaoView;
import java.util.List;

/**
 *
 * @author Orochi
 */
public class ConfiguracaoController {
    private ConfiguracaoView view;

    public ConfiguracaoController(ConfiguracaoView view) {
        this.view = view;
    }
    
    public List<Sala> getSalasFromWS(){
        List<Sala> salas = SalaWS.getAll();
        view.preencheSalas(salas);
        return salas;
    }
    
    public void salvar(){
       Projeto projeto = Projeto.getInstance();
       projeto.setSala(view.getSalaSelecionada());
    }
}
