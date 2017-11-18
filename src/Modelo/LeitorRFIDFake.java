package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Orochi
 */
public class LeitorRFIDFake extends LeitorRFID{
    
    private String leituraViciada;
    
    public void setLeituraViciada(String leituraFake){
        this.leituraViciada = leituraFake;
    }
    @Override
    public String realizarLeitura() {
        return leituraViciada;
    }    
}
