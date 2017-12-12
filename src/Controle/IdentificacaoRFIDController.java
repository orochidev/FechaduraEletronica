/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Entrada;
import Modelo.Fechadura;
import Modelo.FechaduraEletronica;
import Modelo.Leitor;
import Modelo.LeitorRFIDFake;
import Modelo.Pessoa;
import Modelo.Projeto;
import Modelo.RFID;
import Modelo.Sala;
import Modelo.ws.EntradaWS;
import Modelo.ws.RFIDWS;
import Visao.IdentificacaoRFIDView;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.transaction.Transactional;

/**
 *
 * @author Orochi
 */
public class IdentificacaoRFIDController {
    private Fechadura fechadura;
    private Leitor leitorFake;
    private IdentificacaoRFIDView view;
    private OnLeituraRFIDListener listener;
    public IdentificacaoRFIDController(IdentificacaoRFIDView view){
        leitorFake = new LeitorRFIDFake();
        fechadura = new FechaduraEletronica(leitorFake);
        this.view = view;
    }
    
    public void actionLeituraRFID(){
        if(!view.isVazioCampoRFID()){

            RFID rfid = RFIDWS.getRFID(view.getCampoRFID());                
            if(rfid != null){
               Pessoa pessoa = rfid.getPessoa();
               Sala sala = Projeto.getInstance().getSala();
               view.setCampoNome(pessoa.getNome());
                
                Entrada entrada = new Entrada();
                entrada.setPessoa(pessoa);
                entrada.setSala(sala);
                entrada.setRegistradoEm(new Date());
                EntradaWS ws = new EntradaWS(entrada);
                ws.save();
                
            }else{
                actionRFIDInvalido();
            }
        }
        view.limpaCampoRFID();               
    }
    
    private void actionRFIDInvalido(){
    }
            

    private Fechadura getFechadura(){
        return this.fechadura;
    }
    private Sala getSala(){
        return this.fechadura.getSala();
    }
}
